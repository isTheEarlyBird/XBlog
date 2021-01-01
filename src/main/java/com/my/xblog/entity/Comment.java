package com.my.xblog.entity;

import com.baomidou.mybatisplus.annotation.IdType;

import java.util.ArrayList;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.my.xblog.util.DateFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@ApiModel(value="XComment对象", description="")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "评论id")
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "评论内容")
    private String content;

    @ApiModelProperty(value = "点赞")
    private Integer likes;

    @ApiModelProperty(value = "启用状态[0:禁用,1:启用]")
    private Integer status;

    @ApiModelProperty(value = "评论人id")
    private Long userId;

    @ApiModelProperty(value = "文章id")
    private Long articleId;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "回复列表")
    @TableField(exist = false)
    private ArrayList<Reply> children = new ArrayList<>();

    @ApiModelProperty(value = "评论用户")
    @TableField(exist = false)
    private SysUser sysUser;

    @ApiModelProperty(value = "前台显示创建时间")
    @TableField(exist = false)
    private String createTimeVO;

    @ApiModelProperty(value = "前台显示更新时间")
    @TableField(exist = false)
    private String updateTimeVO;

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        this.createTimeVO = DateFormat.format(createTime);
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        this.updateTimeVO = DateFormat.format(updateTime);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", likes=" + likes +
                ", status=" + status +
                ", userId=" + userId +
                ", articleId=" + articleId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", children=" + children +
                ", sysUser=" + sysUser +
                ", createTimeVO='" + createTimeVO + '\'' +
                ", updateTimeVO='" + updateTimeVO + '\'' +
                '}';
    }
}
