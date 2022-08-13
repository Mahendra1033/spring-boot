package com.golearntolead.api.service;

import com.golearntolead.api.entity.Department;
import com.golearntolead.api.exception.DepartmentNotFoundException;
import com.golearntolead.api.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartmentDetails() {
        return departmentRepository.findAll();
    }

    @Override
    public Optional<Department> getDepartment(Long departmentId) {
        boolean isExists = departmentRepository.findById(departmentId).isPresent();
        if(!isExists) {
            throw new DepartmentNotFoundException("Department Not Found Exception");
        }
        return departmentRepository.findById(departmentId);
    }

    @Override
    public Department updateDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public String deleteDepartment(Long departmentId) {
        departmentRepository.deleteById(departmentId);
        return "Department Details Deleted Successfully";
    }
}
