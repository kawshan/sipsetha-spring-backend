package lk.sipsetha.dao;

import lk.sipsetha.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentDao extends JpaRepository<Payment,Integer> {

    @Query(value = "select lpad(max(p.billnumber)+1,10,0) as billnum from payment as p;",nativeQuery = true)
    public String getNextBillNumber();

    //    @Query(value = "select fees from payment where student_id=(select student.id from student where stunum=?1);",nativeQuery = true)
   // @Query(value = "select fees from payment where student_id=(select student.id from student where stunum=?1);",nativeQuery = true)
   // String paymentByStudent(String stunum);


   @Query(value = "select p from Payment p where p.student_id.stunum=?1")
   public List<Payment> paymentByStudent(String stunum);


   @Query(value = "select max(month) from payment where student_id=?1",nativeQuery = true)
    public String getMaxMonthPaymentByStudent(String stunum);


   @Query(value = "SELECT MAX(month) FROM payment WHERE student_id IN (SELECT id FROM student WHERE stunum=?1) AND student_id IN (SELECT student_id FROM studentregistration WHERE studentregistration_id =?2)",nativeQuery = true)
    public String getmaxbypayment(String stunum, String registration);


   @Query(value = "select p from Payment p where p.student_id.id=?1 and p.month=?2 and p.studentregistration_id.id=?3")
    public Payment checkDuplicateByStudentMonthAndRegistration(Integer id, String month, Integer reg);

}
