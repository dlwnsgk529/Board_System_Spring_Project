package com.dlwnsgk.Board_System_Spring_Project.config;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// @Configuration includes @Component
@Configuration
// SpringSecurity feature
@EnableWebSecurity
public class SecurityConfig {
	
	// Registers the labeled Class to Bean
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		// Write in this function when SpringSecurity is used
		http
		.csrf(csrf->csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())) // To NOT use csrf security for frontend here. added @ JS file. Otherwise unable to send date in RESTAPI
		.cors(cors->cors.configurationSource(corsConfigurationSource())) // allow data to be transferred at certain servers
		.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)) // use session
		.authorizeHttpRequests(authz->authz.requestMatchers("/","/loginPage","/logout", "/noticeCheckPage", "/noticeBoardPage", "/registerPage", "/menu/all").permitAll() // pages that anybody can visit
			.requestMatchers(HttpMethod.POST,"/login", "/register").permitAll() // Allow all to POST login info
			.requestMatchers("/resources/**","/WEB-INF/**").permitAll() // '**' => all files under the root folder.
			.requestMatchers("/noticeAddPage", "/noticeModifyPage").hasAnyAuthority("ADMIN", "MANAGER") // permission limit
			.requestMatchers(HttpMethod.POST, "/menu/add").hasAnyAuthority("ADMIN", "MANAGER") // limit POST @ this url
			.requestMatchers(HttpMethod.POST, "/menu/update").hasAnyAuthority("ADMIN", "MANAGER")
			.requestMatchers(HttpMethod.DELETE, "/menu/delete").hasAnyAuthority("ADMIN", "MANAGER")
			.anyRequest().authenticated() // redirects to loginPage if not permitted above
		)
		
		.formLogin( // works as controller for login
			login->login.loginPage("/loginPage") // url when moved to login page
			.loginProcessingUrl("/login") // url where the data is put
			.failureUrl("/loginPage?error=true") // when login failed, goes back to '/loginPage'
			.usernameParameter("username") // input tag's name
			.passwordParameter("password")
			.successHandler(authenticationSuccessHandler())
			.permitAll()
		)
		
		.logout(
			logout->logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // logged out through this url
			.logoutSuccessUrl("/") // redirect to this url after logout
			.invalidateHttpSession(true) // nullify session
			.deleteCookies("JSESSIONID")
			.permitAll()
		);
		
		
		return http.build();
	}
	
	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler() {
		return new SimpleUrlAuthenticationSuccessHandler() {
			
			@Override
			public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
					Authentication authentication) throws IOException, ServletException {
				// When Login is successful, and add other features (session and permission)
				
				HttpSession session = request.getSession();
				boolean isManager = authentication.getAuthorities().stream()
					.anyMatch(grantedAuthority -> 
						grantedAuthority.getAuthority().equals("ADMIN") ||
						grantedAuthority.getAuthority().equals("MANAGER")
					);
				if(isManager) {
					session.setAttribute("MANAGER", true);
				}
				
				session.setAttribute("username", authentication.getName());
				session.setAttribute("isAuthenticated", true);
				response.sendRedirect(request.getContextPath() + "/");
				
				super.onAuthenticationSuccess(request, response, authentication);
			}
		};
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); // encrypt data at DB. vv important
	}
	
	@Bean
	public org.springframework.web.cors.CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("http://localhost:8080", "http://localhost:8080")); // allow data exchange between front and back @ written servers
		// one should be "http://localhost:3000" but frontend is created in 8080 server in this project
		
		configuration.setAllowedMethods(Arrays.asList("GET","POST", "PUT","DELETE"));
		configuration.setAllowedHeaders(Arrays.asList("Authorization","Content-Type")); // header is the metadata about the exchanged data
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration); // apply above settings at all domains
		
		return source;
	}
	
}