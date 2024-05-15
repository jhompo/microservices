package com.jsoft.inventory_factory.Infraestructure.utils;

import com.jsoft.inventory_factory.Domain.models.Inventory;
import com.jsoft.inventory_factory.Infraestructure.adapter.InventoryMysql;
import com.jsoft.inventory_factory.Infraestructure.entities.InventoryDb;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataLoader implements CommandLineRunner {
    private final InventoryMysql inventoryMysql;

    @Override
    public void run(String... args) throws Exception {
        log.info("Loading data");
        if(inventoryMysql.findAll().isEmpty()){
            inventoryMysql.saveAll(
                    List.of(
                            InventoryDb.builder().sku("00001").quantity(10L).build(),
                            InventoryDb.builder().sku("00002").quantity(20L).build(),
                            InventoryDb.builder().sku("00003").quantity(30L).build(),
                            InventoryDb.builder().sku("00004").quantity(0L).build(),
                            InventoryDb.builder().sku("00005").quantity(50L).build(),
                            InventoryDb.builder().sku("00006").quantity(0L).build()
                    )
            );
        }
        log.info("Data loaded");
    }
}
