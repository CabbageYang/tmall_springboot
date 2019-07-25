package com.how2java.tmall.service;

import com.how2java.tmall.dao.CategoryDAO;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import com.how2java.tmall.pojo.Category;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 首先创建一个 Sort 对象，表示通过 id 倒排序， 然后通过 categoryDAO进行查询。
 * 这里抛弃了 CategoryService 接口 加上 CategoryService 实现类的这种累赘的写法，而是直接使用 CategoryService 作为实现类来做。
 */
@Service
public class CategoryService{

    @Autowired CategoryDAO categoryDAO;

    public List<Category> list(){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return categoryDAO.findAll(sort);
    }

}
