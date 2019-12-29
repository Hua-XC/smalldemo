package com.briup.smalldemo.service;

import com.briup.smalldemo.bean.ex.ArticleEX;

import java.util.List;

public interface IArticleService {
    List<ArticleEX> findAllArticle()throws RuntimeException;
    List<ArticleEX> search(String key,String word) throws RuntimeException;
}
