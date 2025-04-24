package lk.sipsetha.controller;

import lk.sipsetha.dao.RegisteredTypeDao;
import lk.sipsetha.entity.RegisteredType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/registeredtype")
public class RegisteredTypeController {

    @Autowired
    private RegisteredTypeDao dao;


    @GetMapping(value = "/findall")
    public List<RegisteredType> getAllRegisteredType(){
       return dao.findAll();
    }

}
