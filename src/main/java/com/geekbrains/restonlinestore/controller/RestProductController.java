package com.geekbrains.restonlinestore.controller;

import com.geekbrains.restonlinestore.dto.ProductSaveDto;
import com.geekbrains.restonlinestore.dto.ProductViewDto;
import com.geekbrains.restonlinestore.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.geekbrains.restonlinestore.domain.constant.RestControllerName.API_V1;
import static com.geekbrains.restonlinestore.domain.constant.RestControllerName.PRODUCT;

@RestController
@RequestMapping(API_V1 + PRODUCT)
@RequiredArgsConstructor
public class RestProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductViewDto> getProducts(@RequestParam(value ="minPrice", required = false) Integer minPrice,
                                            @RequestParam(value ="maxPrice", required = false) Integer maxPrice){
        if(minPrice != null || maxPrice != null){
            List<ProductViewDto> productViewDto = productService.getProductsByPriceBetween(minPrice, maxPrice);
            System.out.println(productViewDto);
            return productViewDto;
        } else return productService.getProducts();
    }


    @PostMapping
    public ProductViewDto saveProduct(@RequestBody ProductSaveDto product){
        return productService.saveProduct(product);
    }
}
