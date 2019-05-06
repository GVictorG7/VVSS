package salariati.test;

import org.junit.Test;
import salariati.controller.EmployeeController;
import salariati.enumeration.DidacticFunction;
import salariati.model.Employee;
import salariati.repository.mock.EmployeeRepositoryMock;
import salariati.validator.EmployeeValidator;
import salariati.view.ConsoleMenu;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TopDownIntegration {
    @Test
    public void TC1_ECP() {
        EmployeeRepositoryMock mock = new EmployeeRepositoryMock();
        EmployeeController controller = new EmployeeController(mock);
        EmployeeValidator validator = new EmployeeValidator();

        Employee newEmployee = new Employee("Jon", "1981111525252", DidacticFunction.LECTURER, 3000f);
        assertTrue(validator.isValid(newEmployee));
        controller.addEmployee(newEmployee);
        assertEquals(7, controller.getEmployeesList().size());
        assertTrue(newEmployee.equals(controller.getEmployeesList().get(controller.getEmployeesList().size() - 1)));
    }

    @Test
    public void WBT_TC1() {
        EmployeeRepositoryMock mock = new EmployeeRepositoryMock();
        EmployeeController controller = new EmployeeController(mock);

        controller.modifyDidacticFunction("Dumitrescu", "ASSISTANT");
        for (Employee employee : controller.getEmployeesList()) {
            if (employee.getLastName().equals("Dumitrescu")) {
                assertEquals(DidacticFunction.ASSISTANT, employee.getFunction());
            }
        }
    }

    @Test
    public void BBT_F3_valid() {
        EmployeeRepositoryMock mock = new EmployeeRepositoryMock();
        EmployeeController controller = new EmployeeController(mock);

        List<Employee> sortedList = controller.sortEmployees();

        assertTrue(sortedList.get(0).getSalary() > sortedList.get(1).getSalary());
        assertEquals(sortedList.get(1).getSalary(), sortedList.get(2).getSalary());
        assertTrue(sortedList.get(1).computeBirthDateFromCNP().compareTo(sortedList.get(2).computeBirthDateFromCNP()) > 0);
    }

    @Test
    public void integrationA() {
        ConsoleMenu menu = new ConsoleMenu();
        assertTrue(menu.executeOption(1));
    }

    @Test
    public void integrationB() {
        ConsoleMenu menu = new ConsoleMenu();
        assertTrue(menu.executeOption(1));
        assertTrue(menu.executeOption(2));
    }

    @Test
    public void integrationC() {
        ConsoleMenu menu = new ConsoleMenu();
        assertTrue(menu.executeOption(1));
        assertTrue(menu.executeOption(2));
        assertTrue(menu.executeOption(3));
    }
}
