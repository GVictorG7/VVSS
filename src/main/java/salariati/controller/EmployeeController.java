package salariati.controller;

import salariati.enumeration.DidacticFunction;
import salariati.model.Employee;
import salariati.repository.interfaces.EmployeeRepositoryInterface;
import salariati.validator.EmployeeValidator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeController {

	private EmployeeRepositoryInterface employeeRepository;
	private EmployeeValidator employeeValidator = new EmployeeValidator();

	public EmployeeController(EmployeeRepositoryInterface employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public boolean addEmployee(Employee employee) {
		if (employeeValidator.isValid(employee)) {
			employeeRepository.addEmployee(employee);
			return true;
		} else {
			System.out.println("EROARE: Angajat invalid");
			return false;
		}
	}

	public List<Employee> getEmployeesList() {
		return employeeRepository.getEmployeeList();
	}

	public void modifyEmployee(Employee oldEmployee, Employee newEmployee) {
		employeeRepository.modifyEmployee(oldEmployee, newEmployee);
	}

    public boolean modifyDidacticFunction(String employeeName, String newFunction) {
        DidacticFunction didacticFunction = DidacticFunction.valueOf(newFunction);

        for (Employee employee : employeeRepository.getEmployeeList()) {
            if (employee.getLastName().equals(employeeName)){
                employee.setFunction(didacticFunction);
                return true;
            }
        }

        return false;
    }

	public List<Employee> sortEmployees() {
		List<Employee> returnedList = employeeRepository.getEmployeeList();

		if (returnedList.isEmpty()) {
			System.out.println("no employees to sort");
		} else {
			Collections.sort(returnedList, new Comparator<Employee>() {
				@Override
				public int compare(Employee o1, Employee o2) {
					int comparedSalary = o2.getSalary().compareTo(o1.getSalary());
					if (comparedSalary == 0) {
						return o2.computeBirthDateFromCNP().compareTo(o1.computeBirthDateFromCNP());
					} else {
						return comparedSalary;
					}
				}
			});
		}

		return returnedList;
	}

	public void deleteEmployee(Employee employee) {
		employeeRepository.deleteEmployee(employee);
	}

}
