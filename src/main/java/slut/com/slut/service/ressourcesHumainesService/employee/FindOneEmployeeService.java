package slut.com.slut.service.ressourcesHumainesService.employee;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import slut.com.slut.entity.employeeEntity.Employee;
import slut.com.slut.repository.ressourcesHumainesRepository.employee.EmployeeRepository;
import java.util.Optional;

@AllArgsConstructor
@Service
public class FindOneEmployeeService {
    private EmployeeRepository employeeRepository;


    public Optional<Employee> _findOneEmployee(String emailProfessional){
        if(emailProfessional != null) {
            return employeeRepository.findByEmailProfessionalEmployee(emailProfessional);
        }
        return Optional.empty();
    }
}
