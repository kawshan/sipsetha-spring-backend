package lk.sipsetha.controller;

import lk.sipsetha.dao.AllocationStatusDao;
import lk.sipsetha.entity.AllocationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/allocationstatus")
public class AllocationStatusController {

    @Autowired
    private AllocationStatusDao dao;


    @GetMapping(value = "/findall")
    private List<AllocationStatus> getAllAllocationStatus(){
        return dao.findAll();
    }

}
