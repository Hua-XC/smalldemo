package com.briup.smalldemo.web.controller;

import com.briup.smalldemo.bean.ex.ArticleEX;
import com.briup.smalldemo.service.IArticleService;
import com.briup.smalldemo.util.Message;
import com.briup.smalldemo.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(description = "文章查询")
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    @GetMapping("/selectAll")
    @ApiOperation("查询所有")
    public Message selectAll() {
        List<ArticleEX> list = articleService.findAllArticle();
        return MessageUtil.success(list);
    }
    @GetMapping("/search")
    @ApiOperation("搜索")
    public  Message search(String key,String word){
        List<ArticleEX> list = articleService.search(key, word);
        return MessageUtil.success(list);

    }

}