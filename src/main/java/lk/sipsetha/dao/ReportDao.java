package lk.sipsetha.dao;

import lk.sipsetha.entity.Attendance;
import lk.sipsetha.entity.Employee;
import lk.sipsetha.entity.Payment;
import lk.sipsetha.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ReportDao extends JpaRepository<Employee, Integer> {


    @Query(value = "select e from Employee e where e.employeestatus_id.id=1")
    public List<Employee> workingEmployees();


    @Query(value = "select e from Employee e where e.employeestatus_id.id=?1 and e.designation_id.id=?2")
    public List<Employee> getEmpByStatusAndDesignation(int status, int designation);


    @Query(value = "select s from Student s where s.status=true")
    public List<Student> getPresentStudents();


    @Query(value = "select s from Student s where s.status=?1 and s.grade_id.id=?2")
    public List<Student> getByStatusAndGrade(boolean status, int grade);

    @Query(value = "select p from Payment p where p.month=?1")
    public List<Payment> getPaymentByMonth(String month);

    @Query(value = "select p from Payment p where p.paytype_id.id=?1 and p.paymentcategory_id.id=?2")
    public List<Payment> getPaymentByTypeAndCategory(int paytype, int paymentcategory);


    @Query(value = "select p from Payment p where p.paytype_id.id=?1")
    public List<Payment> getPaymentByPaymentType(int paytype);

    @Query(value = "select p from Payment p where p.paymentcategory_id.id=1")
    public List<Payment> getPaymentByPaymentCategory(int paymentcategory);

    @Query(value = "select a from Attendance a where  a.student_id.id=?3 and a.addeddate between ?1 and ?2  order by a.addeddate ")
    public List<Attendance> getAttendanceStartAndENDDate(LocalDate startdate, LocalDate enddate , Integer id);

    //select * from payment where addeddatetime like '2024-06-27%'
    //@Query(value = "select p.* from Payment p where addeddatetime like //?1%", nativeQuery = true)
    @Query(value = "select p from Payment p where DATE(p.addeddatetime) like concat(?1,'%') ")
    public List<Payment> getPaymentByDate(String date);






}
