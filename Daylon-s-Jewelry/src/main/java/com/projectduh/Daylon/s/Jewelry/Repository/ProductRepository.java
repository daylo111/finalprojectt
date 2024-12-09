package com.projectduh.Daylon.s.Jewelry.Repository;
import com.projectduh.Daylon.s.Jewelry.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;




@Repository

public interface ProductRepository extends JpaRepository<Product, Integer> {



}
