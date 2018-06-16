package snakefx;


import java.util.ArrayList;
import javax.swing.ImageIcon;
import snakefx.Direction;
import snakefx.Jouable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Classe correspondant au joueur avec un corps (une liste d'objets corps) et une tête, un nombre de déplacement et un score, ainsi qu'une liste de ressources d'images pour les parties de son corps.
 * @author lk365606
 */
public class Joueur {
    private ArrayList<ObjetCorps> serpent;
    private Tete tete;
    private int deplacement;
    private int score;
    private ArrayList<ImageIcon> ressourcesCorps;
    Jouable jeu;
    
    /**
     * Constructeur de la classe permettant d'initialiser les variables.
     * @param jeu correspond au jeu auquel le joueur est affilié.
     */ 
    public Joueur(Jouable jeu){
        serpent = new ArrayList<>();
        deplacement = 0;
        score = 0;
        initialisation();
        tete =(Tete) serpent.get(0);
        ressourcesCorps = new ArrayList<>();
        this.jeu = jeu;
    }
    
    /**
     * Permet d'initialiser le corps du serpent en créant une tête puis deux parties du corps et en les ajoutant au tableau.
     */
    private void initialisation(){
        serpent.add(new Tete(100,125,this));
        serpent.add(new PartieCorps(75,125,this));
        serpent.add(new PartieCorps(50,125,this));
    }
    
    /**
     * Permet d'ajouter une partie du corps à la liste de parties de corps du joueur en lui attribuant les coordonnées de celle qui la précède.
     */
    public void ajouterPartieCorps(){
        int x = serpent.get(serpent.size()-1).getX();
        int y = serpent.get(serpent.size()-1).getY();
        serpent.add(new PartieCorps(x,y,this));
    }

    /**
     * Permet de récupérer les différents objets composant le serpent.
     * @return le tableau contenant les différents objets composant le serpent.
     */
    public ArrayList<ObjetCorps> getSerpent() {
        return serpent;
    }

    /**
     * Permet de récupérer la tête du serpent.
     * @return la tête du serpent, le premier élément du tableau d'éléments du corps.
     */
    public Tete getTete() {
        return tete;
    }

    /**
     * Permet de récupérer le nombre de déplacements du joueur.
     * @return le nombre de déplacements du joueur.
     */
    public int getDeplacement() {
        return deplacement;
    }

    /**
     * Permet de changer la valeur du nombre de déplacements du joueur.
     * @param deplacement correspond à la nouvelle valeur du nombre de déplacements du joueur.
     */
    public void setDeplacement(int deplacement) {
        this.deplacement = deplacement;
    }

    /**
     * Permet de récupérer le score du joueur.
     * @return le score du joueur.
     */
    public int getScore() {
        return score;
    }

    /**
     * Permet de changer le score du joueur.
     * @param score correspond à la nouvelle valeur du score du joueur.
     */
    public void setScore(int score) {
        this.score = score;
    }
    
    /**
     * Permet d'incrémenter de 1 le nombre de déplacements.
     */
    public void increaseDeplacement(){
        deplacement++;
    }
    
    /**
     * Permet d'incrémenter le score d'une certaine valeur.
     * @param i correspond à la valeur à ajouter au score du joueur.
     */
    public void addScore(int i){
        score +=i;
    }

    /**
     * Permet d'ajouter une ressource d'images à la liste de ressources d'images.
     * @param e correspond à l'image à ajouter.
     */
    public void addCorps(ImageIcon e){
        this.ressourcesCorps.add(e);
    }
    
    /**
     * Permet de récupérer la liste de ressources d'images du corps.
     * @return la liste de ressources d'images du corps.
     */
    public ArrayList<ImageIcon> getRessourceCorps(){
        return this.ressourcesCorps;
    }
}
            