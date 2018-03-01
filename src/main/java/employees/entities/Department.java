package employees.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {

    @Id
    @GeneratedValue
	private long id;
    @Column(name = "title", nullable = false, length = 30)
	private String title;
    @Column(name = "center", nullable = false, length = 30)
	private String center;
    @Column(name = "strategic", nullable = false, length = 30)
	private boolean strategic;

	@OneToMany
	(cascade=CascadeType.ALL)
	private List<Employee> employees;
	
	public Department() {}
	
	public Department(String title, String center, Boolean strategic, List<Employee> employees) {
		this.title = title;
		this.center = center;
		this.strategic = strategic;
		this.employees = employees;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public boolean isStrategic() {
		return strategic;
	}

	public void setStrategic(boolean strategic) {
		this.strategic = strategic;
	}

	public List<Employee> getEmployee() {
		return employees;
	}

	public void setEmployee(List<Employee> employees) {
		this.employees = employees;
	}
	

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		  if (obj == null) {
	            return false;
	        } else if (getClass() != obj.getClass()) {
	            return false;
	        } else {
	            return id == ((Department) obj).id;
	        }
	}



	@Override
	public String toString() {
		return "{\"id\":" + id + ",\"title\":\"" + title + ",\"center\":\"" + center + "\"}";
	}
}