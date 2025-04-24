package lk.sipsetha.dao;

import lk.sipsetha.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchDao extends JpaRepository<Branch,Integer> {
}
