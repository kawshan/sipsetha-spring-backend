package lk.sipsetha.dao;

import lk.sipsetha.entity.TeacherPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TeacherPaymentDao extends JpaRepository<TeacherPayment,Integer> {

    @Query(value = "select lpad(max(tpay.billnumber)+1,10,0) as bilnum from teacherpayment as tpay;",nativeQuery = true)
    public String getNextBillNumber();

}
