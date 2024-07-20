package slut.com.slut.entity.employeeEntity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "Employee", uniqueConstraints = @UniqueConstraint(name = "unique_email", columnNames = {"emailPersonal","emailProfessional"}))
public class Employee {


    @Id
    @Column(name = "IdEmployee")
    private String IdEmployee;
    private String firstNameEmployee;
    private String lastNameEmployee;
    private int phoneEmployee;

    @Column(unique = true)
    private String emailPersonalEmployee;
    @Column(unique = true)
    private String emailProfessionalEmployee;
    private String photoEmployee;

    @DateTimeFormat(pattern = "dd/MM/yy")
    private String dateOfBirthEmployee;
    private String accademyDegreeOfEmployee;
    private String serviceConcern;
    private String statusOfemployee;
    private String dateOfRecruitement;
    private String hourOfRecruitement;

    @Column(unique = false)
    private String directorGeneral;

    private String streetOfEmployee;
    private String numberStreetOfEmployee;
    private String neighborhoodOfEmployee;
    private String cityOfEmployee;
    private String stateOfEmployee;
    private String countryOfEmployee;
    private String createdEmployeeBy;


    @JsonManagedReference
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DiplomaEmployee> diplomaEmployee;

    @JsonManagedReference
    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private CurruculumAndResumeEmployee curruculumAndResumeEmployee;

    @JsonManagedReference
    @OneToOne(mappedBy ="employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private SignatureEmployee signatureEmployee;

    @JsonManagedReference
    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User user;

}
