package org.skypro.skyshop.model.product;

import org.skypro.skyshop.model.search.Searchable;

import java.util.UUID;

public class Product implements Searchable {
    private final UUID id;
    private final String name;


    public Product(UUID id, String laptop, String electronics, String name) {
        this.id = id;
        this.name = name;

    }

    public Product(String number, String laptop, int i, UUID id, String name) {

        this.id = id;
        this.name = name;
    }


    @Override
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    @Override
    public String getContentType() {
        return "product";
    }

    public double getPrice() {
        return 0;
    }
}
