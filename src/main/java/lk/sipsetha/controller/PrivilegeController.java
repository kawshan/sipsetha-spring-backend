package lk.sipsetha.controller;

import lk.sipsetha.dao.PrivilegeDao;
import lk.sipsetha.dao.UserDao;
import lk.sipsetha.entity.Privilege;
import lk.sipsetha.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/privilege")
public class PrivilegeController {
    @Autowired
    private PrivilegeDao privilegeDao;

    @Autowired
    private UserDao userDao;


    @GetMapping(value = "/findall",produces = "application/json")
    public List<Privilege> privilegeFindAll(){
        return privilegeDao.findAll(Sort.by(Sort.Direction.DESC,"id"));
    }

    @DeleteMapping
    public String deletePrivilege(@RequestBody Privilege privilege){

        //existing check
        Privilege extPrivilege = privilegeDao.getReferenceById(privilege.getId());
        if (extPrivilege == null){
            return "cannot delete privilege. privilege does not exists";
        }

        //hard delete
        //soft delete
        try {
//            privilegeDao.delete(privilege);
            extPrivilege.setSel(false);
            extPrivilege.setInst(false);
            extPrivilege.setUpd(false);//in delete mapping
            extPrivilege.setDel(false);
            privilegeDao.save(extPrivilege);

            return "ok";
        }catch (Exception e){
            return "delete not completed "+e.getMessage();
        }

    }

    @PostMapping
    public String savePrivilege(@RequestBody Privilege privilege){
        try {
            privilegeDao.save(privilege);
            return "ok";
        }catch (Exception e){
            return "privilege save not complete"+e.getMessage();
        }
    }

    @PutMapping
    public String modifyPrivilege(@RequestBody Privilege privilege){
        try {
            privilegeDao.save(privilege);
            return "ok";
        }catch (Exception e){
            return "modify privilege was not successful"+e.getMessage();
        }

    }



}











