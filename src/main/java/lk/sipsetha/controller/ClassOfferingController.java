package lk.sipsetha.controller;

import lk.sipsetha.dao.ClassOfferingDao;
import lk.sipsetha.dao.ClassOfferingStatusDao;
import lk.sipsetha.dao.UserDao;
import lk.sipsetha.entity.ClassOffering;
import lk.sipsetha.entity.ClassOfferingStatus;
import lk.sipsetha.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/classoffering")
@CrossOrigin
public class ClassOfferingController {

    @Autowired
    private ClassOfferingDao dao;

    @Autowired
    private PrivilegeController privilegeController;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ClassOfferingStatusDao classOfferingStatusDao;

    @GetMapping(value = "/findall")
    public List<ClassOffering> getAllClassOffering(){
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        HashMap<String,Boolean> getLoggedUserPrivileges = privilegeController.getPrivilegeByUserModule(auth.getName(), "classoffering");
//        if (!getLoggedUserPrivileges.get("select")){
//            return null;
//        }
        return dao.findAll(Sort.by(Sort.Direction.DESC,"id"));
    }

    @DeleteMapping
    public String deleteClassOffering(@RequestBody ClassOffering classOffering){
        //existing check
//        operator
        try {
            ClassOfferingStatus deleteClassOfferingStatus = classOfferingStatusDao.getReferenceById(2);
            classOffering.setDeletedatetime(LocalDateTime.now());
            classOffering.setClassofferingstatus_id(deleteClassOfferingStatus);
//            dao.delete(classOffering);
            dao.save(classOffering);
            return "ok";
        }catch (Exception e){
            return "class offering delete not successful "+e.getMessage();
        }
    }

    @PostMapping
    public String saveClassOffering(@RequestBody ClassOffering classOffering){
        try {
            classOffering.setAddeddatetime(LocalDateTime.now());
            dao.save(classOffering);
            return "ok";
        }catch (Exception e){
            return "class offering save not successful "+e.getMessage();
        }
    }
    @PutMapping
    public String modifyClassOffering(@RequestBody ClassOffering classOffering){
        try {
            classOffering.setModifydatetime(LocalDateTime.now());
            dao.save(classOffering);
            return "ok";
        }catch (Exception e){
            return "class offering modify not successful"+e.getMessage();
        }

    }


    @GetMapping(value = "/bystunum/{stunum}")
    public List<ClassOffering> getByStuNum(@PathVariable("stunum")String stunum){
        while(true){
            return dao.getClassOfferingByStudent(stunum);
        }
    }

}
