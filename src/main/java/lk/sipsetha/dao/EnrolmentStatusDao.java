package lk.sipsetha.dao;

import lk.sipsetha.entity.EnrolmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrolmentStatusDao extends JpaRepository<EnrolmentStatus,Integer> {
}
