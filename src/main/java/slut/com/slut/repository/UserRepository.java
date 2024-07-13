package slut.com.slut.repository;

import org.springframework.data.repository.CrudRepository;
import slut.com.slut.entity.User;

import java.util.UUID;

public interface UserRepository extends CrudRepository<User, String> {

}
