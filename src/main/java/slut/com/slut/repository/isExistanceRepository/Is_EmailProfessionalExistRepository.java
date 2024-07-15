package slut.com.slut.repository.isExistanceRepository;

import org.springframework.data.repository.CrudRepository;
import slut.com.slut.entity.employeeEntity.Employee;
import java.util.Optional;

public interface Is_EmailProfessionalExistRepository extends CrudRepository<Employee, String> {
    Optional<Employee> findByEmailProfessionalEmployee(String emailProfessionalEmployee);
}
