package lk.sipsetha.controller;

import lk.sipsetha.dao.ClassHallStatusDao;
import lk.sipsetha.entity.ClassHallStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/classhallstatus")
public class ClassHallStatusController {

    @Autowired
    private ClassHallStatusDao dao;

    @GetMapping(value = "/findall")
    public List<ClassHallStatus> findAll(){
        return dao.findAll();
    }


}
