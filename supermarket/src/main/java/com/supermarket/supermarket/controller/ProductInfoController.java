package com.supermarket.supermarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.supermarket.supermarket.model.ProductInfo;
import com.supermarket.supermarket.service.ProductInfoService;

@RestController
public class ProductInfoController {
    @Autowired
    private ProductInfoService productInfoService;

    @PostMapping("/product")
    public ProductInfo sendDetails(@RequestBody ProductInfo productInfo)
    {
        return productInfoService.sendpro(productInfo);
    }

    @GetMapping("/products")
    public List<ProductInfo> getprodet()
    {
        return productInfoService.listofproducts();
    }

     @GetMapping("/api/products/sortBy/{field}")
    public ResponseEntity<List<ProductInfo>> sortpro(@PathVariable ("field") String field)
    {
        List<ProductInfo> b=productInfoService.listofPro(field);
        if(b!=null)
        {
            return new ResponseEntity<>(b,HttpStatus.OK);
        }
        return new ResponseEntity<>(b,HttpStatus.NOT_FOUND);
    }

    @GetMapping("/api/products/{offset}/{pagesize}")
    public ResponseEntity<Page<ProductInfo>>pageProductDetails(@PathVariable ("offset") int offset,@PathVariable ("pagesize") int pagesize)
    {
        Page<ProductInfo> c=productInfoService.getProPage(offset,pagesize);
        if(c!=null)
        {
            return new ResponseEntity<>(c,HttpStatus.OK);
        }
        return new ResponseEntity<>(c,HttpStatus.NOT_FOUND);
    }

    @PutMapping("/api/updateprice/{id}")
    public ResponseEntity<Void> put(@PathVariable int proid, @RequestParam int price) {
        productInfoService.putPrice(proid, price);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
