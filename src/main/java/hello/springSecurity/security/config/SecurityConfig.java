package hello.springSecurity.security.config;

import hello.springSecurity.domain.Role;
import hello.springSecurity.security.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .headers().frameOptions().disable()

                .and()
                .authorizeRequests()
                .antMatchers("/", "/css/**", "/images/**", "/js/**").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                .anyRequest().authenticated()

                .and()
                .logout()
                .logoutSuccessUrl("/")

                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(customOAuth2UserService);

    }
}
