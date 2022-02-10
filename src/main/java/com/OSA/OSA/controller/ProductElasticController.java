package com.OSA.OSA.controller;

import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.OSA.OSA.model.DTO.OrderElasticRequestDto;
import com.OSA.OSA.model.DTO.ProductDTO;
import com.OSA.OSA.model.DTO.ProductElasticDto;
import com.OSA.OSA.model.entity.Product;
import com.OSA.OSA.model.entity.ProductElastic;
import com.OSA.OSA.service.ProductElasticService;

@RestController
@CrossOrigin
@RequestMapping("api/productsElastic")
public class ProductElasticController {
	
	@Autowired
	private ProductElasticService productService;
	

	@PostMapping
	public void save(@RequestBody ProductElasticDto productDto) {
		productService.index(productDto);
		System.out.println(productDto.getUsername().toString());
	}
	
	@GetMapping
	public List<ProductElasticDto> getAll() {
		return productService.findAll();
	}
	
	@GetMapping("salesmen/{username}")
	public List<ProductElasticDto> getAllByUsername(@PathVariable String username) {
		return productService.findByUsername(username);
	}
	
	@GetMapping("/price")
	public List<ProductElasticDto> getByRate(@RequestParam(name="minPrice") double minPrice, @RequestParam(name="maxPrice") double maxPrice) {
		return productService.findByPriceBetween(minPrice, maxPrice);
	}
	
	@GetMapping("/{name}")
	public List<ProductElasticDto> getByName(@PathVariable String name) {
		return productService.findByName(name);
	}
	
	@GetMapping("/id/{id}")
	public ProductElasticDto getByid(@PathVariable String id) {
		return productService.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		productService.remove(id);
	}
	

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody ProductElasticDto productDto, @PathVariable String id) {
    	ProductElasticDto productdto = productService.findById(id);
    	ProductElastic product = new ProductElastic(productdto.getId(),productdto.getName(), productdto.getDescription(), productdto.getPrice(),productDto.getUsername());
        product.setId(id);
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());

        productService.save(product);
        return new ResponseEntity<>("Dobro je", HttpStatus.OK);

    }
}
