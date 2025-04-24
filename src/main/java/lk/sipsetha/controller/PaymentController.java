package lk.sipsetha.controller;

import lk.sipsetha.dao.PaymentDao;
import lk.sipsetha.dao.UserDao;
import lk.sipsetha.entity.Payment;
import lk.sipsetha.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    @Autowired
    private PaymentDao dao;

    @Autowired
    private PrivilegeController privilegeController;

    @Autowired
    private UserDao userDao;

    @GetMapping(value = "/paymentform")
    public ModelAndView getPaymentTypeUI(){
        ModelAndView paymentTypeView = new ModelAndView();
        paymentTypeView.setViewName("payment.html");
        return paymentTypeView;
    }

    @GetMapping(value = "/findall")
    public List<Payment> getAllPaymentType(){
        return dao.findAll(Sort.by(Sort.Direction.DESC,"id"));
    }

    @PostMapping
    public String saveStudentPayment(@RequestBody Payment payment){
        System.out.println(payment.getPaymentcategory_id().getName());
        if (payment.getPaymentcategory_id().getName().equals("admission")){
            System.out.println("inside inner admission condition");
            //need to duplicate check
        }else {
            //existing and duplicate
            Payment exPayment=dao.checkDuplicateByStudentMonthAndRegistration(payment.getStudent_id().getId(),payment.getMonth(),payment.getStudentregistration_id().getId());
            if (exPayment!=null){
                return "cannot perform payment because it already exists";
            }
        }





        //operators
        try {
            String getNextBillNumber = dao.getNextBillNumber();
            if (getNextBillNumber==null || getNextBillNumber == ""){
                payment.setBillnumber("0000000001");
            }else {
                payment.setBillnumber(getNextBillNumber);
            }

            payment.setAddeddatetime(LocalDateTime.now());


            dao.save(payment);
            return "ok";
        }catch (Exception e){
            return "student payment submit not complete "+e.getMessage();
        }
    }

    @PutMapping
    public String ModifyPayment(@RequestBody Payment payment){
        //existing check
        //operation
        try {
            payment.setModifydatetime(LocalDateTime.now());
            dao.save(payment);
            return "ok";
        }catch (Exception e){
            return "modify payment is not completed "+e.getMessage();
        }
    }

    @DeleteMapping
    public String deletePayment(@RequestBody Payment payment){
        //existing
        //operator
        try {
            dao.delete(payment);
            return "ok";
        }catch (Exception e){
            return "delete payment not successful "+e.getMessage();
        }
    }

    @GetMapping(value = "/payedamountbystudent/{stunum}")
    public Boolean getPaymentAmountByStudentNum(@PathVariable("stunum")String stunum){
        List<Payment> paymentList = dao.paymentByStudent(stunum);
        if (paymentList.size() == 0){
            return  false;
        }else {
           return true;
        }
    }


    
    @GetMapping(value = "/getmaxmonthbystudent/{stunum}")
    public String getMaxMonthByStudent(@PathVariable("stunum")String stunum){
        return dao.getMaxMonthPaymentByStudent(stunum);
    }

    @GetMapping(value = "/getmaxmonthpayment/{stunum}/{registration}")
    public String getMaxMonthBYPayment(@PathVariable("stunum")String stunum,@PathVariable("registration") String registration){
        return dao.getmaxbypayment(stunum,registration);
    }




}






