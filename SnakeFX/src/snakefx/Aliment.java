/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakefx;

import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author lk365606
 */
public class Aliment {
    int x;
    int y;
    int point;
    Jouable jeu;
    private ArrayList<ImageIcon> ressourcesAliment;

    public Aliment(Jouable jeu, int x, int y) {
        point=50;
        this.jeu = jeu;
        ressourcesAliment = new ArrayList<>();
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public ArrayList<ImageIcon> getRessourcesAliment() {
        return ressourcesAliment;
    }
    
    public void addImage(ImageIcon e){
        this.ressourcesAliment.add(e);
    }
}
