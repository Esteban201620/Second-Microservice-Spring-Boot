package com.marlon.osorio.microservicio.app.items.models.service;

import com.marlon.osorio.microservicio.app.items.models.entity.Item;
import com.marlon.osorio.microservicio.app.items.models.entity.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements IItemService {
    @Bean
    public RestTemplate clientRest() {
        return new RestTemplate();
    }

    @Override
    public List<Item> findAll() {
        return Arrays.stream(
                        Objects.requireNonNull(clientRest().getForObject("http://localhost:8001/products", Product[].class)))
                .map(product -> new Item(product, 1)).collect(
                        Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer amount) {
        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("id", id.toString());
        Product product = clientRest().getForObject("http://localhost:8001/products/{id}", Product.class, pathVariables);
        return new Item(product, amount);
    }
}
