package slut.com.slut.service.isExistanceService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import slut.com.slut.entity.employeeEntity.Employee;
import slut.com.slut.repository.isExistanceRepository.Is_EmailPersonalExistRepository;
import java.util.Optional;

@AllArgsConstructor
@Service
public class Is_EmailPersonalExistService {
    private final Is_EmailPersonalExistRepository is_emailPersonnalExistRepository;

            public Boolean _IsEmailPersonnalExist(String emailPersonnalEmployee){
                Optional<Employee> _request = is_emailPersonnalExistRepository.findByEmailPersonnalEmployee(emailPersonnalEmployee);
                return _request.isPresent();
            }
}
