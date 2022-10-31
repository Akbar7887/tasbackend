package tas.uz.tasbackend.conf;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import tas.uz.tasbackend.filter.CustomAuthenticationFilter;
import tas.uz.tasbackend.filter.CustomAuthorizationFilter;

import static org.springframework.http.HttpMethod.*;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter((authenticationManagerBean()));
        customAuthenticationFilter.setFilterProcessesUrl("/login");
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/login/token/refresh/**", "/login/**").permitAll();
        http.authorizeRequests().antMatchers(GET,"/api/**", "/custom/customerorderget", "/custom/customerget").permitAll();
        http.authorizeRequests().antMatchers(POST,"/custom/customeradd", "/custom/customerorderadd").permitAll();
//        http.authorizeRequests().antMatchers(GET, "/custom/customerorderpost").hasAnyAuthority("ADMIN", "MENEGER");
        http.authorizeRequests().antMatchers(POST, "/api/**").hasAnyAuthority( "ADMIN", "MENEGER");
        http.authorizeRequests().antMatchers(PUT, "/api/**").hasAnyAuthority("ADMIN", "MENEGER");
        http.authorizeRequests().antMatchers(DELETE, "/api/**").hasAnyAuthority("ADMIN", "MENEGER");

//        http.authorizeRequests().antMatchers(POST, "/api/customeradd").hasAnyAuthority( "ADMIN", "MENEGER");

        http.authorizeRequests().antMatchers(POST, "/login/user/save/**").hasAnyAuthority("ADMIN");
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

}
