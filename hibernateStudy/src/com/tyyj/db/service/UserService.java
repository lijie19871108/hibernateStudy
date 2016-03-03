package com.tyyj.db.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyyj.db.Entities.User;
import com.tyyj.db.dao.UserDao;
import com.tyyj.db.util.EndecryptUtils;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	public boolean regist(String userName, String password){
		
		try {
			User user = EndecryptUtils.encryptPasswordWithMD5(userName, password);
			userDao.persist(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean login(String userName, String password){
		
		
		try {
			
			User user = userDao.findByName(userName);
			
			String passwordMD5 = EndecryptUtils.encrytPasswordAndSaltWithMD5(userName,password,user.getSalt());
			
			SecurityUtils.getSubject().login(new UsernamePasswordToken(userName, passwordMD5));
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
}
