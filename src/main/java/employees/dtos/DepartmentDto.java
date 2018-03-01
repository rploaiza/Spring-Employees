package employees.dtos;

import employees.entities.Department;

public class DepartmentDto {

	private long id;

	private String title;

	private String center;

	public DepartmentDto() {}
	
	public DepartmentDto(String title, String center) {
		this.title = title;
		this.center = center;
	}

	public DepartmentDto(Department department) {
		id = department.getId();
		setTitle(department.getTitle());
		setCenter(department.getCenter());
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCenter() {
		return center;
	}

	public void setCenter(String center) {
		this.center = center;
	}

	@Override
	public String toString() {
		return "DepartmentDto[" + id + ": title=" + title + "center" + center + "]";
	}

}