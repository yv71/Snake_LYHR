package snakefx;


import java.util.ArrayList;
import javax.swing.ImageIcon;
import snakefx.Direction;
import static snakefx.Direction.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lk365606
 */
public class Tete extends ObjetCorps{
    private ArrayList<ImageIcon> teteBas;
    private ArrayList<ImageIcon> teteDroite;
    private ArrayList<ImageIcon> teteGauche;
    private ArrayList<ImageIcon> teteHaut;
    
    /*private ImageIcon teteDroite;
    private ImageIcon teteGauche;
    private ImageIcon teteHaut;
    private ImageIcon teteBas;*/
    private Direction dir;

    public Tete(int X, int Y, Joueur j) {
        super(X, Y, j);
        dir = debut;
        teteBas = new ArrayList<>();
        teteDroite = new ArrayList<>();
        teteGauche = new ArrayList<>();
        teteHaut = new ArrayList<>();
    }

    public ArrayList<ImageIcon> getTeteBas() {
        return teteBas;
    }

    public void setTetebas(ArrayList<ImageIcon> tetebas) {
        this.teteBas = tetebas;
    }

    public ArrayList<ImageIcon> getTeteDroite() {
        return teteDroite;
    }

    public void setTeteDroite(ArrayList<ImageIcon> teteDroite) {
        this.teteDroite = teteDroite;
    }

    public ArrayList<ImageIcon> getTeteGauche() {
        return teteGauche;
    }

    public void setTeteGauche(ArrayList<ImageIcon> teteGauche) {
        this.teteGauche = teteGauche;
    }

    public ArrayList<ImageIcon> getTeteHaut() {
        return teteHaut;
    }

    public void setTeteHaut(ArrayList<ImageIcon> teteHaut) {
        this.teteHaut = teteHaut;
    }

    public Direction getDir() {
        return dir;
    }
    
    public void setDir(Direction dir){
        this.dir=dir;
    }
    
    public void addTeteHaut(ImageIcon e){
        this.teteHaut.add(e);
    }
    
    public void addTeteBas(ImageIcon e){
        this.teteBas.add(e);
    }
    
    public void addTeteDroite(ImageIcon e){
        this.teteDroite.add(e);
    }
    
    public void addTeteGauche(ImageIcon e){
        this.teteGauche.add(e);
    }
}
