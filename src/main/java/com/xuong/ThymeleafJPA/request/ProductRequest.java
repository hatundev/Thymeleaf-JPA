package com.xuong.ThymeleafJPA.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductRequest {
    private Long id;
    private String productName;
    private String color;
    private Long quantity;
    private Double sellPrice;
    private Double originPrice;
    private Long brandId;
    private Long subCateId;
    private Long statusId;
}
