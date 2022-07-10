package net.liewe.ah.service;

import net.liewe.ah.model.Product;
import net.liewe.ah.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public List<Product> getSearchResult(String searchitem) {
        return productRepository.findTop20ByProductNameContaining(searchitem);
    }
}
