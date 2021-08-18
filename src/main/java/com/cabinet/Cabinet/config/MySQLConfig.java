package com.cabinet.Cabinet.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.cabinet.Cabinet.dao")
// 연결할 DAO 인터페이스를 담은 패키지를 등록한다.
public class MySQLConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws  Exception {
        // SqlSessionFactory : MySql과 MyBatis를 연결해 주는 객체

        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        // SqlSessionFactoryBean : SqlSessionFactory를 생성해주는 클래스
        sessionFactory.setDataSource(dataSource);
        // setDataSource() : 앞서 정의한 dataSource를 참조한다.

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        // PathMatchingResourcePatternResolver : resource 위치 검색을 돕는 spring class
        // getResources()로 경로 검색을 해 SqlSessionFactory에 mapper와 myBatis-config를 set 해준다.
        sessionFactory.setMapperLocations(resolver.getResources("classpath:mappers/*.xml"));

        // classpath : resource 폴더를 나타냄

        Resource myBatisConfig = new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml");
        sessionFactory.setConfigLocation(myBatisConfig);

        return sessionFactory.getObject();
    }
}
