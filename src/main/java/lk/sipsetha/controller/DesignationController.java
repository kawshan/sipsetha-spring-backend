package lk.sipsetha.controller;

import lk.sipsetha.dao.DesignationDao;
import lk.sipsetha.entity.Designation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/designation")
public class DesignationController {

    @Autowired
    public DesignationDao dao;


    @GetMapping(value = "/findall",produces = "application/json")
    public List<Designation> designationFindAll(){
        return dao.findAll();
    }


    @PostMapping()
    public String saveDesignation(@RequestBody Designation designation){
        try {
            dao.save(designation);
            return "ok";
        }catch (Exception e){
            return "designation not complete"+e.getMessage();
        }
    }

}
