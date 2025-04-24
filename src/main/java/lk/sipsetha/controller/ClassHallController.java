package lk.sipsetha.controller;

import lk.sipsetha.dao.ClassHallDao;
import lk.sipsetha.dao.ClassHallStatusDao;
import lk.sipsetha.dao.UserDao;
import lk.sipsetha.entity.ClassHall;
import lk.sipsetha.entity.ClassHallStatus;
import lk.sipsetha.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/classhall")
public class ClassHallController {

    @Autowired
    private ClassHallDao dao;

    @Autowired
    private ClassHallStatusDao classHallStatusDao;

    @Autowired
    private PrivilegeController privilegeController;

    @Autowired
    private UserDao userDao;

    @GetMapping(value = "/findall")
    //authentication and authorization
    public List<ClassHall> findAll(){
        return dao.findAll(Sort.by(Sort.Direction.DESC,"id"));
    }

    @DeleteMapping
    public String deleteClassHall(@RequestBody ClassHall classHall){

        try {
            ClassHallStatus deleteStatus = classHallStatusDao.getReferenceById(3);
            classHall.setClasshallstatus_id(deleteStatus);
            dao.save(classHall);
            return "ok";
        }catch (Exception e){
            return "class hall delete not complete"+e.getMessage();
        }
    }

    @PutMapping
    public String updateClassHall(@RequestBody ClassHall classHall){
        //existing
        try {
            dao.save(classHall);
            return "ok";
        }catch (Exception e){
            return "class hall update not complete"+e.getMessage();
        }
    }

    @PostMapping
    public String submitClassHall(@RequestBody ClassHall classHall){

        ClassHall exClassHallName = dao.getClasshallByNameAndLocation(classHall.getName(),classHall.getLocation());
        if (exClassHallName!=null){
            return "cannot perform class hall because class hall "+classHall.getName()+" and location "+classHall.getLocation()+" is already exists";
        }


        try {
            classHall.setAddeddatetime(LocalDateTime.now());
//            classHall.setAddeduserid();
            dao.save(classHall);
            return "ok";
        }catch (Exception e){
            return "class hall submit not complete"+e.getMessage();
        }
    }


    @GetMapping(value = "/checkduplicatebyhallname/{hallname}/{location}")
    public Boolean getHallNameForValidate(@PathVariable("hallname") String hallname,@PathVariable("location")String location){
        ClassHall exClassHallName = dao.getClasshallByNameAndLocation(hallname,location);
        if (exClassHallName!=null){
            return true;
        }else {
            return false;
        }
    }




}
