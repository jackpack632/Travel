package com.p.controller;

import com.p.entity.Traveler;
import com.p.service.TravelerService;
import com.p.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private TravelerService travelerService;
    
    @PostMapping
    public R register(@RequestBody Traveler traveler) {//传入id,password,e_mail
        if(travelerService.getById(traveler.getId())!=null)
            return new R().error("用户已存在");
        travelerService.save(traveler);
        return new R().success();
    }
}
