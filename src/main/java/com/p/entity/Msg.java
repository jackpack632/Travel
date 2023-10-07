package com.p.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @TableName msg
 */
@Data
public class Msg implements Serializable {
    @TableId
    private Integer msgId;

    private String msgNotion;

    private String msgState;

    private static final long serialVersionUID = 1L;
}