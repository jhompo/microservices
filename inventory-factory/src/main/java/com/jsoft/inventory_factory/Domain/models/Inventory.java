package com.jsoft.inventory_factory.Domain.models;

import jakarta.persistence.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Inventory {

    private long id;

    private String sku;

    private Long quantity;


}
