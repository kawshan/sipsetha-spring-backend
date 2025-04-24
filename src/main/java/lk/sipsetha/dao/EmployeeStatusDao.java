package lk.sipsetha.dao;

import lk.sipsetha.entity.EmployeeStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeStatusDao extends JpaRepository<EmployeeStatus,Integer> {
}
