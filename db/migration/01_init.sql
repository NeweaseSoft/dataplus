-- @formatter:off

create database if not exists `dataplus` default character set utf8mb4 collate utf8mb4_general_ci;

use `dataplus`;

CREATE TABLE IF NOT EXISTS `datasource_type` (
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键Id, 唯一标识',
    `name` varchar(255) NOT NULL COMMENT '类型名称',
    `category` varchar(255) NOT NULL COMMENT '类型分类: RDBMS | BIG_DATA | MPP | SEMI-STRUCTURED | ANALYTIC | NOSQL | REAL_TIME | TIME_SEQUENCE | API | OTHER',
    `is_often_use` tinyint(1) DEFAULT '0' COMMENT '是否常用, 默认否',
    `logo_maximum` varchar(255) DEFAULT NULL COMMENT '最大图标, 128*72',
    `logo_medium` varchar(255) DEFAULT NULL COMMENT '中等图标, 64*64',
    `logo_minimum` varchar(255) DEFAULT NULL COMMENT '最小图标, 16*16',
    `priority` int(11) DEFAULT '1000' COMMENT '优先级, 用于排序',
    `remark` text COMMENT '备注, 描述信息',
    `create_by` int(11) DEFAULT NULL COMMENT '创建人',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_by` int(11) DEFAULT NULL COMMENT '最后修改人',
    `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
    `is_deleted` tinyint(1) DEFAULT '0' COMMENT '是否删除, 默认否',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='数据源类型表';

CREATE TABLE IF NOT EXISTS `datasource_driver` (
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键Id, 唯一标识',
    `datasource_type_id` int(11) NOT NULL COMMENT '数据源类型Id',
    `name` varchar(255) NOT NULL COMMENT '驱动名称',
    `driver_class` varchar(255) NOT NULL COMMENT '驱动类',
    `remark` text COMMENT '备注',
    `create_by` int(11) DEFAULT NULL COMMENT '创建人',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_by` int(11) DEFAULT NULL COMMENT '最后修改人',
    `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
    `is_deleted` tinyint(1) DEFAULT '0' COMMENT '是否删除, 默认否',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='数据源驱动表';

CREATE TABLE IF NOT EXISTS `datasource_driver_file` (
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键Id, 唯一标识',
    `datasource_type_id` int(11) NOT NULL COMMENT '数据源类型Id',
    `name` varchar(255) NOT NULL COMMENT '驱动名称',
    `driver_class` varchar(255) NOT NULL COMMENT '驱动类',
    `remark` text COMMENT '备注',
    `create_by` int(11) DEFAULT NULL COMMENT '创建人',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_by` int(11) DEFAULT NULL COMMENT '最后修改人',
    `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
    `is_deleted` tinyint(1) DEFAULT '0' COMMENT '是否删除, 默认否',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='数据源驱动文件表';

CREATE TABLE IF NOT EXISTS `datasource_driver_attribute` (
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键Id, 唯一标识',
    `datasource_type_id` int(11) NOT NULL COMMENT '数据源类型Id',
    `name` varchar(255) NOT NULL COMMENT '驱动名称',
    `driver_class` varchar(255) NOT NULL COMMENT '驱动类',
    `remark` text COMMENT '备注',
    `create_by` int(11) DEFAULT NULL COMMENT '创建人',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_by` int(11) DEFAULT NULL COMMENT '最后修改人',
    `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
    `is_deleted` tinyint(1) DEFAULT '0' COMMENT '是否删除, 默认否',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='数据源驱动连接属性表';

-- @formatter:on
