package org.launchcode.casetracker.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Transcript extends AbstractEntity {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

    @NotNull
    private String messages;

    private Date date;

    private Timestamp timestamp;

    public Transcript() {}

    public Transcript(String messages, Date date, Timestamp timestamp) {
        super();
        this.messages = messages;
        this.date = date;
        this.timestamp = timestamp;
    }

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
