package com.tyyj.db.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.tyyj.db.Entities.Cat;
import com.tyyj.db.Entities.TyyjUser;
import com.tyyj.db.util.HibernateUtil;

public class CatTest1 {

	@Test
	public void test() {
		// TODO Auto-generated method stub
				Cat fdsaf = new Cat();
				TyyjUser user = new TyyjUser();
				user.setName("hahha");
				user.setPassword("123456");
				user.setPhoneNumber("125463");
				user.setUserName("lijuie");
				fdsaf.setName("lijt");
				fdsaf.setDescription("get in 20160127 0009");
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction trans = session.beginTransaction();
				//session.persist(fdsaf);
				session.persist(user);
				trans.commit();
				session.close();
				
				session = HibernateUtil.getSessionFactory().openSession();
				trans = session.beginTransaction();
				List<Cat> catlist = session.createQuery(" from Cat").list();
				StringBuffer result = new StringBuffer();
				for(Cat cc : catlist){
					result.append(cc.getName()+"\r\n");
					result.append(cc.getDescription()+"\r\n");
					result.append(cc.getId()+"\r\n");
				}
				trans.commit();
				session.close();
				System.out.println(result);
				try {
					int s =System.in.read();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	@Test
	public void testGet(){

	}

}
