package com.whs.service.impl;

import com.whs.Exception.NotFoundException;
import com.whs.bean.Tag;
import com.whs.dao.TagDao;
import com.whs.service.TagService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;

    @Override
    public Tag saveTag(Tag tag) {

        return tagDao.save(tag);
    }

    @Override
    public Tag getTag(Long id) {
        return tagDao.getById(id);
    }

    @Override
    public Page<Tag> listTag(Pageable pageable) {
        return tagDao.findAll(pageable);
    }

    @Override
    public Tag updateTag(Long id, Tag tag) {
        Tag byId = tagDao.getById(id);
        if(byId ==null){
            throw new NotFoundException("不存在该tag");
        }
        BeanUtils.copyProperties(tag,byId);
        return tagDao.save(byId);
    }

    @Override
    public void deleteTag(Long id) {
         tagDao.deleteById(id);
    }

    @Override
    public Tag getTagByName(String name) {
        return tagDao.findByName(name);
    }

    @Override
    public List<Tag> findAll() {
        return tagDao.findAll();
    }

    @Override
    public List<Tag> listTag(String ids) {

        return tagDao.findAllById(convertToList(ids));
    }

    @Override
    public List<Tag> listTagTop(Integer size) {
        Sort sort= Sort.by(Sort.Direction.DESC,"blogs.size");
        Pageable pageable= PageRequest.of(0,size,sort);
        return tagDao.listTagTop(pageable);
    }

    private List<Long> convertToList(String ids) {
        List<Long> list = new ArrayList<>();
        if (!"".equals(ids) && ids != null) {
            String[] idarray = ids.split(",");
            for (int i=0; i < idarray.length;i++) {
                list.add(new Long(idarray[i]));
            }
        }
        return list;
    }
}
