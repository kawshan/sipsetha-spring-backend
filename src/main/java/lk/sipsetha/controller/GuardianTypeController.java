package lk.sipsetha.controller;

import lk.sipsetha.dao.GuardianTypeDao;
import lk.sipsetha.entity.GuardianType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/guardiantype")
public class GuardianTypeController {
    @Autowired
    public GuardianTypeDao guardianTypeDao;

    @GetMapping(value = "/findall")
    public List<GuardianType> guardianTypeFindAll(){
        return guardianTypeDao.findAll();
    }

}
