package slut.com.slut.entity.userEntity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import slut.com.slut.entity.employeeEntity.Employee;

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

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "IdEmployee", referencedColumnName = "IdEmployee")
    private Employee employee;

    private String username;
    private String firstName;
    private String lastName;

    private String email;

    private String password;
    private int phone;
    private String photo;
    private String role;
    private String status;
    private String service;
    private String number;
    private String address;
    private String neighborhood;
    private String city;
    private String state;
    private String country;
    private Boolean conditions;
    private boolean activation;

    private String userCreatedBy;


}
