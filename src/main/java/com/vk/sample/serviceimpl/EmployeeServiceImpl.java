package com.vk.sample.serviceimpl;

import com.vk.sample.entity.EmployeeEntity;
import com.vk.sample.model.requestmodel.CreateEmployeeRequestModel;
import com.vk.sample.model.requestmodel.UpdateEmployeeRequestModel;
import com.vk.sample.repository.EmployeeRepository;
import com.vk.sample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeEntity getEmployee(final int id) {
        Optional<EmployeeEntity> employee = employeeRepository.findById(id);
        return employee.orElse(null);
    }

    @Override
    public EmployeeEntity createEmployee(final CreateEmployeeRequestModel createEmployeeRequestModel) {
        return employeeRepository.save(EmployeeEntity.builder()
                .firstName(createEmployeeRequestModel.getFirstName())
                .lastName(createEmployeeRequestModel.getLastName())
                .email(createEmployeeRequestModel.getEmail())
                .gender(createEmployeeRequestModel.getGender())
                .mobNum(createEmployeeRequestModel.getMobNum())
                .city(createEmployeeRequestModel.getCity())
                .status(1).build());
    }

    @Override
    public EmployeeEntity deleteEmployee(final int id) {
        Optional<EmployeeEntity> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            employee.get().setStatus(99);
            return employee.get();
        } else {
            return null;
        }
    }

    @Override
    public EmployeeEntity updateEmployee(final UpdateEmployeeRequestModel updateEmployeeRequestModel) {
        Optional<EmployeeEntity> employee = employeeRepository.findById(updateEmployeeRequestModel.getId());
        if (employee.isPresent()) {
            EmployeeEntity employeeEntity = employee.get();
            employeeEntity.setFirstName(updateEmployeeRequestModel.getFirstName());
            employeeEntity.setLastName(updateEmployeeRequestModel.getLastName());
            employeeEntity.setGender(updateEmployeeRequestModel.getGender());
            employeeEntity.setEmail(updateEmployeeRequestModel.getEmail());
            employeeEntity.setMobNum(updateEmployeeRequestModel.getMobNum());
            employeeEntity.setCity(updateEmployeeRequestModel.getCity());
            return employeeEntity;
        } else {
            return null;
        }
    }

    @Override
    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
