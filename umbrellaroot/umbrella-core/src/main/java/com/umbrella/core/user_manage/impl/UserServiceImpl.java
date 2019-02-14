package com.umbrella.core.user_manage.impl;

import com.umbrella.core.user_manage.dao.IUserManageDao;
import com.umbrella.core.user_manage.model.UserVO;
import com.umbrella.core.user_manage.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: com.umbrella.core.user_manage.impl
 * @description:
 * @author: liujinghui
 * @create: 2018-11-25 15:36
 **/
@Service("iUserService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserManageDao iUserManageDao;

    @Override
    public int insertUser(UserVO userVO) {
        return iUserManageDao.insertUser(userVO);
    }

    @Override
    public int updateUser(UserVO userVO) {
        return iUserManageDao.updateUserById(userVO);
    }

    @Override
    public int deleteUser(int userId) {
        return iUserManageDao.deleteUser(userId);
    }

    @Override
    public UserVO queryUserByUserId(int userId) {
        return iUserManageDao.queryUserByUserId(userId);
    }

    @Override
    public UserVO queryUserByUserName(String userName) {
        return iUserManageDao.queryUserByUserName(userName);
    }

    @Override
    public UserVO queryUserByUserEmail(String userEmail) {
        return iUserManageDao.queryUserByEmail(userEmail);
    }

    @Override
    public UserVO queryUserByUserNameAndUserPassword(String userName, String userPassword) {
        return iUserManageDao.queryUserByUserNameAndUserPassword(userName,userPassword);
    }

    @Override
    public UserVO queryUserByUserEmailAndUserPassword(String userEmail, String userPassword) {
        return iUserManageDao.queryUserByUserEmailAndUserPassword(userEmail,userPassword);
    }

    @Override
    public List<UserVO> queryUser() {
        return iUserManageDao.queryUser();
    }
}
