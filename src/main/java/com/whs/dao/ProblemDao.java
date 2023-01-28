package com.whs.dao;

import com.whs.bean.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemDao extends JpaRepository<Problem,Long> {
}
