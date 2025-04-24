package lk.sipsetha.controller;

import lk.sipsetha.dao.AttendanceDao;
import lk.sipsetha.dao.AttendanceStatusDao;
import lk.sipsetha.dao.UserDao;
import lk.sipsetha.entity.Attendance;
import lk.sipsetha.entity.AttendanceStatus;
import lk.sipsetha.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/attendance")
public class AttendanceController {

    @Autowired//dependancy injection
    private AttendanceDao dao; //Attendace dao type dao varible ekak declare karagannawa    //dao eka link karaganne databse operations walata

    @Autowired
    private AttendanceStatusDao attendanceStatusDao;


    @Autowired
    private PrivilegeController privilegeController;

    @Autowired
    private UserDao userDao;

    @GetMapping(value = "/findall")
    public List<Attendance> getAllAttendance(){
        return dao.findAll(Sort.by(Sort.Direction.DESC,"id"));
    }


    @DeleteMapping
    public String deleteAttendance(@RequestBody Attendance attendance){
        try {
            AttendanceStatus deleteAttendanceStatus = attendanceStatusDao.getReferenceById(3);
            attendance.setAttendancestatus_id(deleteAttendanceStatus);;
            attendance.setDeletedate(LocalDate.now());
            dao.save(attendance);
            return "ok";
        }catch (Exception e){
            return "attendance delete was unsuccessful "+e.getMessage();
        }
    }


    @PostMapping
    public String saveAttendance(@RequestBody Attendance attendance){
        Attendance chekDuplicateAttendance=dao.checkDupUsingDateStuClZOff(LocalDate.now().toString(),attendance.getClassoffering_id().getId(),attendance.getStudent_id().getId());
        if (chekDuplicateAttendance!=null){
            return "cannot perform attendance its already exists";
        }


        try {
            attendance.setAddeddate(LocalDate.now());
            dao.save(attendance);
            return "ok";
        }catch (Exception e){
            return "save attendance not complete "+e.getMessage();
        }
    }



    @PutMapping
    public String modifyAttendance(@RequestBody Attendance attendance){
        try {
            attendance.setUpdatedate(LocalDate.now());
            dao.save(attendance);
            return "ok";
        }catch (Exception e){
            return "cannot perform modify attendance "+e.getMessage();
        }
    }


}
