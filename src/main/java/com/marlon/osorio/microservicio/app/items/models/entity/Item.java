package com.marlon.osorio.microservicio.app.items.models.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private Product product;
    private Integer amount;

    public Double getTotal() {
        return product.getCost() * amount.doubleValue();
    }

}
