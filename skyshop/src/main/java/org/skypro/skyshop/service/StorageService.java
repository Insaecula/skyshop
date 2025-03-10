package org.skypro.skyshop.service;
import  org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
@Service
public class StorageService {

    private final Map<UUID, Product> productMap = new HashMap<>();
    private final Map<UUID, Article> articleMap = new HashMap<>();

    public StorageService() {
        initializeTestData();
    }


    private void initializeTestData() {
        Product product = new Product(UUID.randomUUID(), "Laptop", "Electronics", "High-end gaming laptop");
        Article article = new Article(UUID.randomUUID(), "Java Guide", "Learn advanced Java techniques");

        productMap.put(product.getId(), product);
        articleMap.put(article.getId(), article);
    }

    public Collection<Product> getAllProducts() {
        return productMap.values();
    }

    public Collection<Article> getAllArticles() {
        return articleMap.values();
    }
}