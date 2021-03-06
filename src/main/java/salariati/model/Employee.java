package salariati.model;

import salariati.enumeration.DidacticFunction;
import salariati.exception.EmployeeException;
import salariati.validator.EmployeeValidator;

import java.util.Date;

public class Employee {

	/** The last name of the employee */
	private String lastName;
	
	/** The unique id of the employee */
	private String cnp;
	
	/** The didactic function of the employee inside the university */
	private DidacticFunction function;
	
	/** The salary of the employee */
	private Float salary;
	
	/**
	 * Default constructor for employee
	 */
	public Employee() {
		this.lastName  = "";
		this.cnp       = "";
		this.function  = DidacticFunction.ASSISTANT;
		this.salary    = 0f;
	}
	
	/**
	 * Constructor with fields for employee
	 */
	public Employee(String lastName, String cnp, DidacticFunction function, Float salary) {
		this.lastName  = lastName;
		this.cnp       = cnp;
		this.function  = function;
		this.salary    = salary;
	}

	/**
	 * Getter for the employee last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Setter for the employee last name
	 * 
	 * @param lastName the last name to be set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Getter for the employee CNP
	 */
	public String getCnp() {
		return cnp;
	}

	/**
	 * Setter for the employee CNP
	 * 
	 * @param cnp the CNP to be set
	 */
	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	/**
	 * Getter for the employee didactic function
	 */
	public DidacticFunction getFunction() {
		return function;
	}

	/**
	 * Setter for the employee function
	 * 
	 * @param function the function to be set
	 */
	public void setFunction(DidacticFunction function) {
		this.function = function;
	}

	/**
	 * Getter for the employee salary
	 */
	public Float getSalary() {
		return salary;
	}

	/**
	 * Setter for the salary
	 * 
	 * @param salary the salary to be set
	 */
	public void setSalary(Float salary) {
		this.salary = salary;
	}
	
	/**
	 * toString function for employee
	 */
	@Override
	public String toString() {
		String employee = "";
		
		employee += lastName + ";";
		employee += cnp + ";";
		employee += function.toString() + ";";
		employee += salary;
		
		return employee;
	}
	
	/**
	 * equals function for employee
	 */
	public boolean equals(Employee comparableEmployee) {
		boolean hasSameLastName  = this.lastName.equals(comparableEmployee.getLastName()),
				hasSameCNP       = this.cnp.equals(comparableEmployee.getCnp()),
				hasSameFunction  = this.function.equals(comparableEmployee.getFunction()),
				hasSameSalary    = this.salary.equals(comparableEmployee.getSalary());
		return hasSameLastName && hasSameCNP && hasSameFunction && hasSameSalary;
	}
	
	/**
	 * Returns the Employee after parsing the given line
	 * 
	 * @param _employee
	 *            the employee given as String from the input file
	 * @param line
	 *            the current line in the file
	 * 
	 * @return if the given line is valid returns the corresponding Employee
	 * @throws EmployeeException
	 */
	public static Employee getEmployeeFromString(String _employee, int line) throws EmployeeException {
		Employee employee = new Employee();
		
		String[] attributes = _employee.split("[;]");
		
		if( attributes.length != 5 ) {
			throw new EmployeeException("Invalid line at: " + line);
		} else {
			EmployeeValidator validator = new EmployeeValidator();
			employee.setLastName(attributes[1]);
			employee.setCnp(attributes[2]);
			
			if(attributes[3].equals("ASSISTANT"))
				employee.setFunction(DidacticFunction.ASSISTANT);
			if(attributes[3].equals("LECTURER"))
				employee.setFunction(DidacticFunction.LECTURER);
			if(attributes[3].equals("TEACHER"))
				employee.setFunction(DidacticFunction.TEACHER);
			
			employee.setSalary(Float.parseFloat(attributes[4]));
			
			if( !validator.isValid(employee) ) {
				throw new EmployeeException("Invalid line at: " + line);
			}
		}
		
		return employee;
	}

    public Date computeBirthDateFromCNP() {
//        System.out.println("year: " + Integer.parseInt("19".concat(cnp.substring(1, 3))));
//        System.out.println("month: " + Integer.parseInt(cnp.substring(3, 5)));
//        System.out.println("day: " + Integer.parseInt(cnp.substring(5, 7)));
        return new Date(Integer.parseInt("19".concat(cnp.substring(1, 3))), Integer.parseInt(cnp.substring(3, 5)), Integer.parseInt(cnp.substring(5, 7)));
    }
}
