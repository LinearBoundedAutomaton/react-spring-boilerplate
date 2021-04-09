package electrosphere.api.security;

import electrosphere.api.security.user.LocalUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author lba
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    public SecurityConfig(){
        super();
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/api/**").authenticated()
                .antMatchers("/index.html").permitAll()
                .antMatchers("/perform_login").permitAll()
                .antMatchers("/login.html").permitAll()
                .antMatchers("/js/*").permitAll()
                .and()
            .formLogin()
                .loginPage("/index.html")
                .loginProcessingUrl("/perform_login")
                .successForwardUrl("/index.html?login=success")
                .defaultSuccessUrl("/index.html?login=success", true)
                .failureUrl("/login.html?error=true")
                .failureForwardUrl("/login.html?error=true")
                .and()
            .httpBasic() //web.xml equivalent & says we're going to use http basic auth
                .and()
            .logout()
                .permitAll();
    }
    
    
    @Autowired
    LocalUserDetailsService localUserDetailsService;
    
    @Override
    protected void configure(final AuthenticationManagerBuilder auth ) throws Exception{
        auth.userDetailsService(localUserDetailsService);
    }
    
    
    
}
