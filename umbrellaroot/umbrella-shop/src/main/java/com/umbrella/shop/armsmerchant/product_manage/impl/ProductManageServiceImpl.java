package com.umbrella.shop.armsmerchant.product_manage.impl;

import com.umbrella.core.common.common_util.RedisKeyGen;
import com.umbrella.core.common.redis_manage.redisbase.RedisService;
import com.umbrella.shop.armsmerchant.product_manage.dao.IProductManageDao;
import com.umbrella.shop.armsmerchant.product_manage.model.DefaultProductDetailVO;
import com.umbrella.shop.armsmerchant.product_manage.model.DefaultProductVO;
import com.umbrella.shop.armsmerchant.product_manage.service.IProductManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("ProductManageService")
@Transactional
public class ProductManageServiceImpl implements IProductManageService {

    @Autowired
    IProductManageDao iProductManageDao;

    @Autowired
    RedisService redisService;

    @Override
    public void initProductsToRedis() {
        List<DefaultProductDetailVO> defaultProductDetailVOlist = iProductManageDao.queryDefaultProductDetails();
        for (DefaultProductDetailVO defaultProductDetailVO : defaultProductDetailVOlist){
            redisService.set(RedisKeyGen.KeyGen(DefaultProductDetailVO.class,defaultProductDetailVO.getProductId()+""), defaultProductDetailVO.toString());
        }
        for(int i=0;i<10;i++){
            System.out.println((String)redisService.get("PROD_D_"+i));
        }
    }

    @Override
    public List<DefaultProductVO> getDefaultProductVOList() {
        List<DefaultProductDetailVO> defaultProductDetailVOlist = iProductManageDao.queryDefaultProductDetails();
        List<DefaultProductVO> list = new ArrayList<DefaultProductVO>();
        for(int i=0;i<defaultProductDetailVOlist.size();i++){
            DefaultProductVO p = defaultProductDetailVOlist.get(i);
            p.setOriginalPrice(p.getOriginalPrice());
            p.setProductId(p.getProductId());
            p.setProductImg("/img/product0"+p.getProductId()+".png");
            p.setProductTitle(p.getProductTitle());
            p.setStockCount(p.getStockCount());
            list.add(p);
        }
        return list;
    }

    @Override
    public DefaultProductDetailVO getDefaultProductDetailVO() {
        return null;
    }

    @Override
    public boolean decreaseStockCount() {
        return false;
    }

    @Override
    public boolean decreaseStockCount(int num) {
        return false;
    }
}
