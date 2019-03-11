package salariati.repository.mock;

import java.util.ArrayList;
import java.util.List;

import salariati.enumeration.DidacticFunction;

import salariati.model.Employee;
import salariati.repository.interfaces.EmployeeRepositoryInterface;
import salariati.validator.EmployeeValidator;

public class EmployeeRepositoryMock implements EmployeeRepositoryInterface {

	private List<Employee> employeeList;
	private EmployeeValidator employeeValidator;
	
	public EmployeeRepositoryMock() {
		
		employeeValidator = new EmployeeValidator();
		employeeList = new ArrayList<Employee>();
		
		Employee employeeIonel   = new Employee("Pacuraru", "1234567890876", DidacticFunction.ASSISTANT, 2500f);
		Employee employeeMihai   = new Employee("Dumitrescu", "1234567890876", DidacticFunction.LECTURER, 2500f);
		Employee employeeIonela  = new Employee("Ionescu", "1234567890876", DidacticFunction.LECTURER, 2500f);
		Employee employeeMihaela = new Employee("Pacuraru", "1234567890876", DidacticFunction.ASSISTANT, 2500f);
		Employee employeeVasile  = new Employee("Georgescu", "1234567890876", DidacticFunction.TEACHER,  2500f);
		Employee employeeMarin   = new Employee("Puscas", "1234567890876", DidacticFunction.TEACHER,  2500f);
		
		employeeList.add( employeeIonel );
		employeeList.add( employeeMihai );
		employeeList.add( employeeIonela );
		employeeList.add( employeeMihaela );
		employeeList.add( employeeVasile );
		employeeList.add( employeeMarin );
	}
	
	@Override
	public boolean addEmployee(Employee employee) {
		if ( employeeValidator.isValid(employee)) {
			employeeList.add(employee);
			return true;
		}
		return false;
	}
	
	@Override
	public void deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
	}

	@Override
	public void modifyEmployee(Employee oldEmployee, Employee newEmployee) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	@Override
	public List<Employee> getEmployeeByCriteria(String criteria) {
		// TODO Auto-generated method stub
		return null;
	}

}
