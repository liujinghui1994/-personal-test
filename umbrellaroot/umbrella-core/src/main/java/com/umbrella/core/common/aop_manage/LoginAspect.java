package com.umbrella.core.common.aop_manage;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import com.umbrella.core.common.aop_manage.aop_annotation.VerifyLogin;
import org.springframework.stereotype.Component;
/**
 * @program: com.umbrella.core.common.aop_manage
 * @description: 检查登陆AOP切面
 * @author: liujinghui
 * @create: 2019-02-10 14:31
 **/
@Aspect
@Component
public class LoginAspect {

    @Pointcut("@annotation(com.umbrella.core.common.aop_manage.aop_annotation.VerifyLogin)")
    public void verifyLogin(){
        System.out.println("登陆校验切点");
    }

    @Before("verifyLogin()")
    public void beforeCheck(){
        System.out.println("执行校验登陆状态。。。");
    }

}
