package lk.sipsetha.controller;

import lk.sipsetha.dao.ClassOfferingStatusDao;
import lk.sipsetha.entity.ClassOfferingStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/classofferingstatus")
public class ClassOfferingStatusController {

    @Autowired
    private ClassOfferingStatusDao dao;

    @GetMapping(value = "/findall")
    public List<ClassOfferingStatus> getAllClassOfferings(){
        return dao.findAll();
    }

}
