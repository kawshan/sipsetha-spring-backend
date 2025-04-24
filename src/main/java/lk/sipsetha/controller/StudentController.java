package lk.sipsetha.controller;

import lk.sipsetha.dao.StudentDao;
import lk.sipsetha.dao.UserDao;
import lk.sipsetha.entity.Student;
import lk.sipsetha.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
//Purpose of @RestController: To simplify the creation of RESTful web services by automatically converting method return values into HTTP responses in JSON or other formats.
@RestController //@RestController is an annotation in Spring Boot that is used to create RESTful web services. // meken thama apita url request karanna puluwan venne meka naththam apita get post put delete wage request call karanna bari venawa
@RequestMapping(value = "/student") // request mapping warga dekakata haduna ganna puluwan ekak class level anika method level//class level eken patan gaththoth eeta passe method level eke class level ekata enuwa call kranna puluwan ex /student/findall //meka class level request mapping ekak meken patan aran thama apita path haraha request access karanna puluwan venne udaharanayak vidihata gaththoth /student eken patan aragena /find all eka reques karana eka
public class StudentController {
    @Autowired  //dependacy injection //
    public StudentDao studentDao;

    @Autowired//Purpose of @Autowired: To automatically inject the required dependencies into a Spring-managed bean, allowing for automatic resolution of collaborators.
    private PrivilegeController privilegeController;

    @Autowired
    private UserDao userDao;    //data base operations karanna one vena nisa user dao eken instance ekek hadagene eka private verible ekakta assign karagena thiyenwa

    @GetMapping(value = "/findall",produces = "application/json")
    public List<Student> studentFindAll(){
        return studentDao.findAll(Sort.by(Sort.Direction.DESC,"id"));
    }

    @GetMapping(value = "/studentform")
    public ModelAndView studentView(){
        ModelAndView studentUI = new ModelAndView();
        studentUI.setViewName("student.html");
        studentUI.addObject("title","student management");
        return studentUI;
    }

    @PostMapping
    public String saveStudent(@RequestBody Student student){
        //existing check
        try {
            String studentNextNumber= studentDao.getStudentByNextNumber();
            if (studentNextNumber==null || studentNextNumber.equals("")){
                student.setStunum("00001");
            }else {
                student.setStunum(studentNextNumber);
            }

            student.setAddeddatetime(LocalDateTime.now());
            studentDao.save(student);
            return "ok";
        }catch (Exception e){
            return "student add not complete "+e.getMessage();
        }
        //operator
        //auto set values

    }

    @DeleteMapping
    public String deleteStudent(@RequestBody Student student){
        try {
            //auto set values
            student.setDeletedatetime(LocalDateTime.now());
            student.setStatus(false);
            studentDao.save(student);
            return "ok";
            //operator
        }catch (Exception e){
            return "delete not complete"+e.getMessage();
        }


    }

    @PutMapping
    public String updateStudent(@RequestBody Student student){
        try {
            student.setModifydatetime(LocalDateTime.now());
            studentDao.save(student);
            return "ok";
        }catch (Exception e){
            return "cannot update"+e.getMessage();
        }
    }

    @GetMapping(value = "/getbystunum/{stunum}")
    public String getStudentByStuNum(@PathVariable("stunum") String stunum){
        return studentDao.getStudentByStunum(stunum);
    }


}
