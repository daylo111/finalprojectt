package com.projectduh.Daylon.s.Jewelry;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectduh.Daylon.s.Jewelry.Repository.ProductRepository;
import com.projectduh.Daylon.s.Jewelry.model.Product;

@RestController
@RequestMapping("/api/products")
public class MyController {
	
	private final MyService myService;
	private ProductRepository productRepository;
	
	@Autowired
	public MyController(MyService myService) {
		super();
		this.myService = myService;
	}
	
	@GetMapping 
	public List<Product> getAllProudcts() {
		return myService.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
		Optional<Product> product = myService.getProductById(id);
		return product.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
	}
	@PostMapping
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		return new ResponseEntity<Product>(myService.saveProduct(product), HttpStatus.CREATED);
		//Product newProduct = myService.createProduct(product);
		 
	}
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Integer id, @RequestBody Product product) {
		Optional<Product> existingProduct = myService.getProductById(id);
		if (existingProduct.isPresent()) {
			product.setProductId(id);
			Product updatedProduct = myService.saveProduct(product);
			return ResponseEntity.ok(updatedProduct);
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
		Optional<Product> product = myService.getProductById(id);
		if (product.isPresent()) {
			myService.deleteProduct(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

  
	
}