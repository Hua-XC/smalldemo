package com.briup.smalldemo.service.Impl;

import com.briup.smalldemo.bean.ex.ArticleEX;
import com.briup.smalldemo.mapper.ex.ArticleEXMapper;
import com.briup.smalldemo.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements IArticleService {
    @Autowired
    private ArticleEXMapper articleEXMapper;
    @Override
    public List<ArticleEX> findAllArticle() {
        return articleEXMapper.findAll();
    }

    @Override
    public List<ArticleEX> search(String key, String word) throws RuntimeException {
        word=word==null?"":word;    //模糊查询

        //select * from cms_article where titile like %% 就是查询所有
        if ((key==null||"".equals(key))&&(word==null||"".equals(word))){
            return  articleEXMapper.findAll();

        }
        else if ((key==null||"".equals(key)&&!"".equals(word))){//前面下拉框为空，后面输入框不为空
            //根据作者或标题查询
            word="%"+word+"%";
            return articleEXMapper.selectTitleOrWord(word);


        }else if ("title".equals(key)){
            word="%"+word+"%";
            return articleEXMapper.selectTitle(word);

        }else if ("author".equals(key)){
            word="%"+word+"%";
            return  articleEXMapper.SelectAuthor(word);

        }
        return null;
    }
}
