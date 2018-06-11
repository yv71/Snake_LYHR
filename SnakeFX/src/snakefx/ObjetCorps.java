package snakefx;


import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lk365606
 */
public class ObjetCorps {
    private int X;
    private int Y;
    private Joueur j;

    public ObjetCorps(int X, int Y, Joueur j) {
        this.X = X;
        this.Y = Y;
        this.j = j;
    }

 
    public int getX() {
        return X;
    }

    public void setX(int X) {
        this.X = X;
    }

    public int getY() {
        return Y;
    }

    public void setY(int Y) {
        this.Y = Y;
    }
    
    
}
