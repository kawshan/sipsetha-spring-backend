package lk.sipsetha.controller;

import lk.sipsetha.dao.AllocationTypeDao;
import lk.sipsetha.entity.AllocationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/allocationtype")
public class AllocationTypeController {

    @Autowired
    private AllocationTypeDao dao;

    @GetMapping(value = "/findall")
    public List<AllocationType> getAllAllocationType(){
        return dao.findAll();
    }

}
