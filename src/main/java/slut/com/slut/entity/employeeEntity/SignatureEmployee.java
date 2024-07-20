package slut.com.slut.entity.employeeEntity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "SignatureEmployee")
public class SignatureEmployee {

    @Id
    @Column(unique = true)
    private String IdSignatureEmployee;
    private String Signature;


    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "IdEmployee", referencedColumnName = "IdEmployee", foreignKey = @ForeignKey(name = "fk_imployee_signature"))
    private Employee employee;
}
