package com.xuong.ThymeleafJPA.controller;

import com.xuong.ThymeleafJPA.entity.Status;
import com.xuong.ThymeleafJPA.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController {
    @Autowired
    private StatusService statusService;

    @GetMapping()
    public List<Status> findAll(){
        return statusService.findAll();
    }
}
