package com.p.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * @TableName hotel
 */
@Data
public class Hotel implements Serializable {
    private Integer hotelId;

    private String hotelStar;

    private Integer hotelRooms;

    private Integer hotelPrice;

    private Integer hotelRestNum;

    private String hotelState;

    private Integer spotId;

    private static final long serialVersionUID = 1L;
}