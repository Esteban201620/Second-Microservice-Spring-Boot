package com.marlon.osorio.microservicio.app.items.controller;

import com.marlon.osorio.microservicio.app.items.models.entity.Item;
import com.marlon.osorio.microservicio.app.items.models.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private IItemService itemService;

    @GetMapping("/items")
    public List<Item> findAll() {
        return itemService.findAll();
    }

    @GetMapping("/item/{id}/amount/{amount}")
    public Item detail(@PathVariable Long id, @PathVariable Integer amount) {
        return itemService.findById(id, amount);
    }
}

