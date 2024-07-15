package slut.com.slut.entity.employeeEntity.docEmployee;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import slut.com.slut.entity.employeeEntity.Employee;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "DiplomaEmployee")
public class DiplomaEmployee {

    @Id
    @Column(unique = true)
    private String IdDiplomaEmployee;
    private String nameOfDiplomaEmployee;
    private String numberOfDiplomaEmployee;
    private String pathOfDiploma;
    private Date dateOfIssueDiplomaEmployee;
    private String establishmentOfDiplomaIssue;
    private String proffesionDiplomaOfEmployee;

    @ManyToOne
    @JoinColumn(name = "IdEmployee", referencedColumnName = "IdEmployee", foreignKey = @ForeignKey(name = "fk_employee_diploma"))
    private Employee employee;

}
