package com.umbrella.shop.armsmerchant.product_manage.service;


import com.umbrella.shop.armsmerchant.product_manage.model.DefaultProductDetailVO;
import com.umbrella.shop.armsmerchant.product_manage.model.DefaultProductVO;

import java.util.List;

public interface IProductManageService {

    public void initProductsToRedis();

    public List<DefaultProductVO> getDefaultProductVOList();

    DefaultProductDetailVO getDefaultProductDetailVO();

    public boolean decreaseStockCount();

    public boolean decreaseStockCount(int num);
}
