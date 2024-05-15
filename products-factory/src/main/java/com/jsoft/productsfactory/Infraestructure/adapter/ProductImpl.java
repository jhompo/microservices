package com.jsoft.productsfactory.Infraestructure.adapter;

import com.jsoft.productsfactory.Domain.models.Product;
import com.jsoft.productsfactory.Domain.repository.ProductRepository;
import com.jsoft.productsfactory.Infraestructure.Entities.ProductDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class ProductImpl implements ProductRepository {

    @Autowired
    ProductRepositoryMysql productRepositoryMysql;

    @Override
    public List<Product> all() {
        return productRepositoryMysql.findAll().stream().map(this::productDbToProduct).toList();
    }


    @Override
    public Optional<Product> findById(long id) {
        return productRepositoryMysql.findById(id).stream().map(this::productDbToProduct).findFirst();
    }

    @Override
    public Product save(Product product) {
        ProductDb productDb = productToProductDB(product);
        productRepositoryMysql.save(productDb);
        return product ;
    }


    private Product productDbToProduct(ProductDb item) {
        return Product.builder()
                .id(item.getId())
                .name(item.getName())
                .description(item.getDescription())
                .sku(item.getSku())
                .price(item.getPrice())
                .status(item.getStatus())
                .build();
    }

    private ProductDb productToProductDB(Product item) {
        return ProductDb.builder()
                .id(item.getId())
                .name(item.getName())
                .description(item.getDescription())
                .sku(item.getSku())
                .price(item.getPrice())
                .status(item.getStatus())
                .build();
    }

}