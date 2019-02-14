package com.umbrella.shop.armsmerchant.init_main;


import com.umbrella.shop.armsmerchant.product_manage.service.IProductManageService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @program: com.umbrella.armsmerchant.main
 * @description: 初始化商品
 * @author: liujinghui
 * @create: 2018-11-24 12:13
 **/
@Component
public class InitServlet implements InitializingBean {

    @Autowired
    @Qualifier("ProductManageService")
    IProductManageService iProductManageService;


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("***************");
        iProductManageService.initProductsToRedis();
    }

}

