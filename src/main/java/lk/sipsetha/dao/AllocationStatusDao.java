package lk.sipsetha.dao;

import lk.sipsetha.entity.AllocationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllocationStatusDao extends JpaRepository<AllocationStatus,Integer> {
}
