package org.skypro.skyshop.model.search;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.search.Searchable;
import org.skypro.skyshop.service.StorageService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {

    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }


    public List<Product> search(String query) {
        List<Product> allProducts = (List<Product>) storageService.getAllProducts(); // Должен быть вызван!
        return allProducts.stream()
                .filter(product -> product.getName().contains(query))
                .collect(Collectors.toList());
    }
}