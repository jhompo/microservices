package com.jsoft.productsfactory.Infraestructure;

import com.jsoft.productsfactory.Aplication.ProductServices;
import com.jsoft.productsfactory.Domain.models.Product;
import lombok.*;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductServices productServices;

    @GetMapping("/all")
    public List<Product> AllProducts() {
        return productServices.findAll();
    }

    @GetMapping("/{id}")
    public Product AllProducts(@PathVariable Long id) {
        return productServices.getId(id);
    }

    @PostMapping()
    public Product AddProduct(@RequestBody Product product) {
        return productServices.create(product);
    }

}