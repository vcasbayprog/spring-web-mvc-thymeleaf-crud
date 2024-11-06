package com.example.spring_web_mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_web_mvc.entity.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

}
