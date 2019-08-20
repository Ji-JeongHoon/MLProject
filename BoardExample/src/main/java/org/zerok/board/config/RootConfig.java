package org.zerok.board.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@MapperScan(basePackages= {"org.zerok.board.mapper"})
@ComponentScan(basePackages= {"org.zerok.board.service"})
public class RootConfig {
	@Bean
	public DataSource dataSource() {
		HikariDataSource ds = null;
		
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		hikariConfig.setJdbcUrl("jdbc:log4jdbc:postgresql://localhost/board_db");
		hikariConfig.setUsername("postgres");
		hikariConfig.setPassword("p0000");
		
		ds = new HikariDataSource(hikariConfig);
		
		return ds;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());
		
		return sqlSessionFactory.getObject();
	}
}
