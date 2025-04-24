package lk.sipsetha.controller;

import lk.sipsetha.dao.SubjectDao;
import lk.sipsetha.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/subject")
public class SubjectController {

    @Autowired
    private SubjectDao dao;


    @GetMapping(value = "/findall")
    public List<Subject> getAllSubject(){
        return dao.findAll();
    }

    @PostMapping
    public String saveSubject(@RequestBody Subject subject){
        try {
            dao.save(subject);
            return "ok";
        }catch (Exception e){
            return "save not complete "+e.getMessage();
        }
    }

}
