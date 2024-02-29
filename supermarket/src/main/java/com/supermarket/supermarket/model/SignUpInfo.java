package com.supermarket.supermarket.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SignUpInfo {
    @Id
    private int uid;
    private int age;
    private String fname;
    private String lname;
    private String phoneNumber;
    private String address;

}
