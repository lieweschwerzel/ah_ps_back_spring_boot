package net.liewe.ah.repository;

import net.liewe.ah.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository <Product, Long >      {
    //search for string, return 20 results max
    //@Query("select  from product product where product.product_name like %?1%")
    List<Product> findAllByProductNameContaining(String searchitem);


}
