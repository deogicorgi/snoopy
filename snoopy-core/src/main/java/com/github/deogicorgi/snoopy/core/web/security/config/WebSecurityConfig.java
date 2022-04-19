package com.github.deogicorgi.snoopy.core.web.security.config;

import com.github.deogicorgi.snoopy.core.web.security.provider.CustomAuthenticationProvider;
import com.github.deogicorgi.snoopy.core.web.security.service.SnoopyMemberService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    public void configure(WebSecurity web) {
        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(snoopyAuthenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                // /about 요청에 대해서는 로그인을 요구함
                .antMatchers("/about").authenticated()
                // /admin 요청에 대해서는 ROLE_ADMIN 역할을 가지고 있어야 함
//                .antMatchers("/admin").hasRole("ADMIN")
                // 나머지 요청에 대해서는 로그인을 요구하지 않음
                .anyRequest().permitAll().and()
                // 로그인하는 경우에 대해 설정함
                .formLogin()
                // 로그인 페이지를 제공하는 URL을 설정함
                .loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/main")

                .and().logout().logoutUrl("/logout")
                // 로그인 성공 URL을 설정함
//                .successForwardUrl("/index")
                // 로그인 실패 URL을 설정함
//                .failureForwardUrl("/index")
                .permitAll();
//                .and()
//                .addFilterBefore(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public AuthenticationProvider snoopyAuthenticationProvider() {
        return new CustomAuthenticationProvider(snoopyUserDetailService(), bCryptPasswordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService snoopyUserDetailService() {
        return new SnoopyMemberService();
    }
}