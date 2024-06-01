package com.phone.shop.util;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.phone.shop.service.Impl.UserService;

@Configuration
@EnableMethodSecurity
public class SecurityConfiguration {
	private UserDetailsService userService;

    public SecurityConfiguration(UserService userDetailsService){
        this.userService = userDetailsService;
    }

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
                                 AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
    
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeHttpRequests((authorize) ->
                        authorize.requestMatchers(HttpMethod.GET, "/api/**").permitAll()
                                .requestMatchers("/api/auth/**").permitAll()
                                .requestMatchers("/h2-console/**").permitAll()
                                .requestMatchers(
                                        "swagger-ui/**",
                                        "swagger-ui-custom.html",
                                        "swagger-ui/index.html",
                                        "api-docs/**").permitAll()
                                .requestMatchers("/v2/api-docs").permitAll()
                                .requestMatchers("/configuration/ui").permitAll()
                                .requestMatchers("/swagger-resources/**").permitAll()
                                .requestMatchers("/configuration/security").permitAll()
                                .requestMatchers("/swagger-ui.html").permitAll()
                                .requestMatchers("/swagger-ui/*").permitAll()
                                .requestMatchers("/webjars/**").permitAll()
                                .requestMatchers("/v2/**").permitAll()
                );
        http.headers().frameOptions().disable();

        return http.build();
    }
}
