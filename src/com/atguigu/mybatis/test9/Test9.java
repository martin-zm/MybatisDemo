package com.atguigu.mybatis.test9;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.atguigu.mybatis.bean.CUser;
import com.atguigu.mybatis.util.MybatisUtils;

/*
 * ���Ի���
 1. һ������ : session���Ļ��� 
 	1. ִ����session.clearCache();
 	2. ִ��CUD����
 	3. ����ͬһ��Session����
 2. ��������: ��һ��ӳ���ļ����Ļ���
 */
public class Test9 {
		
	@Test
	public void testCacheOne() {
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		
		String Statement = "com.atguigu.mybatis.test9.userMapper.getUser";
		CUser user = session.selectOne(Statement , 1);
		System.out.println(user);
		
		user = session.selectOne(Statement, 1);
		System.out.println(user);
		System.out.println("-------------------");
		
		/*
		 //1. ִ����session.clearCache();
		session.clearCache();
		*/
		
		/*
		//2. ִ��CUD����
		session.update("com.atguigu.day03_mybaits.test9.userMapper.updateUser", new CUser(1, "Tom", 13));
		session.commit();
		*/
		
		//3. ����ͬһ��Session����
		session.close();
		session = factory.openSession();
		
		user = session.selectOne(Statement, 1);
		
		System.out.println(user);
		
		session.close();
	}
	
	@Test
	public void testCacheTwo() {
		
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session1 = factory.openSession();
		SqlSession session2 = factory.openSession();
		
		String statement = "com.atguigu.mybatis.test9.userMapper.getUser";
		CUser user = session1.selectOne(statement, 1);
		//����Ҫ�ύ�����������������
		session1.commit();
		System.out.println(user);
		
		user = session2.selectOne(statement, 1);
		session2.commit();
		System.out.println(user);		
	}
}
