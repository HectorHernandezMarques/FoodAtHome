package es.urjc.dad.practica.prueba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public UserRepositoryAuthenticationProvider authenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
    	// Public pages
       
        http.authorizeRequests().antMatchers("/main").permitAll();
        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests().antMatchers("/main/Contacto").permitAll();
        http.authorizeRequests().antMatchers("/main/Productos").permitAll();
        http.authorizeRequests().antMatchers("/main/oferta1").permitAll();
        http.authorizeRequests().antMatchers("/main/oferta2").permitAll();
        http.authorizeRequests().antMatchers("/main/oferta3").permitAll();
        http.authorizeRequests().antMatchers("/Pedidos").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/anadproduc/nuevo").permitAll();
        http.authorizeRequests().antMatchers("/main/Productos/pedirComida").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/pedido").permitAll();
        http.authorizeRequests().antMatchers("/main/Productos/pedirBebida").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/main/Ofertas/pedirOferta").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/main/Pedido/comprarPedido").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/loginerror").permitAll();
  
        

        // Private pages (all other pages)
        http.authorizeRequests().antMatchers("/anadproduc").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/admin").hasAnyRole("ADMIN");

        // Login form
        http.formLogin().loginPage("/login");
        http.formLogin().usernameParameter("username");
        http.formLogin().passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/main");
        http.formLogin().failureUrl("/loginerror");

        // Logout
        http.logout().logoutUrl("/logout");
        http.logout().logoutSuccessUrl("/main");
        
        // Disable CSRF at the moment
//        http.csrf().disable();
    }

   @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        
    	// User
	   auth.authenticationProvider(authenticationProvider);
      
    }
    
    	


}
