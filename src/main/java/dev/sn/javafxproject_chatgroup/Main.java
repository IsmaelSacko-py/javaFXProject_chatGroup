package dev.sn.javafxproject_chatgroup;

import dev.sn.javafxproject_chatgroup.entities.Discussion;
import dev.sn.javafxproject_chatgroup.entities.Membre;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("chat.fxml")));
        Scene scene = new Scene(parent);
//        stage.setTitle("Page de connexion");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        //launch();

        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("MaBaseDeTestPU");
        EntityManager entityManager = managerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try
        {
//            //Debut de transaction
//            transaction.begin();
//
//            // Creer un objet
//            Membre membre = new Membre();
//            membre.setUsername("Olsen");
//
//            // Obtenez la date et l'heure actuelles
//            LocalDateTime dateTime = LocalDateTime.now();
//
//            // Définir le format de date et heure souhaité
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
//
//            // Formater la date et l'heure en utilisant le format spécifié
//            String dateAdhesion = formatter.format(dateTime);
//
//            membre.setDateAdhesion(dateAdhesion);
//
//
//            // Persister dans la base de données
//            entityManager.persist(membre);
//
//            // Valider la transaction
//            transaction.commit();

            //Debut de transaction
            transaction.begin();

            // Creer un objet
            Discussion discussion = new Discussion();
            discussion.setMessage("Salut tintin");
            Membre membre = entityManager.find(Membre.class, 1);
            discussion.setMembre(membre);

            // Obtenez la date et l'heure actuelles
            LocalDateTime dateTime = LocalDateTime.now();

            // Définir le format de date et heure souhaité
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

            // Formater la date et l'heure en utilisant le format spécifié
            String dateAdhesion = formatter.format(dateTime);

            discussion.setDateMessage(dateAdhesion);


            // Persister dans la base de données
            entityManager.persist(discussion);

            // Valider la transaction
            transaction.commit();



        }catch (Exception e)
        {
            if(transaction.isActive())
            {
                transaction.rollback();
            }
        }
    }
}