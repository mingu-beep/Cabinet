package com.cabinet.Cabinet.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
// 이 어노테이션을 붙이고 클래스 내에 하나 이상의 빈 메소드를 구현하면 스프링 컨테이너가 빈 정의를 생성하고 그 빈들의 요청을 처리할 것을 선언한다.
public class DataSourceConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    // 외부 설정 파일(application.properties)를 참조할 때 쓰는 방법 중 하나
    // 외부 설정 파일에서 접두어(prefix)가 일치하는 것을 참조할 수 있다.
    // 이 어노테이션을 빈이 붙은 메소드에 붙여주면 써드파티 컴포넌트 (ex/Datasource)에 바인딩을 할 수 있다
    // 즉 Datasource가 application.properties에 spring.datasource로 시작되는 값들을 참조해서 쓴다라는 의미.
    // 써드파티 컴포넌트 : 프로그래밍을 도와주는 플러그인이나 라이브러리, 현재 팀 인원 외의 제 3자가 개발한 도구.
    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }


}
