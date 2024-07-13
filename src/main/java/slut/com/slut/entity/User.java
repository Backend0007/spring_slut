package slut.com.slut.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Users", uniqueConstraints = @UniqueConstraint(name="unique_email_IdUser", columnNames = {"email","IdUser"}))
public class User {



    @Id
    @Column(unique = true)
    private String IdUser;

    private String username;
    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;

    private String password;
    private int phone;
    private String photo;
    private String role;
    private String status;
    private String service;
    private String address;
    private String city;
    private String state;
    private String country;
    private Boolean conditions;
}
