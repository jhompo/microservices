package com.jsoft.productsfactory.Domain.repository;

import com.jsoft.productsfactory.Domain.models.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository {

   public List<Product> all();

   public Optional<Product> findById(long id);

   public Product save(Product product);
}