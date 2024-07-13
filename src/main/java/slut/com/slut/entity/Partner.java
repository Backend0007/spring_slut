package slut.com.slut.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name= "Partner", uniqueConstraints = @UniqueConstraint(name="unique_email_phone", columnNames = "email"))
public class Partner {

    @Id
    @Column(unique = true)
    private String IdPartner;

    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private int phone;
    private String photo;
    private int NumberAdress;
    private String Adress;
    private String Quartier;
    private String Commune;
    private String Province;
    private String Pays;
}
