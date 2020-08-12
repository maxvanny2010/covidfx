package com.covid;


import com.covid.datafetch.DataProviderService;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Launch.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 8/12/2020
 */
public class Launch extends Application {
    @Override
    public void start(final Stage primaryStage) {
        final Scene scene = new Scene(new StackPane(new Label("JavaFX")), 200, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
        new DataProviderService().getData("Ukraine");
    }
}
