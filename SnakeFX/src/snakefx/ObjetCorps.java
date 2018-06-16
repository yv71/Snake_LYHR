package snakefx;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Classe correspondant à un élément du corps avec une abscisse, une ordonnée et un joueur attitré.
 * @author lk365606
 */
public class ObjetCorps {
    private int X;
    private int Y;
    private Joueur j;

    /**
     * Constructeur de la classe.
     * @param X correspond à l'abscisse du nouveau composant.
     * @param Y correspond à l'ordonnée du nouveau composant.
     * @param j correspond au joueur auquel le nouveau composant est affilié.
     */
    public ObjetCorps(int X, int Y, Joueur j) {
        this.X = X;
        this.Y = Y;
        this.j = j;
    }

    /**
     * Permet de récupérer l'abscisse de l'objet.
     * @return l'abscisse de l'objet.
     */
    public int getX() {
        return X;
    }

    /**
     * Permet de changer la valeur de l'abscisse de l'objet.
     * @param X correspond à la nouvelle valeur de l'abscisse de l'objet.
     */
    public void setX(int X) {
        this.X = X;
    }

    /**
     * Permet de récupérer l'ordonnée de l'objet.
     * @return l'ordonnée de l'objet.
     */
    public int getY() {
        return Y;
    }

    /**
     * Permet de changer la valeur de l'ordonnée de l'objet.
     * @param Y correspond à la nouvelle ordonnée de l'objet.
     */
    public void setY(int Y) {
        this.Y = Y;
    }
}
