package com.umbrella.shop.armsmerchant.sale_manage.impl;

import com.umbrella.core.user_manage.model.UserVO;
import com.umbrella.shop.armsmerchant.order_manage.service.IOrderService;
import com.umbrella.shop.armsmerchant.product_manage.model.DefaultProductVO;
import com.umbrella.shop.armsmerchant.product_manage.service.IProductManageService;
import com.umbrella.shop.armsmerchant.sale_manage.service.IDefaultSaleService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: com.umbrella.armsmerchant.sale_manage.impl
 * @description:
 * @author: liujinghui
 * @create: 2018-11-19 23:33
 **/
public class DefaultSaleServiceImpl implements IDefaultSaleService {

    @Autowired
    IOrderService iOrderService;
    @Autowired
    IProductManageService iProductManageService;

    @Override
    public boolean doSale(UserVO user, DefaultProductVO productVO) {
        iOrderService.addOrder(user,productVO);
        iProductManageService.decreaseStockCount();
        
        return false;
    }
}
