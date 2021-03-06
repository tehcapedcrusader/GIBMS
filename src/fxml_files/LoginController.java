/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml_files;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.effects.JFXDepthManager;
import com.jfoenix.svg.SVGGlyph;
import core.Navigator;
import guiMediators.Commons;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author Isuru Udukala
 */
public class LoginController implements Initializable
{

    @FXML
    private StackPane stackpane;
    @FXML
    private Label label;
    @FXML
    private JFXButton button_login;
    @FXML
    private AnchorPane rootAnchor;
    @FXML
    private JFXTextField text_ufield;
    @FXML
    private JFXPasswordField pass_pfield;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        JFXDepthManager.setDepth(stackpane, 5);
        SVGGlyph glyph = new SVGGlyph(1, "navigation", Commons.NAVIGATION_GLYPH, Color.WHITE);
        glyph.setSize(25, 30);
        label.setText("");
        label.setGraphic(glyph);

        button_login.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent e)
            {
                //if(text_ufield.getText().toLowerCase().equals("gilemp") && pass_pfield.getText().toLowerCase().equals("alpine64"))
                Navigator.switchForm(rootAnchor, 0);
            }
        });
    }
}