package com.p.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.p.entity.Complaint;
import com.p.service.ComplaintService;
import com.p.utils.R;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ComplaintSystem")
public class ComplaintController {
    @Autowired
    private ComplaintService complaintService;
    @PostMapping
    public R save(@RequestBody Complaint complaint){
        return new R().success(complaintService.save(complaint),"提交成功");
    }
    @GetMapping("/{id}")
    public R get(@PathVariable("id") String id){//根据用户id获取投诉信息
        LambdaQueryWrapper<Complaint> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Complaint::getUserName,id);
        return new R().success(complaintService.list(wrapper),"查询成功");
    }
    @GetMapping("/admin")
    public R getAll(){//获取所有投诉信息
        return new R().success(complaintService.list(),"查询成功");
    }
    @PutMapping
    public R update(@RequestBody Complaint complaint){
        return new R().success(complaintService.updateById(complaint),"提交成功");
    }
    @DeleteMapping("/{id}")
    public R delete(@PathVariable("id") Integer id){
        return new R().success(complaintService.removeById(id),"删除成功");
    }
}
