package com.jsoft.productsfactory.Aplication;

import com.jsoft.productsfactory.Domain.models.Product;
import com.jsoft.productsfactory.Domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {

    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll(){
       return  productRepository.all();
    }

    public Product getId(long id){
        return productRepository.findById(id);
    }
}
