package com.supermarket.supermarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.supermarket.supermarket.model.Brand;
import com.supermarket.supermarket.repository.BrandRepo;

@Service
public class BrandService {
    @Autowired
    private BrandRepo brandRepo;

    public Brand saveDetails(Brand brand)
    {
        return brandRepo.save(brand);
    }

    public List<Brand> listofDetails()
    {
        return brandRepo.findAll();
    }

    public List<Brand>lists(String field)
    {
        return brandRepo.findAll(Sort.by(Sort.Direction.ASC,field));
    }

    public Page<Brand>getDetailsPage(int offset,int pagesize)
    {
        return brandRepo.findAll(PageRequest.of(offset,pagesize));
    }
}
