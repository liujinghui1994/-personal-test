package aop_manage.aop_annotation;

import java.lang.annotation.*;

/**
 * @program: com.umbrella.core.common.aop_manage.aop_annotation
 * @description:
 * @author: liujinghui
 * @create: 2019-02-10 14:42
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface VerifyLogin {
}
