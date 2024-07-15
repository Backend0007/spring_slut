package slut.com.slut.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
public class MainController {


           @GetMapping("/test")
           public String Index() {

               return "Fonctionnelle API";
           }

}
