package com.p.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @TableName hotel
 */
@Data
public class Hotel implements Serializable {
    @TableId
    private Integer hotelId;
    private String hotelName;

    private String hotelStar;

    private Integer hotelRooms;

    private Integer hotelPrice;

    private Integer hotelRestNum;

    private String hotelState;

    private String spotName;

    private static final long serialVersionUID = 1L;
}