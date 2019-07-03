package com.quartz.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 基础字段类,定义通用字段
 */
public class BasePojo {

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "描述")
    private String desc;

    @TableLogic
    @ApiModelProperty(value = "数据有效性:默认1有效,0无效")
    private Boolean valid;

}
