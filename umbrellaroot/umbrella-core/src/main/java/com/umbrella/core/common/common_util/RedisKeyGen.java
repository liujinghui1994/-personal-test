package com.umbrella.core.common.common_util;


import com.umbrella.core.common.common_constant.KeyCodeConstant;
import com.umbrella.core.user_manage.model.UserVO;

/**
 * @program: com.umbrella.armsmerchant.common.common_util
 * @description:
 * @author: liujinghui
 * @create: 2018-11-24 11:12
 **/
public class RedisKeyGen {
    public static String KeyGen(Class clazz,String key){
        if(null == key || "".equals(key)){
            return "";
        }
        if(clazz == UserVO.class){
            return KeyCodeConstant.PRODUCT_KEY_PREFIX_CODE+key;
        }else{
            return key;
        }
    }
}
