package com.briup.smalldemo.web.controller;

import com.briup.smalldemo.bean.Link;
import com.briup.smalldemo.service.ILinkService;
import com.briup.smalldemo.util.Message;
import com.briup.smalldemo.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/link")
@Api(description = "链接管理")//Api用来注解的
public class LinkController {
    @Autowired
    private ILinkService linkService;

    @GetMapping("/selectAll")
    @ApiOperation("查询所有链接")
    public Message selectAll() {
        List<Link> links = linkService.findAll();
        return MessageUtil.success(links);

    }

    @GetMapping("deletaById")
    @ApiOperation("根据参与删除链接")
    @ApiImplicitParam(name = "id", value = "链接id", paramType = "query", dataType = "int", required = true)
    //根据name找下面方法里的参数匹配，int idX，上面的name就是idx
    //paramType = "query"必要的
    public Message deleteById(int id) {
        linkService.deleteById(id);
        return MessageUtil.success();
    }

    @PostMapping("/addLink")
    @ApiOperation("添加链接")
    public Message addLink(Link link) {
        linkService.saveOrUpdate(link);
        return MessageUtil.success();

    }

    @RequestMapping("/findById")
    @ApiOperation("根据id查link")
    @ApiImplicitParam(name = "id", value = "链接id", paramType = "query", dataType = "int", required = true)
    public Message findById(int id) {
        Link link = linkService.selectById(id);
        return MessageUtil.success(link);

    }

    @PostMapping("/update")
    @ApiOperation("更新数据")
    public Message update(Link link) {
        linkService.saveOrUpdate(link);
        return MessageUtil.success();
    }
    @PostMapping("/insert")
    @ApiOperation("更新数据")
    public Message insert(Link link) {
        linkService.insert(link);
        return MessageUtil.success();
    }
}
