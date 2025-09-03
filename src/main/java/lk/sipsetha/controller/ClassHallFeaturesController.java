package lk.sipsetha.controller;

import lk.sipsetha.dao.ClassHallFeaturesDao;
import lk.sipsetha.entity.ClassHallFeatures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/classhallfeatures")
@CrossOrigin
public class ClassHallFeaturesController {

    @Autowired
    private ClassHallFeaturesDao dao;

    @GetMapping(value = "/findall")
    public List<ClassHallFeatures> getAll(){
        return dao.findAll();
    }

    @GetMapping(value = "/withoutchfeatures/{classhallid}")
    public List<ClassHallFeatures> getClassHallWithoutFeatures(@PathVariable("classhallid")Integer classHallId){
        return dao.getClassHallWithOutFeatures(classHallId);
    }

}
