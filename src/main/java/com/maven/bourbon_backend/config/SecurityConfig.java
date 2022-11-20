
package com.maven.bourbon_backend.config;

import com.maven.bourbon_backend.filter.CustomAuthenticationFilter;
import com.maven.bourbon_backend.filter.CustomAuthorizationFilter;
import com.maven.bourbon_backend.service.RefreshService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RefreshService refreshService;

    public SecurityConfig(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder, RefreshService refreshService) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.refreshService = refreshService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors();
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean(), refreshService);
        customAuthenticationFilter.setFilterProcessesUrl("/BourbonCommunityReviews/profile/login");
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        http.authorizeRequests().antMatchers("/BourbonCommunityReviews/profile/login").permitAll();
        http.authorizeRequests().antMatchers("/BourbonCommunityReviews/profile/refresh").permitAll();
        http.authorizeRequests().antMatchers("/BourbonCommunityReviews/profile/logout").permitAll();
        http.authorizeRequests().antMatchers("/BourbonCommunityReviews/profile/new").permitAll();
        http.authorizeRequests().antMatchers("/BourbonCommunityReviews/profile/check/**").permitAll();
        //http.authorizeRequests().antMatchers("/BourbonCommunityReviews/bourbon").permitAll();
        http.authorizeRequests().antMatchers(GET, "/BourbonCommunityReviews/profile").permitAll();
        http.authorizeRequests().antMatchers(GET, "/BourbonCommunityReviews/bourbon/**").permitAll();
        http.authorizeRequests().antMatchers(GET, "/BourbonCommunityReviews/review/**").permitAll();
        http.authorizeRequests().antMatchers(GET, "/BourbonCommunityReviews/message").hasAnyAuthority("User");
        http.authorizeRequests().antMatchers(POST, "/BourbonCommunityReviews/profile").hasAnyAuthority("User");
        http.authorizeRequests().antMatchers(POST, "/BourbonCommunityReviews/bourbon").hasAnyAuthority("User");
        http.authorizeRequests().antMatchers(POST, "/BourbonCommunityReviews/review").hasAnyAuthority("User");
        http.authorizeRequests().antMatchers(POST, "/BourbonCommunityReviews/message").hasAnyAuthority("User");
        http.authorizeRequests().antMatchers(PUT, "/BourbonCommunityReviews/bourbon").hasAnyAuthority("Admin");
        http.authorizeRequests().antMatchers(DELETE, "/BourbonCommunityReviews/bourbon").hasAnyAuthority("Admin");
        http.authorizeRequests().antMatchers(PUT, "/BourbonCommunityReviews/profile").hasAnyAuthority("User");
        http.authorizeRequests().antMatchers(DELETE, "/BourbonCommunityReviews/profile").hasAnyAuthority("Admin");
        http.authorizeRequests().antMatchers(POST, "/BourbonCommunityReviews/review").hasAnyAuthority("User");
        http.authorizeRequests().antMatchers(PUT, "/BourbonCommunityReviews/review").hasAnyAuthority("User");
        http.authorizeRequests().antMatchers(DELETE, "/BourbonCommunityReviews/review").hasAnyAuthority("User");
        http.authorizeRequests().anyRequest().authenticated();
        //http.authorizeRequests().anyRequest().permitAll();
        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
    }
}
