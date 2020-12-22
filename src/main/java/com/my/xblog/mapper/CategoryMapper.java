package com.my.xblog.mapper;

import com.my.xblog.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author my
 * @since 2020-12-19
 */
public interface CategoryMapper extends BaseMapper<Category> {

    /*
     * 根据文章id获取分类
     * @Author xuan
     * @Date 21:35 2020/12/22
     * @Param articleId
     * @return
     **/
    public List<Category> findCategoryByArticleId(Long articleId);

    /*
     * 获取所有分类
     * @Author Administrator
     * @Date 21:36 2020/12/22
     * @Param null
     * @return
     **/
    public List<Category> categorys();
}
