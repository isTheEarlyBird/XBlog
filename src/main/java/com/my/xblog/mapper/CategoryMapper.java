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

    public List<Category> findCategoryByArticleId(Long articleId);
}
