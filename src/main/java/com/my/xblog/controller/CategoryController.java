package com.my.xblog.controller;


import com.my.xblog.common.MyResult;
import com.my.xblog.entity.Category;
import com.my.xblog.service.ArticleService;
import com.my.xblog.service.CategoryService;
import com.my.xblog.vo.CommonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author my
 * @since 2020-12-19
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ArticleService articleService;

    /*
     * 推荐分类列表
     * @Author Administrator
     * @Date 19:50 2020/12/28
     * @return 
     **/
    @GetMapping("/recommendCategory")
    public MyResult allCategory() {
        List<Category> recommendCategory = categoryService.listCategorys(1, 7);
        return MyResult.success().data("recommendCategory", recommendCategory);
    }

    /*
     * 分类页
     * @Author Administrator
     * @Date 19:55 2020/12/28
     * @Param cid      分类id
     * @Param current  当前页
     * @Param size     每页多少条数据
     * @return
     **/
    @GetMapping("/categorys/{cid}/{current}/{size}")
    public MyResult categorys(@PathVariable String cid, @PathVariable Integer current, @PathVariable Integer size) {
        List<Category> allCategory = categoryService.listCategorys();

        CommonVO commonVO = new CommonVO();
        commonVO.setRecommendArticles(articleService.listRecommendArticles());
        commonVO.setCategorys(categoryService.listCategorys(1, 7));
        commonVO.setPageInfo(articleService.listArticleByCategoryIdPage(Long.valueOf(cid), current, size));

        return MyResult.success().data("allCategory", allCategory).data("commonVO", commonVO);
    }

}

