package net.liewe.ah.controller;

import net.liewe.ah.model.Product;
import net.liewe.ah.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/prods")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //return all products in a List
    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    //return List for auto complete search from frontend
    @RequestMapping(value = "/search/{searchitem}", method = RequestMethod.GET)
    public List<Product> getSearchResult(@PathVariable("searchitem") String searchitem) {
        return productService.getSearchResult(searchitem);
    }


}


