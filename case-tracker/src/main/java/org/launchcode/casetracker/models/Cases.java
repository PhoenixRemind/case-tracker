package org.launchcode.casetracker.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Cases extends AbstractEntity {

    @NotNull
    private String currentStatus;

    public Cases() {}

    public Cases(String currentStatus) {
        super();
        this.currentStatus = currentStatus;
    }

    public String getCurrentStatus() { return currentStatus; }

    public void setCurrentStatus(String currentStatus) { this.currentStatus = currentStatus; }

}
