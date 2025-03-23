package org.skypro.skyshop.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.search.SearchService;

import org.skypro.skyshop.service.StorageService;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static javax.management.Query.times;
import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static org.testng.Assert.assertEquals;

class SearchServiceTest {

    private SearchService searchService;
    private StorageService storageServiceMock;

    @BeforeEach
    void setUp() {
        storageServiceMock = mock(StorageService.class);
        searchService = new SearchService(storageServiceMock);
    }

    @Test
    void search_NoProducts_ReturnsEmptyList() {
        when(storageServiceMock.getAllProducts()).thenReturn(Collections.emptyList());

        List<Product> result = searchService.search("Test");

        assertTrue(result.isEmpty());
        verify(storageServiceMock, times(1)).getAllProducts();
    }

    private StorageService verify(StorageService storageServiceMock, Object times) {
        return null;
    }

    private Object times(int i) {
        return null;
    }

    @Test
    void search_NoMatchingProducts_ReturnsEmptyList() {
        Product product = new Product(UUID.randomUUID(), "Laptop", "Electronics", "Laptop");
        when(storageServiceMock.getAllProducts()).thenReturn(List.of(product));

        List<Product> result = searchService.search("Laptop");

        assertTrue(result.isEmpty());
    }

    @Test
    void search_MatchingProductFound_ReturnsListWithProduct() {
        Product product = new Product(UUID.randomUUID(), "Laptop", "Electronics", "Laptop");
        when(storageServiceMock.getAllProducts()).thenReturn(List.of(product));

        List<Product> result = searchService.search("Laptop");

        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals("Laptop", result.get(0).getName());
    }
}
