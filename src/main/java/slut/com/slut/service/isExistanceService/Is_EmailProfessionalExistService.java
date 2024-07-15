package slut.com.slut.service.isExistanceService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import slut.com.slut.entity.employeeEntity.Employee;
import slut.com.slut.repository.isExistanceRepository.Is_EmailProfessionalExistRepository;
import java.util.Optional;

@AllArgsConstructor
@Service
public class Is_EmailProfessionalExistService {
    private Is_EmailProfessionalExistRepository isEmailProfessionalExistRepository;



    public Boolean _Is_EmailProfessionalExist(String emailProfessionalEmployee) {
        Optional<Employee> _request = isEmailProfessionalExistRepository.findByEmailProfessionalEmployee(emailProfessionalEmployee);
              return _request.isPresent();
           }

}
