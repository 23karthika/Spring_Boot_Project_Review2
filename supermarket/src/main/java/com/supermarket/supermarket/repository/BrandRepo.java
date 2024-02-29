package com.supermarket.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supermarket.supermarket.model.Brand;

@Repository
public interface BrandRepo extends JpaRepository<Brand,Integer> {

    
}