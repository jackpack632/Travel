package com.p.controller;

import com.p.entity.Admin;
import com.p.entity.User;
import com.p.service.AdminService;
import com.p.service.TravelerService;
import com.p.utils.Jwt;
import com.p.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/Login")

public class LoginController {
    @Autowired
    AdminService adminService;
    @Autowired
    TravelerService travelerService;

    @PostMapping
    public R login(@RequestBody User user){

        try {
            if(user.getId().equals("admin")){
                int code=adminService.getById(user.getId()).getPassword().equals(user.getPassword())?200:400;
                String msg=code==200?"管理员登陆成功":"登陆失败，用户名或密码错误";
                //下发令牌
                if(code==200){
                    HashMap<String, Object> claims=new HashMap<>();
                    claims.put("id",user.getId());
                    claims.put("role","admin");
                    String jwt=new Jwt().create(claims);
                    return new R().success(jwt,msg);
                }
                return new R().error(msg);
            }else {
                int code=travelerService.getById(user.getId()).getPassword().equals(user.getPassword())?200:400;
                String msg=code==200?"用户登陆成功":"登陆失败，用户名或密码错误";
                //下发令牌
                if(code==200){
                    HashMap<String, Object> claims=new HashMap<>();
                    claims.put("id",user.getId());
                    claims.put("role","traveler");
                    String jwt=new Jwt().create(claims);
                    return new R().success(jwt,msg);
                }
                return new R().error(msg);
            }
        } catch (Exception e) {
            return new R().error("登陆失败，用户名或密码错误");
        }
    }
}
