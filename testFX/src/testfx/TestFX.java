/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testfx;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author kingdragon
 */
public class TestFX extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       
        BorderPane root= new BorderPane();
       
        
        Scene scene = new Scene(root, 300, 250);
        
       
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(5));
        gridpane.setHgap(5);gridpane.setVgap(5);
        
        gridpane.setGridLinesVisible(true);
        gridpane.setVgap(20);
        gridpane.setHgap(30);
        
        
        ColumnConstraints colomn1 = new ColumnConstraints(100);
        ColumnConstraints colomn2 = new ColumnConstraints(50,150,300);
        colomn2.setHgrow(Priority.ALWAYS);
        gridpane.getColumnConstraints().addAll(colomn1,colomn2);
        
        
        Label lbl1=new Label("first name");
        Label lbl2=new Label("last name");
        Label dob=new Label("dob");
        
        TextField text1= new TextField();
        TextField text2= new TextField();
        TextField text3= new TextField();
        
        Button btn = new Button("save");
        
        GridPane.setHalignment(lbl1,HPos.RIGHT);
        gridpane.add(lbl1, 0, 0);
       
        
        GridPane.setHalignment(lbl2,HPos.RIGHT);
        gridpane.add(lbl2, 0, 1);
        
        GridPane.setHalignment(dob,HPos.RIGHT);
        gridpane.add(dob, 0, 2);
        
        GridPane.setHalignment(text1,HPos.RIGHT);
        gridpane.add(text1, 1, 0);
        
         GridPane.setHalignment(text2,HPos.RIGHT);
        gridpane.add(text2, 1, 1);
        
         GridPane.setHalignment(text3,HPos.RIGHT);
        gridpane.add(text3, 1, 2);
        
        
         GridPane.setHalignment(btn,HPos.RIGHT);
        gridpane.add(btn, 1, 3);
        
        
        FlowPane flow = new FlowPane();
        flow.setPrefHeight(40);
        flow.setStyle("-fx-background-color: lightblue;");
        
        Text t = new Text("Info");
        Font f = new Font("Serif", 30);
        t.setFont(f);
        t.setFill(Color.CHOCOLATE);
        
        flow.getChildren().add(t);
        root.setCenter(gridpane);
        root.setTop(flow);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UNIFIED);
        primaryStage.show();
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
