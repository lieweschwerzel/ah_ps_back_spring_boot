package net.liewe.ah.repository;

import net.liewe.ah.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository <Product, Long >      {
    //search for string, return 20 results max
    List<Product> findAllByProductNameContaining(String searchitem);


}
