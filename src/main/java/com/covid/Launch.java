package com.covid;


import com.covid.datafetch.DataProviderService;
import com.covid.datafetch.model.DataModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
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

    @Override
    public void start(final Stage primaryStage) throws IOException {
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
        final DataModel model = new DataProviderService().getData("Germany");
        System.out.println(model);
        final Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
        secondaryStage.setX(visualBounds.getMaxX() - 25 - scene.getWidth());
        secondaryStage.setY(visualBounds.getMinY() + 25);

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
