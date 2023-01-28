package com.whs.dao;

import com.whs.bean.Tag;
import com.whs.bean.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TagDao extends JpaRepository<Tag,Long> {
    Tag findByName(String name);

    @Query("SELECT t FROM t_tag t")
    List<Tag> listTagTop(Pageable pageable);
}
