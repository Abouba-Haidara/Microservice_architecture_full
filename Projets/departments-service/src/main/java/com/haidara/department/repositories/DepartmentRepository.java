package com.haidara.department.repositories;

import com.haidara.department.entities.Department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
