package employees.daos;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import employees.entities.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Long> {

	@Query("select e from Employee e where e.id like ?1")
	Employee findEmployee(Long id);
	
	@Query("select e from Employee e where e.surname like ?1")
	Employee findEmployeeSurname(String surname);
	
	@Modifying
	@Transactional
	@Query(value = "delete from Employee e where e.id = ?1")
	void deleteById(Long id);

}
