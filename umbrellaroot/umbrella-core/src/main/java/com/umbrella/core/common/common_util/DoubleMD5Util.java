package com.umbrella.core.common.common_util;

import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

/**
 * @program: com.umbrella.core.common.common_util
 * @description:MD5简易工具
 * @author: liujinghui
 * @create: 2018-11-25 14:10
 **/
public class DoubleMD5Util {

    private static String md5(String src) {
        byte[] passwordByte= src.getBytes();
        return DigestUtils.md5DigestAsHex(passwordByte);
    }

    /**
     * 生成md5
     * @param password 密码
     * @param salt 盐
     * @return
     */
    public static String genMD5(String password, String salt) {
        return md5(salt==null?"":salt + password);
    }
    /**
     *
     * @param inputPassword 前端传来的一次MD5的密码
     * @param dbUserPassword 数据库经过两次MD5后的密码
     * @param salt 盐
     * @return
     */
    public static boolean validatePasword(String inputPassword,String dbUserPassword,String salt){
        return genMD5(inputPassword,salt).equals(dbUserPassword);
    }

}
