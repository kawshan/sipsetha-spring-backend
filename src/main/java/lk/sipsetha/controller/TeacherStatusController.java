package lk.sipsetha.controller;

import lk.sipsetha.dao.TeacherStatusDao;
import lk.sipsetha.entity.TeacherStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/teacherstatus")
public class TeacherStatusController {

    @Autowired
    private TeacherStatusDao dao;

    @GetMapping(value = "/findall")
    public List<TeacherStatus> getAllTeacherStatus(){
        return dao.findAll();
    }

}
