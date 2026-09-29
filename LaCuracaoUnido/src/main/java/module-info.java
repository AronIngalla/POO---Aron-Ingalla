module pe.edu.upeu.lacuracao {

    requires javafx.controls;
    requires javafx.fxml;

    requires jakarta.validation;
    requires org.hibernate.validator;

    requires static lombok;

    requires java.desktop;

    opens pe.edu.upeu.lacuracao.controller to javafx.fxml;
    opens pe.edu.upeu.lacuracao.model to javafx.base, org.hibernate.validator;

    exports pe.edu.upeu.lacuracao;
    exports pe.edu.upeu.lacuracao.controller;
}