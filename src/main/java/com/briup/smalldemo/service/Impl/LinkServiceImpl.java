package com.briup.smalldemo.service.Impl;

import com.briup.smalldemo.bean.Link;
import com.briup.smalldemo.bean.LinkExample;
import com.briup.smalldemo.mapper.LinkMapper;
import com.briup.smalldemo.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LinkServiceImpl implements ILinkService {

    @Autowired
    LinkMapper linkMapper;

    @Override
    public List<Link> findAll() throws RuntimeException {
       LinkExample linkExample=new LinkExample();
       List<Link>links=linkMapper.selectByExample(linkExample);
       return links;

    }

    @Override
    public void deleteById(int id) throws RuntimeException {
        linkMapper.deleteByPrimaryKey(id);
    }

    @Override
    //引用类型在调用前都要判空处理
    public void saveOrUpdate(Link link) throws RuntimeException {
        if (link==null){
            throw new RuntimeException("参数为空");
        }
        if (link.getId()==null){
            linkMapper.insert(link);

        }else {
            linkMapper.updateByPrimaryKey(link);

        }
    }

    @Override
    public Link selectById(int id) throws RuntimeException {
        Link link=linkMapper.selectByPrimaryKey(id);
        return link;
    }

    @Override
    public void insert(Link link) throws RuntimeException {
        linkMapper.updateByPrimaryKey(link);
    }
}
