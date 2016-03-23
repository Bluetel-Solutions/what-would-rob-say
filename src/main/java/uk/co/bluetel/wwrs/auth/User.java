package uk.co.bluetel.wwrs.auth;

import javax.security.auth.Subject;
import java.security.Principal;

/**
 * @author David Avila.
 */
public class User implements Principal {

    public User(String username){

    }
    @Override
    public boolean equals(Object another) {
        return true;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String getName() {
        return "Username";
    }

    @Override
    public boolean implies(Subject subject) {
        return true;
    }
}
