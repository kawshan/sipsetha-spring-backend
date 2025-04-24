package lk.sipsetha.controller;

import lk.sipsetha.dao.PayTypeDao;
import lk.sipsetha.entity.PayType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/paytype")
public class PayTypeController {
    @Autowired
    private PayTypeDao dao;

    @GetMapping(value = "/findall")
    public List<PayType> getAllPayType(){
        return dao.findAll();
    }

}
