package com.jsoft.productsfactory.Domain.repository;

import com.jsoft.productsfactory.Domain.models.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository {

   public List<Product> all();

   public Product findById(long id);

   public Product save(Product product);
}