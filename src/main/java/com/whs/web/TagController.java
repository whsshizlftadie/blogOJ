package com.whs.web;

import com.whs.bean.Tag;
import com.whs.service.BlogService;
import com.whs.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller("TagShowController")
@RequestMapping("tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @Autowired
    private BlogService blogService;

    @RequestMapping("/{id}")
    public String tags(@PathVariable Long id, Model model,
                       @PageableDefault(size = 8,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable){
        List<Tag> all = tagService.findAll();
        if(id==-1){
            id=all.get(0).getId();
        }

        model.addAttribute("tags",all);
        model.addAttribute("page",blogService.listBlog(id,pageable));
        model.addAttribute("activeTagId",id);

        return "tags";
    }

}
