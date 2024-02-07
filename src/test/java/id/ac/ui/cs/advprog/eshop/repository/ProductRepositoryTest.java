package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ProductRepositoryTest {

    @InjectMocks
    ProductRepository productRepository;
    @BeforeEach
    void setUp(){
    }
    @Test
    void testCreateAndFind(){
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testFindAllIfEmpty(){
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindAllifMoreThanOneProduct(){
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product1.getProductId(), savedProduct.getProductId());
        savedProduct = productIterator.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());
        assertFalse(productIterator.hasNext());
    }

    // Exercise
    @Test
    void testDeleteProduct(){
        Product productAK = new Product();
        productAK.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        productAK.setProductName("AK-47 Vulcan");
        productAK.setProductQuantity(2);
        productRepository.create(productAK);

        Product productGlock = new Product();
        productGlock.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        productGlock.setProductName("Glock Fade");
        productGlock.setProductQuantity(1);
        productRepository.create(productGlock);

        //Delete
        productRepository.delete(productAK);

        Iterator<Product> productIterator = productRepository.findAll();
        Product currentProduct = productIterator.next();
        assertEquals("a0f9de46-90b1-437d-a0bf-d0821dde9096", currentProduct.getProductId());
        assertNotEquals("eb558e9f-1c39-460e-8860-71af6af63bd6", currentProduct.getProductId());
    }

    @Test
    void testEditProduct(){
        Product product = new Product();
        product.setProductId("cba5ef02-081c-44c3-a3c8-a49bb37ef505");
        product.setProductName("Hyundai Creta");
        product.setProductQuantity(1);
        productRepository.create(product);

        //Edit
        product.setProductQuantity(2);

        Iterator<Product> productIterator = productRepository.findAll();
        Product current = productIterator.next();
        assertNotEquals(1, current.getProductQuantity());
    }
}
