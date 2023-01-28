package com.whs.web;

import com.whs.bean.Blog;
import com.whs.bean.Type;
import com.whs.service.BlogService;
import com.whs.service.TypeService;
import com.whs.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller("TypeShowController")
@RequestMapping("type")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private BlogService blogService;

    @RequestMapping("/{id}")
    public String Types(@PathVariable Long id, Model model,
                        @PageableDefault(size = 8,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable){

        List<Type> types = typeService.findAll();
        if(id==-1){
            id=types.get(0).getId();
        }
        model.addAttribute("types",types);
        BlogQuery blogQuery=new BlogQuery();
        blogQuery.setTypeId(id);
        Page<Blog> blogs = blogService.listBlog(pageable,blogQuery);
        model.addAttribute("blogs",blogs);
        model.addAttribute("activeTypeId",id);
        return "types";
    }
}
