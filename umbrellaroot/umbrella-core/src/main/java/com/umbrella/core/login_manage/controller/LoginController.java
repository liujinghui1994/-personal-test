package com.umbrella.core.login_manage.controller;

import com.umbrella.core.common.redis_manage.redisapi.RedisListAPI;
import com.umbrella.core.common.result_manage.ResultVO;
import com.umbrella.core.common.session_manage.CookieHelper;
import com.umbrella.core.login_manage.constant.LoginConstant;
import com.umbrella.core.user_manage.model.UserVO;
import com.umbrella.core.common.result_manage.Result;
import com.umbrella.core.login_manage.service.ILoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RequestMapping("login")
@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private ILoginService loginService;
	@Autowired
	private CookieHelper cookieHelper;
	@Autowired
    private RedisListAPI redisListAPI;


    /**
     * 登陆页面
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/loginPage")
    public String loginPage(HttpServletRequest request) throws Exception {



        return "login/login";
    }

	/**
     * 执行登陆
     * @param //request
     * @return
     * @throws Exception
     */
    @RequestMapping("/doLogin")
    @ResponseBody
    public ResultVO doLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model, UserVO user) throws Exception {
        //输入内容校验
        if(null == user || null == user.getUserName() || null == user.getUserPassword()){
            return Result.error(LoginConstant.EMPTY_INPUT);
        }
        UserVO userVO = null;
        try{
            userVO = loginService.loginUserByUserNameAndUserPassword(user.getUserName(),user.getUserPassword());
            if(null == userVO){
                return Result.error(LoginConstant.WRONG_USERNAME_PASSWORD);
            }
            model.addAttribute("userVO",userVO);
            //!!!!登陆成功后我们就设置我们的Cookie
            cookieHelper.addCookie(response,session.getId(),userVO);
        }catch(Exception e){
            e.printStackTrace();
           return Result.error(e,LoginConstant.QUERY_USER_INFO_ERROR);
        }
        return Result.success(LoginConstant.LOGIN_SUCCESS);
    }

}
