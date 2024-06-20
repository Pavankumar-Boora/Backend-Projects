package com.learning.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.learning.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	@Query("select  e from Employee e where e.deleted = false and e.employeeId = :employeeId")
	public Optional<Employee> findById(@Param("employeeId") Integer employeeId);
	
	@Modifying
	@Query("update Employee e set e.deleted = true where e.employeeId = :employeeId")
	public void deleteById(@Param("employeeId") Integer employeeId);
	
	@Query("select  e from Employee e where e.deleted = false")
	public List<Employee> findAll();

	@Modifying
	@Query("update Employee e set e.deleted = true where e.employeeDepartmentId = :employeeDepartmentId")
	public void deleteAllEmployeesOfDepartment(@Param("employeeDepartmentId") Integer departmentId);

	@Query("select  e from Employee e where e.deleted = false and e.employeeDepartmentId = :departmentId")
	public List<Employee> findOneDepartmentEmployees(@Param("departmentId") Integer departmentId);
	
	@Query("select  e from Employee e where e.deleted = false and e.employeeFirstName = :employeeFirstName and e.employeeLastName=:employeeLastName")
	public Optional<Employee> findByEmployeeFirstNameAndEmployeeLirstName(@Param("employeeFirstName") String employeeFirstName,@Param("employeeLastName") String employeeLastName);
	
}
