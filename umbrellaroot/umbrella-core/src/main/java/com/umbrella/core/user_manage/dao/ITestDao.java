package com.umbrella.core.user_manage.dao;

import com.umbrella.core.user_manage.model.TestVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITestDao {
    public List<TestVO> queryTestVO();
}
