package com.xuong.ThymeleafJPA.repository;

import com.xuong.ThymeleafJPA.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CateRepository extends JpaRepository<Category, Long> {
}
