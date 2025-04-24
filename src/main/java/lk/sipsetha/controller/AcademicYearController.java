package lk.sipsetha.controller;

import lk.sipsetha.dao.AcademicYearDao;
import lk.sipsetha.entity.AcademicYear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/academicyear")
public class AcademicYearController {

    @Autowired
    private AcademicYearDao dao;

    @GetMapping(value = "/findall")
    public List<AcademicYear> getAllAcademicYear(){
        return dao.findAll();
    }


    @PostMapping
    public String saveAcademicYear(@RequestBody AcademicYear academicyear){
        try {
            dao.save(academicyear);
            return "ok";
        }catch (Exception e){
            return "academic year save not complete"+e.getMessage();
        }

    }
}
