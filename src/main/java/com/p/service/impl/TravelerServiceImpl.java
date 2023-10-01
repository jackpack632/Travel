package com.p.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.p.entity.Traveler;
import com.p.service.TravelerService;
import com.p.dao.TravelerDao;
import org.springframework.stereotype.Service;

/**
* @author my computer
* @description 针对表【traveler】的数据库操作Service实现
* @createDate 2023-09-28 08:54:23
*/
@Service
public class TravelerServiceImpl extends ServiceImpl<TravelerDao, Traveler>
implements TravelerService {

}
