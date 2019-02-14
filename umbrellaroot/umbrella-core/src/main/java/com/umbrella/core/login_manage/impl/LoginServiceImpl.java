package com.umbrella.core.login_manage.impl;

import com.umbrella.core.common.common_util.DoubleMD5Util;
import com.umbrella.core.user_manage.model.UserVO;
import com.umbrella.core.login_manage.service.ILoginService;
import com.umbrella.core.user_manage.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Service("loginService")
public class LoginServiceImpl implements ILoginService {
	
	@Autowired
	private IUserService iUserService;

	@Override
	public UserVO loginUserByUserNameAndUserPassword(String userName, String userPassword) {
		UserVO userVO = null;
		userVO = iUserService.queryUserByUserName(userName);
		boolean checkPassword = DoubleMD5Util.validatePasword(userPassword,userVO.getUserPassword(),userVO.getUserSalt());
		if(!checkPassword){
			return null;
		}
		return userVO;
	}

	@Override
	public UserVO loginUserByUserEmailAndUserPassword(String userEmail, String userPassword) {
		UserVO userVO = iUserService.queryUserByUserEmail(userEmail);
		userVO = iUserService.queryUserByUserEmailAndUserPassword(userEmail, DoubleMD5Util.genMD5(userVO.getUserPassword(),userVO.getUserSalt()));
		return userVO;
	}
}
