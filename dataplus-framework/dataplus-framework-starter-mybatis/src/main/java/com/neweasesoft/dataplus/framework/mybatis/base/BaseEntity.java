package com.neweasesoft.dataplus.framework.mybatis.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

/**
 * 实体表基类
 *
 * @author fushuwei
 */
@Data
public class BaseEntity<T extends Model<?>> extends Model<T> {

    /**
     * 主键Id
     * <p>
     * 生成策略:
     * <p>AUTO: 自增长</p>
     * <p>NONE: 未定义</p>
     * <p>INPUT: 用户输入</p>
     * <p>ASSIGN_ID: 雪花算法 (Mybatis-Plus默认生成策略)</p>
     * <p>ASSIGN_UUID: 剔除中划线的UUID</p>
     */
    @TableId
    private String id;

    /**
     * 备注, 描述信息
     */
    @TableField
    private String remark;

    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 最后更新人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    /**
     * 最后更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 是否已被删除, 默认否
     */
    @TableLogic(value = "0", delval = "1")
    private Boolean isDeleted = false;

    /**
     * 更新时是否强制更新公共字段, 默认是
     */
    @TableField(exist = false)
    private Boolean isForceUpdateFill = true;
}
