package com.jsoft.productsfactory.Infraestructure.adapter;

import com.jsoft.productsfactory.Domain.models.Product;
import com.jsoft.productsfactory.Infraestructure.Entities.ProductDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProductRepositoryMysql extends JpaRepository<ProductDb, Long> {
}
