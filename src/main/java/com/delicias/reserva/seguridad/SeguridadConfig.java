package com.delicias.reserva.seguridad;

import com.delicias.reserva.servicios.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;

@Configuration
@EnableWebSecurity
public class SeguridadConfig {

    @Autowired
    private MyUserDetailService myUserDetailService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        HttpSessionRequestCache requestCache = new HttpSessionRequestCache();
        requestCache.setMatchingRequestParameterName(null);
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(registry -> {
                    registry.requestMatchers("/", "/js/**","/js2/**", "/css/**", "/fonts/**", "/assets/**", "/favicon.ico","error").permitAll();
                    registry.requestMatchers("/auth/**").permitAll();
                    registry.requestMatchers("/usuario/register").permitAll();
                    registry.requestMatchers("/user/index").permitAll();

                    // registry.requestMatchers("/distrito/**").hasRole("USER");
                    registry.requestMatchers("/reserva/**").hasRole("USER");
                    registry.requestMatchers("/pedido/**").hasRole("USER");
                    registry.requestMatchers("/bebida/**").hasRole("USER");
                    registry.requestMatchers("/plato/**").hasRole("USER");
                    registry.requestMatchers("/mesa/**").hasRole("USER");
                    registry.requestMatchers("/usuario/myprofile").hasRole("USER");

                    registry.requestMatchers("/distrito/**").hasRole("ADMIN");
                    registry.requestMatchers("/reserva/**").hasRole("ADMIN");
                    registry.requestMatchers("/pedido/**").hasRole("ADMIN");
                    registry.requestMatchers("/rol/**").hasRole("ADMIN");
                    registry.requestMatchers("/categoria/**").hasRole("ADMIN");
                    registry.requestMatchers("/bebida/**").hasRole("ADMIN");
                    registry.requestMatchers("/plato/**").hasRole("ADMIN");
                    registry.requestMatchers("/mesa/**").hasRole("ADMIN");
                    registry.requestMatchers("/usuario/**").hasRole("ADMIN");

                    registry.anyRequest().authenticated();
                })
                .requestCache((cache) -> cache
                        .requestCache(requestCache))
                .formLogin(httpSecurityFormLoginConfigurer -> {
                    httpSecurityFormLoginConfigurer.loginPage("/auth/login").successHandler(new AuthSuccessHandler())
                            .permitAll();

                })
                // .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                .build();
    }

    // @Bean
    // public UserDetailsService userDetailsService() {
    // UserDetails userAdmin = User.builder()
    // .username("admin")
    // .password("$2a$12$57VCW.MjVCPJOlVYYZMylOTayWesEkQIU0oHoOQ.00mZkCGTD09XK")
    // .roles("ADMIN")
    // .build();
    // return new InMemoryUserDetailsManager(userAdmin);
    // }

    @Bean
    public UserDetailsService userDetailsService() {
        return myUserDetailService;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(myUserDetailService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
