package com.p.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.p.dao.ComplaintDao;
import com.p.dao.TravelerDao;
import com.p.entity.Complaint;
import com.p.entity.Traveler;
import com.p.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintServiceImpl extends ServiceImpl<ComplaintDao, Complaint> implements ComplaintService {
}
