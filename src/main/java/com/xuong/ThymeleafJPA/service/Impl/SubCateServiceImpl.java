package com.xuong.ThymeleafJPA.service.Impl;

import com.xuong.ThymeleafJPA.entity.SubCategory;
import com.xuong.ThymeleafJPA.repository.SubCateRepository;
import com.xuong.ThymeleafJPA.service.SubCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCateServiceImpl implements SubCateService {
    @Autowired
    private SubCateRepository subCateRepository;

    @Override
    public List<SubCategory> findAll() {
        return subCateRepository.findAll();
    }

    @Override
    public SubCategory findById(Long id) {
        return subCateRepository.findById(id).get();
    }
}
