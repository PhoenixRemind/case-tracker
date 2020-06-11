package org.launchcode.casetracker.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends AbstractEntity {

    @OneToMany
    private List<Cases> cases = new ArrayList<>();

    @NotNull
    private String username;

    @NotNull
    private String pwHash;

    private String role;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User() {}

    public User(String username, String password, String role) {
        this.username = username;
        this.pwHash = encoder.encode(password);
        this.role = role;
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getRole() { return role; }

    public void setRole(String role) { this.role = role; }
}
