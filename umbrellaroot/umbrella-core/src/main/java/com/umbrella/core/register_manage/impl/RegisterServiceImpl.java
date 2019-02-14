package com.umbrella.core.register_manage.impl;

import com.umbrella.core.common.common_util.DoubleMD5Util;
import com.umbrella.core.user_manage.model.UserVO;
import com.umbrella.core.user_manage.service.IUserService;
import com.umbrella.core.register_manage.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service("iRegisterService")
public class RegisterServiceImpl implements IRegisterService {
	
	@Autowired
	private IUserService iUserService;
	
	@Override
	public int registerUser(UserVO userVO){
		userVO.setUserSalt(UUID.randomUUID().toString());
		userVO.setUserPassword(DoubleMD5Util.genMD5(userVO.getUserPassword(),userVO.getUserSalt()));
		int result = iUserService.insertUser(userVO);
		return result;
	}
}
