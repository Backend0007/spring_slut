package slut.com.slut.repository.ressourcesHumainesRepository.employee;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import slut.com.slut.entity.employeeEntity.Employee;

import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, String> {

    @Query("SELECT e FROM Employee e WHERE e.emailProfessionalEmployee = :email OR e.emailPersonalEmployee = :email")
    Optional<Employee> findByEmailProfessionalEmployeeOrEmailPersonalEmployee(String email);

}
