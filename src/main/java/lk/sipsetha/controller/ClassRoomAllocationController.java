package lk.sipsetha.controller;

import lk.sipsetha.dao.AllocationStatusDao;
import lk.sipsetha.dao.ClassRoomAllocationDao;
import lk.sipsetha.dao.UserDao;
import lk.sipsetha.entity.AllocationStatus;
import lk.sipsetha.entity.ClassroomAllocation;
import lk.sipsetha.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/classroomallocation")
public class ClassRoomAllocationController {

    @Autowired  //dependency injection
    private ClassRoomAllocationDao dao;

    @Autowired
    private AllocationStatusDao allocationStatusDao;

    @Autowired
    private PrivilegeController privilegeController;

    @Autowired
    private UserDao userDao;

    @GetMapping(value = "/findall")
    public List<ClassroomAllocation> getAllClassRoomAllocation(){
        return dao.findAll(Sort.by(Sort.Direction.DESC,"id"));
    }


    @PostMapping
    public String saveClassRoomAllocation(@RequestBody ClassroomAllocation classroomAllocation){
        try {
            classroomAllocation.setAddeddatetime(LocalDateTime.now());
            dao.save(classroomAllocation);
            return "ok";
        }catch (Exception e){
            return "class room allocation save is not complete "+e.getMessage();
        }

    }

    @PutMapping
    public String updateClassRoomAllocation(@RequestBody ClassroomAllocation classroomAllocation){
        try {
            dao.save(classroomAllocation);
            return "ok";
        }catch (Exception e){
            return "update class room allocation is not complete"+e.getMessage();
        }

    }


    @DeleteMapping
    public String deleteClassroomAllocation(@RequestBody ClassroomAllocation classroomAllocation){
        try {
            AllocationStatus deleteAllocationStatus =allocationStatusDao.getReferenceById(2);
            classroomAllocation.setAllocationstatus_id(deleteAllocationStatus);
            dao.save(classroomAllocation);
            return "ok";
        }catch (Exception e){
            return "delete class room allocation is not complete "+e.getMessage();
        }
    }


}
