package az.spring.rest.demo.springrestdemo.service;

import az.spring.rest.demo.springrestdemo.rest.model.dto.EmployeeDto;
import az.spring.rest.demo.springrestdemo.rest.model.response.EmployeeResponse;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    EmployeeResponse getAllEmployees();
    EmployeeDto getEmployee(long id);
    EmployeeResponse getEmployeeByNameAndSurname(String name,String surname);
}
