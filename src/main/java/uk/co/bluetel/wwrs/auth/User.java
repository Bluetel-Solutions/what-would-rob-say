package uk.co.bluetel.wwrs.auth;

import com.google.common.collect.ImmutableSet;

import javax.security.auth.Subject;
import java.security.Principal;

/**
 * @author David Avila.
 */
public class User implements Principal {
    private String name;
    private ImmutableSet<String> roles;

    public User(String username, ImmutableSet<String> secret){
        this.name = username;
        this.roles = secret;
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
        return name;
    }

    @Override
    public boolean implies(Subject subject) {
        return true;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ImmutableSet<String> getRoles() {
        return roles;
    }

    public void setRoles(ImmutableSet<String> roles) {
        this.roles = roles;
    }
}
