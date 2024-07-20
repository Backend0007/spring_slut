package slut.com.slut.repository.isExistanceRepository;

import org.springframework.data.repository.CrudRepository;
import slut.com.slut.entity.employeeEntity.Employee;

import java.util.Optional;

public interface Is_Employee_ExistRepository extends CrudRepository<Employee, String> {
    Optional<Employee> findByFirstNameEmployeeAndLastNameEmployeeAndDateOfBirthEmployee(String firstName, String lastName, String dateOfbirth);
}

