package com.umbrella.core.common.session_manage;

import com.umbrella.core.common.common_util.ProtostuffUtil;
import com.umbrella.core.common.redis_manage.redisbase.RedisService;
import com.umbrella.core.user_manage.model.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @program: com.umbrella.core.common.session_manage
 * @description:
 * @author: liujinghui
 * @create: 2018-12-02 21:53
 **/
@Component
public class CookieHelper {

    @Autowired
    RedisService redisService;

    public boolean addCookie(HttpServletResponse response, String token, UserVO user) {
        try{
            if(null == token || "".equals(token)){
                token = UUID.randomUUID().toString().replace("-","");
            }
            if(null == user){
                return false;
            }
            Cookie cookie = new Cookie(SessionCookieConstant.COOKIE_TOKEN_NAME, token);
            cookie.setMaxAge(SessionCookieConstant.COOKIE_MAX_AGE);//60秒过期
            cookie.setPath(SessionCookieConstant.COOKIE_PATH);//网站根目录
            response.addCookie(cookie);//写入到客户端
            //写入Redis
            redisService.set(token, ProtostuffUtil.serializer(user));
            redisService.expire(token,SessionCookieConstant.COOKIE_MAX_AGE);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public UserVO getCookie(HttpServletRequest request){
        try{
            String token = request.getSession().getId();
            byte[] bytes = redisService.get(token.getBytes());
            UserVO user = ProtostuffUtil.deserializer(bytes,UserVO.class);
            if(null != user){
                redisService.expire(token,SessionCookieConstant.COOKIE_MAX_AGE);
                return user;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
