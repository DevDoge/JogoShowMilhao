module com.example.jogoshowmilhao {
    requires javafx.controls;
    requires javafx.fxml;
    requires log4j;
    requires jlayer;
    requires java.sql;


    opens br.com.jogoshowmilhao.application to javafx.fxml;
    exports br.com.jogoshowmilhao.application;
    exports br.com.jogoshowmilhao.controller;
    opens br.com.jogoshowmilhao.controller to javafx.fxml;
}