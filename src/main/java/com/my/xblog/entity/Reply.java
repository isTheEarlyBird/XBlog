package com.my.xblog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
@ApiModel(value="XReply对象", description="")
public class Reply extends Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "被回复评论id")
    private Long commentId;

    @ApiModelProperty(value = "回复人id")
    private Long replyId;

    @ApiModelProperty(value = "被回复用户")
    private SysUser replyUser;

    @Override
    public String toString() {
        return "Reply{" +
                "id=" + this.getId() +
                ", content='" + this.getContent() + '\'' +
                ", likes=" + this.getLikes() +
                ", status=" + this.getStatus() +
                ", userId=" + this.getUserId() +
                ", articleId=" + this.getArticleId() +
                ", createTime=" + this.getCreateTime() +
                ", updateTime=" + this.getUpdateTime() +
                ", children=" + this.getChildren() +
                ", sysUser=" + this.getSysUser() +
                ", createTimeVO='" + this.getCreateTimeVO() + '\'' +
                ", updateTimeVO='" + this.getUpdateTimeVO() + '\'' +
                "commentId=" + commentId +
                ", replyId=" + replyId +
                ", replyUser=" + replyUser +
                '}';
    }
}
