package com.atguigu.mybatis.test4;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.atguigu.mybatis.bean.Order;
import com.atguigu.mybatis.util.MybatisUtils;

public class Test4 {

	public static void main(String[] args) {
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		
		String statement = "com.atguigu.mybatis.test4.userMapper.getOrder";
		statement = "com.atguigu.mybatis.test4.userMapper.getOrder2";
		Order order = session.selectOne(statement, 1);
		System.out.println(order);
	}
}
