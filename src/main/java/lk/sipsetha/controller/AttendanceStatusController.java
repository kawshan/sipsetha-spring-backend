package lk.sipsetha.controller;

import lk.sipsetha.dao.AttendanceStatusDao;
import lk.sipsetha.entity.AttendanceStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/attendancestatus")
public class AttendanceStatusController {

    @Autowired
    private AttendanceStatusDao dao;

    @GetMapping(value = "/findall")
    public List<AttendanceStatus> getAllAttendanceStatus(){
        return dao.findAll();
    }


}
