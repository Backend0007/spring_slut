package slut.com.slut.entity.paymentAccountEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import slut.com.slut.entity.accountEntity.Account;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "PaymentAccount")
public class PaymentAccount {


    @Id
    @Column(unique = true)
    private int mobileAccount;
    private String nameOfOperator;


    @OneToOne
    @JoinColumn(name = "IdAccount")
    private Account account;
}
