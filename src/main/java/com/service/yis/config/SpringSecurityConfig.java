package com.service.yis.config;


import com.service.yis.service.BackedLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    LoginIDValidator loginIDValidator; // 유저가 id,pw입력한 후 form이 발송되면 vaildator로 감

    @Autowired
    BackedLoginService loginService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                        .antMatchers("/chk","/account/join","/account/signup").permitAll() // LoadBalancer chk -> 클라우드 사용
                        .anyRequest()
                        .authenticated() // 어떠한 요청들을 다 로그인 필요
                .and()
                        .formLogin() // 폼 방식 로그인
                        .loginPage("/account/login") // 로그인 커스텀 페이지
                        .loginProcessingUrl("/doLogin")
                        .usernameParameter("username")
                        .passwordParameter("pw")
                        .successHandler(new LoginSuccessHandler())
                        .failureHandler(new LoginFailureHandler())
                        //.defaultSuccessUrl("/test/index",true) // 로그인 성공시 url
                        .permitAll()
                .and()
                        .logout()
                        .logoutUrl("/doLogout")
                        .logoutSuccessUrl("/account/login");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/css/*","static/img/*"); //css,img 사용 위해 추후 js도 추가 필요
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(loginService);
    }
}
