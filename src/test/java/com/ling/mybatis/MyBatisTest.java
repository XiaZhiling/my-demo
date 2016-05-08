package com.ling.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ling.mybatis.dao.IUserOperation;
import com.ling.mybatis.model.User;

public class MyBatisTest {
	
	private static Logger log = LoggerFactory.getLogger(MyBatisTest.class);
	
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	private static SqlSession sqlSession;
	
	@Before
	public void init() throws Exception{
		reader = Resources.getResourceAsReader("mybatis-config.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		sqlSession = sqlSessionFactory.openSession();
	}
	
	@After
	public void destroy() throws IOException{
		if(reader!=null){
			reader.close();
		}
		sqlSession.close();
	}
	
	@Test
	public void testMybatis(){
		User user = sqlSession.selectOne("com.ling.mybatis.dao.IUserOperation.selectUserByID", 1);
		log.info("user= {}",user);
	}
	
	@Test
	public void testIUserOperation(){
		IUserOperation operation = sqlSession.getMapper(IUserOperation.class);
		User user = operation.selectUserByID(1);
		log.info("testIUserOperation user={}",user);
	}
	
	@Test
	public void testIUserOperationResultMap(){
		IUserOperation operation = sqlSession.getMapper(IUserOperation.class);
		List<User> list = operation.selectUsers("xz%");
		log.info("找到了{}个user",list.size());
		for (User user : list) {
			log.info("user:{}",user);
		}
	}
	
	

}
