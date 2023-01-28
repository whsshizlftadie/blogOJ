package com.whs.web;

import com.whs.bean.Blog;
import com.whs.bean.Comment;
import com.whs.service.BlogService;
import com.whs.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CommentService commentService;

    @Value("${comment.avatar}")
    private String avatar;

    @GetMapping("/comments/{id}")
    public String comments(@PathVariable(value = "id") Long blogId, Model model) {


        model.addAttribute("comments",commentService.listCommentsByBlogId(blogId));

        return "blog :: commentList";
    }

    @PostMapping("/comments")
    public String post(Comment comment){
        Blog b =blogService.getBlog(comment.getBlog().getId());
        if(comment.getNickname().equals(b.getUser().getNickname())){
//            System.out.println(b.getUser().getAvatar());
            comment.setAvatar(b.getUser().getAvatar());
            comment.setAdminComment(true);
        }else{
            comment.setAdminComment(false);
            comment.setAvatar(avatar);
        }
        comment.setBlog(b);
        commentService.saveComment(comment);
        return "redirect:/comments/"+comment.getBlog().getId();
    }
}
