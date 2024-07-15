package slut.com.slut.controller.ressourcesHumaines;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import slut.com.slut.entity.employeeEntity.Employee;
import slut.com.slut.service.employeeService.EmployeeService;

@RestController
@AllArgsConstructor
@RequestMapping("ressources_humaine")
public class RhController {
    private final EmployeeService employeeService;


     @PostMapping("create")
     public int _CreateEmployee(@RequestBody Employee employee){
         return this.employeeService._createEmployeeFromService(employee);
     }

}
