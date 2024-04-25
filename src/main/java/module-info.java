module dev.sn.javafxproject_chatgroup {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires java.sql;
    requires org.hibernate.orm.core;



    opens dev.sn.javafxproject_chatgroup to javafx.fxml;
    exports dev.sn.javafxproject_chatgroup;

    opens dev.sn.javafxproject_chatgroup.entities;
}