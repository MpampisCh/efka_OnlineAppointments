package org.team1;

import org.team1.security.CustomAccessDeniedHandler;
import org.team1.security.MySavedRequestAwareAuthenticationSuccessHandler;
import org.team1.security.RestAuthenticationEntryPoint;
import org.team1.services.MyDoctorDetailsService;
import org.team1.services.MyClientDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
public class WebAppConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Autowired
    private MySavedRequestAwareAuthenticationSuccessHandler mySuccessHandler;

    @Autowired
    private CustomAccessDeniedHandler accessDeniedHandler;

    @Autowired
    private MyClientDetailsService myClientDetailsService;

    @Autowired
    private MyDoctorDetailsService myDoctorDetailsService;

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(myClientDetailsService);
        authProvider.setUserDetailsService(myDoctorDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    private SimpleUrlAuthenticationFailureHandler myFailureHandler = new SimpleUrlAuthenticationFailureHandler();

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .and()
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler)
                .authenticationEntryPoint(restAuthenticationEntryPoint)
                .and()
                .authorizeRequests()
                .antMatchers("/Appointment/**").authenticated()
                .antMatchers("/Doctor/**").hasRole("Doctor")
                .antMatchers("/Client/**").hasRole("Client")
                .and()
                .formLogin()
                .successHandler(mySuccessHandler)
                .failureHandler(myFailureHandler)
                .and()
                .logout()
                .logoutSuccessUrl("/index.html");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}