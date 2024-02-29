package com.supermarket.supermarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.supermarket.supermarket.model.Brand;
import com.supermarket.supermarket.service.BrandService;
import com.supermarket.supermarket.service.ProductInfoService;

@RestController
public class BrandController {
    @Autowired
    private BrandService brandService;

    @Autowired
    private ProductInfoService productInfoService;

    @PostMapping("/brand")
    public Brand postDetails(@RequestBody Brand brand)
    {
        return brandService.saveDetails(brand);
    }

    @GetMapping("/Brands")
    public List<Brand> getDetails()
    {
        return brandService.listofDetails();
    }

    @GetMapping("/api/brands/sortBy/{field}")
    public ResponseEntity<List<Brand>> sortDetails(@PathVariable ("field") String field)
    {
        List<Brand> b=brandService.lists(field);
        if(b!=null)
        {
            return new ResponseEntity<>(b,HttpStatus.OK);
        }
        return new ResponseEntity<>(b,HttpStatus.NOT_FOUND);
    }

    @GetMapping("/api/brands/{offset}/{pagesize}")
    public ResponseEntity<Page<Brand>>pageDetails(@PathVariable ("offset") int offset,@PathVariable ("pagesize") int pagesize)
    {
        Page<Brand> c=brandService.getDetailsPage(offset,pagesize);
        if(c!=null)
        {
            return new ResponseEntity<>(c,HttpStatus.OK);
        }
        return new ResponseEntity<>(c,HttpStatus.NOT_FOUND);
    }
}
