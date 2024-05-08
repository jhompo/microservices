package com.jsoft.productsfactory.Aplication;

import com.jsoft.productsfactory.Domain.models.Product;
import com.jsoft.productsfactory.Domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServices {

    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll(){
       return  productRepository.all();
    }

    public Optional<Product> getId(long id){
        return productRepository.findById(id);
    }

    public Product create(Product product){
        return productRepository.save(product);

    }
}
