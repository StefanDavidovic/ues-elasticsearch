package com.OSA.OSA.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.OSA.OSA.model.DTO.OrderElasticRequestDto;
import com.OSA.OSA.service.OrderElasticService;
import com.OSA.OSA.service.ShoppingCartService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("api/ordersElastic")
public class OrderElasticController {
	
	@Autowired
	private OrderElasticService orderService;
	
    @Autowired
    private ShoppingCartService shoppingCartService;
	
	@GetMapping
	public List<OrderElasticRequestDto> index() {
		return orderService.findAll();
	}
	
	//http://localhost:8096/api/ordersElastic/comment
	@GetMapping("/comment")
	public List<OrderElasticRequestDto> getByComment(@RequestBody OrderElasticRequestDto orderElasticRequestDto) {
		return orderService.findAllByComment(orderElasticRequestDto.getComment());
	}
	
	//http://localhost:8096/api/ordersElastic/rate?minRate=2&maxRate=5
	@GetMapping("/rate")
	public List<OrderElasticRequestDto> getByRate(@RequestParam(name="minRate") int minRate, @RequestParam(name="maxRate") int maxRate) {
		return orderService.findByRateBetween(minRate,maxRate);
	}
	
    @GetMapping("/{comment}")
    public List<OrderElasticRequestDto> getByKomentar(@PathVariable String comment){
        return orderService.findAllByComment(comment);

    }
	
	@PostMapping
	public void index(@RequestBody OrderElasticRequestDto orderDto) {
		orderService.index(orderDto);
		shoppingCartService.removeAll();
	}

}
