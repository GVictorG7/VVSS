package salariati.test;

import static org.junit.Assert.*;
import salariati.model.Employee;

import org.junit.Before;
import org.junit.Test;

import salariati.repository.interfaces.EmployeeRepositoryInterface;
import salariati.repository.mock.EmployeeRepositoryMock;
import salariati.validator.EmployeeValidator;
import salariati.controller.EmployeeController;
import salariati.enumeration.DidacticFunction;

public class AddEmployeeTest {

	private EmployeeRepositoryInterface employeeRepository;
	private EmployeeController controller;
	private EmployeeValidator employeeValidator;
	
	@Before
	public void setUp() {
		employeeRepository = new EmployeeRepositoryMock();
		controller         = new EmployeeController(employeeRepository);
		employeeValidator  = new EmployeeValidator();
	}
	
	@Test
	public void testRepositoryMock() {
		assertFalse(controller.getEmployeesList().isEmpty());
		assertEquals(6, controller.getEmployeesList().size());
	}
	
	@Test
	public void testAddNewEmployee() {
		Employee newEmployee = new Employee("ValidLastName", "1910509055057", DidacticFunction.ASSISTANT, 3000f);
		assertTrue(employeeValidator.isValid(newEmployee));
		controller.addEmployee(newEmployee);
		assertEquals(7, controller.getEmployeesList().size());
		assertTrue(newEmployee.equals(controller.getEmployeesList().get(controller.getEmployeesList().size() - 1)));
	}

	@Test
	public void TC1_ECP() {
		Employee newEmployee = new Employee("Jon", "1981111525252", DidacticFunction.LECTURER, 3000f);
		assertTrue(employeeValidator.isValid(newEmployee));
		controller.addEmployee(newEmployee);
		assertEquals(7, controller.getEmployeesList().size());
		assertTrue(newEmployee.equals(controller.getEmployeesList().get(controller.getEmployeesList().size() - 1)));
	}

	@Test
	public void TC2_ECP() {
		Employee newEmployee = new Employee("Mihai", "1234567890123", DidacticFunction.ASSISTANT, -2f);
		assertFalse(employeeValidator.isValid(newEmployee));
		controller.addEmployee(newEmployee);
		assertEquals(6, controller.getEmployeesList().size());
		assertFalse(newEmployee.equals(controller.getEmployeesList().get(controller.getEmployeesList().size() - 1)));
	}

	@Test
	public void TC3_ECP() {
		Employee newEmployee = new Employee("Boss123", "1234567890123", DidacticFunction.TEACHER, 0f);
		assertFalse(employeeValidator.isValid(newEmployee));
		controller.addEmployee(newEmployee);
		assertEquals(6, controller.getEmployeesList().size());
		assertFalse(newEmployee.equals(controller.getEmployeesList().get(controller.getEmployeesList().size() - 1)));
	}

	@Test
	public void TC4_ECP() {
		Employee newEmployee = new Employee("Nume", "2", DidacticFunction.TEACHER, 0f);
		assertFalse(employeeValidator.isValid(newEmployee));
		controller.addEmployee(newEmployee);
		assertEquals(6, controller.getEmployeesList().size());
		assertFalse(newEmployee.equals(controller.getEmployeesList().get(controller.getEmployeesList().size() - 1)));
	}

	@Test
	public void TC1_BVA() {
		Employee newEmployee = new Employee("Paula", "2990709082410", DidacticFunction.ASSISTANT, 5000f);
		assertTrue(employeeValidator.isValid(newEmployee));
		controller.addEmployee(newEmployee);
		assertEquals(7, controller.getEmployeesList().size());
		assertTrue(newEmployee.equals(controller.getEmployeesList().get(controller.getEmployeesList().size() - 1)));
	}

	@Test
	public void TC2_BVA() {
		Employee newEmployee = new Employee("ab", "1234567890123", DidacticFunction.TEACHER, 0f);
		assertTrue(employeeValidator.isValid(newEmployee));
		controller.addEmployee(newEmployee);
		assertEquals(7, controller.getEmployeesList().size());
		assertTrue(newEmployee.equals(controller.getEmployeesList().get(controller.getEmployeesList().size() - 1)));
	}
}
