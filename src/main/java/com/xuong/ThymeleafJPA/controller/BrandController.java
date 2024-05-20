package com.xuong.ThymeleafJPA.controller;

import com.xuong.ThymeleafJPA.entity.Brand;
import com.xuong.ThymeleafJPA.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping()
    public List<Brand> findAll() {
        return brandService.findAll();
    }

}
