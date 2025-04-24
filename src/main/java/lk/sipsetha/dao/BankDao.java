package lk.sipsetha.dao;

import lk.sipsetha.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankDao extends JpaRepository<Bank,Integer> {
}
