package uk.co.bluetel.wwrs.auth;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

import java.util.Set;


/**
 * @author David Avila.
 */
public class WWRSAuthenticator implements Authenticator<BasicCredentials, User> {
    /**
     * Valid users with mapping user -> roles
     */
    private static final ImmutableMap<String, ImmutableSet<String>> VALID_USERS = ImmutableMap.of(
            "guest", ImmutableSet.of(""),
            "user", ImmutableSet.of("Basic"),
            "admin", ImmutableSet.of("Admin", "Basic")
    );

    /**
     * Authenticates the user. Checks that the password is correct and get all the roles related to the user.
     * @param credentials
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Optional<User> authenticate(BasicCredentials credentials) throws AuthenticationException {
        System.out.println(credentials.getPassword());
        if (VALID_USERS.containsKey(credentials.getUsername()) && "secret".equals(credentials.getPassword())) {
            return Optional.of(new User(credentials.getUsername(),VALID_USERS.get(credentials.getUsername())));
        }
        return Optional.absent();
    }
}
