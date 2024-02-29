package com.supermarket.supermarket.model;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SignUp {
    @Id
    private int userId;
    private String userName;
    private String email;
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    private SignUpInfo signUpInfo;
}
