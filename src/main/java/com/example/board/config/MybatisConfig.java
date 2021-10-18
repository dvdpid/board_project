package com.example.board.config;

import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class MybatisConfig {
	   @Bean  //mybatis 이용을 위한 bean 등록
	   public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
	      SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
	      sessionFactory.setDataSource(dataSource);
	      sessionFactory.setTypeAliasesPackage("com.example.board.board.dto , com.example.board.user.dto");
	      
	      Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*Mapper.xml");
	      sessionFactory.setMapperLocations(res);
	      
	      
	      return sessionFactory.getObject();

    }
}
