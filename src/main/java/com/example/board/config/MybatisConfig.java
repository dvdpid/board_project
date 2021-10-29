package com.example.board.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class MybatisConfig {
	
	
//	@Value("${mybatis.sql.mapper.location}")
//    private String sqlMapperLocation;
//    
//    /**
//     * sqlConfigLocation
//     */
//    @Value("${mybatis.sql.config.location}")
//    private String sqlConfigLocation;
//
//	/**
//	 * sqlSessionFactory
//	 *  
//	 * @return
//	 * @throws Exception SqlSessionFactory
//	 */
	
	   @Bean  //mybatis 이용을 위한 bean 등록
	   public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
	      SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
	      sessionFactory.setDataSource(dataSource);
	      sessionFactory.setTypeAliasesPackage("com.example.board.board.dto , com.example.board.user.dto, com.example.board.comment.dto");
	      
	      Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*Mapper.xml");
	      sessionFactory.setMapperLocations(res);
	      
//	      // Mapper 설정
//	      sessionFactory.setMapperLocations( new PathMatchingResourcePatternResolver().getResources(sqlMapperLocation) );
//	      // Config 설정
//	      sessionFactory.setConfigLocation( new PathMatchingResourcePatternResolver().getResource(sqlConfigLocation) );
	      
	      return sessionFactory.getObject();

    }
}
