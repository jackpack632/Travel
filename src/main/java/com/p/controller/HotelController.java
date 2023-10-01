package com.p.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.p.entity.Hotel;
import com.p.service.HotelService;
import com.p.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("HotelSystem")

public class HotelController {
    @Autowired
    private HotelService hotelService;

    //根据传来的spot_id查询酒店
    @GetMapping("/{spot_id}")
    public R getHotelBySpotId(@PathVariable("spot_id") Integer spot_id){
        LambdaQueryWrapper<Hotel> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Hotel::getSpotId,spot_id);
        return new R().success(hotelService.list(wrapper),"查询成功");

    }
    @GetMapping("admin/information")
    public R getHotelInformation(){
        return new R().success(hotelService.list(),"查询成功");
    }
    @PostMapping("admin/information")
    public R addHotelInformation(@RequestBody Hotel hotel){
        return new R().success(hotelService.save(hotel),"添加成功");
    }
    @PutMapping("admin/information")
    public R updateHotelInformation(@RequestBody Hotel hotel){
        return new R().success(hotelService.updateById(hotel),"修改成功");
    }
}
