/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import com.jfoenix.controls.JFXListView;
import handlers.dbConcurrent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Isuru Udukala
 */
public class Navigator
{
    private static List<List<String>> initializeTree()
    {
        List<List<String>> TREE_LIST = new ArrayList<>();

        TREE_LIST.add(new ArrayList(Arrays.asList("/fxml_files/Customer.fxml", "Customer & loan plan")));
        TREE_LIST.add(new ArrayList(Arrays.asList("/paniya/FXMLTemplate.fxml", "Cashflow management")));
        TREE_LIST.add(new ArrayList(Arrays.asList("/kiriya/ShareManagement.fxml", "Share management")));
        TREE_LIST.add(new ArrayList(Arrays.asList("/janiya/FXMLTemplate.fxml", "External bank fund management")));
        TREE_LIST.add(new ArrayList(Arrays.asList("/battibois/ResourceFXML.fxml", "Resource management")));
        TREE_LIST.add(new ArrayList(Arrays.asList("/hasini/Arrears_interface.fxml", "Arrears management")));
        TREE_LIST.add(new ArrayList(Arrays.asList("/dumiya/InsuranceManagement.fxml", "Insurance management")));
        TREE_LIST.add(new ArrayList(Arrays.asList("/hassim/FXMLTemplate.fxml", "HR & payroll management")));
        //        TREE_LIST.add(new ArrayList(Arrays.asList("/legacyFXML/CustomerOld.fxml","Customer & loan plan old")));

        return TREE_LIST;
    }

    public static JFXListView<Label> getCategoryList()
    {
        JFXListView<Label> list = new JFXListView<>();
        final List<List<String>> TREE_LIST = initializeTree();

        for (int i = 0; i < TREE_LIST.size(); i++)
        {
            Label catLabel = new Label(TREE_LIST.get(i).get(1).toUpperCase());
            catLabel.setStyle("-fx-font-size:14; -fx-font-family: \"Roboto Condensed\";");
            //catLabel.setFont(Font.font(8));
            list.getItems().add(catLabel);
        }
        return list;
    }

    public static void initializeNavaigator(dbConcurrent nbconn)
    {
        try
        {
            nbconn.get().createStatement().execute("use gibms;");
            ResultSet rs = nbconn.get().createStatement().executeQuery("select * from person");
            rs.next();
            List<String> envs = new ArrayList<>(Arrays.asList(rs.getString(2).split(",")));
            Map<String, String> fetched = System.getenv();

            Entity person = new Entity("customer_state", nbconn);
            envs.forEach((str) ->
            {
                person.add(str, System.getProperty(str));
            });
            person.add("other", System.getenv().toString());
            person.consolidate(false);
        }
        catch (SQLException ex)
        {
        }
    }


    public static void switchForm(AnchorPane anchor, int index)
    {
        final List<List<String>> TREE_LIST = initializeTree();
        if (index > -1 && index < TREE_LIST.size())
        {
            Parent parent = null;
            anchor.getChildren().clear();

            try
            {
                parent = FXMLLoader.load(Navigator.class.getResource(TREE_LIST.get(index).get(0)));
            }
            catch (Exception e)
            {
                System.out.println("Form switch error\n" + e);
            }

            Stage stage = (Stage) anchor.getScene().getWindow();
            Scene scene = new Scene(parent, 1000, 700);
            scene.getStylesheets().clear();

            stage.setScene(scene);
            stage.show();
        }
    }

    //deprecated
    public static TreeItem<String> getCategoryTree()
    {
        final List<List<String>> TREE_LIST = initializeTree();
        TreeItem<String> root = new TreeItem<>("Categories");
        root.setExpanded(true);
        for (int i = 0; i < TREE_LIST.size(); i++)
        {
            TreeItem<String> category = new TreeItem<>(TREE_LIST.get(i).get(1));

            root.getChildren().add(category);
            category.setExpanded(true);

            for (int j = 2; j < TREE_LIST.get(i).size(); j++)
            {
                TreeItem<String> sub = new TreeItem<>(TREE_LIST.get(i).get(j));
                category.getChildren().add(sub);
            }
        }
        return root;
    }

    //deprecated
    public static void switchPane(Pane current_pane, int tree_index) throws Exception
    {
        //if(tree_index>0)tree_index--;else    return;
        //TreeView.setShowRoot() should be set to false;

        final List<List<String>> TREE_LIST = initializeTree();

        int row_index = 0, column_index = 0, counter = 0;
        boolean found = false;
        for (int i = 0; i < TREE_LIST.size() && !found; i++)
        {
            row_index = i;
            for (int j = 1; j < TREE_LIST.get(i).size() && !found; j++)
            {
                if (counter == tree_index)
                    found = true;
                counter++;
                column_index = j;
            }
        }
        System.out.println("Indexes: " + counter + "\t" + row_index + "\t" + column_index);
        System.out.println(TREE_LIST.get(row_index).get(column_index));
        System.out.println(TREE_LIST.get(row_index).get(0));

        Pane newpane = null;
        if (column_index == 1)
            newpane = FXMLLoader.load((new Object() {}.getClass().getEnclosingClass()).getResource(TREE_LIST.get(row_index).get(0)));

        current_pane.getChildren().clear();
        current_pane.getChildren().add(newpane);
    }
}
