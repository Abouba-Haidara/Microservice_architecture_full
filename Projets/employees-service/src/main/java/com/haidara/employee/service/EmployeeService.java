package com.haidara.employee.service;

import com.haidara.employee.VO.Department;
import com.haidara.employee.VO.ResponseTemplateVO;
import com.haidara.employee.entities.Employee;
import com.haidara.employee.repositories.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Employee saveEmployee(Employee employee) {
        log.info("Inside saveEmployee of method service");
        return employeeRepository.save(employee);
    }



    public ResponseTemplateVO getUserWithDepartment(long employeeId) {
        log.info("Inside getUserWithDepartment of method service");
        ResponseTemplateVO vo =  new ResponseTemplateVO();
        Employee employee = employeeRepository.findById(employeeId).get();

        Department department =  restTemplate
                .getForObject(
                        "http://DEPARTMENT-SERVICE/api/departments/" + employee.getDepartmentId(),
                         Department.class);


        vo.setEmployee(employee);
        vo.setDepartment(department);

        return vo ;
    }
}
