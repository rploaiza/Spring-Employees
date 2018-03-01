package employees.entities;


import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Employee {
	
	@Id
    @GeneratedValue
	private long id;
    @Column(name = "surname", nullable = false, length = 30)
	private String surname;
    @Temporal(TemporalType.TIMESTAMP)
	private Calendar entry;
    @Column(name = "active", nullable = false, length = 30)
	private boolean active;

    public Employee() {}
    
	public Employee(String surname, boolean active) {
		this.surname = surname;
		this.active = active;
		this.entry = Calendar.getInstance();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Calendar getEntry() {
		return entry;
	}

	public void setEntry(Calendar entry) {
		this.entry = entry;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "{\"id\":" + id + ",\"surname\":\"" + surname + ",\"active\":\"" + active + "\"}";
	}

}