package lk.sipsetha.dao;

import lk.sipsetha.entity.ClassOffering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClassOfferingDao extends JpaRepository<ClassOffering,Integer> {


//    @Query(value = "select classname from classoffering where id=(select classoffering_id from studentregistration where student_id=(select id from student where stunum=?1))",nativeQuery = true)
//    @Query(value = "select cof from ClassOffering cof where cof.id=(select sreg.id from StudentRegistration sreg where sreg.student_id=(select s.id from Student s where s.stunum=?1))")

    @Query(value = "select * from classoffering where id in (select classoffering_id from studentregistration where student_id in (select id from student where stunum=?1))",nativeQuery = true)
    public List<ClassOffering> getClassOfferingByStudent(String stunum);


    @Query(value = "select * from classoffering where grade_id in (select grade_id from student where stunum=?1)",nativeQuery = true)
    public List<ClassOffering> getClassOfferingsByStudentGrade(String stunum);


}
