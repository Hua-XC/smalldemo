package com.briup.smalldemo.service;

import com.briup.smalldemo.bean.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll()throws RuntimeException;
    Category findById(int id) throws RuntimeException;
    void  deleteById(int id)throws  RuntimeException;
    void saveOrUpdate(Category category)throws  RuntimeException;
}
