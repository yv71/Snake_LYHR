/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakefx;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 * Classe correspondant à un aliment du jeu.
 * @author lk365606
 */
public class Aliment {
    private int x;
    private int y;
    private int point;
    private Jouable jeu;
    private Random aleatoire;
    private ArrayList<ImageIcon> ressourcesAliment;

    /**
     * Constructeur d'un aliment. De base, l'aliment donne 50 points et comprend une liste vide de ressources d'images.
     * @param jeu correspond au jeu auquel l'aliment est lié.
     */
    public Aliment(Jouable jeu) {
        point=50;
        aleatoire = new Random();
        this.jeu = jeu;
        ressourcesAliment = new ArrayList<>();
        this.placementAleatoire();
    }

    /**
     * Permet de récupérer l'abscisse de l'aliment.
     * @return l'abscisse de l'aliment.
     */
    public int getX() {
        return x;
    }

    /**
     * Permet de modifier l'abscisse de l'aliment.
     * @param x correspond à la nouvelle valeur d'abscisse de l'aliment.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Pemet de récupérer l'ordonnée de l'aliment.
     * @return l'ordonnée de l'aliment.
     */
    public int getY() {
        return y;
    }

    /**
     * Permet de modifier l'ordonnée de l'aliment.
     * @param y correspond à la nouvelle valeur d'ordonnée de l'aliment.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Permet de récupérer le nombre de points que rapporte l'aliment.
     * @return le nombre de points rapportés par l'aliment.
     */
    public int getPoint() {
        return point;
    }

    /**
     * Permet de changer la valeur du nombre de points rapportés par l'aliment.
     * @param point correspond à la nouvelle valeur de nombre de points rapportés par l'aliment.
     */
    public void setPoint(int point) {
        this.point = point;
    }

    /**
     * Permet de récupérer les ressources images de l'aliment.
     * @return le tableau de ressources images de l'aliment.
     */
    public ArrayList<ImageIcon> getRessourcesAliment() {
        return ressourcesAliment;
    }
    
    /**
     * Permet d'ajouter une image à la liste des ressources images de l'aliment.
     * @param e correspond à l'image à ajouter à la liste.
     */
    public void addImage(ImageIcon e){
        this.ressourcesAliment.add(e);
    }
    
    /**
     * Permet de changer de manière aléatoire l'abscisse et l'ordonnée de l'aliment.
     */
    public void placementAleatoire(){
        this.setX(aleatoire.nextInt(33)*25+25);
        this.setY(aleatoire.nextInt(22)*25+100);
    }
}
