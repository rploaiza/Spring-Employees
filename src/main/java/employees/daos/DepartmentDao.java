package employees.daos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import employees.entities.Department;

public interface DepartmentDao extends JpaRepository<Department, Long> {

	Department findByTitle(String title);

	List<Department> findByTitleOrCenter(String title, String center);

	// Consulta JPQL

	@Query("select d.id from Department d where d.id like ?1")
	List<Long> findDepart(Long id);

	@Query("select d, e from Department d join d.employees e where d.id like ?1")
	List<Long> findEmployeeForDepart(Long id);
	
	@Query("select d from Department d where d.title like ?1")
	Department findDepartmentForTitle(String surname);
	
	@Modifying
	@Transactional
	@Query(value = "delete from Department e where e.title = ?1")
	void deleteBySurnameQuery(String surname);

}