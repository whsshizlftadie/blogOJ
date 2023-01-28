package com.whs.service.impl;

import com.whs.Exception.NotFoundException;
import com.whs.bean.Type;
import com.whs.dao.TypeDao;
import com.whs.service.TypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;


    @Override
    public Type saveType(Type type) {
        return typeDao.save(type);
    }


    @Override
    public Type getType(Long id) {
        return typeDao.getById(id);
    }

    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeDao.findAll(pageable);
    }

    @Override
    public Type updateType(Long id, Type type) {
        Type byId = typeDao.getById(id);
        if(byId == null){
            throw new NotFoundException("不存在该类新");
        }
        BeanUtils.copyProperties(type, byId);
        return typeDao.save(byId);
    }

    @Override
    public void deleteType(Long id) {
        typeDao.deleteById(id);
    }

    @Override
    public Type getTypeByName(String name) {
        return typeDao.findByName(name);
    }

    @Override
    public List<Type> findAll() {
        return typeDao.findAll();
    }

    @Override
    public List<Type> listTypeTop(Integer size) {
        Sort sort=Sort.by(Sort.Direction.DESC,"blogs.size");
        Pageable pageable=PageRequest.of(0, size,sort);
        return typeDao.listTypeTop(pageable);
    }
}
