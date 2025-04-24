package lk.sipsetha.controller;

import lk.sipsetha.dao.ReportDao;
import lk.sipsetha.entity.Attendance;
import lk.sipsetha.entity.Employee;
import lk.sipsetha.entity.Payment;
import lk.sipsetha.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ReportDataController {

    @Autowired
    private ReportDao reportDao;


    @GetMapping(value = "/reportdataemployee")
    public List<Employee> getWorkingEmployee() {
        return reportDao.workingEmployees();
    }

    //reportdataemployee?status=1&designation=1
    @GetMapping(value = "/reportdataemployee", params = {"status", "designation"})
    public List<Employee> getEmployeeListByStatusAndDesignation(@RequestParam("status") int status, @RequestParam("designation") int designation) {
        return reportDao.getEmpByStatusAndDesignation(status, designation);
    }

    @GetMapping(value = "/reportpresentstudent")
    public List<Student> getPresentStudents() {
        return reportDao.getPresentStudents();
    }

    //reportdatastudent?status=1&grade=1
    @GetMapping(value = "/reportdatastudent", params = {"status", "grade"})
    public List<Student> getStudentListByStatusAndGrade(@RequestParam("status") boolean status, @RequestParam("grade") int grade) {
        return reportDao.getByStatusAndGrade(status, grade);
    }

    //reportdatapayment?month=2024-07
    @GetMapping(value = "/reportdatapayment", params = {"month"})
    public List<Payment> getStudentPaymentByMonth(@RequestParam("month") String month) {
        return reportDao.getPaymentByMonth(month);
    }


    //reportdatapayment?paytype=1&paymentcategory=1
    @GetMapping(value = "reportdatapayment", params = {"paytype", "paymentcategory"})
    public List<Payment> getStudentPaymentByTypeAndCategory(@RequestParam("paytype") int paytype, @RequestParam("paymentcategory") int paymentcategory) {
        return reportDao.getPaymentByTypeAndCategory(paytype, paymentcategory);
    }

    //reportdatapayment?paytype=1
    @GetMapping(value = "/reportdatapayment", params = {"paytype"})
    public List<Payment> getStudentByPaymentType(@RequestParam("paytype") int paytype) {
        return reportDao.getPaymentByPaymentType(paytype);
    }


    //    reportdatapayment?paymentcategory=1
    @GetMapping(value = "/reportdatapayment", params = {"paymentcategory"})
    public List<Payment> getStudentByPaymentCategory(@RequestParam("paymentcategory") int paymentcategory) {
        return reportDao.getPaymentByPaymentCategory(paymentcategory);
    }

    ///reportdataattendance/{startdate}/{enddate}
    @GetMapping(value = "/reportdataattendance/{startdate}/{enddate}/{id}")
    public List<Attendance> getAttendanceBYStartDateAndEndDate(@PathVariable("startdate") LocalDate startdate, @PathVariable("enddate") LocalDate enddate,@PathVariable("id")Integer id) {
        return reportDao.getAttendanceStartAndENDDate(startdate, enddate,id);
    }

    //reportdatapayment/2024-07-27
    @GetMapping(value = "/reportdatapayment/{date}")
    public List<Payment> getReportByDate(@PathVariable("date") String date) {
        return reportDao.getPaymentByDate(date);
    }

}

