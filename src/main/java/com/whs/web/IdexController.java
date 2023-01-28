package com.whs.web;

import com.whs.Exception.NotFoundException;
import com.whs.bean.Blog;
import com.whs.service.BlogService;
import com.whs.service.TagService;
import com.whs.service.TypeService;
import com.whs.utils.MarkdownUtils;
import com.whs.vo.BlogQuery;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class IdexController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;





    @RequestMapping("/")
    public String index(@PageableDefault(size = 8,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable,
                        Model model){

        model.addAttribute("tags",tagService.listTagTop(10));
        model.addAttribute("types",typeService.listTypeTop(6));
        model.addAttribute("page",blogService.listBlog(pageable));
        model.addAttribute("recommendBlogs",blogService.listBlogTop(8));


        return "index";
    }

    @RequestMapping("/blog/search")
    public String search(BlogQuery query,
                         Model model,
                         @PageableDefault(size = 8,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable){
        String like=query.getTitle();
        model.addAttribute("tags",tagService.listTagTop(10));
        model.addAttribute("types",typeService.listTypeTop(6));
        model.addAttribute("page",blogService.listBlog(pageable,like));
        model.addAttribute("recommendBlogs",blogService.listBlogTop(8));

        return "index::main-view";
    }

    @RequestMapping("/blog/{id}")
    public String Blog(@PathVariable Long id,Model model){
        //Blog blog = blogService.getBlog(id);
//        blog.setViews(blog.getViews()+1);
//        blogService.updateBlog(blog.getId(),blog);

//        blog.setContent(MarkdownUtils.markdownToHtmlExtensions(blog.getContent()));
        model.addAttribute("blog",blogService.getAndConvert(id));


        return "blog";
    }



}
