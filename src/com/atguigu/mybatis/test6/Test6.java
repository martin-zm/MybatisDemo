package com.atguigu.mybatis.test6;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.atguigu.mybatis.bean.Classes;
import com.atguigu.mybatis.bean.Order;
import com.atguigu.mybatis.util.MybatisUtils;

public class Test6 {

	public static void main(String[] args) {
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		
		String statement = "com.atguigu.mybatis.test6.classMapper.getClass";	
		statement = "com.atguigu.mybatis.test6.classMapper.getClass2";
		Classes c = session.selectOne(statement, 2);
		System.out.println(c);
		
		session.close();
	}
}
