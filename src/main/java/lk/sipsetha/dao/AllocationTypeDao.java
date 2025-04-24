package lk.sipsetha.dao;

import lk.sipsetha.entity.AllocationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllocationTypeDao extends JpaRepository<AllocationType,Integer> {
}
