package aop_manage.aop_aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @program: com.umbrella.core.common.aop_manage
 * @description: 检查登陆AOP切面
 * @author: liujinghui
 * @create: 2019-02-10 14:31
 **/
@Aspect
@Component
public class LoginAspectByExecution {
    @Pointcut("execution( public * aop_manage.login.LoginController.doMainIndex(Integer))")
    public void verifyLoginByExecution(){}

    @Before("verifyLoginByExecution()")
    public void beforeVerifyLoginByExecution(){
        System.out.println("LoginAspectByExecution...");
    }
}
