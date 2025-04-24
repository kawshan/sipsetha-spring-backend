package lk.sipsetha.controller;

import lk.sipsetha.dao.UserDao;
import lk.sipsetha.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ReportUiController {

@Autowired
private UserDao userDao;

    @GetMapping(value = "/reportworkingemployee")
    public ModelAndView reportWorkingEmployee(){
        ModelAndView workingEmpView = new ModelAndView();
        workingEmpView.setViewName("reportworkingemployee.html");
        return workingEmpView;
    }

    @GetMapping(value = "/reportstudentui")
    public ModelAndView reportStudentView(){
        ModelAndView studentReportUI = new ModelAndView();
        studentReportUI.setViewName("studentreport.html");
        return studentReportUI;
    }

    @GetMapping(value = "/reportpaymentui")
    public ModelAndView reportPaymentView(){
        ModelAndView paymentReportUI = new ModelAndView();
        paymentReportUI.setViewName("paymentreport.html");
        return paymentReportUI;
    }



    @GetMapping(value = "/reportattendancetui")
    public ModelAndView reportAttendanceView(){
        ModelAndView attendanceReportUI = new ModelAndView();
        attendanceReportUI.addObject("title","attendance report");
        attendanceReportUI.setViewName("attendancereport.html");
        return attendanceReportUI;
    }






}
