package com.supermarket.supermarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.supermarket.supermarket.model.SignUpInfo;
import com.supermarket.supermarket.repository.SignUpInfoRepo;

@Service
public class SignUpInfoService {
    @Autowired
    private SignUpInfoRepo signUpInfoRepo;
    
    public SignUpInfo saveDetails(SignUpInfo signUpInfo)
    {
        return signUpInfoRepo.save(signUpInfo);
    }

    public List<SignUpInfo> listofDetails()
    {
        return signUpInfoRepo.findAll();
    }

    public List<SignUpInfo>signupInfoDetails(String field)
    {
        return signUpInfoRepo.findAll(Sort.by(Sort.Direction.ASC,field));
    }

    public Page<SignUpInfo>getsignInfoPage(int offset,int pagesize)
    {
        return signUpInfoRepo.findAll(PageRequest.of(offset,pagesize));
    }
}
