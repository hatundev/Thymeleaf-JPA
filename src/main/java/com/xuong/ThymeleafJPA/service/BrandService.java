package com.xuong.ThymeleafJPA.service;

import com.xuong.ThymeleafJPA.entity.Brand;

import java.util.List;


public interface BrandService {
    List<Brand> findAll();

    Brand findById(Long id);
}
