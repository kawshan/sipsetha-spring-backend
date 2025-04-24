package lk.sipsetha.controller;

import lk.sipsetha.dao.EnrolmentStatusDao;
import lk.sipsetha.entity.EnrolmentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value ="/enrolmentstatus")
public class EnrolmentStatusController {
    @Autowired
    private EnrolmentStatusDao enrolmentStatusDao;


    @GetMapping(value = "/findall")
    public List<EnrolmentStatus> findAllEnrolmentStatus(){
        return enrolmentStatusDao.findAll();
    }
}
