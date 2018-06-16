package snakefx;


import java.util.ArrayList;
import javax.swing.ImageIcon;
import snakefx.Direction;
import static snakefx.Direction.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Correspond à la tête du serpent, qui est un objet du corps, correspondant au joueur avec une direction et différentes listes de ressources d'images selon sa direction.
 * @author lk365606
 */
public class Tete extends ObjetCorps{
    private ArrayList<ImageIcon> teteBas;
    private ArrayList<ImageIcon> teteDroite;
    private ArrayList<ImageIcon> teteGauche;
    private ArrayList<ImageIcon> teteHaut;
    private Direction dir;

    /**
     * Constructeur de la classe tête permettant d'initialiser les listes de ressources ainsi que la direction et position de la tête.
     * @param X correspond à l'abscisse de la tête.
     * @param Y correspond à l'ordonnée de la tête.
     * @param j correspond au joueur auquel la tête est affiliée.
     */
    public Tete(int X, int Y, Joueur j) {
        super(X, Y, j);
        dir = debut;
        teteBas = new ArrayList<>();
        teteDroite = new ArrayList<>();
        teteGauche = new ArrayList<>();
        teteHaut = new ArrayList<>();
    }

    /**
     * Permet de récupérer la liste de ressources d'images de la tête lorsqu'elle est dirigée vers le bas.
     * @return la liste de ressources d'images de la tête lorsqu'elle est dirigée vers le bas.
     */
    public ArrayList<ImageIcon> getTeteBas() {
        return teteBas;
    }

    /**
     * Permet de récupérer la liste de ressources d'images de la tête lorsqu'elle est dirigée vers la droite.
     * @return la liste de ressources d'images de la tête lorsqu'elle est dirigée vers la droite.
     */
    public ArrayList<ImageIcon> getTeteDroite() {
        return teteDroite;
    }

    /**
     * Permet de récupérer la liste de ressources d'images de la tête lorsqu'elle est dirigée vers la gauche.
     * @return la liste de ressources d'images de la tête lorsqu'elle est dirigée vers la gauche.
     */
    public ArrayList<ImageIcon> getTeteGauche() {
        return teteGauche;
    }

    /**
     * Permet de récupérer la liste de ressources d'images de la tête lorsqu'elle est dirigée vers le haut.
     * @return la liste de ressources d'images de la tête lorsqu'elle est dirigée vers le haut.
     */
    public ArrayList<ImageIcon> getTeteHaut() {
        return teteHaut;
    }

    /**
     * Permet de récupérer la direction de la tête du serpent.
     * @return la direction de la tête du serpent.
     */
    public Direction getDir() {
        return dir;
    }
    
    /**
     * Permet de modifier la direction de la tête du serpent.
     * @param dir correspond à la nouvelle direction de la tête du serpent.
     */
    public void setDir(Direction dir){
        this.dir=dir;
    }
    
    /**
     * Permet d'ajouter une nouvelle ressource image lorsque la tête est dirigée vers le haut.
     * @param e correspond à la nouvelle ressource image.
     */
    public void addTeteHaut(ImageIcon e){
        this.teteHaut.add(e);
    }
    
    /**
     * Permet d'ajouter une nouvelle ressource image lorsque la tête est dirigée vers le bas.
     * @param e correspond à la nouvelle ressource image.
     */
    public void addTeteBas(ImageIcon e){
        this.teteBas.add(e);
    }
    
    /**
     * Permet d'ajouter une nouvelle ressource image lorsque la tête est dirigée vers la droite.
     * @param e correspond à la nouvelle ressource image.
     */
    public void addTeteDroite(ImageIcon e){
        this.teteDroite.add(e);
    }
    
    /**
     * Permet d'ajouter une nouvelle ressource image lorsque la tête est dirigée vers la gauche.
     * @param e correspond à la nouvelle ressource image.
     */
    public void addTeteGauche(ImageIcon e){
        this.teteGauche.add(e);
    }
}
