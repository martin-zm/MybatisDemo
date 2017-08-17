package com.atguigu.mybatis.test9;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.atguigu.mybatis.bean.CUser;
import com.atguigu.mybatis.util.MybatisUtils;

/*
 * 测试缓存
 1. 一级缓存 : session级的缓存 
 	1. 执行了session.clearCache();
 	2. 执行CUD操作
 	3. 不是同一个Session对象
 2. 二级缓存: 是一个映射文件级的缓存
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
		 //1. 执行了session.clearCache();
		session.clearCache();
		*/
		
		/*
		//2. 执行CUD操作
		session.update("com.atguigu.day03_mybaits.test9.userMapper.updateUser", new CUser(1, "Tom", 13));
		session.commit();
		*/
		
		//3. 不是同一个Session对象
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
		//必须要提交，二级缓存才能作用
		session1.commit();
		System.out.println(user);
		
		user = session2.selectOne(statement, 1);
		session2.commit();
		System.out.println(user);		
	}
}
