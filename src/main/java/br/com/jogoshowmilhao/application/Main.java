package br.com.jogoshowmilhao.application;

import br.com.jogoshowmilhao.connection.ConnectionFactory;
import br.com.jogoshowmilhao.util.LogUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public class Main extends Application {

    private static final String VIEW_FXML = "views/hello-view.fxml";

    private static final String OPENING_MUSIC = "src/main/resources/br/com/jogoshowmilhao/application/songs/som-abertura-2.mp3";
    private static final String DECK_MUSIC = "src/main/resources/br/com/jogoshowmilhao/application/songs/tire-a-carta-do-baralho-voice.mp3";

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource(VIEW_FXML)));
        primaryStage.setTitle("Hello World");
        LogUtil.getLogger(Main.class).info(primaryStage.getTitle());
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        ContinuousReproduction reproduction = new ContinuousReproduction(OPENING_MUSIC, true);
        reproduction.start();

//        JLayer layer = new JLayer();
//        File mp3 = new File(DECK_MUSIC);
//        layer.tocar(mp3);
//        layer.start();

        Connection connection = ConnectionFactory.getConnection();
        String sql = "INSERT INTO jogador (id, nome, pontuacao) VALUES ($next_id, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(2, "Marcos");
            statement.setInt(3, 2);
            statement.execute();
            connection.commit();

        } catch (SQLException throwables) {
            LogUtil.getLogger(Main.class).error(throwables.getMessage());
        }
    }

    public static void main(String[] args) {
        launch();
    }
}