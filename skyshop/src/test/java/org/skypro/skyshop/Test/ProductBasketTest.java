package org.skypro.skyshop.Test;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skypro.skyshop.Error.NoSuchProductException;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.service.StorageService;

import java.util.List;
import static javax.management.Query.times;
import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductBasketTest {
    private ProductBasket productBasket;
    private StorageService storageServiceMock;

    @BeforeEach
    void setUp() {
        storageServiceMock = Mockito.mock(StorageService.class);
        productBasket = new ProductBasket();
    }

    @Test
    void addProduct_NonExistentProduct_ThrowsException() {
        Mockito.when(storageServiceMock.getProductById("1")).thenThrow(new NoSuchProductException("Product not found"));

        Assert.assertThrows(NoSuchProductException.class, () -> productBasket.addProduct("1", storageServiceMock));
        verify(storageServiceMock, times(1)).getProductById("1");
    }

    @Test
    void addProduct_ExistingProduct_CallsAddMethod() {
        Product product = new Product("1", "Laptop", 1000);
        Mockito.when(storageServiceMock.getProductById("1")).thenReturn(product);

        productBasket.addProduct("1", storageServiceMock);
        Assertions.assertEquals(1, productBasket.getProducts().size());
    }

    @Test
    void getUserBasket_EmptyBasket_ReturnsEmptyList() {
        Assert.assertTrue(productBasket.getProducts().isEmpty());
    }

    @Test
    void getUserBasket_NonEmptyBasket_ReturnsCorrectProducts() {
        Product product = new Product("1", "Laptop", 1000);
        productBasket.addProduct(product);

        List<Product> products = (List<Product>) productBasket.getProducts();
        Assert.assertEquals(1, products.size());
        assertEquals("Laptop", products.get(0).getName());
    }
}

