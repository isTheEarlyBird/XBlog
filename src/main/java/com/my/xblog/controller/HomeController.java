package com.my.xblog.controller;

import com.my.xblog.comment.Constant;
import com.my.xblog.comment.MyResult;
import com.my.xblog.service.ArticleService;
import com.my.xblog.service.CategoryService;
import com.my.xblog.vo.HomeVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * @author xuan
 * @ClassName HomeController
 * @Description 主页
 * @date 2020/12/19 15:56
 * @Version 1.0
 **/
@Api(tags = "主页")
@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CategoryService categoryService;


    /*
     * 首页数据
     * @Author Administrator
     * @Date 21:12 2020/12/21
     * @Param current
     * @Param size
     * @return com.my.xblog.comment.MyResult
     **/
    @GetMapping("/{current}/{size}")
    public MyResult home(@PathVariable("current") Integer current, @PathVariable("size") Integer size) {
        HomeVO homeVO = new HomeVO();
        homeVO.setPageInfo(articleService.listArticleByPageByTime(current, size));
        homeVO.setRecommendArticles(articleService.listRecommendArticles());
        homeVO.setCategorys(categoryService.listCategorys());
        return MyResult.success().data("homeVO", homeVO);
    }
}
