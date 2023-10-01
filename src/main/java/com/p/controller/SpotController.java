package com.p.controller;

import com.p.service.SpotService;
import com.p.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Spot")
public class SpotController {
    @Autowired
    private SpotService spotService;
    @GetMapping
    public R list(){
        List list = spotService.list();
        return new R().success(list,"查询成功");
    }
}
