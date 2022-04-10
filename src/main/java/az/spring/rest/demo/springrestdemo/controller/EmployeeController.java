package az.spring.rest.demo.springrestdemo.controller;

import az.spring.rest.demo.springrestdemo.rest.model.dto.EmployeeDto;
import az.spring.rest.demo.springrestdemo.rest.model.response.EmployeeResponse;
import az.spring.rest.demo.springrestdemo.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Target;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
@Tag(name = "Employee service")
public class EmployeeController {

    public final EmployeeService employeeService;

    @GetMapping
    public EmployeeResponse getAllEmployee(){
       return employeeService.getAllEmployees();
    }

    @GetMapping("/{employee-id}")
    @Operation(summary = "This gets employee by id")
    public EmployeeDto getEmployee(@PathVariable("employee-id") long id){
        return employeeService.getEmployee(id);
    }

    @GetMapping("/search")
    public EmployeeResponse getEmployeeByNameAndSurname(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname){
        return employeeService.getEmployeeByNameAndSurname(name,surname);
    }

}
