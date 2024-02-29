package com.supermarket.supermarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.supermarket.supermarket.model.ProductInfo;
import com.supermarket.supermarket.repository.ProductInfoRepo;

import jakarta.transaction.Transactional;

@Service
public class ProductInfoService {
    @Autowired 
    private ProductInfoRepo productInfoRepo;


    public ProductInfo sendpro(ProductInfo productInfo)
    {
        return productInfoRepo.save(productInfo);
    }

    public List<ProductInfo> listofproducts()
    {
        return productInfoRepo.findAll();
    }

    public List<ProductInfo>listofPro(String field)
    {
        return productInfoRepo.findAll(Sort.by(Sort.Direction.ASC,field));
    }

    public Page<ProductInfo>getProPage(int offset,int pagesize)
    {
        return productInfoRepo.findAll(PageRequest.of(offset,pagesize));
    }

    @Transactional
    public void putPrice(int proid, int price) {
        productInfoRepo.updatePrice(proid, price);
    }

    
}
