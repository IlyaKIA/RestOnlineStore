package com.geekbrains.restonlinestore.dto;

import com.geekbrains.restonlinestore.domain.Category;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductSaveDto {
    private Long id;

    private String title;

    private Integer price;

    private Category category;

    private String picturePath;
}
