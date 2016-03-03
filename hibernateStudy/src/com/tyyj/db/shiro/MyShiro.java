package com.tyyj.db.shiro;

import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyyj.db.Entities.Role;
import com.tyyj.db.Entities.User;
import com.tyyj.db.dao.UserDao;
import com.tyyj.db.util.EndecryptUtils;

@Service
public class MyShiro extends AuthorizingRealm{

	@Autowired
	UserDao userDao;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		
		String loginName=(String)principalCollection.fromRealm(getName()).iterator().next();
		User user = new User();
		if(user!=null){
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			info.setRoles(user.getRolesName());
			List<Role> roleList = user.getRoleList();
			for(Role role : roleList){
				info.addStringPermission(role.getRolename());
			}
			return info;
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		// TODO Auto-generated method stub

		
		UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
		
		User user = userDao.findByName(token.getUsername());
		//String password = new String(token.getPassword());
		
		//String passwordMD5 = EndecryptUtils.encrytPasswordAndSaltWithMD5(token.getUsername(),password,user.getSalt());

		if(user!=null){
			return new SimpleAuthenticationInfo(token.getUsername(), user.getPassword(), getName());
		}
		return null;
	}

}
