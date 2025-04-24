package lk.sipsetha.dao;

import lk.sipsetha.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TeacherDao extends JpaRepository<Teacher,Integer> {


    @Query(value = "select lpad(max(t.teachernum)+1,5,0)as teachernum from teacher as t;",nativeQuery = true)
    public String getTeacherNextNumber();


    @Query(value = "select t from Teacher t where t.nic=?1")
    public Teacher getTeacherByNic(String nic);


    @Query(value = "select t from Teacher t where t.email=?1")
    public Teacher getTeacherByEmail(String email);

}
