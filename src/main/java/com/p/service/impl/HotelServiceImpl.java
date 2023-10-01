package com.p.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.p.dao.HotelDao;
import com.p.service.HotelService;
import org.springframework.stereotype.Service;
import com.p.entity.Hotel;
@Service
public class HotelServiceImpl extends ServiceImpl<HotelDao, Hotel>
implements HotelService {
}
