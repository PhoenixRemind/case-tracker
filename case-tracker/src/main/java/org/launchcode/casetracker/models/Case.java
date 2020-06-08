package org.launchcode.casetracker.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Case extends AbstractEntity {

    @NotNull
    private String currentStatus;

    @ManyToOne
    private User user;

    public Case() {}

    public Case(String currentStatus, User user) {
        super();
        this.currentStatus = currentStatus;
        this.user = user;
    }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public String getCurrentStatus() { return currentStatus; }

    public void setCurrentStatus(String currentStatus) { this.currentStatus = currentStatus; }

}
