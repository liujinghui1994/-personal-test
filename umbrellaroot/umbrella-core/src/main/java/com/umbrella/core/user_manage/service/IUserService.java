package com.umbrella.core.user_manage.service;

import com.umbrella.core.user_manage.model.UserVO;

import java.util.List;

/**
 * @program: com.umbrella.core.user_manage.service
 * @description:
 * @author: liujinghui
 * @create: 2018-11-25 15:35
 **/
public interface IUserService {

    public int insertUser(UserVO userVO);

    public int updateUser(UserVO userVO);

    public int deleteUser(int userId);

    public UserVO queryUserByUserId(int userId);

    public UserVO queryUserByUserName(String userName);

    public UserVO queryUserByUserEmail(String userEmail);

    public UserVO queryUserByUserNameAndUserPassword(String userName,String userPassword);

    public UserVO queryUserByUserEmailAndUserPassword(String userEmail,String userPassword);

    public List<UserVO> queryUser();

}
