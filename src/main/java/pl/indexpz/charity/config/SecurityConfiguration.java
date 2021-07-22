package pl.indexpz.charity.config;

//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.indexpz.charity.domain.service.CustomUserDetailService;

@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private CustomUserDetailService customUserDetailService;


    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/register").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/users/user-editpasswordform.jsp").fullyAuthenticated()
                .antMatchers("/users", "/users/", "/users/*", "/users/**").authenticated()
                .antMatchers("/vehicle", "/vehicle/", "/vehicle/*", "/vehicle/**").authenticated()
                .antMatchers("/forms/user", "/forms/user/", "/forms/user/*").hasAnyRole("USER")
                .antMatchers("/static/css", "/static/css/**").permitAll()
                .antMatchers("/*").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/user/homepage")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .and()
                .csrf()
                .disable();
    }

}