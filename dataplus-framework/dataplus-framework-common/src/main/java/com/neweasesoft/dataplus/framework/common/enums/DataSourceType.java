package com.neweasesoft.dataplus.framework.common.enums;

/**
 * 数据源类型
 *
 * @author fushuwei
 */
public enum DataSourceType {
    MySQL(10, "MySQL"),
    Oracle(20, "Oracle"),
    SqlServer(30, "SqlServer"),
    PG(40, "PostgreSQL");

    private int id;
    private String name;

    DataSourceType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
