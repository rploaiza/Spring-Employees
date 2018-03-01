package employees;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import employees.daos.DepartmentDao;
import employees.entities.Department;
import employees.entities.Employee;


@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")

public class DepartmentDaoTest {

	@Autowired
    private DepartmentDao departmentDao;	
	
	@Before
    public void seedDb() {
    	Employee[] employees = {new Employee("Roberth", true), new Employee("Jesus", false)};

        Department[] departments = {new Department("Title","Center",true, Arrays.asList(employees[0], employees[1]))};
        departmentDao.save(Arrays.asList(departments));
    }
	
	
    @Test
    public void testCount() {
        assertEquals(1, departmentDao.count());
    }
    
    @Test
    public void testFindOne() {
    	Employee[] employees = {new Employee("Roberth", true), new Employee("Jesus", false)};
    	Department department = new Department("Title", "Center", true, Arrays.asList(employees));
        departmentDao.save(department);
        assertEquals("Center", departmentDao.findOne(department.getId()).getCenter());
    }
    
    @Test
    public void testFindAll() {
        assertNotNull(departmentDao.findAll());
    }
        
    @Test
    public void testFindByDepartment() {
        assertNotNull(departmentDao.findByTitleOrCenter("Title", "Center"));
    }
    
    @Test
    public void testFindByTitle() {
        assertNotNull(departmentDao.findByTitle("Title"));
    }
    
    @Test
    public void TestFindDepart() {
		assertEquals(1, departmentDao.findDepart(1L).size());
	}
    
    @Test
    public void TestFindEmployeeForDepart() {
    	Employee[] employees = {new Employee("Roberth", true), new Employee("Jesus", false)};
    	Department department = new Department("Title", "Center", true, Arrays.asList(employees));
        departmentDao.save(department);
		assertEquals(2, departmentDao.findEmployeeForDepart(1L).size());
	}
    
    
    @Test
    public void testDeleteBySurnameQuery() {
        assertNotNull(departmentDao.findDepartmentForTitle("Title"));
        departmentDao.deleteBySurnameQuery("Title");
        assertNull(departmentDao.findDepartmentForTitle("Title"));
    }
    

    
    @After
    public void deleteDb() {
    	departmentDao.deleteAll();
    }

}
