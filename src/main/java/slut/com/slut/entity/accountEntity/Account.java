package slut.com.slut.entity.accountEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import slut.com.slut.entity.accountEntity.docEntreprise.DocEntreprise;
import slut.com.slut.entity.partnerEntity.Partner;
import slut.com.slut.entity.paymentAccountEntity.PaymentAccount;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Account", uniqueConstraints = @UniqueConstraint(name ="unique_IdAccount_BusinessNumber_phone_denomination", columnNames = {"IdAccount","businessNumber","denomination","phone"}))
public class Account {

    @Id
    @Column(unique = true)
    private String IdAccount;
    private String nameOfadministrator;
    private String nameOfunderAdministrator;
    private String phonePro;
    private String businessNumber;
    private String denomination;
    private String status;

    @DateTimeFormat(pattern = "MM-mm-ss")
    private Date hourOfSouscription;
    @DateTimeFormat(pattern = "dd-MM-yy")
    private Date dateOfSouscription;
    private String createByAgency;
    private String manageByAgency;
    private String agentCreator;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdPartner")
    private Partner partners;
    @OneToOne
    private DocEntreprise docEntreprise;
    @OneToOne
    private PaymentAccount paymentAccount;
}
