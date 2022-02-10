package com.OSA.OSA.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.OSA.OSA.model.DTO.ProductDTO;
import com.OSA.OSA.model.DTO.ShoppingCartDTO;
import com.OSA.OSA.model.entity.Product;
import com.OSA.OSA.model.entity.ShoppingCart;
import com.OSA.OSA.model.entity.User;
import com.OSA.OSA.service.ProductService;
import com.OSA.OSA.service.ShoppingCartService;
import com.OSA.OSA.service.UserService;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "api/articles")
public class ProductController {
	
	@Value("${uploadDir}")
	private String uploadFolder;
	
    @Autowired
    private UserService userService;
	
    @Autowired
    private ProductService productService;
    
    @Autowired
    private ShoppingCartService shoppingCartService;
    
    
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getProducts() {
        List<Product> products = productService.findAll();
        System.out.println("BLAA");

        // Convert products to DTOs
        List<ProductDTO> productsDTO = new ArrayList<>();
        for (Product p : products) {
            productsDTO.add(new ProductDTO(p));
        }

        return new ResponseEntity<>(productsDTO, HttpStatus.OK);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable("id") Integer id) {
        Product product = productService.findOne(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new ProductDTO(product), HttpStatus.OK);
    }

    
    
    @PostMapping(value = "/new")
    public ResponseEntity<ProductDTO> saveProduct(@RequestParam("name") String name, @RequestParam("description") String description, 
    		@RequestParam("price") BigDecimal price, ModelMap model,@RequestParam("user") Integer user) {
        System.out.println("POST POGODJEN 1");
        User userr = userService.findOne(user);
//        System.out.println(userr 	);
    	Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setUser(userr);
//        System.out.println("AAAA" +user.toString());
//        product.setImage_src(image_src);
        
//        Path path = Paths.get("uploads/");
        
//        try {
//        	System.out.println("TU SAM");
//        	InputStream inputStream = image_src.getInputStream();
//        	Files.copy(inputStream, path.resolve(image_src.getOriginalFilename()),
//        			StandardCopyOption.REPLACE_EXISTING);
//        	product.setImage_src(image_src.getOriginalFilename().toLowerCase());
//        	
//        	model.addAttribute("product", product);
//        }catch(Exception e) {
//        	
//        }
        
        
//        System.out.println(image_src.getOriginalFilename().toLowerCase());

        product = productService.save(product);
        System.out.println("POST POGODJEN 2");
        return new ResponseEntity<>(new ProductDTO(product), HttpStatus.CREATED);
    }
    
    
    @GetMapping(value="/getImage/{image_src}")
    public ResponseEntity<ByteArrayResource> getImage(@PathVariable("image_src") String image_src){
    	if(!image_src.equals("")||image_src != null ) {
    		try {
				Path filename = Paths.get("uploads", image_src);
				byte[] buffer = Files.readAllBytes(filename);
				ByteArrayResource byteArrayResource = new ByteArrayResource(buffer);
				return ResponseEntity.ok().contentLength(buffer.length).contentType(MediaType.parseMediaType("image/png")).body(byteArrayResource);
			} catch (Exception e) {
			}
    	}
    	return ResponseEntity.badRequest().build();
    }
    
    
    @PutMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@RequestParam("image_src") MultipartFile image_src, @RequestParam("name") String name, @RequestParam("description") String description, 
    		@RequestParam("price") BigDecimal price, ModelMap model, @PathVariable("id") Integer id) {
        Product product = productService.findOne(id);

        if (product == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        
//        Path path = Paths.get("uploads/");
        
//        try {
//        	System.out.println("TU SAM");
//        	InputStream inputStream = image_src.getInputStream();
//        	Files.copy(inputStream, path.resolve(image_src.getOriginalFilename()),
//        			StandardCopyOption.REPLACE_EXISTING);
//        	product.setImage_src(image_src.getOriginalFilename().toLowerCase());
//        	
//        	model.addAttribute("product", product);
//        }catch(Exception e) {
//        	
//        }
        product = productService.save(product);

        return new ResponseEntity<>(new ProductDTO(product), HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Integer id) {
        Product product = productService.findOne(id);
        if (product != null) {
            productService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping(value = "/addToCart")
    public ResponseEntity<ShoppingCart> addToCart(@RequestParam("product") String name,@RequestParam("qty") Integer qty,
    		@RequestParam("price") BigDecimal price) {
    	System.out.println(name + "ID PRODUKTA");
    	System.out.println(price + "CeNA PRODUKTA");
    	System.out.println(qty + "QTY PRODUKTA");
    	ShoppingCart cart = new ShoppingCart();
    	Product product = productService.findOne(name);
    	System.out.println(product + "PRODUCT");
    	cart.setProduct_id(product);
    	cart.setPrice(price);
    	cart.setQty(qty);


        cart = shoppingCartService.save(cart);
        return new ResponseEntity<>(cart, HttpStatus.CREATED);
    }
    
    @GetMapping(value = "/carts")
    public ResponseEntity<List<ShoppingCartDTO>> getCartItems() {
        List<ShoppingCart> products = shoppingCartService.findAll();
        
        List<ShoppingCartDTO> productsDTO = new ArrayList<>();
        for (ShoppingCart p : products) {
            productsDTO.add(new ShoppingCartDTO(p));
        }

        return new ResponseEntity<>(productsDTO , HttpStatus.OK);
    }

    
    @DeleteMapping(value = "/carts/{id}")
    public ResponseEntity<?> deleteFromCart(@PathVariable("id") Integer id) {
        ShoppingCart product = shoppingCartService.findOne(id);
        if (product != null) {
        	System.out.println(product.getId());
        	shoppingCartService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
        	System.out.println(222);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    

}
