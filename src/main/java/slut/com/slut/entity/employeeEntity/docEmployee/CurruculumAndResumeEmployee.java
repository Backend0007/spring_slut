package slut.com.slut.entity.employeeEntity.docEmployee;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import slut.com.slut.entity.employeeEntity.Employee;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "CurruculumAndResumeEmployee")
public class CurruculumAndResumeEmployee {

    @Id
    @Column(unique = true)
    private String IdCurruculumAndResume;
    private String Curruculum;
    private String Resume;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "IdEmployee", referencedColumnName = "IdEmployee", foreignKey = @ForeignKey(name = "fk_employee_cvAnResume"))
    private Employee employee;
}
