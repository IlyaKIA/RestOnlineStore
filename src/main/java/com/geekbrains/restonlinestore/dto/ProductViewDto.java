package com.geekbrains.restonlinestore.dto;

import com.geekbrains.restonlinestore.domain.Category;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductViewDto {
    private Long id;

    private String title;

    private Integer price;

//    private Category category;

//    private String picturePath;
}
