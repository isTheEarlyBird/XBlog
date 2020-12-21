package com.my.xblog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.my.xblog.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author xuan
 * @Description 服务类
 * @date 2020/12/19 16:54
 * @Version 1.0
 **/
public interface ArticleService extends IService<Article> {

    /**
     * 根据时间分页查询文章
     * @param current
     * @param size
     * @return
     */
    public Page<Article> listArticleByPageByTime(Integer current, Integer size);

    /*
     * 获取推荐文章
     * @Author xuan
     * @Date 21:34 2020/12/19
     * @return
     **/
    public List<Article> listRecommendArticles();
}
