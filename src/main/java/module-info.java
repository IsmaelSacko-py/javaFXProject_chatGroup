module dev.sn.javafxproject_chatgroup {
    requires javafx.controls;
    requires javafx.fxml;


    opens dev.sn.javafxproject_chatgroup to javafx.fxml;
    exports dev.sn.javafxproject_chatgroup;
}