package com.haidara.department.controller;

import com.haidara.department.entities.Department;
import com.haidara.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Slf4j
public class DepartmentRestController {

    private DepartmentService departmentService;

    public DepartmentRestController(DepartmentService departmentService) {
        this.departmentService =  departmentService;
    }

    // actions
    @PostMapping("/departments/")
    public Department saveDepartment(@RequestBody Department department) {
        log.info("Inside saveDepartment of method controller");
        return departmentService.saveDepartment(department) ;
    }

    @GetMapping("/departments/{departmentId}")
    public Department findDepartmentById(@PathVariable("departmentId") long id) {
        log.info("Inside findDepartmentById of method controller");
        return departmentService.findDepartmentById(id);
    }


}
