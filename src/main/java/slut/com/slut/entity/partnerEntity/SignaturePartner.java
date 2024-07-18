package slut.com.slut.entity.partnerEntity;


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
@Table(name = "SignaturePartner")
public class SignaturePartner {

    @Id
    @Column(unique = true)
    private String IdSignaturePartner;

    @OneToOne
    @JoinColumn(name = "IdPartner")
    private Partner partner;
}
