package id.ac.ui.cs.advprog.eshop.service;
import id.ac.ui.cs.advprog.eshop.model.Product;

import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class ProductServiceImplTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    ProductServiceImpl productService;
    @BeforeEach
    void setup(){
    }

    @Test
    void testCreateService(){
        Product product = new Product();
        when(productService.create(product)).thenReturn(product);

        Product result = productService.create(product);

        assertEquals(product, result);
        verify(productRepository, times(1)).create(product);
    }

    @Test
    void testFindAllService(){
        List<Product> mockProduct = new ArrayList<>();
        mockProduct.add(new Product());
        mockProduct.add(new Product());

        Iterator<Product> productIterator = mockProduct.iterator();
        when(productRepository.findAll()).thenReturn(productIterator);
        List<Product> result = productService.findAll();

        assertEquals(mockProduct, result);
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testGetService(){
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Rubicon Yapang");
        product.setProductQuantity(1);
        when(productRepository.findAll()).thenReturn(Collections.singletonList(product).iterator());
        Product tempProduct = productService.get(product.getProductId());

        assertEquals(tempProduct, product);
        assertNotNull(tempProduct);
    }

    @Test
    void testDeleteService(){
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Rubicon Yapang");
        product.setProductQuantity(1);
        productRepository.create(product);

        when(productRepository.delete(product)).thenReturn(true);
        assertTrue(productRepository.delete(product));
    }
}