package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.Iterator;

public interface ProductRepositoryInterface {
    public Product create(Product product);
    public Iterator<Product> findAll();
    public boolean delete(Product product);
    public Product replace(Product product, int index);
}
