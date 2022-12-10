-- @formatter:off
create database if not exists `dataplus` default character set utf8mb4 collate utf8mb4_general_ci;

use `dataplus`;

CREATE TABLE IF NOT EXISTS `t_datasource_type` (
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键Id, 唯一标识',
    `name` varchar(255) NOT NULL COMMENT '数据源类型名称',
    `category` varchar(255) NOT NULL COMMENT '数据源类别: RDBMS | BIG_DATA | MPP | SEMI-STRUCTURED | ANALYTIC | NOSQL | REAL_TIME | TIME_SEQUENCE | API | OTHER',
    `is_often_use` tinyint(1) DEFAULT '0' COMMENT '是否常用, 默认否',
    `logo_maximum` varchar(255) DEFAULT NULL COMMENT '最大图标, 128*72',
    `logo_medium` varchar(255) DEFAULT NULL COMMENT '中等图标, 64*64',
    `logo_minimum` varchar(255) DEFAULT NULL COMMENT '最小图标, 16*16',
    `remark` text COMMENT '备注',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='数据源类型表';

-- @formatter:on
