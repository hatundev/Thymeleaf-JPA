package com.xuong.ThymeleafJPA.controller;

import com.xuong.ThymeleafJPA.entity.Category;
import com.xuong.ThymeleafJPA.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
@RequestMapping("/cate")
public class CateController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public List<Category> findAll() {
        return categoryService.findAll();
    }
}
