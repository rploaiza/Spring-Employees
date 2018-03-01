package employees.dtos;

import employees.entities.Employee;

public class EmployeeDto {

	private long id;

	private String surname;

	private Boolean active;
	
	public EmployeeDto() {}
	
	public EmployeeDto(String surname, Boolean active) {
		this.surname = surname;
		this.active = active;
	}

	public EmployeeDto(Employee employee) {
		id = employee.getId();
		setSurname(employee.getSurname());
		setActive(employee.isActive());
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "EmployeeDto[" + id + ": surname=" + surname + ", active=" + active + "]";
	}

}