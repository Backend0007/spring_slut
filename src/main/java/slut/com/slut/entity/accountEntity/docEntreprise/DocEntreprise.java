package slut.com.slut.entity.accountEntity.docEntreprise;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import slut.com.slut.entity.accountEntity.Account;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "DocEntreprise", uniqueConstraints = @UniqueConstraint(name = "unique_numberOfDocument", columnNames = "numberOfDocument"))
public class DocEntreprise {

    @Id
    @Column(unique = true)
    private String IdDocEntreprise;

    private String name;
    private String numberOfDocument;
    private Date dateOfIssue;
    private Date dateOfExpiration;
    private String authorityOfIssue;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdAccount")
    private Account account;
}
