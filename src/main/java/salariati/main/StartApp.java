package salariati.main;

import salariati.model.Employee;
import salariati.repository.interfaces.EmployeeRepositoryInterface;
import salariati.repository.mock.EmployeeRepositoryMock;
import salariati.validator.EmployeeValidator;
import salariati.controller.EmployeeController;
import salariati.enumeration.DidacticFunction;

//functionalitati
//F01.	 adaugarea unui nou angajat (nume, prenume, CNP, functia didactica, salariul de incadrare);
//F02.	 modificarea functiei didactice (asistent/lector/conferentiar/profesor) a unui angajat;
//F03.	 afisarea salariatilor ordonati descrescator dupa salariu si crescator dupa varsta (CNP).

public class StartApp {
	
	public static void main(String[] args) {
		
		EmployeeRepositoryInterface employeesRepository = new EmployeeRepositoryMock();
		EmployeeController employeeController = new EmployeeController(employeesRepository);
		
		for(Employee employee : employeeController.getEmployeesList())
			System.out.println(employee.toString());
		System.out.println("-----------------------------------------");
		
		Employee employee = new Employee("LastName", "1234567894321", DidacticFunction.ASSISTANT, 2500f);
		employeeController.addEmployee(employee);
		
		for(Employee employee1 : employeeController.getEmployeesList())
			System.out.println(employee1.toString());
		
		EmployeeValidator validator = new EmployeeValidator();
		System.out.println( validator.isValid(new Employee("LastName", "1234567894322", DidacticFunction.TEACHER, 3400f)) );
		
	}

}
