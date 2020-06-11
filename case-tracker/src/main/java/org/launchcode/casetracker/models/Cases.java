package org.launchcode.casetracker.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Cases extends AbstractEntity {

    @ManyToOne
    private User user;

    @NotNull
    private String currentStatus;

    public Cases() {}

    public Cases(String currentStatus, User user) {
        super();
        this.currentStatus = currentStatus;
        this.user = user;
    }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public String getCurrentStatus() { return currentStatus; }

    public void setCurrentStatus(String currentStatus) { this.currentStatus = currentStatus; }

}
