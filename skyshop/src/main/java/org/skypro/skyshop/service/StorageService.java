package org.skypro.skyshop.service;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;
import org.skypro.skyshop.model.article.Article;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class StorageService {

    private final Collection<Article> articles = new ArrayList<>();
    private final Collection<Product> products = new ArrayList<>();

    public StorageService() {
        initializeTestData();
    }


    private void initializeTestData() {
        Product product = new Product(UUID.randomUUID(), "Laptop", "Electronics", "High-end gaming laptop");
        Article article = new Article(UUID.randomUUID(), "Java Guide", "Learn advanced Java techniques");


    }

    public Collection<Product> getAllProducts() {
        return products;
    }

    public Collection<Article> getAllArticles() {
        return articles;
    }
    public Collection<Object> getAllSearchable() {
        List<Object> searchableItems = new ArrayList<>();
        searchableItems.addAll(products);
        searchableItems.addAll(articles);
        return searchableItems;
    }

    public Collection<Article> searchArticles(String query) {
        return null;
    }
}