package com.neweasesoft.dataplus.datasource.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 数据源驱动
 */
@Data
public class Driver implements Serializable {

    private int id;
    private String name;
}
