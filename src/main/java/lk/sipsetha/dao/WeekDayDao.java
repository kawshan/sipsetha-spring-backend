package lk.sipsetha.dao;

import lk.sipsetha.entity.WeekDay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeekDayDao extends JpaRepository<WeekDay,Integer> {
}
