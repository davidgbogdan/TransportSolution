package com.david.drxtransportsolution.config;

import com.david.drxtransportsolution.user.Role;
import com.david.drxtransportsolution.user.User;
import com.david.drxtransportsolution.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final UserRepository repository;

    @Bean
    public UserDetailsService userDetailsService() {
       return username -> {
           Optional<User> userOptional = repository.findByEmail(username);
           if(userOptional.isEmpty()){
               throw new UsernameNotFoundException("User not found");
           }
           User user = userOptional.get();
           List<GrantedAuthority> authorities = new ArrayList<>();
           authorities.add(new SimpleGrantedAuthority(user.getRole().name()));
           if(user.getRole() == Role.ADMIN){
               authorities.add(new SimpleGrantedAuthority(Role.USER.name()));
           }
           return new org.springframework.security.core.userdetails.User(
                   user.getEmail(), user.getPassword(), user.isEnabled(),
                   true, true, true, authorities
           );
       };
    }


    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
