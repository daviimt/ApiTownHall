package com.example.demo.serviceImpl;

import com.example.demo.entity.Department;
import com.example.demo.models.DepartmentDTO;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    @Qualifier("departmentRepository")
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDTO addAppointment(DepartmentDTO departmentDTO) {
        departmentRepository.save(transform(departmentDTO));
        return departmentDTO;
    }

    @Override
    public List<DepartmentDTO> listAllDepartments() {
        return departmentRepository.findAll().stream().
                map(c -> transform(c)).collect(Collectors.toList());
    }

    @Override
    public Department findDepartmentById(int id) {
        return departmentRepository.findById(id);
    }

    @Override
    public boolean removeDepartment(int id) {
        if (departmentRepository.findById(id) != null) {
            departmentRepository.deleteById(id);
            return true;
        } else
            return false;
    }

    @Override
    public Department transform(DepartmentDTO departmentDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(departmentDTO, Department.class);
    }

    @Override
    public DepartmentDTO transform(Department department) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(department, DepartmentDTO.class);
    }
}