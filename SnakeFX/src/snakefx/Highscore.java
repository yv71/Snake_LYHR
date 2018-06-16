/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakefx;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Beelzed
 */
public class Highscore implements Serializable{
    private int score;
    private String nomJoueur;
    private int numHighscore;
    
    public Highscore(int score, String nomJoueur, int numHighscore){
        this.score = score;
        this.nomJoueur = nomJoueur;
        this.numHighscore = numHighscore;
    }
    
    public void saveMe() throws FileNotFoundException, IOException{
        FileOutputStream file = new FileOutputStream("Higschore"+numHighscore+".dat");
        ObjectOutputStream os = new ObjectOutputStream(file);
        os.writeObject(this);
        os.flush();
        os.close();       
    }
    
    public void loadMe(String nomFichier) throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream file = new FileInputStream(nomFichier+".dat");
        ObjectInputStream os = new ObjectInputStream(file);
        Highscore load = (Highscore) os.readObject();     
        this.score = load.getScore();
        this.nomJoueur = load.getNomJoueur();
        this.numHighscore = load.getNumHighscore();
    }

    public int getScore() {
        return score;
    }

    public String getNomJoueur() {
        return nomJoueur;
    }

    public int getNumHighscore() {
        return numHighscore;
    }    
    
}
