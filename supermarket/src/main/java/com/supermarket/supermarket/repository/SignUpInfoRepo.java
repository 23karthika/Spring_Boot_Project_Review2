package com.supermarket.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supermarket.supermarket.model.SignUpInfo;

@Repository
public interface SignUpInfoRepo extends JpaRepository<SignUpInfo,Integer> {

    
}