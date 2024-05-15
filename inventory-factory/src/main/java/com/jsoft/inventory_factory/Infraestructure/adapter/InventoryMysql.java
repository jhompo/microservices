package com.jsoft.inventory_factory.Infraestructure.adapter;

import com.jsoft.inventory_factory.Domain.models.Inventory;
import com.jsoft.inventory_factory.Infraestructure.entities.InventoryDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface InventoryMysql extends JpaRepository<InventoryDb,Long> {

    Optional<InventoryDb> findBySku(String sku);

    List<InventoryDb> findBySkuIn(List<String> skus);


}
