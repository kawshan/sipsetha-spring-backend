package lk.sipsetha.dao;

import lk.sipsetha.entity.TeacherStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherStatusDao extends JpaRepository<TeacherStatus,Integer> {
}
