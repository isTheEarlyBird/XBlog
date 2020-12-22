package com.my.xblog.entity;

import com.baomidou.mybatisplus.annotation.IdType;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

import com.my.xblog.util.DateFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author my
 * @since 2020-12-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="XArticle对象", description="")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "摘要")
    private String summary;

    @ApiModelProperty(value = "封面")
    private String cover;

    @ApiModelProperty(value = "文章内容")
    private String content;

    @ApiModelProperty(value = "类型[1:原创,2:转载]")
    private Integer type;

    @ApiModelProperty(value = "浏览量")
    private Integer views;

    @ApiModelProperty(value = "点赞数")
    private Integer likes;

    @ApiModelProperty(value = "评论数")
    private Integer comments;

    @ApiModelProperty(value = "是否开启评论[0:不开启,1:开启]")
    private Boolean commentable;

    @ApiModelProperty(value = "是否推荐[0:不推荐,1:推荐]")
    private Boolean recommended;

    @ApiModelProperty(value = "是否发布[0:草搞,1:发布,2:禁用/回收站]")
    private Boolean published;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "前台显示创建时间")
    @TableField(exist = false)
    private String createTimeVO;

    @ApiModelProperty(value = "前台显示更新时间")
    @TableField(exist = false)
    private String updateTimeVO;

    @ApiModelProperty(value = "分类")
    @TableField(exist = false)
    private List<Category> categorys;

    @ApiModelProperty(value = "用户")
    @TableField(exist = false)
    private SysUser sysUser;

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        this.createTimeVO = DateFormat.format(createTime);
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        this.updateTimeVO = DateFormat.format(updateTime);
    }

}
