/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablefx;

import control.PersonTableUtil;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Person;

/**
 *
 * @author Администратор
 */
public class TableFx extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        //create a table view with a list of persons
        TableView <Person> table = new TableView<>(PersonTableUtil.getPersonList());
        
        //add a columns to table
        table.getColumns().addAll(PersonTableUtil.getIdColumn(),
                                    PersonTableUtil.getFirstNameColumn(),
                                    PersonTableUtil.getLastNameColumn(),
                                    PersonTableUtil.getBirthDate());
        
        System.out.println(table.getVisibleLeafColumns());
        
        BorderPane root = new BorderPane(table);                
        Scene scene = new Scene(root, 1024,768);        
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
