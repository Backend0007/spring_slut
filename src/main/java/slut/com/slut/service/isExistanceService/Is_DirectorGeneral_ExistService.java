package slut.com.slut.service.isExistanceService;

import lombok.Data;
import org.springframework.stereotype.Service;
import slut.com.slut.entity.employeeEntity.Employee;
import slut.com.slut.repository.ressourcesHumainesRepository.employee.EmployeeRepository;

import java.util.Objects;
import java.util.Optional;


@Service
@Data
public class Is_DirectorGeneral_ExistService {
    private EmployeeRepository employeeRepository;

    public Is_DirectorGeneral_ExistService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    };



    public boolean _is_DirectorGeneral_Exist(String parametter){
            Optional<Employee> _request = employeeRepository.findByDirectorGeneral("true");
        return _request.isPresent() && Objects.equals(parametter, "true");
    }
}
