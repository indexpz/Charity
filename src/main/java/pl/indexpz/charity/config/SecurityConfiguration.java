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
//                .antMatchers("/users/user-editpasswordform.jsp").fullyAuthenticated()
                .antMatchers("/users", "/users/", "/users/*", "/users/**").authenticated()
                .antMatchers("/forms/user", "/forms/user/", "/forms/user/*").hasAnyRole("USER")
                .antMatchers("/resources", "/resources/**").permitAll()
                .antMatchers("/form", "/form/**").hasAnyRole("USER")
                .antMatchers("/form_summary", "/form_summary/**").hasAnyRole("USER")
                .antMatchers("/form_confirmation", "/form_confirmation/**").hasAnyRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .and()
                .csrf()
                .disable();
    }

}