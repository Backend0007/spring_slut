package slut.com.slut.service.employeeService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import slut.com.slut.entity.employeeEntity.Employee;
import slut.com.slut.entity.employeeEntity.SignatureEmployee;
import slut.com.slut.entity.employeeEntity.docEmployee.CurruculumAndResumeEmployee;
import slut.com.slut.entity.employeeEntity.docEmployee.DiplomaEmployee;
import slut.com.slut.entity.userEntity.User;
import slut.com.slut.repository.ressourcesHumainesRepository.employee.CvAndResumeEmployeeRepository;
import slut.com.slut.repository.ressourcesHumainesRepository.employee.DiplomaEmployeeRepository;
import slut.com.slut.repository.ressourcesHumainesRepository.employee.EmployeeRepository;
import slut.com.slut.repository.ressourcesHumainesRepository.employee.SignatureEmployeeRepository;
import slut.com.slut.repository.userRepository.UserRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final UserRepository userRepository;
    private final DiplomaEmployeeRepository diplomaEmployeeRepository;
    private final CvAndResumeEmployeeRepository cvAndResumeEmployeeRepository;
    private final SignatureEmployeeRepository signatureEmployeeRepository;

    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("dd/MM/yyyy");
    private static final SimpleDateFormat TIME_FORMATTER = new SimpleDateFormat("HH:mm:ss");

    public int _createEmployeeFromService(Employee employee){
        if (employee == null) {
            return 20001;
        }

        String employeeId = UUID.randomUUID().toString();
        String userId = UUID.randomUUID().toString();
        String _IdDiploma = UUID.randomUUID().toString();
        String _IdCvAndResume = UUID.randomUUID().toString();
        String _IdSignature = UUID.randomUUID().toString() ;


        Date currentDate = new Date();

        String formattedDate = DATE_FORMATTER.format(currentDate);
        String formattedTime = TIME_FORMATTER.format(currentDate);

        employee.setIdEmployee(employeeId);
        employee.setDateOfRecruitement(formattedDate);
        employee.setHourOfRecruitement(formattedTime);

        User user = _createUserFromEmployee(employee, userId);
        DiplomaEmployee diploma = _createDiploma(employee, _IdDiploma);
        CurruculumAndResumeEmployee cvAndResume= _createCvAndResume(employee, _IdCvAndResume);
        SignatureEmployee signature = _createSignature(employee, _IdSignature);

        employeeRepository.save(employee);
        diplomaEmployeeRepository.save(diploma);
        cvAndResumeEmployeeRepository.save(cvAndResume);
        signatureEmployeeRepository.save(signature);
        userRepository.save(user);


        return 20000;
    }

    private User _createUserFromEmployee(Employee employee, String userId) {
        User user = new User();
        user.setIdUser(userId);
        user.setUsername(employee.getFirstNameEmployee() + "-" + employee.getLastNameEmployee());
        user.setFirstName(employee.getFirstNameEmployee());
        user.setLastName(employee.getLastNameEmployee());
        user.setPhone(employee.getPhoneEmployee());
        user.setPhoto(employee.getPhotoEmployee());
        user.setService(employee.getServiceConcern());
        user.setStatus(employee.getStatusOfemployee());
        user.setAddress(employee.getStreetOfEmployee());
        user.setNumber(employee.getNumberStreetOfEmployee());
        user.setNeighborhood(employee.getNeighborhoodOfEmployee());
        user.setCity(employee.getCityOfEmployee());
        user.setState(employee.getStateOfEmployee());
        user.setCountry(employee.getCountryOfEmployee());
        user.setActivation(false);
        return user;
    }

    private DiplomaEmployee _createDiploma(Employee employee, String _IdDiploma){
        DiplomaEmployee diploma = new DiplomaEmployee();
        diploma.setIdDiplomaEmployee(_IdDiploma);
        diploma.setEmployee(employee);
        return diploma;
    }

    private CurruculumAndResumeEmployee _createCvAndResume(Employee employee, String _IdCvAndResume){
        CurruculumAndResumeEmployee cvAnResume = new CurruculumAndResumeEmployee();
        cvAnResume.setIdCurruculumAndResume(_IdCvAndResume);
        cvAnResume.setEmployee(employee);
        return cvAnResume;
    }

    private SignatureEmployee _createSignature(Employee employee, String _IdSignature){
        SignatureEmployee signature = new SignatureEmployee();
        signature.setIdSignatureEmployee(_IdSignature);
        signature.setEmployee(employee);
        return signature;
    }
}
