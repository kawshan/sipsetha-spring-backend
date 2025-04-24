package lk.sipsetha.controller;

import lk.sipsetha.dao.EmployeeStatusDao;
import lk.sipsetha.entity.EmployeeStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/employeestatus")
public class EmployeeStatusController {
    @Autowired
    public EmployeeStatusDao dao;

    @GetMapping(value = "/findall")
    public List<EmployeeStatus> employeeStatusesFindAll(){
        return dao.findAll();
    }

}
