package lk.sipsetha.controller;

import lk.sipsetha.dao.RegistrationStatusDao;
import lk.sipsetha.entity.RegistrationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/registrationstatus")
public class RegistrationStatusController {

    @Autowired
    private RegistrationStatusDao dao;

    @GetMapping(value = "/findall")
    public List<RegistrationStatus> getAllRegistrationStatus(){
        return dao.findAll();
    }
}
