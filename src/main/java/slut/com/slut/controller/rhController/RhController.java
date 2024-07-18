package slut.com.slut.controller.rhController;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import slut.com.slut.entity.employeeEntity.Employee;
import slut.com.slut.service.ressourcesHumainesService.employee.CreateEmployeeService;
import slut.com.slut.service.ressourcesHumainesService.employee.DeleteEmployeeService;
import slut.com.slut.service.ressourcesHumainesService.employee.FindOneEmployeeService;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("ressources_humaine")
public class RhController {
    private final CreateEmployeeService createEmployeeService;
    private final DeleteEmployeeService deleteEmployeeService;
    private final FindOneEmployeeService findOneEmployeeService;


     @PostMapping("create")
     public int _CreateEmployee(@RequestBody Employee employee){
         return this.createEmployeeService._createEmployeeFromService(employee);
     }


     @GetMapping("search/{email}")
     public ResponseEntity<Employee> _FindOneEmployeeByEmailPro(@PathVariable("email") String _email){
         Optional<Employee> employee = this.findOneEmployeeService._findOneEmployeeByEmailPro(_email);
         return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity
                                                                 .notFound()
                                                                 .build());
     }


     @DeleteMapping("delete/{IdEmployee}")
     public int _DeleteEmployee(@PathVariable("IdEmployee") String _idEmployee){
         return this.deleteEmployeeService._deleteEmployee(_idEmployee);
     }
}
