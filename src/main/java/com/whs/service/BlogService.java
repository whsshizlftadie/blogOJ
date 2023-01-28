package com.whs.service;

import com.whs.bean.Blog;
import com.whs.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface BlogService {

    Blog getBlog(Long id);

    Blog getAndConvert(Long id);

    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

    Page<Blog> listBlog(Pageable pageable, String like);

    Page<Blog> listBlog(Pageable pageable);

    List<Blog> listBlogTop(Integer size);

    Page<Blog> listBlog(Long TagId,Pageable pageable);

    Map<String,List<Blog>> ArchiveBlog();

    Blog saveBlog(Blog blog);

    Blog updateBlog(Long id, Blog blog);

    void deleteBlog(Long id);


    public Long blogCount();



}
