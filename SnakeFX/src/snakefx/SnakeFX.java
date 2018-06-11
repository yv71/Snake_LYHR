/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakefx;

import java.awt.Color;
import java.awt.Graphics;
import java.net.URL;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;

/**
 *
 * @author remil
 */
public class SnakeFX extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
         Lecteur.setupMediaView(435, -235, 300, 300);
        final SwingNode swingNode = new SwingNode();    
        Jouable jeu = new Jouable();
        swingNode.setContent(jeu);
        swingNode.setTranslateX(0);
        swingNode.setTranslateY(0);
        root.getChildren().add(swingNode);
         
      
       
        root.getChildren().add(Lecteur.getMediaView());
        
       
        
        Scene scene = new Scene(root, 1200, 680);  
        primaryStage.setTitle("Snake"); 
        primaryStage.setResizable(false);
        primaryStage.setOnCloseRequest(e -> Platform.exit());
        primaryStage.setScene(scene);
        primaryStage.setX(10);
        primaryStage.setY(10);
        primaryStage.show();
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
          public void handle(WindowEvent we) {
              jeu.stopTimer();
          }
      });        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
