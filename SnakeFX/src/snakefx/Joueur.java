package snakefx;


import java.util.ArrayList;
import snakefx.Direction;
import snakefx.Jouable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lk365606
 */
public class Joueur {
    private ArrayList<ObjetCorps> serpent;
    /*private int[]positionSnakeX = new int [750];
    private int[]posoitionSnakeY = new int [750];*/
    private int tailleCorps;
    private Tete tete;
    private int deplacement;
    private int score;
   
    
    public Joueur(Jouable jeu){
        serpent = new ArrayList<>();
        tailleCorps = 3;
        deplacement = 0;
        score = 0;
        initialisation();
        tete =(Tete) serpent.get(0);
    }
    
    private void initialisation(){
        serpent.add(new Tete(100,125,this));
        serpent.add(new PartieCorps(75,125,this));
        serpent.add(new PartieCorps(50,125,this));
    }
    
    public void ajouterPartieCorps(){
        int x = serpent.get(serpent.size()-1).getX();
        int y = serpent.get(serpent.size()-1).getY();
        serpent.add(new PartieCorps(x,y,this));
        this.increaseTaille();
    }

    public ArrayList<ObjetCorps> getSerpent() {
        return serpent;
    }

    public void setSerpent(ArrayList<ObjetCorps> serpent) {
        this.serpent = serpent;
    }

    public int getTailleCorps() {
        return tailleCorps;
    }

    public void setTailleCorps(int tailleCorps) {
        this.tailleCorps = tailleCorps;
    }

    public Tete getTete() {
        return tete;
    }

    public void setTete(Tete tete) {
        this.tete = tete;
    }

    public int getDeplacement() {
        return deplacement;
    }

    public void setDeplacement(int deplacement) {
        this.deplacement = deplacement;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    public void increaseDeplacement(){
        deplacement++;
    }
    
    public void addScore(int i){
        score +=i;
    }
    
    public void increaseTaille(){
        tailleCorps++;
    }
}
            
