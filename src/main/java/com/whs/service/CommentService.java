package com.whs.service;

import com.whs.bean.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> listCommentsByBlogId(Long blogId);

    Comment saveComment(Comment comment);
}
