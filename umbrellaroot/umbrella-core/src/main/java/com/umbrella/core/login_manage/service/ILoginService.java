package com.umbrella.core.login_manage.service;

import com.umbrella.core.user_manage.model.UserVO;

public interface ILoginService {

	public UserVO loginUserByUserNameAndUserPassword(String userName, String userPassword);

	public UserVO loginUserByUserEmailAndUserPassword(String userEmail,String userPassword);

}
