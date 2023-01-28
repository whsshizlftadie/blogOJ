package com.whs.service.impl;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.whs.Exception.NotFoundException;
import com.whs.bean.Blog;
import com.whs.bean.Type;
import com.whs.dao.BlogDao;
import com.whs.service.BlogService;
import com.whs.utils.MarkdownUtils;
import com.whs.vo.BlogQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.*;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogDao blogDao;

    @Override
    public Blog getBlog(Long id) {
        return blogDao.getById(id);
    }

    @Override
    public Blog getAndConvert(Long id) {
        Blog blog = blogDao.getById(id);
        blogDao.updateViews(id);

        if(blog==null){
            throw new NotFoundException("not found");
        }

        Blog b = new Blog();
        BeanUtils.copyProperties(blog,b);
        b.setContent(MarkdownUtils.markdownToHtmlExtensions(blog.getContent()));

        return b;
    }

    @Override
    public Page<Blog> listBlog(Pageable pageable, BlogQuery blog) {

        return blogDao.findAll(new Specification<Blog>() {
            @Override
            public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> pl=new ArrayList<Predicate>();
                if(blog.getTitle()!=null&&!"".equals(blog.getTitle())){
                    pl.add(criteriaBuilder.like(root.<String>get("title"),"%"+blog.getTitle()+"%"));
                }
                if(blog.getTypeId()!=null){
                    pl.add(criteriaBuilder.equal(root.<Type>get("type").get("id"),blog.getTypeId()));
                }
                if(blog.isRecommend()){
                    pl.add(criteriaBuilder.equal(root.<Boolean>get("recommend"),blog.isRecommend()));
                }
                query.where(pl.toArray(new Predicate[pl.size()]));
                return null;
            }
        },pageable);
    }

    @Override
    public Page<Blog> listBlog(Pageable pageable, String like) {
        return blogDao.findAll(new Specification<Blog>() {
            @Override
            public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> pl=new ArrayList<>();
                if(like!=null&&!"".equals(like)){
                    pl.add(criteriaBuilder.like(root.<String>get("title"),"%"+like+"%"));
                }
                query.where(pl.toArray(new Predicate[pl.size()]));
                return null;
            }
        }, pageable);
    }

    @Override
    public Page<Blog> listBlog(Pageable pageable) {
        return blogDao.findAll(pageable);
    }

    @Override
    public Blog saveBlog(Blog blog) {
        if (blog.getId() == null) {
            blog.setCreateTime(new Date());
            blog.setUpdateTime(new Date());
            blog.setViews(0);
        } else {
            blog.setUpdateTime(new Date());
        }
        return blogDao.save(blog);
    }

    @Override
    public Blog updateBlog(Long id, Blog blog) {
        Blog byId = blogDao.getById(id);
        if(byId==null){
            throw new NotFoundException("Blog not found");
        }
        BeanUtils.copyProperties(blog, byId);
        return blogDao.save(byId);
    }

    @Override
    public void deleteBlog(Long id) {
         blogDao.deleteById(id);
    }

    @Override
    public Long blogCount() {
        long count = blogDao.count();
        return count;
    }

    @Override
    public List<Blog> listBlogTop(Integer size) {
        Sort sort=Sort.by(Sort.Direction.DESC,"updateTime");
        Pageable pageable= PageRequest.of(0,size,sort);
        return blogDao.listBlogTop(pageable);
    }

    @Override
    public Page<Blog> listBlog(Long TagId, Pageable pageable) {
        return blogDao.findAll(new Specification<Blog>() {
            @Override
            public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//                jpa关联查询
                Join join=root.join("tags");
                return criteriaBuilder.equal(join.get("id"),TagId);
            }
        },pageable);
    }

    @Override
    public Map<String, List<Blog>> ArchiveBlog() {

        List<String> groupYear = blogDao.findGroupYear();

        Map<String, List<Blog>> map=new LinkedHashMap<String, List<Blog>>();
        for (String s : groupYear) {
            List<Blog> blogByYear = blogDao.findBlogByYear(s);
            map.put(s,blogByYear);
        }

        return map;
    }


}
