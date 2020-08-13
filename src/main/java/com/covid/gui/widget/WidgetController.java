package com.covid.gui.widget;

import com.covid.config.ConfigModel;
import com.covid.config.ConfigurationService;
import com.covid.datafetch.DataProviderService;
import com.covid.datafetch.model.CountryData;
import com.covid.datafetch.model.DataModel;
import com.covid.datafetch.model.GlobalData;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Window;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * WidgetController.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 8/12/2020
 */
public class WidgetController implements Initializable {
    private ScheduledExecutorService service;
    private ConfigModel configModel;
    @FXML
    public AnchorPane rootPane;
    @FXML
    public Text textGlobalReport, textCountryCode, textCountryReport;

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        try {
            this.configModel = new ConfigurationService().getConfiguration();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.initializeScheduler();
        this.initializeContextMenu();
        this.textCountryCode.setText(configModel.getCountryCode());
    }

    private void initializeScheduler() {
        this.service = Executors.newSingleThreadScheduledExecutor();
        this.service.scheduleAtFixedRate(
                this::loadData, 0,
                this.configModel.getRefreshIntervalInSeconds(),
                TimeUnit.SECONDS);
    }

    private void loadData() {
        System.out.println("Refreshing data");
        final DataProviderService provider = new DataProviderService();
        final DataModel data = provider.getData(this.configModel.getCountryName());
        Platform.runLater(() -> inflateData(data));

    }

    private void inflateData(final DataModel model) {
        final GlobalData globalData = model.getGlobalData();
        this.textGlobalReport.setText(
                this.getFormattedData(
                        globalData.getCases(), globalData.getRecovered(), globalData.getDeaths()
                )
        );
        final CountryData country = model.getCountryData();
        this.textCountryReport.setText(
                this.getFormattedData(
                        country.getCases(), country.getRecovered(), country.getDeaths()
                )
        );
        this.readStage(this.textCountryCode.getScene().getWindow());
    }

    private String getFormattedData(final long total, final long recovered, final long deaths) {
        return String.format("Cases: %-8d | Recovered: %-6d | Deaths: %-6d", total, recovered, deaths);
    }

    private void readStage(final Window stage) {
        stage.sizeToScene();
        final Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
        stage.setX(visualBounds.getMaxX() - 25 - this.textCountryCode.getScene().getWidth());
        stage.setY(visualBounds.getMinY() + 25);

    }

    private void initializeContextMenu() {
        final MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(event -> System.exit(0));
        final MenuItem refresh = new MenuItem("Refresh now");
        refresh.setOnAction(event ->
                this.service.schedule(this::loadData, 0, TimeUnit.SECONDS));
        final ContextMenu contextMenu = new ContextMenu(exit, refresh);
        this.rootPane.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            if (event.isSecondaryButtonDown()) {
                contextMenu.show(this.rootPane, event.getScreenX(), event.getScreenY());
            } else {
                if (contextMenu.isShowing()) {
                    contextMenu.hide();
                }

            }
        });
    }
}
