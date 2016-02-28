package com.tyyj.db.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tyyj.db.Entities.TyyjManor;
import com.tyyj.db.dao.TyyyjManorHome;
import com.tyyj.db.util.HibernateUtil;

@Service
public class BaseInfoManageService {
	
	
	@Autowired
	TyyyjManorHome TyyjManorHome;
	
	@SuppressWarnings("unchecked")
	public List<TyyjManor> getAllManors(){
		List<TyyjManor> manors = TyyjManorHome.findAll();
		return manors;
	}
	
}
