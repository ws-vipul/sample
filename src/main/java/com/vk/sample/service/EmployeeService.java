package com.vk.sample.service;

import com.vk.sample.entity.EmployeeEntity;
import com.vk.sample.model.requestmodel.CreateEmployeeRequestModel;
import com.vk.sample.model.requestmodel.UpdateEmployeeRequestModel;

import java.util.List;

public interface EmployeeService {

    EmployeeEntity getEmployee(final int id);
    EmployeeEntity createEmployee(final CreateEmployeeRequestModel  createEmployeeRequestModel);
    EmployeeEntity deleteEmployee(final int id);
    EmployeeEntity updateEmployee(final UpdateEmployeeRequestModel updateEmployeeRequestModel);
    List<EmployeeEntity> getAllEmployees();

}
