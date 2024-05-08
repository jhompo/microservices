package com.jsoft.productsfactory.Infraestructure.adapter;

import com.jsoft.productsfactory.Domain.models.Product;
import com.jsoft.productsfactory.Domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ProductImpl implements ProductRepository {

    @Autowired
    ProductRepositoryMysql productRepositoryMysql;

    @Override
    public List<Product> all() {
        return productRepositoryMysql.findAll();
    }

    @Override
    public Product findById(long id) {
        return  productRepositoryMysql.findById(id).orElseThrow();
    }

    @Override
    public Product save(Product product) {
        return productRepositoryMysql.save(product);
    }
}
