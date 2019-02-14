package com.umbrella.core.user_manage.impl;

import com.umbrella.core.common.common_util.ProtostuffUtil;
import com.umbrella.core.metadata_manage.InstanceVO;
import com.umbrella.core.metadata_manage.InstanceVO2;
import com.umbrella.core.user_manage.dao.ITestDao;
import com.umbrella.core.user_manage.model.TestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @program: com.umbrella.core.user_manage.impl
 * @description:
 * @author: liujinghui
 * @create: 2019-01-15 20:31
 **/
@Service
public class TestService {

    @Autowired
    ITestDao iTestDao;

    @PostConstruct
    public void getTestVOList(){
        List<TestVO> list = iTestDao.queryTestVO();
        System.out.println();
    }

    public static void main(String[] args) {
        InstanceVO vo1 = new InstanceVO();
        vo1.setId("11111");
        byte[] b1 = ProtostuffUtil.serializer(vo1);
        b1 = b1.toString().getBytes();
        InstanceVO2 vo2 = ProtostuffUtil.deserializer(b1,InstanceVO2.class);
        System.out.println(vo2);
    }
}
