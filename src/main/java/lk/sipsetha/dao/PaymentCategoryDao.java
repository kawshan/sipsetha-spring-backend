package lk.sipsetha.dao;

import lk.sipsetha.entity.PaymentCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentCategoryDao extends JpaRepository<PaymentCategory,Integer> {
}
