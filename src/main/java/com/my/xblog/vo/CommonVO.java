package com.my.xblog.vo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.my.xblog.entity.Article;
import com.my.xblog.entity.Category;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author xuan
 * @ClassName HomeVO
 * @Description 前台主页数据
 * @date 2020/12/19 16:05
 * @Version 1.0
 **/
@ApiModel("前台主页数据")
@Data
public class CommonVO {

    @ApiModelProperty("分类列表")
    private List<Category> categorys;

    @ApiModelProperty("推荐文章列表")
    private List<Article> recommendArticles;

    @ApiModelProperty("文章分页")
    private Page<Article> pageInfo;
}
