package lk.sipsetha.controller;

import lk.sipsetha.dao.QualificationsDao;
import lk.sipsetha.entity.Qualifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/qualifications")
public class QualificationsController {

    @Autowired
    private QualificationsDao dao;

    @GetMapping(value = "/findall")
    public List<Qualifications> getAllQualifications(){
        return dao.findAll();
    }

}
