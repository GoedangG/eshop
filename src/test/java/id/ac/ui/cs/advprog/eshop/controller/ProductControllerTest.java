package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import id.ac.ui.cs.advprog.eshop.service.ProductServiceImplTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductControllerTest {
    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService productService;

    @Mock
    private Model model;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreateProductGet(){
        //eq for first argument and any() matcher for second argument
        when(model.addAttribute(eq("product"), any(Product.class))).thenReturn(model);

        assertEquals("createProduct", productController.createProductPage(model));
        verify(model).addAttribute(eq("product"), any(Product.class));
        verifyNoMoreInteractions(model);
    }

    @Test
    void testCreateProductPost(){
        Product product = new Product();
        when(productService.create(product)).thenReturn(product);

        assertEquals("redirect:list", productController.createProductPost(product));
        verify(productService).create(product);
        verifyNoMoreInteractions(productService);
    }

    @Test
    void testEditProductGet(){
        Product product = new Product();
        String testId = "123";
        when(productService.get(testId)).thenReturn(product);

        // Act
        String viewName = productController.editProductPage(model, testId);

        // Assert
        assertEquals("editProduct", viewName, "View name should match");
        verify(model).addAttribute("product", product);
        verifyNoMoreInteractions(model);
    }

    @Test
    void testEditProductPost(){
        String testId = "123";
        Product product = new Product();
        when(productService.edit(product, testId)).thenReturn(product);

        String redirectUrl = productController.editProductPost(product, model, testId);

        assertEquals("redirect:/product/list", redirectUrl, "Redirect URL should match");
        verify(productService).edit(product, testId);
        verifyNoMoreInteractions(productService);
    }

    @Test
    void testDeleteProduct(){
        // Arrange
        String testId = "123";
        Product product = new Product();
        when(productService.delete(testId)).thenReturn(true);

        // Act
        String redirectUrl = productController.deleteProductPost(product, model, testId);

        // Assert
        assertEquals("redirect:/product/list", redirectUrl, "Redirect URL should match");
        verify(productService).delete(testId);
        verifyNoMoreInteractions(productService);
    }

    @Test
    void testProductList(){
        List<Product> productList = new ArrayList<>();
        when(productService.findAll()).thenReturn(productList);

        String viewName = productController.productListPage(model);

        assertEquals("productList", viewName, "View name should match");
        verify(model).addAttribute("products", productList);
        verifyNoMoreInteractions(model);
    }
}
