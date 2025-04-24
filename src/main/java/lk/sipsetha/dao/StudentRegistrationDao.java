package lk.sipsetha.dao;

import lk.sipsetha.entity.StudentRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRegistrationDao extends JpaRepository<StudentRegistration, Integer> {


    @Query(value = "select lpad(max(sr.indexnumber)+1,5,0) as srnumber from studentregistration as sr;", nativeQuery = true)
    public String getStudentRegistrationNextNumber();

    @Query(value = "select sr from StudentRegistration sr where sr.student_id.stunum=?1 and sr.registrationstatus_id.id=1")
//    @Query(value = "select sr.indexnumber from StudentRegistration sr where sr.student_id=(select s.id from Student s where s.stunum=?1)")
    public List<StudentRegistration> getIndexNumberFromStuNum(String indexnumb);

    @Query(value = "select * from studentregistration where student_id in (select id from student where stunum=?1)and registerdtype_id=2 and id=?2",nativeQuery = true)
    public StudentRegistration getStudentRegistrationByStunumRegType(String stunum, String regid);



}
