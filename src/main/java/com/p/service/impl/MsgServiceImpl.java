package com.p.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.p.dao.MsgDao;
import com.p.entity.Msg;
import com.p.service.MsgService;
import org.springframework.stereotype.Service;

/**
* @author my computer
* @description 针对表【msg】的数据库操作Service实现
* @createDate 2023-10-02 12:04:04
*/
@Service
public class MsgServiceImpl extends ServiceImpl<MsgDao, Msg>
    implements MsgService{

}




