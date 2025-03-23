package org.skypro.skyshop.model.basket;

import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.service.StorageService;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
@SessionScope
    public class ProductBasket implements Serializable {

        private final Map<UUID, Integer> products = new HashMap<>();


        public void addProduct(Product id) {
            products.put(id, products.getOrDefault(id, 0) + 1);
        }


        public Map<UUID, Integer> getProducts() {
            return Collections.unmodifiableMap(products);
        }

    public void addProduct(String number, StorageService storageServiceMock) {

    }
}

