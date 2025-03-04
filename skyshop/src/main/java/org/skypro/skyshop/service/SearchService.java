package org.skypro.skyshop.service;
import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.search.SearchResult;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {

    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }



    public Collection<Object> search(String query) {
        return storageService.getAllSearchable().stream()
                .filter(searchable -> {
                    if (searchable instanceof Article) {
                        Article article = (Article) searchable;
                        return article.getSearchTerm().toLowerCase().contains(query.toLowerCase());
                    } else if (searchable instanceof Product) {
                        Product product = (Product) searchable;
                        return product.getSearchTerm().toLowerCase().contains(query.toLowerCase());
                    }
                    return false;
                })
                .collect(Collectors.toList());

    }
}