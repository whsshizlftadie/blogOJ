package com.whs.service;

import com.whs.bean.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface OJService {

    Page<Problem> PROBLEM_LIST(Pageable pageable);

    Problem getProblemById(Long id);


}
