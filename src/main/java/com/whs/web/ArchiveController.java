package com.whs.web;

import com.whs.bean.Blog;
import com.whs.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller("ArchiveShowController")
@RequestMapping("archive")
public class ArchiveController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/")
    public String getArchive(Model model){
        Map<String, List<Blog>> stringListMap = blogService.ArchiveBlog();
        model.addAttribute("archiveMap", stringListMap);
        model.addAttribute("blogCount",blogService.blogCount());
        return "archives";
    }
}
