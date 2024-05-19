package com.xuong.ThymeleafJPA.repository;

import com.xuong.ThymeleafJPA.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCateRepository extends JpaRepository<SubCategory, Long> {

}
