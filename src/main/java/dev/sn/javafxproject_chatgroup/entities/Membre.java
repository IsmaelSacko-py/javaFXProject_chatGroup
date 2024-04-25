package dev.sn.javafxproject_chatgroup.entities;
import javax.persistence.*;
import java.util.List;

@Entity
public class Membre
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100, nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String dateAdhesion;

    // Donnes tous les messages envoyés par un utilisateur
    @OneToMany(mappedBy = "membre")
    private List<Discussion> messages;

    public Membre() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDateAdhesion() {
        return dateAdhesion;
    }

    public void setDateAdhesion(String dateAdhesion) {
        this.dateAdhesion = dateAdhesion;
    }

    public List<Discussion> getMessages() {
        return messages;
    }

    public void setMessages(List<Discussion> messages) {
        this.messages = messages;
    }
}
