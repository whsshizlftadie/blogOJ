package com.whs.dao;

import com.whs.bean.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentDao extends JpaRepository<Comment,Long> {


    List<Comment> findByBlogIdAndParentCommentNull(long blogId, Sort sort);


}
