package com.OSA.OSA.controller;

import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.OSA.OSA.model.DTO.OrderDTO;
import com.OSA.OSA.model.DTO.OrderElasticRequestDto;
import com.OSA.OSA.model.DTO.ProductDTO;
import com.OSA.OSA.model.entity.Buyer;
import com.OSA.OSA.model.entity.Item;
import com.OSA.OSA.model.entity.Order;
import com.OSA.OSA.model.entity.Product;
import com.OSA.OSA.model.entity.ShoppingCart;
import com.OSA.OSA.model.entity.User;
import com.OSA.OSA.repository.BuyerRepo;
import com.OSA.OSA.service.ItemService;
import com.OSA.OSA.service.OrderElasticService;
import com.OSA.OSA.service.OrderService;
import com.OSA.OSA.service.ShoppingCartService;
import com.OSA.OSA.service.UserService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping(value = "api/orders")
public class OrderController {

	@Autowired
	private OrderElasticService orderServiceElastic;
	
    @Autowired
    private UserService userService;
    
    @Autowired
    private ItemService itemService;
    
    @Autowired
    private ShoppingCartService shoppingCartService;
    
    @Autowired
    private OrderService orderService;
    
    @GetMapping
    public ResponseEntity<List<OrderDTO>> getOrders() {
        List<Order> products = orderService.findAll();

        List<OrderDTO> productsDTO = new ArrayList<>();
        for (Order p : products) {
            productsDTO.add(new OrderDTO(p));
        }
        return new ResponseEntity<>(productsDTO, HttpStatus.OK);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable("id") Integer id) {
        Order product = orderService.findOne(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    
    @PostMapping(value = "/new")
    public ResponseEntity<Order> saveOrder(@RequestParam("price") BigDecimal price,@RequestParam("user") Integer user) {

//    	Item item = new Item();
    	List<Item> items = new ArrayList<>();
        User userr = userService.findOne(user);
        
        System.out.println("OVO JE NEKI TEST");
        List<ShoppingCart> carts = shoppingCartService.findAll();
        
        Order order = new Order();
    	order.setDelivered(false);
    	order.setDate(new Timestamp(System.currentTimeMillis()));
    	order.setRate(1);
    	order.setComment("");
    	order.setAnonymousComment(false);
    	order.setArchivedComment(false);
    	order.setPrice(price);
    	order.setUser(userr);

    	order = orderService.save(order);
    	
        for (ShoppingCart shoppingCart : carts) {
        	Item item = new Item();
			item.setProduct(shoppingCart.getProduct_id());
			item.setQty(shoppingCart.getQty());
			item.setOrder(order);
			itemService.save(item);
			items.add(item);
			shoppingCartService.remove(shoppingCart.getId());
		}
    	order.setItems(items);
    	System.out.println("AAAAAAAA " + items.get(0).getId());
    	
    	
    	
    	order = orderService.save(order);
    	return new ResponseEntity<>(order, HttpStatus.CREATED);

        }
    
    @GetMapping(value = "/find-undelivered/{id}")
    public ResponseEntity<List<OrderDTO>> getUndelivered(@PathVariable("id") Integer id) {
        List<Order> products = orderService.findAll();
        User user = userService.findOne(id);
        
        List<OrderDTO> productsDTO = new ArrayList<>();
        for (Order p : products) {
        	if(!p.isDelivered() && p.getUser().getId().equals(user.getId())) {
        		productsDTO.add(new OrderDTO(p));
        	}
            
        }
        return new ResponseEntity<>(productsDTO, HttpStatus.OK);
    }
    
    
}
