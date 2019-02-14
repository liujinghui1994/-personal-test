package com.umbrella.shop.armsmerchant.product_manage.dao;

import com.umbrella.shop.armsmerchant.product_manage.model.DefaultProductDetailVO;
import com.umbrella.shop.armsmerchant.product_manage.model.DefaultProductVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductManageDao {

    List<DefaultProductVO> queryDefaultProducts();

    List<DefaultProductDetailVO> queryDefaultProductDetails();
}
