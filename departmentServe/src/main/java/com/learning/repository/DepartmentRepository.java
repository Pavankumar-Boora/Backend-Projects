package com.learning.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.learning.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	
	@Modifying
	@Query("update Department e set e.deleted = true where e.departmentId = :departmentId")
	public void deleteById(@Param("departmentId") Integer departmentId);
	
	@Query("select  e from Department e where e.deleted = false and e.departmentId = :departmentId")
	public Optional<Department> findById(@Param("departmentId") Integer departmentId);
	
	@Query("select  e from Department e where e.deleted = false")
	public List<Department> findAll();
	
}
