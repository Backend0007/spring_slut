package slut.com.slut.entity.partnerEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import slut.com.slut.entity.accountEntity.Account;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name= "Partner", uniqueConstraints = @UniqueConstraint(name="unique_email_phonePro", columnNames = {"email","phonePro"}))
public class Partner {

    @Id
    @Column(unique = true)
    private String IdPartner;

    private String userNamePartner;
    private String firstNamePartner;
    private String lastNamePartner;
    private String emailPartner;
    private int phonePartner;
    private String photoPartner;
    private int numberOfAdressPartner;
    private String adressPartner;
    private String neighborhoodPartner;
    private String cityPartner;
    private String statePartner;
    private String countryPartner;


    @OneToMany
    private List<Account> accounts;

    @OneToOne
    private SignaturePartner signaturePartner;
}
