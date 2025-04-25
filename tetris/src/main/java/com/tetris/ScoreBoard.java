package com.tetris;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class ScoreBoard {

    public static void showTopScores() {
        Stage stage = new Stage();
        VBox layout = new VBox(10);
        layout.setStyle("-fx-padding: 20; -fx-background-color: #1e1e1e;");
        
        Label title = new Label("🏆 High Scores");
        title.setStyle("-fx-text-fill: gold; -fx-font-size: 20px;");
        layout.getChildren().add(title);

        List<String> topScores = ScoreManager.loadTopScores();
        for (String entry : topScores) {
            Label label = new Label(entry);
            label.setStyle("-fx-text-fill: white; -fx-font-size: 14px;");
            layout.getChildren().add(label);
        }

        Scene scene = new Scene(layout, 250, 300);
        stage.setTitle("High Scores");
        stage.setScene(scene);
        stage.show();
    }
}
