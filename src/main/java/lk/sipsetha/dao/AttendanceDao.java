package lk.sipsetha.dao;

import lk.sipsetha.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AttendanceDao extends JpaRepository<Attendance,Integer> {

    //define query to check duplicate of attendance using date, student and class offering
    @Query(value = "select * from attendance where addeddate=?1 and classoffering_id=?2 and student_id=?3",nativeQuery = true)
    public Attendance checkDupUsingDateStuClZOff(String addeddate, Integer classOffering, Integer studentID);
}
