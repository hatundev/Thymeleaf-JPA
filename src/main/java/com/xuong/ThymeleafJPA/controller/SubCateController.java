package com.xuong.ThymeleafJPA.controller;

import com.xuong.ThymeleafJPA.entity.SubCategory;
import com.xuong.ThymeleafJPA.service.SubCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subcate")
public class SubCateController {
    @Autowired
    private SubCateService subCateService;

    @GetMapping
    public List<SubCategory> findAll() {
        return subCateService.findAll();
    }
}
