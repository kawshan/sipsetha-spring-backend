package lk.sipsetha.controller;

import lk.sipsetha.dao.ClassTypeDao;
import lk.sipsetha.entity.ClassType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/classtype")
public class ClassTypeController {

    @Autowired
    private ClassTypeDao dao;

    @GetMapping(value = "/findall")
    public List<ClassType> getAllClassType(){
        return dao.findAll();
    }

}
