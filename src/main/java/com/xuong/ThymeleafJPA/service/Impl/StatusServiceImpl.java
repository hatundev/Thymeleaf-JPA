package com.xuong.ThymeleafJPA.service.Impl;

import com.xuong.ThymeleafJPA.entity.Status;
import com.xuong.ThymeleafJPA.repository.StatusRepository;
import com.xuong.ThymeleafJPA.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    private StatusRepository statusRepository;

    @Override
    public List<Status> findAll() {
        return statusRepository.findAll();
    }

    @Override
    public Status findById(Long id) {
        return statusRepository.findById(id).get();
    }
}
