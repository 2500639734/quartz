package com.quartz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.quartz.pojo.BasePojo;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2019-07-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="QuartzInfo对象", description="")
public class QuartzInfo extends BasePojo {

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

}
