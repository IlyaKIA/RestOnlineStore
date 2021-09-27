package com.geekbrains.restonlinestore.service.impl;

import com.geekbrains.restonlinestore.domain.Product;
import com.geekbrains.restonlinestore.dto.ProductSaveDto;
import com.geekbrains.restonlinestore.dto.ProductViewDto;
import com.geekbrains.restonlinestore.repository.ProductRepository;
import com.geekbrains.restonlinestore.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ModelMapper modelMapper;

    private final ProductRepository productRepository;

    @Override
    public List<ProductViewDto> getProducts() {
        List<Product> productList = productRepository.findAll();
        return productList.stream()
                .map(product -> modelMapper.map(product, ProductViewDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductViewDto saveProduct(ProductSaveDto product) {
        Product newProduct = modelMapper.map(product, Product.class);
        Product ProductEntity = productRepository.save(newProduct);
        return ProductViewDto.builder()
                .id(ProductEntity.getId())
                .title(ProductEntity.getTitle())
                .price(ProductEntity.getPrice())
                .build();
    }

    @Override
    public List<ProductViewDto> getProductsByPriceBetween(Integer minPrice, Integer maxPrice) {
        List<Product> productList = productRepository.findProductsByPriceBetween(minPrice, maxPrice);
        return productList.stream()
                .map(product -> modelMapper.map(product, ProductViewDto.class))
                .collect(Collectors.toList());
    }
}
