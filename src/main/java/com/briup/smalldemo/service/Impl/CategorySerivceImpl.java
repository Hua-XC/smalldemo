package com.briup.smalldemo.service.Impl;

import com.briup.smalldemo.bean.Article;
import com.briup.smalldemo.bean.ArticleExample;
import com.briup.smalldemo.bean.Category;
import com.briup.smalldemo.bean.CategoryExample;
import com.briup.smalldemo.mapper.ArticleMapper;
import com.briup.smalldemo.mapper.CategoryMapper;
import com.briup.smalldemo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorySerivceImpl implements ICategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<Category> findAll() throws RuntimeException {
        CategoryExample example =new CategoryExample();
        return categoryMapper.selectByExample(example);
//        Category category=new Category();
//        return  categoryMapper.selectByExample(category);
    }

    @Override
    public Category findById(int id) throws RuntimeException {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteById(int id) throws RuntimeException {
        categoryMapper.deleteByPrimaryKey(id);
        ArticleExample example=new ArticleExample();
        example.createCriteria().andCategoryIdEqualTo(id);
        articleMapper.deleteByExample(example);

    }

    @Override
    public void saveOrUpdate(Category category) throws RuntimeException {
        if (category==null){
            throw new RuntimeException("参数为空");
        }if (category.getId()==null){

        }

    }
}
