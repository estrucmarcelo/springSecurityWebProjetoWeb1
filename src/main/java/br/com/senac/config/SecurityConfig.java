package br.com.senac.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import br.com.senac.service.PessoaDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.csrf().disable()
		.cors()
		.and()
		.securityMatcher("/**")
		.authorizeHttpRequests()
		.requestMatchers(HttpMethod.GET,"/curso/listarCursos").permitAll()
		.requestMatchers("/curso/cadastrar").hasRole("USER")
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.defaultSuccessUrl("/curso/listarCursos")
        .failureUrl("/login?error=true")
        .permitAll()
		.and()
		.logout()
		.invalidateHttpSession(true)
        .deleteCookies("JSESSIONID");
		
		return http.build();
		
	}
	
	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http, PasswordEncoder passwordEncoder,
			UserDetailsService userDetailService) throws Exception {
		
		return http.getSharedObject(AuthenticationManagerBuilder.class)
				.userDetailsService(userDetailsService())
				.passwordEncoder(passwordEncoder)
				.and()
				.build();
	}
	
//	@Bean
//	public InMemoryUserDetailsManager userDetailsService() {
//		UserDetails admin = User.withUsername("admin")
//				.password(encoder().encode("adminPass"))
//				.roles("ADMIN")
//				.build();
//		UserDetails user = User.withUsername("user")
//				.password(encoder().encode("userPass"))
//				.roles("USER")
//				.build();
//		
//		return new InMemoryUserDetailsManager(admin, user);
//		
//	}
	
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new PessoaDetailService();
	}
	
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	
	
	
	
}
