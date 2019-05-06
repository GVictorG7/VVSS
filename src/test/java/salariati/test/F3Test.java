package salariati.test;

import org.junit.Test;
import salariati.controller.EmployeeController;
import salariati.model.Employee;
import salariati.repository.implementations.EmployeeRepositoryImplementation;
import salariati.repository.mock.EmployeeRepositoryMock;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class F3Test {
    @Test
    public void BBT_F3_valid() {
        EmployeeRepositoryMock mock = new EmployeeRepositoryMock();
        EmployeeController controller = new EmployeeController(mock);

        List<Employee> sortedList = controller.sortEmployees();
//        sortedList.forEach(System.out::println);

        assertTrue(sortedList.get(0).getSalary() > sortedList.get(1).getSalary());
        assertEquals(sortedList.get(1).getSalary(), sortedList.get(2).getSalary());
        assertTrue(sortedList.get(1).computeBirthDateFromCNP().compareTo(sortedList.get(2).computeBirthDateFromCNP()) > 0);
    }

    @Test
    public void BBT_F3_nonvalid() {
        EmployeeRepositoryMock mock = new EmployeeRepositoryMock();
        mock.clearEmployeeList();
        EmployeeController controller = new EmployeeController(mock);

        List<Employee> sortedList = controller.sortEmployees();

        assertTrue(sortedList.isEmpty());
    }
}
