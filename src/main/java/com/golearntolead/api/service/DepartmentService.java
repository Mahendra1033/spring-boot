package com.golearntolead.api.service;

import com.golearntolead.api.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> getDepartmentDetails();

    Optional<Department> getDepartment(Long departmentId);

    Department updateDepartment(Department department);

    String deleteDepartment(Long departmentId);
}
