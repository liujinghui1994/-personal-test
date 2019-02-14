package com.umbrella.core.register_manage.controller;

import com.umbrella.core.common.result_manage.ResultVO;
import com.umbrella.core.register_manage.constant.RegisterConstant;
import com.umbrella.core.user_manage.model.UserVO;
import com.umbrella.core.common.result_manage.Result;
import com.umbrella.core.register_manage.service.IRegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("register")
@Controller
public class RegisterController {

	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
	@Autowired
	private IRegisterService iRegisterService;
	/**
     * 注册页面
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/registerPage")
    public String registerPage(HttpServletRequest request) throws Exception {
        return "register/register";
    }
    
    
	/**
     * 保存注册页面
     * @return
     * @throws Exception
     */
    @RequestMapping("/saveRegisterDetail")
    @ResponseBody
    public ResultVO saveRegisterDetail(UserVO userVO, Model model) throws Exception {
        try {
            if (null == userVO) {
                Result.error(RegisterConstant.EMPTY_INPUT);
            } else {
                int result = iRegisterService.registerUser(userVO);
                if (result > 0) {
                    return Result.success(RegisterConstant.REGISTER_SUCCESS);
                }
            }
        } catch (Exception e) {
            Result.error(e, RegisterConstant.REGISTER_ERROR);
        }
        return Result.error(RegisterConstant.REGISTER_ERROR);
    }
}
