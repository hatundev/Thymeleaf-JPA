package com.xuong.ThymeleafJPA.repository;

import com.xuong.ThymeleafJPA.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
}
