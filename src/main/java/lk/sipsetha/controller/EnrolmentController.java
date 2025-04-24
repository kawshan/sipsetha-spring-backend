package lk.sipsetha.controller;

import lk.sipsetha.dao.EnrolmentDao;
import lk.sipsetha.dao.EnrolmentStatusDao;
import lk.sipsetha.dao.UserDao;
import lk.sipsetha.entity.Enrolment;
import lk.sipsetha.entity.EnrolmentHasClassOfferings;
import lk.sipsetha.entity.EnrolmentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/enrolment")
public class EnrolmentController {

    @Autowired
    private EnrolmentDao dao;

    @Autowired
    private PrivilegeController privilegeController;

    @Autowired
    private EnrolmentStatusDao enrolmentStatusDao;

    @Autowired
    private UserDao userDao;


    @GetMapping(value = "/findall")
    public List<Enrolment> getAllEnrolment(){
        return dao.findAll();
    }

    @PostMapping
    public String saveEnrolment(@RequestBody Enrolment enrolment){
        try {

            String enrolmentNextNumber = dao.getEnrolmentNextNumber();
            if (enrolmentNextNumber==null || enrolmentNextNumber ==""){
                enrolment.setEnrolmentnum("0000000001");
            }else {
                enrolment.setEnrolmentnum(enrolmentNextNumber);
            }


            enrolment.setAddeddatetime(LocalDateTime.now());
            for (EnrolmentHasClassOfferings ehco : enrolment.getClassOfferings()){
                ehco.setEnrolment_id(enrolment);
            }
            dao.save(enrolment);
            return "ok";
        }catch (Exception e){
            return "save not complete"+e.getMessage();
        }
    }

    @PutMapping
    public String updateEnrolment(@RequestBody Enrolment enrolment){
        try {
            enrolment.setModifydatetime(LocalDateTime.now());
            for (EnrolmentHasClassOfferings ehco : enrolment.getClassOfferings()){
                ehco.setEnrolment_id(enrolment);
            }
            return "ok";
        }catch (Exception e){
            return "update enrolment not complete"+e.getMessage();
        }
    }

    @DeleteMapping
    public String deleteEnrolment(@RequestBody Enrolment enrolment){
        try {
            enrolment.setDeletedatetime(LocalDateTime.now());
            for (EnrolmentHasClassOfferings ehco : enrolment.getClassOfferings()){
                ehco.setEnrolment_id(enrolment);
            }
            EnrolmentStatus deleteEnrolmentStatus = enrolmentStatusDao.getReferenceById(2);
            enrolment.setEnrolmentstatus_id(deleteEnrolmentStatus);
            dao.save(enrolment);
            return "ok";
        }catch (Exception e){
            return "delete enrolment not complete "+e.getMessage();
        }
    }

}
