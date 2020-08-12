package com.covid.gui.widget;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * WidgetController.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 8/12/2020
 */
public class WidgetController implements Initializable {
    @FXML
    public AnchorPane rootPane;
    @FXML
    public Text textGlobalRecord, textCountryCode, textCountryReport;

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {

    }
}
