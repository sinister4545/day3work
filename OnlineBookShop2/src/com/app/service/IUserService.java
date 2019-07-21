package com.app.service;

import com.app.pojos.Users;

public interface IUserService {

	Users validateUser(String user,String pass);

}
