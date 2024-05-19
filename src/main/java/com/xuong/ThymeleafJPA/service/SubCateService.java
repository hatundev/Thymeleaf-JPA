package com.xuong.ThymeleafJPA.service;

import com.xuong.ThymeleafJPA.entity.SubCategory;

import java.util.List;

public interface SubCateService {
    List<SubCategory> findAll();

    SubCategory findById(Long id);
}
