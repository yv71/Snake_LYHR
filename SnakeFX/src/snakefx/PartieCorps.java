package snakefx;


import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Classe correspondant à une partie du corps avec une abscisse et une ordonnée.
 * @author lk365606
 */
public class PartieCorps extends ObjetCorps{

    /**
     * Constructeur de la classe.
     * @param X correspond à l'abscisse de la partie du corps.
     * @param Y correspond à l'ordonnée de la partie du corps.
     * @param j correspond au joueur auquel la partie du corps est affiliée.
     */
    public PartieCorps(int X, int Y, Joueur j) {
        super(X, Y, j);
    }
}
