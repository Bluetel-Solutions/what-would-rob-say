package uk.co.bluetel.wwrs.auth;

import io.dropwizard.auth.Authorizer;

/**
 * @author David Avila.
 */
public class WWRSAuthorizer implements Authorizer<User> {

    /**
     * Method which check if the user can get access to a resoure.
     * @param principal
     * @param role
     * @return
     */
    @Override
    public boolean authorize(User principal, String role) {
        if(principal.getRoles() != null && principal.getRoles().contains(role)) {
            return true;
        }
        return false;
    }
}
