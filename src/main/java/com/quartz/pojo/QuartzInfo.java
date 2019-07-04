package com.quartz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author shenke
 * @since 2019-07-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="QuartzInfo对象", description="")
public class QuartzInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "定时任务名称")
    private String name;

    @ApiModelProperty(value = "定时任务执行周期表达式")
    private String cycle;

    @ApiModelProperty(value = "定时任务执行类全路径")
    private String classPath;

    @ApiModelProperty(value = "定时任务开关:默认1启动,0关闭")
    private Boolean status;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "数据有效性:默认1有效,0无效")
    @TableLogic
    private Boolean valid;


}
