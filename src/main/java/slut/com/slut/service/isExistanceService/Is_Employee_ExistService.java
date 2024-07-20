package slut.com.slut.service.isExistanceService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import slut.com.slut.entity.employeeEntity.Employee;
import slut.com.slut.repository.isExistanceRepository.Is_Employee_ExistRepository;
import java.util.Optional;

@AllArgsConstructor
@Service
public class Is_Employee_ExistService {
    private final Is_Employee_ExistRepository isEmployeeExistRepository;


    public Boolean _Is_Employee_Exist(String _firstName, String _lastName, String _dateOfBirth) {
        Optional<Employee> _request = isEmployeeExistRepository.findByFirstNameEmployeeAndLastNameEmployeeAndDateOfBirthEmployee(_firstName, _lastName, _dateOfBirth);
        return _request.isPresent();
    }



}
