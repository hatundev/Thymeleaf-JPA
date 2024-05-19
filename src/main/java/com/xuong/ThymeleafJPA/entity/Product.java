package com.xuong.ThymeleafJPA.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", nullable = false, length = 100)
    private String productName;

    @Column(name = "color", nullable = false, length = 50)
    private String color;

    @Column(name = "quantity", nullable = false)
    private Long quantity;

    @Column(name = "sell_price", nullable = false)
    private Double sellPrice;

    @Column(name = "origin_price", nullable = false)
    private Double originPrice;

    @Column(name = "description", length = 1000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "sub_cate_id", nullable = false)
    private SubCategory subCategory;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;

    @ManyToMany
    @JoinTable(name = "product_brand", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "brand_id"))
    private List<Brand> brand;
}
