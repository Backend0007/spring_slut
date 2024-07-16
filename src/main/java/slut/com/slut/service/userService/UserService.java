package slut.com.slut.service.userService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import slut.com.slut.entity.employeeEntity.Employee;
import slut.com.slut.repository.userRepository.UserRepository;
import slut.com.slut.entity.userEntity.User;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;


    public int _createUserFromService(User user) {
        if(user != null) {
            String _IdUser = UUID.randomUUID().toString();
            user.setIdUser(_IdUser);
            user.setEmployee(this._createFake());
            this.userRepository.save(user);
            return 10000;
        }
        return 10001;
     // Fin de la methode createUser
    }


      public Optional<User> _getUserFromService(String IdUser) {
        if(IdUser != null) {
            return this.userRepository.findById(IdUser);
        }
        return Optional.empty();
    }


    private Employee _createFake(){
        String IdEmployee = UUID.randomUUID().toString();
        Employee employee = new Employee();
        employee.setIdEmployee(IdEmployee);
        return  employee;
    }
 // Fin de la class global
}
