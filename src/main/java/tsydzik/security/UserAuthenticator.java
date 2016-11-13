package tsydzik.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import tsydzik.data.User;
import tsydzik.repository.UserRepository;

import java.util.Collections;
import java.util.List;

/**
 * @author Eugene Tsydzik
 * @since 13.11.16.
 */
@Component
public class UserAuthenticator implements AuthenticationProvider {

    public static final List<SimpleGrantedAuthority> USER_AUTHORITIES
            = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));

    private final UserRepository userRepository;

    public UserAuthenticator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) authentication;

        String login = (String) usernamePasswordAuthenticationToken.getPrincipal();
        String password = (String) usernamePasswordAuthenticationToken.getCredentials();
        User user = userRepository.findByLoginAndPassword(login, password);

        if (user != null) {
            return new UsernamePasswordAuthenticationToken(login, null, USER_AUTHORITIES);
        }

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.isAssignableFrom(UsernamePasswordAuthenticationToken.class);
    }
}
