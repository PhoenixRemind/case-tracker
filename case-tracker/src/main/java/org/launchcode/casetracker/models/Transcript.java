package org.launchcode.casetracker.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Transcript extends AbstractEntity {

    //May need this for accurate timestamps
//    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

    @NotNull
    private String messages;

    private Date date;

    private Timestamp timestamp;

    @ManyToOne
    private User user;

    @ManyToOne
    private Ticket aCase;

    public Transcript() {}

    public Transcript(String messages, Date date, Timestamp timestamp, Ticket aCase, User user) {
        super();
        this.messages = messages;
        this.date = date;
        this.timestamp = timestamp;
        this.aCase = aCase;
        this.user = user;
    }

    public Ticket getCase() { return aCase; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public void setCase(Ticket aCase) { this.aCase = aCase; }

    public String getMessages() {
        return messages;
    }

    public Date getDate() {
        return date;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
