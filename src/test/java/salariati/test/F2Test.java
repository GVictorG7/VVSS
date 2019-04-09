package salariati.test;

import org.junit.Test;
import salariati.controller.EmployeeController;
import salariati.enumeration.DidacticFunction;
import salariati.model.Employee;
import salariati.repository.mock.EmployeeRepositoryMock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class F2Test {
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
    public void WBT_TC2() {
        EmployeeRepositoryMock mock = new EmployeeRepositoryMock();
        EmployeeController controller = new EmployeeController(mock);

        try {
            controller.modifyDidacticFunction("Pacuraru", "JANITOR");
        } catch (IllegalArgumentException e) {

        }

        for (Employee employee : controller.getEmployeesList()) {
            if (employee.getLastName().equals("Pacuraru")) {
                assertEquals(DidacticFunction.ASSISTANT, employee.getFunction());
            }
        }
    }

    @Test
    public void WBT_TC3() {
        EmployeeRepositoryMock mock = new EmployeeRepositoryMock();
        EmployeeController controller = new EmployeeController(mock);

        controller.modifyDidacticFunction("Bam", "LECTURER");
        for (Employee employee : controller.getEmployeesList()) {
            assertFalse(employee.getLastName().equals("Bam"));
        }
    }
}
