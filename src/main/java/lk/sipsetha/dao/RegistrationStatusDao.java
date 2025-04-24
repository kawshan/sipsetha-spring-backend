package lk.sipsetha.dao;

import lk.sipsetha.entity.RegistrationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationStatusDao extends JpaRepository<RegistrationStatus,Integer> {
}
