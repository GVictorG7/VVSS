package salariati.controller;

import java.util.List;

import salariati.model.Employee;
import salariati.repository.interfaces.EmployeeRepositoryInterface;
import salariati.validator.EmployeeValidator;

public class EmployeeController {
	
	private EmployeeRepositoryInterface employeeRepository;
	private EmployeeValidator employeeValidator = new EmployeeValidator();

	public EmployeeController(EmployeeRepositoryInterface employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public void addEmployee(Employee employee) {
		if (employeeValidator.isValid(employee)) {
			employeeRepository.addEmployee(employee);
		}
	}
	
	public List<Employee> getEmployeesList() {
		return employeeRepository.getEmployeeList();
	}
	
	public void modifyEmployee(Employee oldEmployee, Employee newEmployee) {
		employeeRepository.modifyEmployee(oldEmployee, newEmployee);
	}

	public void deleteEmployee(Employee employee) {
		employeeRepository.deleteEmployee(employee);
	}
	
}
