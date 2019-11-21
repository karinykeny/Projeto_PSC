package com.sunshine.PSC.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends  WebSecurityConfigurerAdapter  {
	//"WebSecurityConfigurerAdapter" - Classe nativa do Spring Security 

	@Autowired
	private ImplementsUserDetailService userDetailsService;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{ //método de configurações
		http.csrf().disable().authorizeRequests()//crsf provê vários tipos de segurança para a aplicação
<<<<<<< HEAD
<<<<<<< HEAD
		.antMatchers(HttpMethod.GET, "/").permitAll()
		//todos os me
		/*.antMatchers(HttpMethod.GET, "/quarto/listarQuartos").hasRole("ADMIN")
=======
		/*.antMatchers(HttpMethod.GET, "/").permitAll()//todos os me
=======
		.antMatchers(HttpMethod.GET, "/").permitAll()//todos os me
>>>>>>> 0c4f74c5074625dff93100d54cf0c91544453f5b

>>>>>>> 0d15b4c8ec93c949e219b61f82a249a64a3ec83a

		.antMatchers(HttpMethod.GET, "quarto/cadastrarQuartos").hasRole("USER")
		.antMatchers(HttpMethod.GET, "/reserva/listarReservas").hasRole("ADMIN")
		

		//.anyRequest().authenticated() //para todas as demais requisições precisará de Autenticação

		.and().formLogin().permitAll()// para que a pessoa acesse o formulário de login do spring security e assim ter acesso... 
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		http.headers().frameOptions().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{ // método que define como será feita a autenticação em memória através da classe "AuthenticationManagerBuilder" 
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/css/**");
	}
	//Esse método serve para que o spring security não bloqueie as páginas estáticas quando o browser pedir o acesso a estas pastas
	
	
}
