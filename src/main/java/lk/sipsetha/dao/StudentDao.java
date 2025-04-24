package lk.sipsetha.dao;

import lk.sipsetha.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentDao extends JpaRepository<Student,Integer> {

    //define query to get student next number
    @Query(value = "select lpad(max(s.stunum)+1,5,0) as stunumber from sipsetha.student as s;",nativeQuery = true)
    public String getStudentByNextNumber();


    //define query for get student by student name
    @Query(value = "select s from Student s where s.stunum=?1")
    public Student getStudentByStudentNumber(String id);


    @Query(value = "select s.id from Student s where s.stunum=?1")
    public String getStudentByStunum(String stunum);

}
