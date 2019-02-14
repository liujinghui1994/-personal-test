package com.umbrella.shop.armsmerchant.order_manage.service;

import com.umbrella.core.user_manage.model.UserVO;
import com.umbrella.shop.armsmerchant.product_manage.model.DefaultProductVO;

public interface IOrderService {
    public boolean addOrder(UserVO user, DefaultProductVO productVO);
}
