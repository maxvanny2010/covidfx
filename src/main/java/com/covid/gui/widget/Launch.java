package com.covid.gui.widget;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * Launch.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 8/12/2020
 */
public class Launch extends Application {
    private double xOffset;
    private double yOffset;

    public static void main(final String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) throws IOException {
        System.err.close();

        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setOpacity(0);
        primaryStage.show();

        final Stage secondaryStage = new Stage();
        secondaryStage.initStyle(StageStyle.UNDECORATED);
        secondaryStage.initOwner(primaryStage);

        final Parent root = FXMLLoader.load(getClass().getResource("/widget.fxml"));
        final Scene scene = new Scene(root);
        secondaryStage.setScene(scene);
        secondaryStage.show();

        scene.setOnMousePressed(event -> {
            this.xOffset = secondaryStage.getX() - event.getScreenX();
            this.yOffset = secondaryStage.getY() - event.getScreenY();
        });
        scene.setOnMouseDragged(event -> {
            secondaryStage.setX(event.getScreenX() + this.xOffset);
            secondaryStage.setY(event.getScreenY() + this.yOffset);
        });

    }
}
