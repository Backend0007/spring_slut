package slut.com.slut.service.ressourcesHumainesService.employee;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import slut.com.slut.entity.employeeEntity.Employee;
import slut.com.slut.repository.ressourcesHumainesRepository.employee.EmployeeRepository;

@AllArgsConstructor
@Service
public class DeleteEmployeeService {
    private final EmployeeRepository employeeRepository;

            public int _deleteEmployee(String IdEmployee){

                   try {
                       employeeRepository.deleteById(IdEmployee);
                       return 30000;
                   } catch (EmptyResultDataAccessException e) {
                       return 30001;
                   }

            }
}
