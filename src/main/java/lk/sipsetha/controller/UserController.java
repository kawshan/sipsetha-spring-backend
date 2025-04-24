package lk.sipsetha.controller;

import lk.sipsetha.dao.UserDao;
import lk.sipsetha.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserDao userDao;

    @Autowired
    private PrivilegeController privilegeController;


    @GetMapping(value = "/findall")
    public List<User> findAll() {
            return userDao.findAll(Sort.by(Sort.Direction.DESC,"id"));
    }


    @PostMapping
    public String saveUser(@RequestBody User user) {
        //check duplicate
        User extUserName = userDao.getUserByUserName(user.getUsername());
        if (extUserName != null) {
            return "save not complete... user already exists";
        }

        User extUserEmployee = userDao.getUserByEmployee(user.getEmployee_id().getId());
        if (extUserEmployee != null) {
            return "save not complete given employee is already exists";
        }


        //operator
        try {
            //auto set values
            user.setAddeddatetime(LocalDateTime.now());
            userDao.save(user);
            return "ok";
        } catch (Exception e) {
            return "user save not completed " + e.getMessage();
        }
    }

    @PutMapping
    public String updateUser(@RequestBody User user) {

        //existing and duplicate check
        User extUser = userDao.getReferenceById(user.getId());// Request body eke inna user data base eke kalin innawada balananawa
        if (extUser == null) {  //ehema use kenekn naththam update karanna ba ne  ee nisa meeke null namm ee kiyanne user kenek naththam
            return "user not exist";    // api error ekek return karanawa user kenek na kiyala
        }
        User extUserEmail = userDao.getUserByEmail(user.getEmail());
        if (extUserEmail != null && extUserEmail.getId() != user.getId()) {
            return "email already exist";
        }

        User extUserName = userDao.getUserByUserName(user.getUsername());
        if (extUserName != null && !user.getId().equals(extUserName.getId())){
            return "update not complete.. user name already exists";
        }


        try {
            userDao.save(user);
            return "ok";
        } catch (Exception e) {
            return "user update not complete. please check again" + e.getMessage();
        }


    }

    @DeleteMapping
    public String deleteUser(@RequestBody User user) {

        User extUser = userDao.getReferenceById(user.getId());
        if (extUser == null){
            return "user delete not success. user not exists.";
        }
        try {
            //operations
            //userDao.delete(user); this is hard delete ->this directly removes user record form database
            user.setStatus(false);  //this is soft delete -> in here we only set user status to false
            userDao.save(user);
            return "ok";
        } catch (Exception e) {
            return "user delete not completed please check again" + e.getMessage();
        }


    }


    @GetMapping(value = "/byempid/{empid}")
    public Boolean getUserByEmpId(@PathVariable("empid")Integer empid){
        User userByEmpID = userDao.getUserByEmployee(empid);
        if (empid!=null){
            return true;
        }else {
            return false;
        }
    }

    @GetMapping(value = "/byid/{userid}")
    public User getUserByUserId(@PathVariable("userid")Integer userid){
        return userDao.getById(userid);
    }


}
