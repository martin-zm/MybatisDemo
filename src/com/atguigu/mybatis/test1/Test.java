package com.atguigu.mybatis.test1;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.atguigu.mybatis.bean.User;

public class Test {
	
	public static void main(String[] args) {
		String resource = "conf.xml";
		InputStream is = Test.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		
		String statement = "com.atguigu.mybatis.test1.userMapper.getUser";
		User user = session.selectOne(statement, 2);
		System.out.println(user);		
	}	
}
