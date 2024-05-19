package com.xuong.ThymeleafJPA.repository;


import com.xuong.ThymeleafJPA.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
