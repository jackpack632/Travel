package com.p.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.p.entity.Hotel;
import com.p.entity.Spot;
import com.p.service.SpotService;
import com.p.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("{spot_name}")
    public R getSpotByName(@PathVariable("spot_name") String spot_name){
        LambdaQueryWrapper<Spot> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Spot::getSpotName,spot_name);
        return new R().success(spotService.list(wrapper),"查询成功");
    }
}
