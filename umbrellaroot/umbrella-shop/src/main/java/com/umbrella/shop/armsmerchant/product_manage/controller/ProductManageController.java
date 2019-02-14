package com.umbrella.shop.armsmerchant.product_manage.controller;


import com.umbrella.core.common.session_manage.CookieHelper;
import com.umbrella.core.user_manage.model.UserVO;
import com.umbrella.shop.armsmerchant.product_manage.model.DefaultProductDetailVO;
import com.umbrella.shop.armsmerchant.product_manage.model.DefaultProductVO;
import com.umbrella.shop.armsmerchant.product_manage.service.IProductManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/productManage")
public class ProductManageController {

    @Autowired
    @Qualifier("ProductManageService")
    IProductManageService iProductManageService;

    @Autowired
    CookieHelper cookieHelper;


    @RequestMapping("/listDefaultProducts")
    public String listDefaultProducts(HttpServletRequest request,HttpServletResponse response, Model model) {
        UserVO user = cookieHelper.getCookie(request);
        if(null != user){
            //如果获取到User 则放入model中
            model.addAttribute("userVO", user);
        }else{
            //如果没有获得User，那就去登陆吧
            model.addAttribute("redirectPath", "/listDefaultProducts");
            return "login/login";
        }
        List<DefaultProductVO> defaultProductVOList = iProductManageService.getDefaultProductVOList();
        model.addAttribute("defaultProductVOList", defaultProductVOList);
        iProductManageService.initProductsToRedis();
        return "defaultproductslist";
    }



    @RequestMapping("/defaultProductDetail")
    public String showProductDetail(HttpServletRequest request,HttpServletResponse response, Model model, UserVO user){
        model.addAttribute("user", user);
        DefaultProductDetailVO defaultProductDetailVO = iProductManageService.getDefaultProductDetailVO();
        model.addAttribute("defaultProductDetailVO", defaultProductDetailVO);
        return "defaultproductdetail";
    }



}
