package com.neweasesoft.dataplus.framework.mybatis.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;

/**
 * 实体表基类
 */
@Data
public class BaseEntity<T extends Model<?>> extends Model<T> {

    /**
     * 主键Id
     * <p>
     * 生成策略:
     * AUTO: 自增长
     * NONE: 未定义
     * INPUT: 用户输入
     * ASSIGN_ID: 雪花算法 (默认)
     * ASSIGN_UUID: 剔除中划线的UUID
     */
    @TableId
    private String id;

    @TableField
    private String remark;

    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT, jdbcType = JdbcType.VARCHAR)
    private String createBy;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 最后更新人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR)
    private String updateBy;

    /**
     * 最后更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 是否删除
     */
    @TableLogic(value = "0", delval = "1")
    private Boolean isDeleted;

    /**
     * 更新时是否强制更新公共字段, 默认是
     * <p>
     * true: 调用 Mybatis-Plus 的更新方法时, 用当前登录人Id和当前时间强制更新 entity 的 update_by 和 update_time 属性
     * <p>
     * false: 调用 Mybatis-Plus 的更新方法时, 如果 entity 的 update_by 和 update_time 属性有值, 则直接使用. 如果没有值, 则使用当前登录人Id和当前时间填充
     */
    @TableField(exist = false)
    private Boolean isForceUpdateFill = true;
}
