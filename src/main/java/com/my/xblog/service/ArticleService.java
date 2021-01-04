package com.my.xblog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.my.xblog.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.my.xblog.entity.Category;

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
    public IPage<Article> listArticleByPageByTime(Integer currentPage, Integer size);

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
     * 根据分类id获取文章
     * @Author Administrator
     * @Date 22:28 2020/12/23
     * @Param cid  分类id
     * @Param current  当前页
     * @Param size  一页多少条
     * @return
     **/
    public IPage<Article> listArticleByCategoryIdPage(Long cid, Integer current, Integer size);

    /*
     * 根据id获取文章
     * @Author Administrator
     * @Date 19:59 2020/12/22
     * @Param id
     * @return
     **/
    public Article findArticleById(Long id);

    /*
     * 查看文章
     * @Author Administrator
     * @Date 19:59 2020/12/22
     * @Param id
     * @return
     **/
    public Article watch(Long id);

    /*
     * 添加文章
     * @Author Administrator
     * @Date 19:46 2020/12/28
     * @Param article
     * @return
     **/
    void insert(Article article);

    /*
     * 增加文章点赞数
     * @Author Administrator
     * @Date 21:28 2021/1/2
     * @Param aid
     * @return 
     **/
    void increaseLikes(Long aid);

    /*
     * 减少文章点赞数
     * @Author Administrator
     * @Date 20:27 2021/1/3
     * @Param aid
     * @return
     **/
    void decreaseLikes(Long aid);
}
