package com.xuong.ThymeleafJPA.service.Impl;

import com.xuong.ThymeleafJPA.entity.Brand;
import com.xuong.ThymeleafJPA.repository.BrandRepository;
import com.xuong.ThymeleafJPA.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public Brand findById(Long id) {
        return brandRepository.findById(id).get();
    }
}
