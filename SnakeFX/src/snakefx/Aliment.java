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
 *
 * @author lk365606
 */
public class Aliment {
    private int x;
    private int y;
    private int point;
    private Jouable jeu;
   private Random aleatoire;
    private ArrayList<ImageIcon> ressourcesAliment;

    public Aliment(Jouable jeu) {
        point=50;
        aleatoire = new Random();
        this.jeu = jeu;
        ressourcesAliment = new ArrayList<>();
        this.placementAleatoire();
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
    
    public void placementAleatoire(){
        this.setX(aleatoire.nextInt(33)*25+25);
        this.setY(aleatoire.nextInt(22)*25+100);
    }
}
