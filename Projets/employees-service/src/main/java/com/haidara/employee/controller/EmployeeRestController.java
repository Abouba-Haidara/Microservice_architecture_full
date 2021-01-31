package com.haidara.employee.controller;

import com.haidara.employee.VO.ResponseTemplateVO;
import com.haidara.employee.entities.Employee;
import com.haidara.employee.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Slf4j
public class EmployeeRestController {
    private EmployeeService employeeService;
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }


    // actions
    @PostMapping("/employees/")
    public Employee saveEmployee(@RequestBody Employee employee) {
        log.info("Inside saveEmployee of method controller");
        return employeeService.saveEmployee(employee) ;
    }

    @GetMapping("/employees/{EmployeeId}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("EmployeeId") long employeeId) {
        log.info("Inside getUserWithDepartment of method controller");
        return employeeService.getUserWithDepartment(employeeId);
    }



}
