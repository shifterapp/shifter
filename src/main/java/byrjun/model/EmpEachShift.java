package byrjun.model;

import java.util.LinkedList;

public class EmpEachShift {
	private Shift shift;
	private LinkedList<Employee> employees;

	public EmpEachShift(Shift shift, LinkedList<Employee> employees) {
		this.shift = shift;
		this.employees = employees;
	}
	
	//Getters and setters
	public Shift getShift() {
		return this.shift;
	}
	public LinkedList<Employee> getEmployees() {
		return this.employees;
	}
	public void setShift(Shift shift) {
		this.shift = shift;
	}
	public void getShift(LinkedList<Employee> employees) {
		this.employees = employees;
	}

	
}
