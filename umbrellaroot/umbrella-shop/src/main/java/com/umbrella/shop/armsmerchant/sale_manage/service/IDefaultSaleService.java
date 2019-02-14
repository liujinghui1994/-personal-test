package com.umbrella.shop.armsmerchant.sale_manage.service;

import com.umbrella.core.user_manage.model.UserVO;
import com.umbrella.shop.armsmerchant.product_manage.model.DefaultProductVO;

public interface IDefaultSaleService {
    public boolean doSale(UserVO user, DefaultProductVO productVO);
}
