package com.supermarket.supermarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.supermarket.supermarket.model.SignUp;
import com.supermarket.supermarket.repository.SignUpRepo;

@Service
public class SignUpService {
    @Autowired
    private SignUpRepo signUpRepo;

    public SignUp post(SignUp signUp)
    {
        return signUpRepo.save(signUp);
    }

    public List<SignUp>listofcustomer()
    {
        return signUpRepo.findAll();
    }

    public List<SignUp>signupDetails(String field)
    {
        return signUpRepo.findAll(Sort.by(Sort.Direction.ASC,field));
    }

    public Page<SignUp>getsignPage(int offset,int pagesize)
    {
        return signUpRepo.findAll(PageRequest.of(offset,pagesize));
    }

}
