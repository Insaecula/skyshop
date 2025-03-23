package org.skypro.skyshop.service;
import org.skypro.skyshop.Error.NoSuchProductException;
import  org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StorageService {

    private final Map<String, Product> products = new HashMap<>();
    private final Map<UUID, Product> productMap = new HashMap<>();
    private final Map<UUID, Article> articleMap = new HashMap<>();

    public StorageService() {
        initializeTestData();
    }
//

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


    public Optional<Product> getProductById(UUID id) {
        return Optional.ofNullable(productMap.get(id));
    }

    public Product getProductById(String id) {
        return Optional.ofNullable(products.get(id))
                .orElseThrow(() -> new NoSuchProductException("Товар с ID " + id + " не найден."));
    }
}