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
                .antMatchers("/resources/css", "/resources/css/**").permitAll()
                .antMatchers("/resources/images", "/resources/images/**").permitAll()
                .antMatchers("/resources", "/resources/**").permitAll()
                .antMatchers("/resources/js", "/resources/js/**").permitAll()
                .antMatchers("/form", "/form/**").permitAll()
                .antMatchers("/form-confirmation", "/form-confirmation/**").permitAll()
//                .antMatchers("/*").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/user/user_home_page")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .and()
                .csrf()
                .disable();
    }

}