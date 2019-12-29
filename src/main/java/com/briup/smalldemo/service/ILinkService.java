package com.briup.smalldemo.service;

import com.briup.smalldemo.bean.Link;

import java.util.List;

public interface ILinkService {
    List<Link> findAll() throws  RuntimeException;
    void  deleteById(int id)throws  RuntimeException;
    void saveOrUpdate(Link link)throws RuntimeException;
    Link selectById(int id)throws RuntimeException;
    void insert(Link link)throws RuntimeException;
}
