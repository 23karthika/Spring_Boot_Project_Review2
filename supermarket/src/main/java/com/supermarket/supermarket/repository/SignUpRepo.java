package com.supermarket.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supermarket.supermarket.model.SignUp;

@Repository
public interface SignUpRepo extends JpaRepository<SignUp,Integer> {

    
} 