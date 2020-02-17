/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_ecole.Java.Gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.svg.SVGGlyph;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *
 * @author FiveHearoes
 */
public class CustomizedStage extends VBox {

    private Stage primaryStage;
    private AnchorPane Titlebar;
    private final AnchorPane MoveBar;
    private final HBox buttonsContainer;
    private final JFXButton Close;
    private final JFXButton Minus;

    private Timeline windowDecoratorAnimation;
    private Timeline Closebtn;
    private Timeline Minusbtn;

    private double xOffset = 0;
    private double yOffset = 0;

    private boolean allowMove = false;
    private boolean isDragging = false;

    public CustomizedStage(Stage stage, Node node, boolean setStyle) {
        primaryStage = stage;

        if (setStyle) {

            primaryStage.initStyle(StageStyle.UNDECORATED);
        }
        try {
            Titlebar = (AnchorPane) FXMLLoader.load(getClass().getResource("/gestion_ecole/Fxml/TitleBar.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(CustomizedStage.class.getName()).log(Level.SEVERE, null, ex);
        }
        buttonsContainer = (HBox) Titlebar.getChildren().get(0);
        SVGGlyph close = new SVGGlyph(0,
                "CLOSE",
                "M450 550H500V50Q450 0 400 50V550z M260 150 Q0 270 0 550Q0 1000 450 1000Q900 1000 900 550Q900 270 640 150Q500 150 600 240Q840 320 800 560Q900 900 450 900Q100 900 100 550Q100 340 300 340Q400 150 260 150",
                Color.web("#FFF", 0.7));
        close.setSize(24, 24);
        SVGGlyph minus = new SVGGlyph(0,
                "MINUS",
                "M50 160H300V0V160H350Q400 200 350 240H300V350V240H50Q0 200 50 160z",
                Color.web("#FFF", 0.7));
        minus.setSize(24, 24);
        Close = (JFXButton) buttonsContainer.getChildren().get(0);
        Minus = (JFXButton) buttonsContainer.getChildren().get(1);

        Close.setGraphic(close);
        Close.setOnAction((action) -> Platform.exit());
        Close.setOnMouseEntered((action) -> {
            Closebtn = new Timeline();
            Closebtn.getKeyFrames().add(new KeyFrame(Duration.millis(300), new KeyValue(close.fillProperty(), Color.web("#F44336"))));
            Closebtn.play();
        });

        Close.setOnMouseExited((action) -> {
            Closebtn = new Timeline();
            Closebtn.getKeyFrames().add(new KeyFrame(Duration.millis(300), new KeyValue(close.fillProperty(), Color.web("#FFF", 0.7))));
            Closebtn.play();
        });

        Minus.setGraphic(minus);
        Minus.setOnAction((action) -> primaryStage.setIconified(true));
        Minus.setOnMouseEntered((action) -> {
            Minusbtn = new Timeline();
            Minusbtn.getKeyFrames().add(new KeyFrame(Duration.millis(300), new KeyValue(minus.fillProperty(), Color.web("#FFF", 1))));
            Minusbtn.play();
        });

        Minus.setOnMouseExited((action) -> {
            Minusbtn = new Timeline();
            Minusbtn.getKeyFrames().add(new KeyFrame(Duration.millis(300), new KeyValue(minus.fillProperty(), Color.web("#FFF", 0.7))));
            Minusbtn.play();
        });

        MoveBar = (AnchorPane) Titlebar.getChildren().get(1);
        MoveBar.addEventHandler(MouseEvent.MOUSE_ENTERED, (enter) -> allowMove = true);
        MoveBar.addEventHandler(MouseEvent.MOUSE_EXITED, (enter) -> {
            if (!isDragging) {
                allowMove = false;
            }
        });

        MoveBar.setOnMouseDragged((mouseEvent) -> {
            isDragging = true;

            if (allowMove) {
                primaryStage.setX(mouseEvent.getScreenX() - xOffset);
                primaryStage.setY(mouseEvent.getScreenY() - yOffset);
                mouseEvent.consume();
            }
        });

        this.setOnMouseMoved((mouseEvent) -> {
            updateInitMouseValues(mouseEvent);
        });

        getChildren().addAll(Titlebar, node);
    }

    private void updateInitMouseValues(MouseEvent mouseEvent) {
        xOffset = mouseEvent.getSceneX();
        yOffset = mouseEvent.getSceneY();
    }

}
