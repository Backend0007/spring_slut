package slut.com.slut.controller.userController;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import slut.com.slut.service.userService.UserService;
import slut.com.slut.entity.userEntity.User;

import java.util.Optional;


@RestController
@AllArgsConstructor
@RequestMapping("user")
public class UserController {
    private final UserService userService;





    @PostMapping("create")
    public int _createUserFromController(@RequestBody User user) {
        return  this.userService._createUserFromService(user);
    }



    @GetMapping("get/{idUser}")
    public ResponseEntity<User> _ListUserFromController(@PathVariable("idUser") String IdUser) {
           Optional<User> user = this.userService._getUserFromService(IdUser);
            return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity
                                                                .notFound()
                                                                .build());
   }




}
