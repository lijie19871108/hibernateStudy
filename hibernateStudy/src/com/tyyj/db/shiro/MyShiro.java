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

@Service
public class MyShiro extends AuthorizingRealm{
	
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
		User user = new User();
		user.setUsername("tom");
		user.setPassword("000000");
		if(user!=null){
			return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(),getName());
		}
		return null;
	}

}
