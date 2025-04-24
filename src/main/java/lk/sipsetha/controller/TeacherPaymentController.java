package lk.sipsetha.controller;

import lk.sipsetha.dao.TeacherPaymentDao;
import lk.sipsetha.dao.UserDao;
import lk.sipsetha.entity.TeacherPayment;
import lk.sipsetha.entity.TeacherPaymentHasEnrolment;
import lk.sipsetha.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/teacherpayment")
public class TeacherPaymentController {
    @Autowired
    private TeacherPaymentDao dao;

    @Autowired
    private PrivilegeController privilegeController;

    @Autowired
    private UserDao userDao;


    @GetMapping(value = "/findall")
    private List<TeacherPayment> getAllTeacherPayment(){
        return dao.findAll();
    }

    @PostMapping
    public String saveTeacherPayment(@RequestBody TeacherPayment teacherPayment){
        try {
            String nextBillNumber = dao.getNextBillNumber();
            if (nextBillNumber==null || nextBillNumber==""){
                teacherPayment.setBillnumber("0000000001");
            }else {
                teacherPayment.setBillnumber(nextBillNumber);
            }

            teacherPayment.setAddeddatetime(LocalDateTime.now());


            for (TeacherPaymentHasEnrolment teacherPaymentHasEnrolment : teacherPayment.getTeacherPaymentHasEnrolments()){
                teacherPaymentHasEnrolment.setTeacherpayment_id(teacherPayment);
            }
            dao.save(teacherPayment);
            return "ok";

        }catch (Exception e){
            return "teacher payment save not completed"+e.getMessage();
        }
    }

    @PutMapping
    public String updateTeacherPayment(@RequestBody TeacherPayment teacherPayment){
        try {
            for (TeacherPaymentHasEnrolment teacherPaymentHasEnrolment : teacherPayment.getTeacherPaymentHasEnrolments()){
                teacherPaymentHasEnrolment.setTeacherpayment_id(teacherPayment);
            }
            return "ok";
        }catch (Exception e){
            return "update teacher payment not complete"+e.getMessage();
        }
    }
    @DeleteMapping
    public String deleteTeacherPayment(@RequestBody TeacherPayment teacherPayment){
        try {
            for (TeacherPaymentHasEnrolment tphe : teacherPayment.getTeacherPaymentHasEnrolments()){
                tphe.setTeacherpayment_id(teacherPayment);
            }

            dao.delete(teacherPayment);
            return "ok";
        }catch (Exception e){
            return "teacher payment delete not complete "+e.getMessage();
        }
    }


}
