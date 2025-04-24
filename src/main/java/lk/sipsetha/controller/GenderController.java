package lk.sipsetha.controller;

import lk.sipsetha.dao.GenderDao;
import lk.sipsetha.entity.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/gender")
public class GenderController {
    @Autowired
    public GenderDao dao;

    @GetMapping(value = "/findall",produces = "application/json")
    public List<Gender> genderFindAll(){
        return dao.findAll();
    }

}
