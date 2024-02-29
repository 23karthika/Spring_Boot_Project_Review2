package com.supermarket.supermarket.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ProductInfo {
    @Id
    private int proid;
    private String proname;
    private int price;

    @JsonBackReference
    @ManyToOne
    private Brand brand;
}
