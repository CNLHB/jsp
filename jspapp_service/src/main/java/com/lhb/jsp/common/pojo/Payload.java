package com.lhb.jsp.common.pojo;


import lombok.Data;

import java.util.Date;

/**
 * @author
 * @date 2020/1/12 - 9:15
 */
@Data
public class Payload<T> {
    private String id;
    private T userInfo;
    private Date expiration;
}