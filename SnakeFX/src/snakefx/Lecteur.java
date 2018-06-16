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
 * Classe gérant le lecteur de vidéo et de musique du jeu.
 * @author remil
 */
public class Lecteur {

    private static Lecteur instance = null;                                            //Singleton
    final JFXPanel fxPanel = new JFXPanel();
    private static MediaView mv;
    private static MediaPlayer mp;
    private HashMap<String,MediaPlayer> listeMediaPlayer;                       //Multiton
    
//---------- CONSTRUCTEURS -----------------------------------------------------
    /**
    *Correspond au constructeur de la classe permettant d'initialiser le Hashmap. 
    */
    private Lecteur() {
        this.listeMediaPlayer = new HashMap<>();                                   
    }
    
//------------------------------------------------------------------------------

//---------- GETEUR/SETEUR -----------------------------------------------------

    /**
     * Si l'instance est déjà créée, la renvoie, sinon, la crée.
     * @return l'instance lecteur.
     */
    public static Lecteur get() {
        if(instance == null) {
            instance = new Lecteur();
        }
        return instance;
    }
    
//------------------------------------------------------------------------------

    /**
     * Permet de lancer une musique sans la recharger si elle est déjà en mémoire.
     * @param nomFichier correspond au nom du fichier à lire.
     * @param volume correspond au volume de lecture du fichier.
     */
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
    
    /**
     * Permet de lancer une vidéo sans la recharger si elle est déjà en mémoire.
     * @param nomFichier correspondant au fichier à lire.
     */
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
    
    /**
     * Permet de couper tous les sons en lecture.
     */
    public static void stopAllAudio() {
        for(MediaPlayer media : get().listeMediaPlayer.values()) {
            media.stop();
        }
    }
    
    /**
     * Permet de couper la vidéo en lecture.
     */
    public static void stopVideo()
    {
         Lecteur.mp.stop();
    }   
    
    /**
    * Permet de récupérer la fenêtre d'affichage de la vidéo.
    * @return la fenêtr d'affichage de la vidéo.
    */
    public static MediaView getMediaView()
    { 
        return Lecteur.mv;
    }
    
    /**
    * Permet de définir la fenêtre d'affichage de la vidéo avec ses coordonnées et sa hauteur et sa largeur.
    * @param x correspond à l'abscisse de la fenêtre.
    * @param y corrspond à l'ordonnée de la fenêtre.
    * @param hauteur correspond à la hauteur de la fenêtre.
    * @param largeur correspond à la largeur de la fenêtre.
    */
    public static void setupMediaView( double x, double y, double hauteur, double largeur) //435, -235, 300, 300
    {
        Lecteur.mv = new MediaView();  
        Lecteur.mv.setFitHeight(hauteur);
        Lecteur.mv.setFitWidth(largeur);
        Lecteur.mv.setTranslateX(x);
        Lecteur.mv.setTranslateY(y);
    }
}
