package tsydzik.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.Arrays;

/**
 * @author Eugene Tsydzik
 * @since 13.11.16.
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public AuthenticationManager authenticationManager(AdminAuthenticator adminAuthenticator,
                                                       UserAuthenticator userAuthenticator) {
        return new ProviderManager(Arrays.asList(adminAuthenticator, userAuthenticator));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
//                .authorizeRequests()
//                .anyRequest().permitAll();
                .formLogin().loginPage("/login").permitAll()
                .and()
                .authorizeRequests()
                .anyRequest().permitAll();
    }

}
