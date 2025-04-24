package lk.sipsetha.controller;

import lk.sipsetha.dao.WeekDayDao;
import lk.sipsetha.entity.WeekDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/weekday")
public class WeekDayController {

    @Autowired
    private WeekDayDao dao;


    @GetMapping(value = "/findall")
    public List<WeekDay> getAllWeekDay(){
        return dao.findAll();
    }

}
