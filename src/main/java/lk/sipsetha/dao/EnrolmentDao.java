package lk.sipsetha.dao;

import lk.sipsetha.entity.Enrolment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EnrolmentDao extends JpaRepository<Enrolment,Integer> {


    @Query(value = "select lpad(max(enl.enrolmentnum)+1,9,0)as enrolnum from enrolment as enl;",nativeQuery = true)
    public String getEnrolmentNextNumber();

}
