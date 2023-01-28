package com.whs.service.impl;

import com.whs.bean.Problem;
import com.whs.dao.ProblemDao;
import com.whs.service.OJService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;


import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class OJServiceImpl implements OJService {

    @Autowired
    private ProblemDao problemDao;

    @Override
    public Page<Problem> PROBLEM_LIST(Pageable pageable) {
        return problemDao.findAll( pageable);
    }

    @Override
    public Problem getProblemById(Long id) {
        return problemDao.getById(id);
    }
}
