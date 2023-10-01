package com.p.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.p.entity.Traveler;
import org.apache.ibatis.annotations.Mapper;

/**
* @author my computer
* @description 针对表【traveler】的数据库操作Mapper
* @createDate 2023-09-28 08:54:23
* @Entity com.p.entity.traveler
 * 
*/
@Mapper
public interface TravelerDao extends BaseMapper<Traveler> {


}
