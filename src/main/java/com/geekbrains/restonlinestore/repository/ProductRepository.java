package com.geekbrains.restonlinestore.repository;

import com.geekbrains.restonlinestore.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductsByPriceBetween(Integer minPrice, Integer maxPrice);

}
