/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testrc;

import io.reactivex.Observable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author drging
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button button;
    
    private static double x =0;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Observable<Double> cr=get();
        new Thread(()->{
        cr.subscribe(x->{button.setLayoutX(x);});
        }).start();
    }    
    @FXML
    void test(MouseEvent e) {
            //button.setLayoutX(e.getSceneX());
            //label.setLayoutX(e.getSceneX());
            //button.setLayoutY(e.getSceneY());
        x=e.getSceneX();
        //cr.subscribe(x->{button.setLayoutX(x);});
    }
    public static Observable<Double> get()
    {
        Observable<Double> obs =  Observable.<Double>create(s->{
        System.out.println("osb1");
        while(true)
        {s.onNext(x);
            //Thread.sleep(1000);
            System.out.println("ok");
        }
    });
        return obs;
    }
}
