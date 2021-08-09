package br.com.jogoshowmilhao.application;

import br.com.jogoshowmilhao.util.LogUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    private static final String VIEW_FXML = "views/hello-view.fxml";

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource(VIEW_FXML)));
        primaryStage.setTitle("Hello World");
        LogUtil.getLogger(Main.class).info(primaryStage.getTitle());
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}