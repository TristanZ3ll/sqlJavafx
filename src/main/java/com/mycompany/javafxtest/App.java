package com.mycompany.javafxtest;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.geometry.Pos; 
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 
import javafx.scene.control.Button;
//import java.sql.*;




/**
 * JavaFX App
 */
public class App extends Application {

    public static Connection conn();
    create table Staff ( id char(9) not
    null, lastName varchar(15),
    firstName varchar(15),
    mi char(1), address varchar(20),
    city varchar(20), state char(2),
    telephone char(10), email
    varchar(40));
    
    
    ALTER TABLE Staff ADD CONSTRAINT clr_prmrykey (id);
    
    
    @Override
    public void start(Stage stage) {
        
        
        var IDLabel = new Label("ID");
        var LNLabel = new Label("Last Name");
        var addLabel = new Label("Address");
        var FNLabel = new Label("First Name");
        var mLabel = new Label("Mi");
        var cityLabel = new Label("City");
        var stateLabel = new Label("State");
        var tLabel = new Label("Telephone");
        
        TextField IDtf = new TextField();
        TextField LNtf = new TextField();
        TextField addtf = new TextField();
        TextField FNtf = new TextField();
        TextField mtf = new TextField();
        TextField citytf = new TextField();
        TextField statetf = new TextField();
        TextField ttf = new TextField();
        
        Button View = new Button("View");
        Button Insert = new Button("Insert");
        Button Update = new Button("Update");
        Button Clear = new Button("Clear");
        
         GridPane gridPane = new GridPane();    
      
      //Setting size for the pane  
      gridPane.setMinSize(400, 200); 
       
      //Setting the padding  
      gridPane.setPadding(new Insets(10, 10, 10, 10)); 
      
      //Setting the vertical and horizontal gaps between the columns 
      gridPane.setVgap(5); 
      gridPane.setHgap(5);       
      
      //Setting the Grid alignment 
      gridPane.setAlignment(Pos.CENTER); 
        
      
      gridPane.add(IDLabel,0,0);
      gridPane.add(IDtf,1,0);
      gridPane.add(LNLabel,0,1);
      gridPane.add(LNtf,1,1);
      gridPane.add(addLabel,0,2);
      gridPane.add(addtf,1,2);
      gridPane.add(FNLabel,0,3);
      gridPane.add(FNtf, 1, 3);
      gridPane.add(mLabel,2,4);
      gridPane.add(mtf,3,4);
      gridPane.add(cityLabel,0,4);
      gridPane.add(citytf,1,4);
      gridPane.add(stateLabel,0,5);
      gridPane.add(statetf,1,5);
      gridPane.add(tLabel,0,6);
      gridPane.add(ttf,1,6);
      
      gridPane.add(View,0,8);
      gridPane.add(Insert,1,8);
      gridPane.add(Update,2,8);
      gridPane.add(Clear,3,8);
      
      EventHandler<ActionEvent> clearEvent = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
                IDtf.clear();
                LNtf.clear();
                addtf.clear();
                FNtf.clear();
                mtf.clear();
                citytf.clear();
                statetf.clear();
                ttf.clear();
            } 
        }; 
      
      EventHandler<ActionEvent> viewEvent = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            {
                select firstName, mi, lastName
                        from Staff where id = idtf;
            } 
        }; 
      
      EventHandler<ActionEvent> updateEvent = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
                update Staff set firstName = FNtb, lastName= lntb, mi = mtb, id = idtb,address = addtb, cty = citytb, state=statetb, telephone = ttb
                            where id = idtb;
            } 
        }; 
      
      EventHandler<ActionEvent> insertEvent = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
                Insert into Staff (id, lastName, firstName, mi, address, city, state, telephone) values (IDtf, LNtf, FNtf, mtf,addtf,citytf,statetf,ttf,);
            } 
        }; 
      
      Clear.setOnAction(clearEvent);
      View.setOnAction(viewEvent);
      Insert.setOnAction(insertEvent);
      Update.setOnAction(updateEvent);
      
        var scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}