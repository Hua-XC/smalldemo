package com.briup.smalldemo.mapper.ex;

import com.briup.smalldemo.bean.ex.ArticleEX;

import java.util.List;

public interface ArticleEXMapper {
    List<ArticleEX> findAll();
    List<ArticleEX>selectTitleOrWord(String word);
    List<ArticleEX>selectTitle(String word);
    List<ArticleEX>SelectAuthor(String word);

}
