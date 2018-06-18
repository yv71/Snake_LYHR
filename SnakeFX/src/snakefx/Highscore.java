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
import java.util.ArrayList;

/**
 *
 * @author Beelzed
 */
public class Highscore implements Serializable {

    private String nomJoueur;
    private String nomJoueur2;
    private String nomJoueur3;

    private int highscore1;
    private int highscore2;
    private int highscore3;

    public Highscore() {

    }

    /**
     * Méthode permettant la sauvegarde du fichier Highscore contenant les informations des meilleurs scores du jeu
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void saveMe() throws FileNotFoundException, IOException {
        FileOutputStream file = new FileOutputStream("Highscore.dat");
        ObjectOutputStream os = new ObjectOutputStream(file);
        os.writeObject(this);
        os.flush();
        os.close();
    }

    /**
     * Méthode permettant le chargement du fichier de sauvegarde Highscore contenant les informations des meilleurs scores du jeu
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public void loadMe() throws FileNotFoundException, IOException, ClassNotFoundException {
        try {
            FileInputStream file = new FileInputStream("Highscore.dat");
            ObjectInputStream os = new ObjectInputStream(file);
            Highscore load = (Highscore) os.readObject();
            this.nomJoueur = load.getNomJoueur();
            this.highscore1 = load.getHighscore1();
            this.nomJoueur2 = load.getNomJoueur2();
            this.highscore2 = load.getHighscore2();
            this.nomJoueur3 = load.getNomJoueur3();
            this.highscore3 = load.getHighscore3();
        } catch (FileNotFoundException e) {
            
        }

    }

    public String getNomJoueur() {
        return nomJoueur;
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    public String getNomJoueur2() {
        return nomJoueur2;
    }

    public void setNomJoueur2(String nomJoueur2) {
        this.nomJoueur2 = nomJoueur2;
    }

    public String getNomJoueur3() {
        return nomJoueur3;
    }

    public void setNomJoueur3(String nomJoueur3) {
        this.nomJoueur3 = nomJoueur3;
    }

    public int getHighscore1() {
        return highscore1;
    }

    public void setHighscore1(int highscore1) {
        this.highscore1 = highscore1;
    }

    public int getHighscore2() {
        return highscore2;
    }

    public void setHighscore2(int highscore2) {
        this.highscore2 = highscore2;
    }

    public int getHighscore3() {
        return highscore3;
    }

    public void setHighscore3(int highscore3) {
        this.highscore3 = highscore3;
    }

}
