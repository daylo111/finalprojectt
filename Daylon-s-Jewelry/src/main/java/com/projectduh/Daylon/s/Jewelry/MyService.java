package com.projectduh.Daylon.s.Jewelry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.projectduh.Daylon.s.Jewelry.Repository.ProductRepository;
import com.projectduh.Daylon.s.Jewelry.model.Product;

import java.util.List;
import java.util.Optional;

@Service
public class MyService {
	private ProductRepository productRepository;
	
	@Autowired
	public MyService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }


    public void deleteProduct(Integer productid) {
        productRepository.deleteById(productid);
    }

    
}
