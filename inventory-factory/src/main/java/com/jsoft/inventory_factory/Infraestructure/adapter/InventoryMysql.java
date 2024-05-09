package com.jsoft.inventory_factory.Infraestructure.adapter;

import com.jsoft.inventory_factory.Domain.models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface InventoryMysql extends JpaRepository<Inventory,Long> {

    Optional<Inventory> findBySku(String sku);

    List<Inventory> findBySkuIn(List<String> skus);


}
