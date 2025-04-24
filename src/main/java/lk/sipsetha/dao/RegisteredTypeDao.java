package lk.sipsetha.dao;

import lk.sipsetha.entity.RegisteredType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisteredTypeDao extends JpaRepository<RegisteredType,Integer> {
}
