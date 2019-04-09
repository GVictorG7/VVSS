package salariati.controller;

import salariati.enumeration.DidacticFunction;
import salariati.model.Employee;
import salariati.repository.interfaces.EmployeeRepositoryInterface;
import salariati.validator.EmployeeValidator;

import java.util.List;

public class EmployeeController {

	private EmployeeRepositoryInterface employeeRepository;
	private EmployeeValidator employeeValidator = new EmployeeValidator();

	public EmployeeController(EmployeeRepositoryInterface employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public void addEmployee(Employee employee) {
		if (employeeValidator.isValid(employee)) {
			employeeRepository.addEmployee(employee);
		} else {
			System.out.println("EROARE: Angajat invalid");
		}
	}

	public List<Employee> getEmployeesList() {
		return employeeRepository.getEmployeeList();
	}

	public void modifyEmployee(Employee oldEmployee, Employee newEmployee) {
		employeeRepository.modifyEmployee(oldEmployee, newEmployee);
	}

    public void modifyDidacticFunction(String employeeName, String newFunction) {
        DidacticFunction didacticFunction = DidacticFunction.valueOf(newFunction);

        for (Employee employee : employeeRepository.getEmployeeList()) {
            if (employee.getLastName().equals(employeeName)){
                employee.setFunction(didacticFunction);
            }
        }
    }

	public void deleteEmployee(Employee employee) {
		employeeRepository.deleteEmployee(employee);
	}

}
