package com.briup.smalldemo.web.controller;


import com.briup.smalldemo.bean.Category;
import com.briup.smalldemo.service.ICategoryService;
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
@RequestMapping("/Category")
@Api(description = "栏目管理")
public class CategoryController {
    @Autowired
    private  ICategoryService categoryService;

    @GetMapping("/selectAll")
    @ApiOperation("查询全部")
    public Message selectAll(){
        List<Category> list=categoryService.findAll();
        return MessageUtil.success(list);
    }

    @GetMapping("/selectById")
    @ApiOperation("查询ID")
    public Message selectById(int id){
        Category category=categoryService.findById(id);
        return  MessageUtil.success(category);
    }
}
