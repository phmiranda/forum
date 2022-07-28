/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number: 71
 * Description: Introdução ao Spring Boot
 * Date: 26/03/2022
 */

package br.com.phmiranda.comunidade.config.security;

import br.com.phmiranda.comunidade.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    AuthService authService;

    // Configuração de autenticação.
    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(authService).passwordEncoder(new BCryptPasswordEncoder());
    }

    // Configuração de autorização.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers(HttpMethod.POST, "/auth/basica").permitAll()
            .antMatchers(HttpMethod.POST, "/auth/oauth/google").permitAll()
            .antMatchers(HttpMethod.POST, "/auth/oauth/facebook").permitAll()
            .antMatchers(HttpMethod.GET,"/duvidas").permitAll()
            .antMatchers(HttpMethod.GET,"/duvidas/*").permitAll()
            .antMatchers(HttpMethod.GET,"/olamundo").permitAll()
            .anyRequest().authenticated().and().csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    // Configuração de recursos estáticos (CSS, Javascript, Imagens).
    @Override
    public void configure(WebSecurity web) throws Exception {

    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
