package com.vk.sample.controller;

import com.vk.sample.constants.ApiConstants;
import com.vk.sample.entity.EmployeeEntity;
import com.vk.sample.model.requestmodel.CreateEmployeeRequestModel;
import com.vk.sample.model.requestmodel.UpdateEmployeeRequestModel;
import com.vk.sample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sample")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }

    @GetMapping(ApiConstants.GET_EMPLOYEE)
    public EmployeeEntity getEmployee(@PathVariable("id") int id) {
        return employeeService.getEmployee(id);
    }

    @PostMapping(ApiConstants.CREATE_EMPLOYEE)
    public EmployeeEntity createEmployee(@RequestBody CreateEmployeeRequestModel createEmployeeRequestModel) {
        return employeeService.createEmployee(createEmployeeRequestModel);
    }

    @PutMapping(ApiConstants.UPDATE_EMPLOYEE)
    public EmployeeEntity updateEmployee(@RequestBody UpdateEmployeeRequestModel updateEmployeeRequestModel) {
        return employeeService.updateEmployee(updateEmployeeRequestModel);
    }

    @PutMapping(ApiConstants.DELETE_EMPLOYEE)
    public EmployeeEntity deleteEmployee(@PathVariable("id") int id) {
        return employeeService.deleteEmployee(id);
    }

    @GetMapping(ApiConstants.GET_ALL_EMPLOYEE)
    public List<EmployeeEntity> getAllEmployee() {
        return employeeService.getAllEmployees();
    }

}
