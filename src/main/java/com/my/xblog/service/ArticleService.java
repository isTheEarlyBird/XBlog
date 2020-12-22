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
     * @param currentPage  当前页
     * @param size  一页
     * @return
     */
    public Page<Article> listArticleByPageByTime(Integer currentPage, Integer size);

    /*
     * 获取推荐文章
     * @Author xuan
     * @Date 21:34 2020/12/19
     * @return
     **/
    public List<Article> listRecommendArticles();

    /*
     * 根据用户id获取文章列表
     * @Author Administrator
     * @Date 20:33 2020/12/22
     * @Param uid
     * @return
     **/
    public List<Article> listArticleByUserId(Long uid);

    /*
     * 根据id获取文章
     * @Author Administrator
     * @Date 19:59 2020/12/22
     * @Param id
     * @return
     **/
    public Article findArticleByID(Long id);

}
