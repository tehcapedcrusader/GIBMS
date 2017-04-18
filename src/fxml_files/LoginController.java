/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml_files;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.effects.JFXDepthManager;
import com.jfoenix.svg.SVGGlyph;
import core.Navigator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Isuru Udukala
 */
public class LoginController implements Initializable {

    @FXML
    private StackPane stackpane;
    @FXML
    private JFXTextField user;
    @FXML
    private Label label;
    @FXML
    private JFXButton button_login;
    @FXML
    private AnchorPane rootAnchor;
    
    private JFXSnackbar snackbar;
    @FXML
    private JFXSpinner spinner;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        JFXDepthManager.setDepth(stackpane, 5);
        SVGGlyph glyph = new SVGGlyph(1,"navigation","M18 8h-1V6c0-2.76-2.24-5-5-5S7 3.24 7 6v2H6c-1.1 0-2 .9-2 2v10c0 1.1.9 2 2 2h12c1.1 0 2-.9 2-2V10c0-1.1-.9-2-2-2zm-6 9c-1.1 0-2-.9-2-2s.9-2 2-2 2 .9 2 2-.9 2-2 2zm3.1-9H8.9V6c0-1.71 1.39-3.1 3.1-3.1 1.71 0 3.1 1.39 3.1 3.1v2z",Color.WHITE);
        glyph.setSize(25, 30);
        label.setText("");
        label.setGraphic(glyph);
        
        spinner.setVisible(false);
        
        button_login.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e)
            {
                spinner.setVisible(true);
                
                Navigator.switchForm(rootAnchor, 0);
            }
        });
    }
}

//public class LoginController implements Initializable {
//
//    @FXML
//    private StackPane stackpane;
//    @FXML
//    private JFXTextField user;
//    @FXML
//    private Label label;
//    @FXML
//    private JFXButton button_login;
//    @FXML
//    private AnchorPane rootAnchor;
//    
//    private JFXSnackbar snackbar;
//    @FXML
//    private JFXSpinner spinner;
//
//    /**
//     * Initializes the controller class.
//     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) 
//    {
//        ExecutorService executor = Executors.newFixedThreadPool(10);
//                Callable<Connection> someCallable = new something();
////                Future<Connection> foo = executor.submit(someCallable);
//            Connection foo;
//        try {
//            foo = executor.submit(someCallable).get();
//        } catch (InterruptedException ex) {
//            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ExecutionException ex) {
//            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//                
//        JFXDepthManager.setDepth(stackpane, 5);
//        SVGGlyph glyph = new SVGGlyph(1,"navigation","M18 8h-1V6c0-2.76-2.24-5-5-5S7 3.24 7 6v2H6c-1.1 0-2 .9-2 2v10c0 1.1.9 2 2 2h12c1.1 0 2-.9 2-2V10c0-1.1-.9-2-2-2zm-6 9c-1.1 0-2-.9-2-2s.9-2 2-2 2 .9 2 2-.9 2-2 2zm3.1-9H8.9V6c0-1.71 1.39-3.1 3.1-3.1 1.71 0 3.1 1.39 3.1 3.1v2z",Color.WHITE);
//        glyph.setSize(25, 30);
//        label.setText("");
//        label.setGraphic(glyph);
//        
//        spinner.setVisible(false);
//        
//        button_login.setOnAction(new EventHandler<ActionEvent>(){
//            @Override
//            public void handle(ActionEvent e)
//            {
//                spinner.setVisible(true);
//                
////                try
////                {
////                    System.out.println(new Date() + " - " + foo.get());
////                }
////                catch (Exception ex){}
//                spinner.setVisible(false);
//        
//                executor.shutdown();
//                
//                //Navigator.switchForm(rootAnchor, 0);
//                System.out.println("Done");
//            }
//        });
//        
//    }
//}
//
//class something implements Callable<Connection>
//{
//    Connection conn = null;
//    
//    @Override
//    public Connection call() throws InterruptedException
//    {
//        Connection conn = dbConnect.connect();
//        return conn;
//    }
//    public Connection get()
//    {
//        if(conn == null)
//            try {
//                conn = call();
//            } catch (Exception e) {}
//        return conn;
//    }
//}
//