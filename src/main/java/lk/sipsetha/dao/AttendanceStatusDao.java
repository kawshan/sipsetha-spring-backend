package lk.sipsetha.dao;

import lk.sipsetha.entity.AttendanceStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceStatusDao extends JpaRepository<AttendanceStatus,Integer> {
}
