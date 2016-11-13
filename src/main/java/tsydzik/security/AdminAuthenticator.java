package tsydzik.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * @author Eugene Tsydzik
 * @since 13.11.16.
 */
@Component
public class AdminAuthenticator implements AuthenticationProvider {

    public static final List<SimpleGrantedAuthority> ADMIN_AUTHORITIES
            = Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"));

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) authentication;

        String login = (String) usernamePasswordAuthenticationToken.getPrincipal();
        String password = (String) usernamePasswordAuthenticationToken.getCredentials();

        if ("admin".equals(login) && "admin".equals(password)) {
            return new UsernamePasswordAuthenticationToken(login, null, ADMIN_AUTHORITIES);
        }

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.isAssignableFrom(UsernamePasswordAuthenticationToken.class);
    }
}
