package com.whs.dao;

import com.whs.bean.Blog;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BlogDao extends JpaRepository<Blog,Long> , JpaSpecificationExecutor<Blog> {

    @Query("select b from t_blog  b where b.recommend=true ")
    List<Blog> listBlogTop(Pageable pageable);


    @Modifying
    @Query("update t_blog b set b.views=b.views+1 where b.id=?1")
    int updateViews(@Param(value = "b.id") Long id);

    @Query("select function('date_format', b.updateTime, '%Y') as year from t_blog b group by function('date_format', b.updateTime, '%Y') order by function('date_format', b.updateTime, '%Y') desc ")
    List<String> findGroupYear();

    @Query("select b from t_blog b where function('date_format', b.updateTime, '%Y') = ?1")
    List<Blog> findBlogByYear(String year);



}
