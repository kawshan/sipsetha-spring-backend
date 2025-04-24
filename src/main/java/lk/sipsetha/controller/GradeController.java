package lk.sipsetha.controller;

import lk.sipsetha.dao.GradeDao;
import lk.sipsetha.entity.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/grade")
public class GradeController {

    @Autowired
    public GradeDao gradeDao;

    @GetMapping(value = "/findall")
    public List<Grade> gradeFindAll(){
        return gradeDao.findAll();
    }

}
