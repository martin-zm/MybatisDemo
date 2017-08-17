package com.atguigu.mybatis.test2;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.atguigu.mybatis.bean.User;
import com.atguigu.mybatis.test3.UserMapper;
import com.atguigu.mybatis.util.MybatisUtils;

public class Test2 {
	
	@Test
	public void testAdd() {
		SqlSessionFactory factory = MybatisUtils.getFactory();
		//默认是手动提交的
		SqlSession session =  factory.openSession();	
		
		String statement = "com.atguigu.mybatis.test2.userMapper.addUser";
		
		int insert = session.insert(statement, new User(-1, "KK", 23));
		
		//提交
		session.commit();
		session.close();
		
		System.out.println(insert);		
	}
	
	@Test
	public void testUpdate() {
		SqlSessionFactory factory = MybatisUtils.getFactory();
		//默认是手动提交的
		SqlSession session =  factory.openSession(true);	
		
		String statement = "com.atguigu.mybatis.test2.userMapper.updateUser";
		
		int update = session.update(statement, new User(3, "KK3", 25));
		
		//提交
		//session.commit();
		session.close();
		
		System.out.println(update);		
	}
	
	@Test
	public void testDelete() {
		SqlSessionFactory factory = MybatisUtils.getFactory();
		//默认是手动提交的
		SqlSession session =  factory.openSession(true);	
		
		String statement = "com.atguigu.mybatis.test2.userMapper.deleteUser";
		
		int delete = session.delete(statement, 3);
		
		//提交
		//session.commit();
		session.close();
		
		System.out.println(delete);		
	}	
	
	@Test
	public void testGetUser() {
		SqlSessionFactory factory = MybatisUtils.getFactory();
		//默认是手动提交的
		SqlSession session =  factory.openSession(true);	
		
		String statement = "com.atguigu.mybatis.test2.userMapper.getUser";
		
		User user = session.selectOne(statement, 1);
		
		//提交
		//session.commit();
		session.close();
		
		System.out.println(user);		
	}	
	
	@Test
	public void testGetAllUsers() {
		SqlSessionFactory factory = MybatisUtils.getFactory();
		//默认是手动提交的
		SqlSession session =  factory.openSession(true);	
		
		String statement = "com.atguigu.mybatis.test2.userMapper.getAllUsers";
		
		List<User> list = session.selectList(statement);
		//提交
		//session.commit();
		session.close();
		
		System.out.println(list);		
	}
	
	@Test
	public void testAdd2() {
		SqlSessionFactory factory = MybatisUtils.getFactory();
		//默认是手动提交的
		SqlSession session =  factory.openSession(true);	
		
		UserMapper mapper = session.getMapper(UserMapper.class);
		int add = mapper.add(new User(-1, "SS", 45));
		System.out.println(add);
		
		session.close();
	}
}
