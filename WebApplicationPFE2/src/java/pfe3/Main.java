package pfe3;
	
import com.jfoenix.controls.JFXHamburger;
import java.io.IOException;
import javafx.application.Application;
import javafx.beans.Observable;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;



public class Main extends Application {
     private static FXMLLoader loader;
	@Override
	public void start(Stage primaryStage) {
		try {    
                    loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("fenetrexml.fxml")); 
                   
                    loader.load();
                    
			//Pane root= FXMLLoader.load(getClass().getResource("fenetrexml.fxml"));
                         
                        Pane root=loader.getRoot();
                       root.getStyleClass().add("ok");
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setHeight(600);
			primaryStage.setWidth(800);
			primaryStage.setMinWidth(800);
			primaryStage.setMinHeight(600);
			Control.setStage(primaryStage);
                        
                        
                        
                        
                        
                        primaryStage.heightProperty().addListener((Observable e) -> {
                             // System.out.println("pfe2.Main.start()");
                            Control c = loader.getController();
                            c.SetVisible(false);
                             
                             
                             Label lbl = (Label) scene.lookup("#lbl");
                             lbl.setLayoutY(primaryStage.getHeight()-70);
                            Line axe = (Line) scene.lookup("#axe");
                            axe.setStartY(primaryStage.getHeight()/2.0);
                            axe.setEndY(axe.getStartY());
                            Line R = (Line) scene.lookup("#R");
                            
                            R.setEndY(axe.getStartY()-5);
                            R.setStartY(R.getEndY()-30);
                         Circle f1 = (Circle) scene.lookup("#f1");
                         Circle f2 = (Circle) scene.lookup("#f2");
                         f1.setLayoutY(axe.getStartY());
                         double mil=((axe.getEndX()-10)/2.0);
                       //  f1.setLayoutX(mil-20);
                         f2.setLayoutY(f1.getLayoutY());
                     //    f2.setLayoutX(mil+20);
                          Line op = (Line) scene.lookup("#op");
                         // op.setStartX(mil);
                       //   op.setEndX(mil);
                          op.setEndY(primaryStage.getHeight()-50);
                          op.setStartY(50);
                        Line   op2= (Line) scene.lookup("#Miroire");
                       op2.setEndY((primaryStage.getHeight()/2)+70);
//                         Line M=(Line) scene.lookup("#M1");
//                         M.setLayoutX(op2.getStartX()-8);
                         
                       Line M=(Line) scene.lookup("#M2");
                        M.setLayoutY(op2.getEndY()+10);
                        
                          
                          
                         Arc arc = (Arc) scene.lookup("#arc");
                         Arc arc1 = (Arc) scene.lookup("#arc1");
                         Arc arc2 = (Arc) scene.lookup("#arc2");
                         Arc arc3 = (Arc) scene.lookup("#arc3");
                       //  arc.setLayoutX(R.getEndX()-1);
                         arc.setLayoutY(R.getStartY()-22);
                         arc1.setLayoutY(op.getStartY()-4);
                        // arc1.setLayoutX(mil);
                        // arc2.setLayoutX(mil);
                         arc2.setLayoutY(op.getEndY()+4);
                         Line R2 = (Line) scene.lookup("#R2");
                         R2.setStartY(axe.getEndY());
                         R2.setEndY(axe.getEndY()+75);
                       //  R2.setStartX(mil+150);
                      //   R2.setEndX(mil+150);
                       //  arc3.setLayoutX(R2.getStartX()-1);
                         arc3.setLayoutY(R2.getEndY()-7);
                         
                         ImageView img = (ImageView) scene.lookup("#img");
                         img.setFitHeight(primaryStage.getHeight());
                         
                        
                        });
                        
                        
                        
                        
                        
                        
                        
                        primaryStage.widthProperty().addListener((Observable e) -> {
                             // System.out.println("pfe2.Main.start()");
                            Control c = loader.getController();
                            c.SetVisible(false);
                            
                            
                            Line axe = (Line) scene.lookup("#axe");
                            axe.setEndX(primaryStage.getWidth()-10);
                            
                         Circle f1 = (Circle) scene.lookup("#f1");
                         Circle f2 = (Circle) scene.lookup("#f2");
                         double mil=((axe.getEndX()-10)/2.0);
                         f1.setLayoutX(mil-20);
                         f2.setLayoutX(mil+20);
                          Line op = (Line) scene.lookup("#op");
                          op.setStartX(mil);
                          op.setEndX(mil);
                         op= (Line)scene.lookup("#Miroire");
                         op.setStartX(mil);
                         op.setEndX(mil);
                         
                         
                           Line M=(Line) scene.lookup("#M1");
                         M.setLayoutX(op.getStartX()-8);
                         
                        M=(Line) scene.lookup("#M2");
                        M.setLayoutX(op.getStartX()-8);
                        
                         
                         
                         Arc arc = (Arc) scene.lookup("#arc");
                         Arc arc1 = (Arc) scene.lookup("#arc1");
                         Arc arc2 = (Arc) scene.lookup("#arc2");
                         Arc arc3 = (Arc) scene.lookup("#arc3");
                        
                        
                       
                         arc1.setLayoutX(mil);
                         arc2.setLayoutX(mil);
                    
                         Line R2 = (Line) scene.lookup("#R2");
                     
                         R2.setStartX(mil+150);
                         R2.setEndX(mil+150);
                         arc3.setLayoutX(R2.getStartX()-1);
                         JFXHamburger   hamburger= (JFXHamburger) scene.lookup("#hamburger");
                         hamburger.setLayoutX(primaryStage.getWidth()-45);
                         
                            ImageView img = (ImageView) scene.lookup("#img");
                            img.setFitWidth(primaryStage.getWidth());
                         
                        
                        });
                        
                        
                        //Control.setP(root);
		} catch(IOException e) {
		}
                
                
      
	}
       
        
       public static FXMLLoader getCtl()
      {
          return loader;
      }
        
        
        
	
	public static void main() {
		launch();
	}
        
        
    
        
}
