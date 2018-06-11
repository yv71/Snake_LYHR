/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakefx;

import java.net.URL;
import java.util.HashMap;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 *
 * @author remil
 */
public class Lecteur {

    private static Lecteur instance = null;                                            //Singleton
     final JFXPanel fxPanel = new JFXPanel();
    private static MediaView mv;
    private static MediaPlayer mp;
    private HashMap<String,MediaPlayer> listeMediaPlayer;                       //Multiton
    
//---------- CONSTRUCTEURS -----------------------------------------------------

    Lecteur() {
        this.listeMediaPlayer = new HashMap<>();                                   
    }
    
//------------------------------------------------------------------------------

//---------- GETEUR/SETEUR -----------------------------------------------------

    //Geteur du singleton
    public static Lecteur get() {
        if(instance == null) {
            instance = new Lecteur();
        }
        return instance;
    }
    
//------------------------------------------------------------------------------

    //Lance une musique (sans la recharger si elle est déjà en mémoire)
    public static void play(String nomFichier,double volume) {
        if(get().listeMediaPlayer.get(nomFichier) == null) {
            URL url = Lecteur.class.getResource(nomFichier);
            Media media = new Media(url.toExternalForm());
            get().listeMediaPlayer.put(nomFichier, new MediaPlayer(media));
        }
        get().listeMediaPlayer.get(nomFichier).setVolume(volume);
        get().listeMediaPlayer.get(nomFichier).stop();
        get().listeMediaPlayer.get(nomFichier).play();
    }
     public static void playVideo(String nomFichier) {
        if(get().listeMediaPlayer.get(nomFichier) == null) {
            URL url = Lecteur.class.getResource(nomFichier);
            Media media = new Media(url.toExternalForm());
           
            MediaPlayer mediaplayer = new MediaPlayer(media);
            get().listeMediaPlayer.put(nomFichier, mediaplayer);
            Lecteur.mp = mediaplayer;
            Lecteur.mv.setMediaPlayer(mediaplayer);
        }
        
        
        Lecteur.mp.stop();
        Lecteur.mp.play();
    }
     public static void stopAllAudio() {
        for(MediaPlayer media : get().listeMediaPlayer.values()) {
            media.stop();
        }
    }
     public static void stopVideo()
     {
         Lecteur.mp.stop();
     }   
     public static MediaView getMediaView()
     { 
         return Lecteur.mv;
     }
     public static void setupMediaView( double x, double y, double hauteur, double largeur) //435, -235, 300, 300
     {
            Lecteur.mv = new MediaView();  
            Lecteur.mv.setFitHeight(hauteur);
            Lecteur.mv.setFitWidth(largeur);
            Lecteur.mv.setTranslateX(x);
            Lecteur.mv.setTranslateY(y);
     }
     
    
    
}
