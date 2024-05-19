package com.xuong.ThymeleafJPA.service.Impl;

import com.xuong.ThymeleafJPA.entity.Category;
import com.xuong.ThymeleafJPA.repository.CateRepository;
import com.xuong.ThymeleafJPA.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CateServiceImpl implements CategoryService {
    @Autowired
    private CateRepository cateRepository;

    @Override
    public List<Category> findAll() {
        return cateRepository.findAll();
    }
}
