package lk.sipsetha.dao;

import lk.sipsetha.entity.ClassroomAllocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRoomAllocationDao extends JpaRepository<ClassroomAllocation,Integer> {
}
