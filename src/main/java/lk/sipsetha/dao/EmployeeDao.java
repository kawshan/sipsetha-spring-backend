package lk.sipsetha.dao;

import lk.sipsetha.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeDao extends JpaRepository<Employee,Integer> {


    @Query(value = "select e from Employee as e where e.nic=?1")
    public Employee getByNic(String nic);

    @Query(value = "select e from Employee as e where e.email=?1")
    public Employee getByEmail(String email);

    @Query(value = "SELECT lpad(max(e.empnum)+1,5,0) as empnumber FROM sipsetha.employee as e;",nativeQuery = true)
    public String getEmployeeNextNumber();

    //create query for get employee without user account
    @Query("select e from Employee e where e.id not in(select u.employee_id.id from User u where u.employee_id is not null)")
    public List<Employee> getListWithoutUserAccount();

    @Query(value = "select e from Employee e where e.mobile=?1")
    public Employee getBYMobile(String mobile);

}
