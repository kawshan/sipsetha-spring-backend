package lk.sipsetha.controller;

import lk.sipsetha.dao.PaymentCategoryDao;
import lk.sipsetha.entity.PaymentCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/paymentcategory")
public class PaymentCategoryController {

    @Autowired
    private PaymentCategoryDao dao;

    @GetMapping(value = "/findall")
    public List<PaymentCategory> findAll(){
    return dao.findAll();
    }

}
