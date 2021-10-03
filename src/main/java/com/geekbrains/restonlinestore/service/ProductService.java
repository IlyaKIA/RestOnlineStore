package com.geekbrains.restonlinestore.service;

import com.geekbrains.restonlinestore.domain.Product;
import com.geekbrains.restonlinestore.dto.ProductSaveDto;
import com.geekbrains.restonlinestore.dto.ProductViewDto;
import com.geekbrains.restonlinestore.repository.ProductRepository;

import java.util.List;

public interface ProductService {

    List<ProductViewDto> getProducts();

    public ProductViewDto saveProduct(ProductSaveDto product) ;

    List<ProductViewDto> getProductsByPriceBetween(Integer minPrice, Integer maxPrice);
}
