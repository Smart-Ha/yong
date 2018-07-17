package com.wangy.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class BaseObject implements Serializable {
    private Long id;
    private String label;
    private Date createTime;
    private Date modifyTime;


}
