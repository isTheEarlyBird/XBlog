package com.my.xblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.my.xblog.entity.Category;
import com.my.xblog.mapper.CategoryMapper;
import com.my.xblog.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.my.xblog.util.DateFormat;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author my
 * @since 2020-12-19
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Override
    public List<Category> listCategorys() {
        return baseMapper.selectList(null);
    }

    @Override
    public List<Category> listCategorys(Integer start, Integer end) {
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        wrapper.between("id", start, end);
        return baseMapper.selectList(wrapper);
    }

    @Override
    public Long insert(Category category) {
        //redis查询，是否有该分类
        category.setCreateTime(new Date());
        category.setUpdateTime(new Date());
        category.setDescription(category.getName());
        baseMapper.insert(category);
        //redis添加

        return category.getId();
    }
}
