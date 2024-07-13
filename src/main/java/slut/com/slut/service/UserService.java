package slut.com.slut.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import slut.com.slut.repository.UserRepository;
import slut.com.slut.entity.User;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;




    public int _createUser(User user) {
        int code;
        if(user != null) {
            String _IdUser = UUID.randomUUID().toString();
            user.setIdUser(_IdUser);
            this.userRepository.save(user);
            code = 10025;
            return code;
        }
        code = 10024;
        return code;
     // Fin de la methode createUser
    }





      public Optional<User> _getUser(String IdUser) {
        if(IdUser != null) {
            return this.userRepository.findById(IdUser);
        }
        return Optional.empty();
    }
 // Fin de la class global
}
