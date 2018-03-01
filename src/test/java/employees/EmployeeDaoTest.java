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
import employees.daos.EmployeeDao;
import employees.entities.Department;
import employees.entities.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")

public class EmployeeDaoTest {
	
	@Autowired
    private DepartmentDao departmentDao;
	
	@Autowired
    private EmployeeDao employeeDao;
	
	@Before
    public void seedDb() {
    	Employee[] employees = {new Employee("Roberth", true), new Employee("Jesus", false)};

        Department[] departments = {new Department("Title","Center",true, Arrays.asList(employees[0], employees[1]))};
        departmentDao.save(Arrays.asList(departments));
    }

    @Test
    public void TestFindEmployee() {
		assertEquals("Jesus", employeeDao.findEmployee(2L).getSurname());
	}

    @Test
    public void testDeleteById() {
        assertNotNull(employeeDao.findEmployee(1L));
        employeeDao.deleteById(1L);
        //assertNull(employeeDao.findEmployee(1L));
    }
    
    @After
    public void deleteDb() {
    	departmentDao.deleteAll();
    	employeeDao.deleteAll();
    }
}
