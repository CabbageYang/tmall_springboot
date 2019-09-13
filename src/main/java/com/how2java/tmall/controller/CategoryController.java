package com.how2java.tmall.controller;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *  这个就是专门用来提供 RESTFUL 服务器控制器
 *  对于categories 访问，会获取所有的 Category对象集合，并返回这个集合。 因为是声明为 @RestController，
 *  所以这个集合，又会被自动转换为 JSON数组抛给浏览器。
 *
 *  在controller上加注解@Controller 和@RestController都可以在前端调通接口，但是二者的区别在于，
 *  当用前者的时候在方法上必须添加注解@ResponseBody，如果不添加@ResponseBody，就会报上面错误，
 *  因为当使用@Controller 注解时，spring默认方法返回的是view对象（页面）。而加上@ResponseBody，则方法返回的就是具体对象了。
 *  @RestController的作用就相当于@Controller+@ResponseBody的结合体
 */

@RestController  //表示这是一个控制器，并且对每个方法的返回值都会直接转换为 json 数据格式
public class CategoryController {
    @Autowired  CategoryService categoryService;

    @GetMapping(value = "/categories")
    public Page4Navigator<Category> list(@RequestParam(value="start",defaultValue = "0") int start,
                                         @RequestParam(value = "size",defaultValue = "5") int size) throws Exception{
        start = start<0?0:start;
        Page4Navigator<Category> page = categoryService.list(start,size,5);
        return page;
    }
}
