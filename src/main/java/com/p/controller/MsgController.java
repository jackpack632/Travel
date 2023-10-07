package com.p.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.p.entity.Msg;
import com.p.service.MsgService;
import com.p.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/EmergencyInfo")
public class MsgController  {
    @Autowired//?
    private MsgService msgService;
    @GetMapping
    public R list(){
        LambdaQueryWrapper<Msg> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Msg::getMsgState,"发布");
        return new R().success(msgService.list(wrapper),"查询成功");
    }
    @GetMapping("admin/information")
    public R getMsg(){
        return new R().success(msgService.list(),"查询成功");
    }
    @PostMapping("admin/information")
    public R addMsg(@RequestBody Msg msg){
        return new R().success(msgService.save(msg),"添加成功");
    }
    @PutMapping("admin/information")
    public R updateMsg(@RequestBody Msg msg){
        return new R().success(msgService.updateById(msg),"修改成功");
    }
    @DeleteMapping("admin/information/{id}")
    public R deleteMsg(@PathVariable("id") Integer id){
        return new R().success(msgService.removeById(id),"删除成功");
    }


}

