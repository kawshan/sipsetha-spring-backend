package lk.sipsetha.dao;

import lk.sipsetha.entity.Guardian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GuardianDao extends JpaRepository<Guardian,Integer> {


    @Query(value = "select g from Guardian g where g.nic=?1")
    public Guardian getGuardianByByNic(String nic);


    @Query(value = "select mobile from guardian where nic=?1",nativeQuery = true)
    public String getMobileByGuardianNic(String nic);


    @Query(value = "select address from guardian where nic=?1",nativeQuery = true)
    public String getAddressByNic(String nic);

    @Query(value = "select g from Guardian g where g.mobile=?1")
    public Guardian getExistenceByMobile(String mobile);

}
