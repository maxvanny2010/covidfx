package com.covid;


import com.covid.datafetch.DataProviderService;
import com.covid.datafetch.model.DataModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Launch.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 8/12/2020
 */
public class Launch extends Application {
    @Override
    public void start(final Stage primaryStage) throws IOException {
        final Parent root = FXMLLoader.load(getClass().getResource("/widget.fxml"));

        final Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        final DataModel model = new DataProviderService().getData("Germany");
        System.out.println(model);
    }
}
