package com.geekbrains.restonlinestore.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private Integer price;

    @ManyToOne
    @JoinColumn
    private Category category;

    @Column
    private String picturePath;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return title.equals(product.title) && price.equals(product.price) && Objects.equals(picturePath, product.picturePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, price, picturePath);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", picturePath='" + picturePath + '\'' +
                '}';
    }
}
