package slut.com.slut.service.ressourcesHumainesService.employee;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
import slut.com.slut.service.isExistanceService.Is_EmailPersonalExistService;
import slut.com.slut.service.isExistanceService.Is_EmailProfessionalExistService;
import slut.com.slut.service.isExistanceService.Is_Employee_ExistService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@AllArgsConstructor
@Service
public class CreateEmployeeService {
    private final EmployeeRepository employeeRepository;
    private final UserRepository userRepository;
    private final DiplomaEmployeeRepository diplomaEmployeeRepository;
    private final CvAndResumeEmployeeRepository cvAndResumeEmployeeRepository;
    private final SignatureEmployeeRepository signatureEmployeeRepository;
    private final Is_Employee_ExistService isEmployeeExistService;
    private final Is_EmailProfessionalExistService isEmailProfessionalExistService;
    private final Is_EmailPersonalExistService isEmailPersonalExistService;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Transactional
    public int _createEmployeeFromService(Employee employee) {
        if (employee == null) {
            return 20001;
        }

        Boolean IsExist = isEmployeeExistService._Is_Employee_Exist(employee.getFirstNameEmployee(), employee.getLastNameEmployee(), employee.getDateOfBirthEmployee());
        if (IsExist) {
            return 20011;
        }

        Boolean IsEmailPersExist = isEmailPersonalExistService._IsEmailPersonnalExist(employee.getEmailPersonnalEmployee());
        if (IsEmailPersExist) {
            return 20003;
        }

        Boolean IsEmailProExist = isEmailProfessionalExistService._Is_EmailProfessionalExist(employee.getEmailProfessionalEmployee());
        if (IsEmailProExist) {
            return 20033;
        }

        String employeeId = UUID.randomUUID().toString();
        String userId = UUID.randomUUID().toString();
        String _IdDiploma = UUID.randomUUID().toString();
        String _IdCvAndResume = UUID.randomUUID().toString();
        String _IdSignature = UUID.randomUUID().toString();

        LocalDateTime currentDate = LocalDateTime.now();
        String formattedDate = currentDate.format(DATE_FORMATTER);
        String formattedTime = currentDate.format(TIME_FORMATTER);

        employee.setIdEmployee(employeeId);
        employee.setDateOfRecruitement(formattedDate);
        employee.setHourOfRecruitement(formattedTime);

        User user = _createUserFromEmployee(employee, userId);
        DiplomaEmployee diploma = _createDiploma(employee, _IdDiploma);
        CurruculumAndResumeEmployee cvAndResume = _createCvAndResume(employee, _IdCvAndResume);
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

    private DiplomaEmployee _createDiploma(Employee employee, String _IdDiploma) {
        DiplomaEmployee diploma = new DiplomaEmployee();
        diploma.setIdDiplomaEmployee(_IdDiploma);
        diploma.setEmployee(employee);
        return diploma;
    }

    private CurruculumAndResumeEmployee _createCvAndResume(Employee employee, String _IdCvAndResume) {
        CurruculumAndResumeEmployee cvAnResume = new CurruculumAndResumeEmployee();
        cvAnResume.setIdCurruculumAndResume(_IdCvAndResume);
        cvAnResume.setEmployee(employee);
        return cvAnResume;
    }

    private SignatureEmployee _createSignature(Employee employee, String _IdSignature) {
        SignatureEmployee signature = new SignatureEmployee();
        signature.setIdSignatureEmployee(_IdSignature);
        signature.setEmployee(employee);
        return signature;
    }
}
