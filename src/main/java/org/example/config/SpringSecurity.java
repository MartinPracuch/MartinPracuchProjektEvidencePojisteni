package org.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) ->
                        authorize.requestMatchers("/register/**").permitAll()
                                .requestMatchers("/index").permitAll()
                                .requestMatchers("/users",
                                        "/pojistenci",
                                        "/pojistenci/**",
                                        "/addPojisteni/**",
                                        "/addPojisteni",
                                        "/addPojisteni/save/**",
                                        "/editPojisteni/**",
                                        "/editPojisteni/edit/**",
                                        "/addPojisteni/save",
                                        "/deletePojisteni/**",
                                        "/detailPojistence/confirm-delete/**",
                                        "/vytvorit-pojistence",
                                        "/vytvorit-pojistence/save",
                                        "/editPojistence/edit/**",
                                        "/editPojistence/**",
                                        "/smazatPojistence/**",
                                        "/pojisteni",
                                        "/pojisteni/**",
                                        "/upravitPojistence/upravit/**",
                                        "/smazatPojistence/**",
                                        "/upravitPojistence/**",
                                        "/pridatPojisteni/**",
                                        "ulozitPojisteni/ulozit/**",
                                        "/upravitPojisteni/**",
                                        "/upravitPojisteni/ulozit/{pojisteni_id}",
                                        "/smazatPojisteni/**",
                                        "/vytvorit-pojistence/ulozit",
                                        "/upravitPojistence/**",
                                        "/upravitPojistence/upravit/**").hasRole("ADMIN")
                ).formLogin(
                        form -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/users")
                                .permitAll()



                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll()
                )
                .csrf(csrf -> csrf
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                );
        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
}