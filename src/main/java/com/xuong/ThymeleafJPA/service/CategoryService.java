package com.xuong.ThymeleafJPA.service;

import com.xuong.ThymeleafJPA.entity.Category;
import java.util.List;

public interface CategoryService {
    List<Category> findAll();
}
