package com.service.yis.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                        .antMatchers("/chk").permitAll() // LoadBalancer chk -> 클라우드 사용
                        .anyRequest().authenticated() // 어떠한 요청들을 다 로그인 필요
                .and()
                        .formLogin() // 폼 방식 로그인
                        .defaultSuccessUrl("/view/dashboard",true) // 로그인 성공시 url
                        .permitAll()
                .and()
                        .logout(); // 로그아웃
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/css/**","static/img/*"); //css,img 사용 위해 추후 js도 추가 필요
    }
}
