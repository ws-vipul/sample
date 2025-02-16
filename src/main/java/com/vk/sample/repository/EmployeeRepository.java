package com.vk.sample.repository;

import com.vk.sample.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Serializable> {
}
