package lk.sipsetha.controller;

import lk.sipsetha.dao.BranchDao;
import lk.sipsetha.entity.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/branch")
public class BranchController {

    @Autowired
    private BranchDao dao;

    @GetMapping(value = "/findall")
    public List<Branch> getAllBranch(){
        return dao.findAll();
    }

    @PostMapping
    public String saveBranch(@RequestBody Branch branch){
        try {
            dao.save(branch);
            return "ok";
        }catch (Exception e){
            return "save branch not complete"+e.getMessage();
        }
    }

}
