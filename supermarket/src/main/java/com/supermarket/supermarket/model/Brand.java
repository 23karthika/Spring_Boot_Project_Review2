package com.supermarket.supermarket.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Brand {
    @Id
    private int brandId;
    private String brandName;

    @JsonManagedReference
    @OneToMany(mappedBy = "brand",cascade = CascadeType.ALL)
    private List<ProductInfo> productInfo;
}
