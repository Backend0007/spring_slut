package slut.com.slut.service.isExistanceService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import slut.com.slut.entity.employeeEntity.Employee;
import slut.com.slut.repository.isExistanceRepository.Is_EmailPersonalExistRepository;
import java.util.Optional;

@AllArgsConstructor
@Service
public class Is_EmailPersonalExistService {
    private final Is_EmailPersonalExistRepository is_emailPersonalExistRepository;

            public Boolean _IsEmailPersonalExist(String emailPersonalEmployee){
                Optional<Employee> _request = is_emailPersonalExistRepository.findByEmailPersonalEmployee(emailPersonalEmployee);
                return _request.isPresent();
            }
}
