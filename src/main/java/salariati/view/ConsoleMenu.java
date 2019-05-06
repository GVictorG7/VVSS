package salariati.view;

import salariati.controller.EmployeeController;
import salariati.enumeration.DidacticFunction;
import salariati.model.Employee;
import salariati.repository.mock.EmployeeRepositoryMock;

import java.util.List;

public class ConsoleMenu {
    private EmployeeRepositoryMock mock = new EmployeeRepositoryMock();
    private EmployeeController controller = new EmployeeController(mock);

    public boolean executeOption(int option) {
        switch (option) {
            case 1:
                return handleOption1();
            case 2:
                return handleOption2();
            case 3:
                return handleOption3();
            default:
                return false;
        }
    }

    private boolean handleOption1() {
        return controller.addEmployee(new Employee("lastName", "1921111123456", DidacticFunction.ASSISTANT, 3000f));
    }

    private boolean handleOption2() {
        return controller.modifyDidacticFunction("lastName", "TEACHER");
    }

    private boolean handleOption3() {
        List<Employee> sortedList = controller.sortEmployees();
        sortedList.forEach(System.out::println);
        return !sortedList.isEmpty();
    }
}
