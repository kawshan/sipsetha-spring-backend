package lk.sipsetha.dao;

import lk.sipsetha.entity.ClassHall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClassHallDao extends JpaRepository<ClassHall,Integer> {

    @Query(value = "select ch from ClassHall ch where ch.name=?1 and ch.location=?2")
    public ClassHall getClasshallByNameAndLocation(String classhall,String location);

}
