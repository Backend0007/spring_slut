package slut.com.slut.entity.employeeEntity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import slut.com.slut.entity.employeeEntity.docEmployee.DiplomaEmployee;
import slut.com.slut.entity.employeeEntity.docEmployee.CurruculumAndResumeEmployee;
import slut.com.slut.entity.userEntity.User;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Employee", uniqueConstraints = @UniqueConstraint(name = "unique_director", columnNames = "directorGeneral"))
public class Employee {


    @Id
    @Column(name = "IdEmployee")
    private String IdEmployee;
    private String firstNameEmployee;
    private String lastNameEmployee;
    private int phoneEmployee;
    private String photoEmployee;

    @DateTimeFormat(pattern = "dd/MM/yy")
    private String dateOfBirthEmployee;
    private String accademyDegreeOfEmployee;
    private String serviceConcern;
    private String statusOfemployee;
    private String dateOfRecruitement;
    private String hourOfRecruitement;
    @Column(unique = true)
    private boolean directorGeneral;
    private String streetOfEmployee;
    private String numberStreetOfEmployee;
    private String neighborhoodOfEmployee;
    private String cityOfEmployee;
    private String stateOfEmployee;
    private String countryOfEmployee;


    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DiplomaEmployee> diplomaEmployee;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private CurruculumAndResumeEmployee curruculumAndResumeEmployee;
    @OneToOne(mappedBy ="employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private SignatureEmployee signatureEmployee;
    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User user;

}