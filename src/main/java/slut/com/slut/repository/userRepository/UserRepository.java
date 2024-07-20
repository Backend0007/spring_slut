package slut.com.slut.repository.userRepository;

import org.springframework.data.repository.CrudRepository;
import slut.com.slut.entity.userEntity.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {

}
