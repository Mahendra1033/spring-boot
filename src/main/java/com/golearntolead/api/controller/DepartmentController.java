package com.golearntolead.api.controller;

import com.golearntolead.api.entity.Department;
import com.golearntolead.api.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class DepartmentController {

    @Value("${home.message}")
    public String homeMessage;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/")
    public String home() {
        return homeMessage;
    }

    @PostMapping("/saveDepartment")
    public Department saveDepartment(@RequestBody Department department) {
        log.info("Inside of Post mapping of Department controller and the data adding into the DB is " + department);
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/everyDepartmentDetails")
    public List<Department> everyDepartmentDetails() {
        return departmentService.getDepartmentDetails();
    }

    @GetMapping("/getDepartment/{departmentId}")
    public Optional<Department> getDepartment(@PathVariable("departmentId") Long departmentId) {
        return departmentService.getDepartment(departmentId);
    }

    @PutMapping("/updateDepartment")
    public Department updateDepartment(@RequestBody Department department) {
        return departmentService.updateDepartment(department);
    }

    @DeleteMapping("/deleteDepartment/{departmentId}")
    public String deleteDepartment(@PathVariable("departmentId") Long departmentId) {
        return departmentService.deleteDepartment(departmentId);
    }
}
