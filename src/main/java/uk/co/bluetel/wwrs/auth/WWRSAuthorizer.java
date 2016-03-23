package uk.co.bluetel.wwrs.auth;

import io.dropwizard.auth.Authorizer;

/**
 * @author David Avila.
 */
public class WWRSAuthorizer implements Authorizer<User> {

    @Override
    public boolean authorize(User principal, String role) {
        boolean authorizeOut = principal.getName().equals("Username") && role.equals("ADMIN");
        System.out.println("Authorize executing: "+authorizeOut);
        return principal.getName().equals("Username") && role.equals("Basic");
    }
}
