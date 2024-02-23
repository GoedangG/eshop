package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepositoryInterface productRepository;

    @Override
    public Product create(Product product){
        product.setProductId(String.valueOf(UUID.randomUUID()));
        productRepository.create(product);
        return product;
    }

    @Override
    public List<Product> findAll(){
        Iterator<Product> productIterator = productRepository.findAll();
        List<Product> allProduct = new ArrayList<>();
        productIterator.forEachRemaining(allProduct::add);
        return allProduct;
    }

    @Override
    public Product get(String id){
        Iterator<Product> products = productRepository.findAll();

        while(products.hasNext()){
            Product current = products.next();
            if(current.getProductId().equals(id)){
                return  current;
            }
        }
        return null;
    }
    @Override
    public boolean delete(String id){
        Product product = get(id);

        if(product != null){
            productRepository.delete(product);
            return true;
        }
        return false;
    }

    @Override
    public Product edit(Product product, String id){
        Iterator<Product> products = productRepository.findAll();

        int index = 0;
        while(products.hasNext()){
            Product current = products.next();
            if(current.getProductId().equals(id)){
                product.setProductId(current.getProductId());
                break;
            }
            index++;
        }
        return productRepository.replace(product, index);
    }
}
