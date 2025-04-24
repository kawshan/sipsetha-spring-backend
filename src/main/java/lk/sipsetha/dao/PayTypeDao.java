package lk.sipsetha.dao;

import lk.sipsetha.entity.PayType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayTypeDao extends JpaRepository<PayType,Integer> {
}
