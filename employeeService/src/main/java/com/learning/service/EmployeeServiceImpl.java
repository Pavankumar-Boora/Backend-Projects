package com.learning.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.learning.dto.ApiResponseDto;
import com.learning.dto.DepartmentDto;
import com.learning.dto.EmployeeDto;
import com.learning.entity.Employee;
import com.learning.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
//	@Autowired
	
	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository=employeeRepository;
	}
	
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private ApiResponseDto apiResponseDto;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
//		checking the empDeptId with DepartmentId
		getDepartmetDetails(employeeDto.getEmployeeDepartmentId());
		String localDatetime=getLocalDateTime();
		employeeDto.setEmployeecreationDateAndTime(localDatetime);
		employeeDto.setEmployeeupdationDateAndTime(localDatetime);
		return new EmployeeDto(employeeRepository.save(new Employee(employeeDto)));
	}

	@Override
	public ApiResponseDto getEmployeeDetails(Integer employeeId) {
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		apiResponseDto.setEmployeeDto(new EmployeeDto(employee.get()));
		apiResponseDto.setDepartmentDto(getDepartmetDetails(employee.get().getEmployeeDepartmentId()));
		return apiResponseDto;
	}

@Override
	public Map<Map<Integer, DepartmentDto>,Map<Integer, List<Employee>>> getAllEmployees() {
		List<Employee> employeesList = employeeRepository.findAll();
		List<DepartmentDto> departmentList = restTemplate
				.exchange("http://department-serve/department/getAllDepartments/", HttpMethod.GET,
						new HttpEntity<>(new HttpHeaders()), new ParameterizedTypeReference<List<DepartmentDto>>() {
						})
				.getBody();
		Map<Integer, DepartmentDto> departmentMap = departmentList.stream()
				.collect(Collectors.toMap(DepartmentDto::getDepartmentId, department -> department));

		
		
		Map<Integer, List<Employee>> employeesGroupedByDepartmentId = employeesList.stream()
				.collect(Collectors.groupingBy(Employee::getEmployeeDepartmentId));
		
		
		
//		List<ApiResponseDto> apiResponseDtoList = new ArrayList<>();
//
//	    employeesGroupedByDepartmentId.forEach((departmentId, employees) -> {
//	        DepartmentDto departmentDto = departmentMap.get(departmentId);
//	        employees.forEach(employee -> {
//	            ApiResponseDto apiResponseDto = new ApiResponseDto();
//	            apiResponseDto.setDepartmentDto(departmentDto);
//	            apiResponseDto.setEmployeeDto(new EmployeeDto(employee));
//	            apiResponseDtoList.add(apiResponseDto);
//	        });
//	    });
		
//		 employeesList.stream()
//	                .map(employee -> {
//	                    EmployeeDto employeeDto = new EmployeeDto();
//	                    DepartmentDto departmentDto = departmentMap.get(employee.getEmployeeDepartmentId());
//	                    EmployeeDto employeeDto2 = new EmployeeDto(employee);
//	                    employeeDto2.setEmployeeDepartmentId(employeeDto2.getEmployeeDepartmentId()+""+departmentDto.getDepartmentName());
//	                    return apiResponseDto;
//	                })   
//	                .collect(Collectors.toList());
		
		
		
		Map<Map<Integer, DepartmentDto>,Map<Integer, List<Employee>>> mpList=new HashMap<Map<Integer,DepartmentDto>, Map<Integer,List<Employee>>>();
		mpList.put(departmentMap, employeesGroupedByDepartmentId);
		return mpList;
//	    return employeesGroupedByDepartmentId;
	}

	@Override
	public EmployeeDto updateEmployee(Integer employeeId, EmployeeDto employeeDto) {
		EmployeeDto employeeDb = getEmployeeDetails(employeeId).getEmployeeDto();
		if(employeeDto.getEmployeeDepartmentId()!=null) {
			getDepartmetDetails(employeeDto.getEmployeeDepartmentId());
			employeeDb.setEmployeeDepartmentId(employeeDto.getEmployeeDepartmentId());
		}
		if(employeeDto.getEmployeeEmailId()!=null) {
			employeeDb.setEmployeeEmailId(employeeDto.getEmployeeEmailId());
		}
		if(employeeDto.getEmployeeFirstName()!=null) {
			employeeDb.setEmployeeFirstName(employeeDto.getEmployeeFirstName());
		}
		if(employeeDto.getEmployeeLastName()!=null) {
			employeeDb.setEmployeeFirstName(employeeDto.getEmployeeFirstName());
		}
		if(employeeDto.getEmployeeupdatedPerson()!=null) {
			employeeDb.setEmployeeupdatedPerson(employeeDto.getEmployeeupdatedPerson());
		}
		if(employeeDto.getEmployeeupdationDateAndTime()!=null) {
			employeeDb.setEmployeeupdationDateAndTime(getLocalDateTime());
		}
		return new EmployeeDto(employeeRepository.save(new Employee(employeeDb)));
	}
	
	@Override
	public String softDeleteEmployeeById(Integer employeeId) {
		getEmployeeDetails(employeeId);
		employeeRepository.deleteById(employeeId);
		return "Employee has been deleted successfully (Soft Deletion)";
	}
	
	@Transactional
	@Override
	public String softDeleteDepartmentEmployees(Integer departmentId) {
		employeeRepository.deleteAllEmployeesOfDepartment(departmentId);
		return "Employees deletion operstion successfully (Group of Soft Deletion)";
	}
	@Override
	public EmployeeDto findByEmployeeFirstNameAndEmployeeLirstName(String employeeFirstName, String employeeLasttName) {
		return new EmployeeDto(employeeRepository.findByEmployeeFirstNameAndEmployeeLirstName(employeeFirstName, employeeLasttName).get());
	}


	@Override
	public List<EmployeeDto> getOneDepartmentEmployees(Integer departmentId) {
		List<Employee> employeeList=employeeRepository.findOneDepartmentEmployees(departmentId);
		return employeeList.stream().map(EmployeeDto::new).collect(Collectors.toList());
	}
	

	public String getLocalDateTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return now.format(formatter);
	}
	
	public DepartmentDto getDepartmetDetails(Integer departmentId) {
		ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity(
				"http://department-serve/department/getOnlyDepartment/" + departmentId, DepartmentDto.class);
		return responseEntity.getBody();
	}
}