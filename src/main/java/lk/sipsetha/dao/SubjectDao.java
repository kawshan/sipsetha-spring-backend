package lk.sipsetha.dao;

import lk.sipsetha.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectDao extends JpaRepository<Subject,Integer> {
}
