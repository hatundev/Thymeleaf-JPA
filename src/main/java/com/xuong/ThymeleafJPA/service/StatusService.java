package com.xuong.ThymeleafJPA.service;

import com.xuong.ThymeleafJPA.entity.Status;

import java.util.List;

public interface StatusService {
    List<Status> findAll();

    Status findById(Long id);
}
