package com.p.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data

public class User {
    @TableId
    String id ;
    String password ;
}
