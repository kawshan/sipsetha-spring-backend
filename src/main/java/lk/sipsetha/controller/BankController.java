package lk.sipsetha.controller;

import lk.sipsetha.dao.BankDao;
import lk.sipsetha.entity.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/bank")
public class BankController {

    @Autowired
    private BankDao dao;

    @GetMapping(value = "/findall")
    public List<Bank> getAllBank(){
        return dao.findAll();
    }
}
