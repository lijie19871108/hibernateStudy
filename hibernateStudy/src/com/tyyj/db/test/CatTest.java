package com.tyyj.db.test;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.tyyj.db.Entities.Cat;
import com.tyyj.db.util.HibernateUtil;

public class CatTest {

	@Test
	public static void testcat(String[] args) {
		// TODO Auto-generated method stub
		Cat mother = new Cat();
		mother.setName("lijie cat");
		mother.setDescription("get in 20160127 0009");
		Session session = null;//HibernateUtil.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		session.persist(mother);
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

}
