package lk.sipsetha.dao;

import lk.sipsetha.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeDao extends JpaRepository<Grade,Integer> {
}
