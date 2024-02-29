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

import com.supermarket.supermarket.model.SignUp;
import com.supermarket.supermarket.model.SignUpInfo;
import com.supermarket.supermarket.service.SignUpInfoService;
import com.supermarket.supermarket.service.SignUpService;

@RestController
public class SignUpController {
    @Autowired
    private SignUpService signUpService;

    @Autowired
    private SignUpInfoService signUpInfoService;

    @PostMapping("/signUp")
    public SignUp postDetails(@RequestBody SignUp signUp)
    {
        return signUpService.post(signUp);
    }

    @GetMapping("/signupdet")
    public List<SignUp> getDetails()
    {
        return signUpService.listofcustomer();
    }


    @PostMapping("/sign")
    public SignUpInfo create(@RequestBody SignUpInfo signUpInfo)
    {
        return signUpInfoService.saveDetails(signUpInfo);
    }


    @GetMapping("/getdet")
    public List<SignUpInfo> getDatas()
    {
        return signUpInfoService.listofDetails();
    }

    @GetMapping("/api/signUp/sortBy/{field}")
    public ResponseEntity<List<SignUp>> sort(@PathVariable ("field") String field)
    {
        List<SignUp> b=signUpService.signupDetails(field);
        if(b!=null)
        {
            return new ResponseEntity<>(b,HttpStatus.OK);
        }
        return new ResponseEntity<>(b,HttpStatus.NOT_FOUND);
    }

    @GetMapping("/api/signUp/{offset}/{pagesize}")
    public ResponseEntity<Page<SignUp>>signpage(@PathVariable ("offset") int offset,@PathVariable ("pagesize") int pagesize)
    {
        Page<SignUp> c=signUpService.getsignPage(offset,pagesize);
        if(c!=null)
        {
            return new ResponseEntity<>(c,HttpStatus.OK);
        }
        return new ResponseEntity<>(c,HttpStatus.NOT_FOUND);
    }

    @GetMapping("/api/signUpInfo/sortBy/{field}")
    public ResponseEntity<List<SignUpInfo>> sortsignInfo(@PathVariable ("field") String field)
    {
        List<SignUpInfo> b=signUpInfoService.signupInfoDetails(field);
        if(b!=null)
        {
            return new ResponseEntity<>(b,HttpStatus.OK);
        }
        return new ResponseEntity<>(b,HttpStatus.NOT_FOUND);
    }

    @GetMapping("/api/signUpInfo/{offset}/{pagesize}")
    public ResponseEntity<Page<SignUpInfo>>signUppage(@PathVariable ("offset") int offset,@PathVariable ("pagesize") int pagesize)
    {
        Page<SignUpInfo> c=signUpInfoService.getsignInfoPage(offset,pagesize);
        if(c!=null)
        {
            return new ResponseEntity<>(c,HttpStatus.OK);
        }
        return new ResponseEntity<>(c,HttpStatus.NOT_FOUND);
    }

}
