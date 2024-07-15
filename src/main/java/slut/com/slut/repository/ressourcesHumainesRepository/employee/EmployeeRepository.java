package slut.com.slut.repository.ressourcesHumainesRepository.employee;

import org.springframework.data.repository.CrudRepository;
import slut.com.slut.entity.employeeEntity.Employee;

import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, String> {
    Optional<Employee> findByEmailProfessionalEmployee(String emailProfessional);
}
