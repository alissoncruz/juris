package com.juris.config.securiry;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.juris.config.securiry.WebSecurityConfig.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private  final PasswordEncoder passwordEncoder;

    public WebSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable().authorizeRequests()
                .antMatchers("/home").permitAll()
                .antMatchers(HttpMethod.POST,"**/user").permitAll()
                .antMatchers(HttpMethod.POST, "/login").permitAll()

                .anyRequest().authenticated()
                .and()

                // filtra requisições de login
                .addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class)

                // filtra outras requisições para verificar a presença do JWT no header
                .addFilterBefore(new JWTAuthenticationFilter(),
                        UsernamePasswordAuthenticationFilter.class);
    }


   @Override
    @Bean
    protected UserDetailsService userDetailsService(){
      UserDetails administrator =  User.builder()
               .username("alisson")
               .password(passwordEncoder.encode("juris@xp2022"))
               .roles(ADMIN.name())
               .build();
      UserDetails lawyer = User.builder()
              .username("advogado")
              .password(passwordEncoder.encode("adv@12345"))
              .roles(LAWYER.name())
              .build();
      UserDetails attendant = User.builder()
              .username("atendente")
              .password(passwordEncoder.encode("atendente@123"))
              .roles(ATTENDANT.name())
              .build();
      return new InMemoryUserDetailsManager(
              administrator,
              lawyer,
              attendant
      );
   }
   @Getter
   @AllArgsConstructor
   public enum ApplicationUserRole{
        ADMIN,
       LAWYER,
       ATTENDANT
   }
}
