package uk.co.bluetel.wwrs.auth;

import com.google.common.base.Optional;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;


/**
 * @author David Avila.
 */
public class WWRSAuthenticator implements Authenticator<BasicCredentials, User> {

    @Override
    public com.google.common.base.Optional<User> authenticate(BasicCredentials credentials) throws AuthenticationException {
        System.out.println(credentials.getPassword());
        if ("secret".equals(credentials)) {
            return Optional.of(new User(credentials.getUsername()));
        }
        return Optional.absent();
    }
}
