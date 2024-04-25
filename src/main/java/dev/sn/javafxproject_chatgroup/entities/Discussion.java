package dev.sn.javafxproject_chatgroup.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Discussion
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private String dateMessage;

    @ManyToOne
    @JoinColumn(name = "idMembre", referencedColumnName = "id", nullable = false)
    private Membre membre;

    public Discussion() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDateMessage() {
        return dateMessage;
    }

    public void setDateMessage(String dateMessage) {
        this.dateMessage = dateMessage;
    }

    public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }
}
