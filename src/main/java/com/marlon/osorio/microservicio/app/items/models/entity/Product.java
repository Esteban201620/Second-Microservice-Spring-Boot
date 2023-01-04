package com.marlon.osorio.microservicio.app.items.models.entity;

import lombok.*;

import java.util.Date;

@Getter
@Setter
public class Product {

    private Long id;
    private String name;
    private Double cost;
    private Date createdAt;
}
