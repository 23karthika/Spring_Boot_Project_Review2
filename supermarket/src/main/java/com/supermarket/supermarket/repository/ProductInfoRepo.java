package com.supermarket.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.supermarket.supermarket.model.ProductInfo;

@Repository
public interface ProductInfoRepo extends JpaRepository<ProductInfo,Integer>{

    @Modifying
    @Query("update ProductInfo product set product.price = ?2 where product.proid = ?1")
    void updatePrice(int proid,int price);

    
}