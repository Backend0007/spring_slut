package slut.com.slut.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import slut.com.slut.service.UserService;
import slut.com.slut.entity.User;
import slut.com.slut.service.response.Response;

import java.util.Optional;


@RestController
@AllArgsConstructor
@RequestMapping("user")
public class UserController {
    private final UserService userService;





    @PostMapping("create")
    public int _createUser(@RequestBody User user) {
        return  this.userService._createUser(user);
    }



    @GetMapping("get/{idUser}")
    public ResponseEntity<User> _ListUser(@PathVariable("idUser") String IdUser) {
           Optional<User> user = this.userService._getUser(IdUser);
            return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity
                                                                .notFound()
                                                                .build());
   }




}
