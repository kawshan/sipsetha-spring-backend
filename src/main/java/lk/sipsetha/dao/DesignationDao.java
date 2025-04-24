package lk.sipsetha.dao;

import lk.sipsetha.entity.Designation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesignationDao extends JpaRepository<Designation,Integer> {
}
