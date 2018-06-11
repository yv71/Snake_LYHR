/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakefx;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import static snakefx.Direction.*;

/**
 *
 * @author remil
 */
public class Jouable extends JPanel implements KeyListener, ActionListener{
    private boolean start = true;
    private boolean gameover = false;
    
    //tableaux représentants les aliments (une image faisant 25px explique que les éléments des tableaux soit des multiples de 25)
    private int[]alimentposX = {25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475, 500, 525, 550, 575, 600, 625, 650, 675, 700, 725, 750, 775, 800, 825, 850};
    private int[]alimentposY = {100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475, 500, 525, 550, 575, 600, 625, 650};
         
     private ImageIcon aliment;
     
     private ImageIcon smiley;
     private ImageIcon ImageTitre;
     private ImageIcon Imagesolo;
     
     private ImageIcon RessourceTeteDroite1 = new ImageIcon(Jouable.class.getResource("RessourcesImg/Tete/tete_right.png"));
     private ImageIcon RessourceTeteDroite2 = new ImageIcon(Jouable.class.getResource("RessourcesImg/Tete/tete_right2.png"));
     private ImageIcon RessourceTeteGauche1 = new ImageIcon(Jouable.class.getResource("RessourcesImg/Tete/tete_left.png"));
     private ImageIcon RessourceTeteGauche2 = new ImageIcon(Jouable.class.getResource("RessourcesImg/Tete/tete_left2.png"));
     private ImageIcon RessourceTeteHaut1 = new ImageIcon(Jouable.class.getResource("RessourcesImg/Tete/tete_up.png"));
     private ImageIcon RessourceTeteHaut2 = new ImageIcon(Jouable.class.getResource("RessourcesImg/Tete/tete_up2.png"));
     private ImageIcon RessourceTeteBas1 = new ImageIcon(Jouable.class.getResource("RessourcesImg/Tete/tete_down.png"));
     private ImageIcon RessourceTeteBas2 = new ImageIcon(Jouable.class.getResource("RessourcesImg/Tete/tete_down2.png"));
     private ImageIcon RessourceTeteDroite3 = new ImageIcon(Jouable.class.getResource("RessourcesImg/Tete/tete_right3.png"));
     private ImageIcon RessourceTeteDroite4 = new ImageIcon(Jouable.class.getResource("RessourcesImg/Tete/tete_right4.png"));
     private ImageIcon RessourceTeteGauche3 = new ImageIcon(Jouable.class.getResource("RessourcesImg/Tete/tete_left3.png"));
     private ImageIcon RessourceTeteGauche4 = new ImageIcon(Jouable.class.getResource("RessourcesImg/Tete/tete_left4.png"));
     private ImageIcon RessourceTeteHaut3 = new ImageIcon(Jouable.class.getResource("RessourcesImg/Tete/tete_up3.png"));
     private ImageIcon RessourceTeteHaut4 = new ImageIcon(Jouable.class.getResource("RessourcesImg/Tete/tete_up4.png"));
     private ImageIcon RessourceTeteBas3 = new ImageIcon(Jouable.class.getResource("RessourcesImg/Tete/tete_down3.png"));
     private ImageIcon RessourceTeteBas4 = new ImageIcon(Jouable.class.getResource("RessourcesImg/Tete/tete_down4.png"));
     private ImageIcon RessourceCorps1 = new ImageIcon(Jouable.class.getResource("RessourcesImg/Corps/corps.png"));
     private ImageIcon RessourceCorps2 = new ImageIcon(Jouable.class.getResource("RessourcesImg/Corps/corps2.png"));
     private ImageIcon RessourceCorps3 = new ImageIcon(Jouable.class.getResource("RessourcesImg/Corps/corps3.png"));
     private ImageIcon RessourceCorps4 = new ImageIcon(Jouable.class.getResource("RessourcesImg/Corps/corps4.png"));
     private ImageIcon RessourceAliment1 = new ImageIcon(Jouable.class.getResource("RessourcesImg/Bonus/pomme.png"));
     private ImageIcon RessourceAliment2 = new ImageIcon(Jouable.class.getResource("RessourcesImg/Bonus/pomme2.png"));
     private ImageIcon RessourceSmiley1 = new ImageIcon(Jouable.class.getResource("RessourcesImg/Bonus/smiley1.png"));
     private ImageIcon RessourceSmiley2 = new ImageIcon(Jouable.class.getResource("RessourcesImg/Bonus/smiley2.png"));
     private ImageIcon RessourceImageTitre1 = new ImageIcon(Jouable.class.getResource("RessourcesImg/Titre/titre.png"));
     private ImageIcon RessourceImageTitre2 = new ImageIcon(Jouable.class.getResource("RessourcesImg/Titre/titre2.png"));
     private ImageIcon RessourceImageSolo1 = new ImageIcon(Jouable.class.getResource("RessourcesImg/Titre/solo1.png"));
     private ImageIcon RessourceImageSolo2 = new ImageIcon(Jouable.class.getResource("RessourcesImg/Titre/solo2.png"));
     private ImageIcon RessourceImageSoleil = new ImageIcon(Jouable.class.getResource("RessourcesImg/Bonus/soleil.png"));
     private ImageIcon RessourceImageSoleil2 = new ImageIcon(Jouable.class.getResource("RessourcesImg/Bonus/soleil2.png"));
     private ImageIcon RessourceBonus1 = new ImageIcon(Jouable.class.getResource("RessourcesImg/Bonus/bonus1.png"));
     private ImageIcon RessourceBonus2 = new ImageIcon(Jouable.class.getResource("RessourcesImg/Bonus/bonus2.png"));
     private ImageIcon RessourceBonus3 = new ImageIcon(Jouable.class.getResource("RessourcesImg/Bonus/bonus3.png"));
     private ImageIcon RessourceBonus4 = new ImageIcon(Jouable.class.getResource("RessourcesImg/Bonus/bonus4.png"));
     private ImageIcon RessourceBonus5 = new ImageIcon(Jouable.class.getResource("RessourcesImg/Bonus/bonus5.png"));
     
    private Random aleatoire = new Random();
    private int posX = aleatoire.nextInt(34); //aleatoire parmi les 34 positions possible pour les abscices des aliments
    private int posY = aleatoire.nextInt(23); //aleatoire parmi les 23 positions possible pour les ordonnées des aliments
    
    int point = 50;
    
    private Joueur joueur;
    private Timer timer;
    private int delai = 104;//vitesse du serpent
    private int boucle = 0;
    private int pulsation = 0;
    boolean test = false;
    boolean lecteurVideo = false;
    int pisteboucle = 0;
 
    Color couleurScore = Color.BLACK;
    Color couleurTaille = Color.BLACK;
    Color couleurLabelScore = Color.BLACK;
    Color couleurLabelTaille = Color.BLACK;
    Color couleurBordJeu = Color.BLACK;
    Color couleurBordTitre = Color.BLACK;
    Color couleurFond = Color.BLACK;

 //   final JFXPanel fxPanel = new JFXPanel();
    private MediaView mv;
    private MediaPlayer mediaplayer;
    private int indexRessource = 0;
    
   public void init(Joueur j){
       j.getTete().addTeteDroite(RessourceTeteDroite1);
       j.getTete().addTeteDroite(RessourceTeteDroite2);
       j.getTete().addTeteDroite(RessourceTeteDroite3);
       j.getTete().addTeteDroite(RessourceTeteDroite4);
       
       
       j.getTete().addTeteGauche(RessourceTeteGauche1);
       j.getTete().addTeteGauche(RessourceTeteGauche2);
       j.getTete().addTeteGauche(RessourceTeteGauche3);
       j.getTete().addTeteGauche(RessourceTeteGauche4);
       
       j.getTete().addTeteHaut(RessourceTeteHaut1);
       j.getTete().addTeteHaut(RessourceTeteHaut2);
       j.getTete().addTeteHaut(RessourceTeteHaut3);
       j.getTete().addTeteHaut(RessourceTeteHaut4);
       
       j.getTete().addTeteBas(RessourceTeteBas1);
       j.getTete().addTeteBas(RessourceTeteBas2);
       j.getTete().addTeteBas(RessourceTeteBas3);
       j.getTete().addTeteBas(RessourceTeteBas4);
       
       
       j.addCorps(RessourceCorps1);
       j.addCorps(RessourceCorps2);
       j.addCorps(RessourceCorps3);
       j.addCorps(RessourceCorps4);
   }
    public Jouable()
    {
        addKeyListener(this); //déclaration de l'écouteur clavier
        setFocusable(true); //Garde le focus sur l'ecran de jeu
        setFocusTraversalKeysEnabled(false);
        
        joueur = new Joueur(this);
        init(joueur);
        timer = new Timer(delai, this);//timer gerant la vitesse du serpent
        Lecteur.play("RessourcesSon/Disco Descent.mp3", 0.2);
        Lecteur.playVideo("RessourcesSon/DiscoDescentRL.mp4");
    }
    
    public void paint(Graphics g) //Méthode chargée de définir l'interface graphique
    {
        //définition arriere plan de la fenetre
        g.setColor(couleurFond);
        g.fillRect(0, 0, 1210, 690); //coordonnées x,y,largeur,longueur        
       
       if(boucle%1040 == 0)
       {
              ImageTitre = RessourceImageTitre1;  //récupère la ressource dans le chemin suivant : NomProjet/src/NomProjet/NomFichier.extension

              if(!lecteurVideo && pulsation >= 160 && pulsation <= 208)
              {
                  
                   lecteurVideo = true;
                   Lecteur.playVideo("RessourcesSon/DiscoDescentRL.mp4");
                              
              }
              if(pulsation > 207)
              {   
                Lecteur.stopVideo();
              }  
              if(pulsation >= 160 && pulsation <= 207)
              {
              smiley = RessourceSmiley1;
              Imagesolo = RessourceImageSolo1;
              aliment = RessourceImageSoleil;
              indexRessource = 2; 
             
              couleurScore = Color.YELLOW;
              couleurLabelScore = Color.CYAN;
              couleurTaille = Color.CYAN;
              couleurLabelTaille = Color.YELLOW;
              couleurBordJeu = Color.RED;
              couleurBordTitre = Color.YELLOW;
              timer.setDelay(delai/2);
              point = 100;
              }
              else
              {
              smiley = null;
              aliment = RessourceAliment1; //récupère la ressource dans le chemin suivant : NomProjet/src/NomProjet/NomFichier.extension
              indexRessource = 0 ;
              couleurScore = Color.YELLOW;
              couleurLabelScore = Color.CYAN;
              couleurTaille = Color.CYAN;
              couleurLabelTaille = Color.YELLOW;
              couleurBordJeu = Color.PINK;
              couleurBordTitre = Color.GREEN;
              }

       }
       else
       if(boucle%520 == 0)
       {
              ImageTitre = RessourceImageTitre2;  //récupère la ressource dans le chemin suivant : NomProjet/src/NomProjet/NomFichier.extension
              if(pulsation >= 160 && pulsation <= 208)
              {
              smiley = RessourceSmiley2;
              Imagesolo = RessourceImageSolo2;
              aliment = RessourceImageSoleil2;
              indexRessource = 3 ;
              couleurScore = Color.CYAN;
              couleurLabelScore = Color.YELLOW;
              couleurTaille = Color.YELLOW;
              couleurLabelTaille = Color.CYAN;
              couleurBordJeu = Color.YELLOW;
              couleurBordTitre = Color.RED;
              }
              else 
              {
                  smiley = null;
              
              aliment = RessourceAliment2; //récupère la ressource dans le chemin suivant : NomProjet/src/NomProjet/NomFichier.extension
              indexRessource = 1 ;
              
              couleurScore = Color.CYAN;
              couleurLabelScore = Color.YELLOW;
              couleurTaille = Color.YELLOW;
              couleurLabelTaille = Color.CYAN;
              couleurBordJeu = Color.GREEN;
              couleurBordTitre = Color.PINK;
              }
       }
       if(pulsation >= 160 && pulsation <= 207)
        {
            if((boucle-(520*pulsation))%520==0)
            {
                  ImageTitre = RessourceBonus5; 
                  
            }
            else
            {
                if((boucle-(520*pulsation))%416 ==0)
                {
                     ImageTitre = RessourceBonus4; 
                     
                }
                else
                {
                    if((boucle-(520*pulsation))%312==0)
                    {
                         ImageTitre = RessourceBonus3; 
                    }
                    else
                    {
                        if((boucle-(520*pulsation))%208 ==0)
                        {
                             ImageTitre = RessourceBonus2; 
                        }
                        else
                        {
                            if((boucle-(520*pulsation))%104==0)
                            {
                                 ImageTitre = RessourceBonus1; 
                                 
                            }
                        }
                    }
                }
            }
        }
       if(smiley!= null)
       {
       smiley.paintIcon(this, g, 815, 250); //affiche l'image la où les coordonnées x,y sont indiqués, correspondant au coin supérieur gauche de l'image
       Imagesolo.paintIcon(this, g, 950, 230);
       }
       else
       {
           //affiche un rectangle qui masque smiley
               g.setColor(couleurFond);
               g.fillRect(851, 0, 600, 800);
          
               lecteurVideo = false;
               point = 50;
               timer.setDelay(delai);
               
       }
       ImageTitre.paintIcon(this, g, 25, 21); //affiche l'image la où les coordonnées x,y sont indiqués, correspondant au coin supérieur gauche de l'image

       //définition des bords de l'image titre (dessine un rectangle)
       g.setColor(couleurBordTitre);
       g.drawRect(24, 20, 851, 55); //coordonnées x,y,largeur,longueur
       
      
       //définition des bords du jeu
       g.setColor(couleurBordJeu);
       g.drawRect(24, 99, 851, 576); //coordonnées x,y,largeur,longueur
       
       //définition de la zone de texte du score
       g.setColor(couleurScore);
       g.setFont(new Font("arial", Font.PLAIN,14)); //définition de l'écriture (police, type d'écriture, taille)
       g.drawString("Score : ", 780, 40); //affciahge de la zone de texte (chaine à afficher, coordonnées x,y de la zone de texte)
       g.setColor(couleurLabelScore);
       g.setFont(new Font("arial", Font.PLAIN,14)); //définition de l'écriture (police, type d'écriture, taille)
       g.drawString("" +joueur.getScore(), 830, 40); //affciahge de la zone de texte (chaine à afficher, coordonnées x,y de la zone de texte)
 
       //définition de la zone de texte de la taille du serpent
       g.setColor(couleurTaille);
       g.setFont(new Font("arial", Font.PLAIN,14)); //définition de l'écriture (police, type d'écriture, taille)
       g.drawString("Taille : ", 783, 60); //affciahge de la zone de texte (chaine à afficher, coordonnées x,y de la zone de texte)
       g.setColor(couleurLabelTaille);
       g.setFont(new Font("arial", Font.PLAIN,14)); //définition de l'écriture (police, type d'écriture, taille)
       g.drawString("" +joueur.getTailleCorps(), 830, 60); //affciahge de la zone de texte (chaine à afficher, coordonnées x,y de la zone de texte)
 
       //définition de l'arrière plan du jeu
       g.setColor(Color.BLACK);
       g.fillRect(25, 100, 850, 575);//coordonnées x,y,largeur,longueur
       if(start)
       {
           Lecteur.stopAllAudio();
           Lecteur.stopVideo();
           start = false;
           indexRessource = 0; //récupère la ressource dans le chemin suivant : NomProjet/src/NomProjet/NomFichier.extension
           joueur.getTete().getTeteDroite().get(indexRessource).paintIcon(this, g, joueur.getTete().getX(), joueur.getTete().getY()); //affiche l'image la où les coordonnées x,y sont indiqués, correspondant au coin supérieur gauche de l'image
       }
       
     
       for(int i = 0; i< joueur.getTailleCorps(); i++) //i va dans un premier temps être à 0, ce qui va dessiner l'element [0] à savoir la tête du serpent
       {
           if(i==0)
           { 
               switch(joueur.getTete().getDir()) 
               { 
                   case debut:
                       joueur.getTete().getTeteDroite().get(indexRessource).paintIcon(this, g, joueur.getSerpent().get(i).getX(), joueur.getSerpent().get(i).getY()); //affiche l'image la où les coordonnées x,y sont indiqués, correspondant au coin supérieur gauche de l'image
                       break;
                   case up:
                       joueur.getTete().getTeteHaut().get(indexRessource).paintIcon(this, g, joueur.getSerpent().get(i).getX(), joueur.getSerpent().get(i).getY()); //affiche l'image la où les coordonnées x,y sont indiqués, correspondant au coin supérieur gauche de l'image
                       break;
                   case right:
                       joueur.getTete().getTeteDroite().get(indexRessource).paintIcon(this, g, joueur.getSerpent().get(i).getX(), joueur.getSerpent().get(i).getY()); //affiche l'image la où les coordonnées x,y sont indiqués, correspondant au coin supérieur gauche de l'image
                       break;
                   case left:
                       joueur.getTete().getTeteGauche().get(indexRessource).paintIcon(this, g, joueur.getSerpent().get(i).getX(), joueur.getSerpent().get(i).getY()); //affiche l'image la où les coordonnées x,y sont indiqués, correspondant au coin supérieur gauche de l'image
                       break;
                   case down:
                       joueur.getTete().getTeteBas().get(indexRessource).paintIcon(this, g, joueur.getSerpent().get(i).getX(), joueur.getSerpent().get(i).getY()); //affiche l'image la où les coordonnées x,y sont indiqués, correspondant au coin supérieur gauche de l'image
                       break;
                   default:
                       throw new AssertionError(joueur.getTete().getDir().name());
               }
           }
           
           if(i!=0) //si le serpent possède déja une tête, c'est une partie du corps qui sera affichée en supplément
           {

               joueur.getRessourceCorps().get(indexRessource).paintIcon(this, g, joueur.getSerpent().get(i).getX(), joueur.getSerpent().get(i).getY()); //affiche l'image la où les coordonnées x,y sont indiqués, correspondant au coin supérieur gauche de l'image
        
           }
       }
  
       if(alimentposX[posX] == joueur.getTete().getX() && alimentposY[posY] == joueur.getTete().getY()) //si les abscices ET ordonnées d'un aliment et de la tête correspondent le serpent se nourrit de l'aliment
       {
           joueur.increaseTaille(); //la taille du serpent augmente
           joueur.addScore(point); //le score augmente
           posX = aleatoire.nextInt(34); //une position du nouvel aliment doit être généré parmi les 34 positions possible pour les abscices des aliments
           posY = aleatoire.nextInt(23); //une position du nouvel aliment doit être généré parmi les 23 positions possible pour les ordonnées des aliments
       }
       aliment.paintIcon(this, g, alimentposX[posX], alimentposY[posY]); //affiche l'image la où les coordonnées x,y sont indiqués, correspondant au coin supérieur gauche de l'image
         
       
       for(int i = 1; i< joueur.getTailleCorps(); i++) //boucle vérifiant si la tête a percutée un élément du corps
       {
           if (joueur.getSerpent().get(i).getX() == joueur.getTete().getX() && joueur.getSerpent().get(i).getY() == joueur.getTete().getY())
           { 
               //affiche un rectangle qui masque smiley
               g.setColor(couleurFond);
               g.fillRect(915, 0, 600, 800);
               joueur.getTete().setDir(debut);
               gameover = true;
               Lecteur.stopAllAudio();
               Lecteur.stopVideo();
               g.setColor(Color.white);
               g.setFont(new Font("algerian", Font.BOLD, 50)); //définition de l'écriture (police, type d'écriture, taille)
               g.drawString("GAME OVER !", 200, 300); //affciahge de la zone de texte (chaine à afficher, coordonnées x,y de la zone de texte)
               
               g.setFont(new Font("algerian", Font.BOLD, 50)); //définition de l'écriture (police, type d'écriture, taille)
               g.drawString("Press SPACE To Restart !", 50, 450); //affciahge de la zone de texte (chaine à afficher, coordonnées x,y de la zone de texte)

           }
       }
       g.dispose();
    }  

    @Override
    public void keyPressed(KeyEvent e) //Evenement déclenché lors de l'appui sur une touche clavier (KeyListener)
    {
        
        if((joueur.getDeplacement() == 0 && e.getKeyCode()== KeyEvent.VK_UP)|| (joueur.getDeplacement() == 0 && e.getKeyCode()== KeyEvent.VK_DOWN)||(joueur.getDeplacement() == 0 && e.getKeyCode()== KeyEvent.VK_RIGHT))
        {
            
            Lecteur.play("RessourcesSon/Disco Descent.mp3", 0.2);
            
           
            timer.start();
        }
        if(e.getKeyCode()== KeyEvent.VK_SPACE)
        {
            if(gameover)
            {

            timer.stop();
            boucle = 0;
            pulsation = 0;
            lecteurVideo = false;
            
            test = false;
            gameover = false;
            start = true;
            joueur = new Joueur(this);
            pisteboucle = 1;
            indexRessource= 0;
            repaint();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) //Si flèche droite appuyée        
        {
            if(!gameover)
            {
                joueur.increaseDeplacement();
                if(joueur.getTete().getDir()!=left){
                    joueur.getTete().setDir(right);
                    
                }
            }
            
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT && timer.isRunning()) //Si flèche gauche appuyée        
        {
            if(!gameover)
            {
                joueur.increaseDeplacement(); //on incrémente cette variable pour éviter que le joueur reste sur la position de démarrage
                    if(joueur.getTete().getDir()!=right)
                    {
                        joueur.getTete().setDir(left);
                    }
            }
            
        }
        if(e.getKeyCode() == KeyEvent.VK_UP) //Si flèche haut appuyée        
        {
            if(!gameover)
            {
                joueur.increaseDeplacement(); //on incrémente cette variable pour éviter que le joueur reste sur la position de démarrage
                if(joueur.getTete().getDir()!=down)
                {
                    joueur.getTete().setDir(up);
                }
            }
            
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) //Si flèche bas appuyée        
        {
            if(!gameover)
            {
                
                joueur.increaseDeplacement(); //on incrémente cette variable pour éviter que le joueur reste sur la position de démarrage
                if(joueur.getTete().getDir()!=up)
                {
                    joueur.getTete().setDir(down);
                }
            }
            
        }
    }

   
    @Override
    public void actionPerformed(ActionEvent e) //Evenement déclenché lorsqu'une touche a bien été appuyée (ActionListener)
    {
       
        boucle += timer.getDelay();
        
        if(pulsation == 336 && !test) //2:55:500 //175500
        {  
        test = true;
        Lecteur.play("RessourcesSon/DiscoDescentBoucle.mp3", 0.2);
        boucle = 1768;
        pulsation = 17;
        pisteboucle = 1;
        
        }
        else
        {
            if(pulsation == 336  && test) //2:47:060 //167060
            {
                if(pisteboucle == 1)
                {
                Lecteur.play("RessourcesSon/DiscoDescentBoucle2.mp3", 0.2);
                pisteboucle = 2;
                }
                else
                {
                    Lecteur.play("RessourcesSon/DiscoDescentBoucle.mp3", 0.2);
                    pisteboucle = 1;
                }
                boucle = 1768;
                pulsation = 17;
                
                
            }
        }
        if(boucle%520==0)
        {
            pulsation ++;
        }   
        switch(joueur.getTete().getDir())
        {       
            case up:
                for (int i = joueur.getTailleCorps()-1; i>0; i--) //virage
                {
                    joueur.getSerpent().get(i).setX(joueur.getSerpent().get(i-1).getX());//fait suivre les éléments du corps jusqu'à la tête lors d'un virage
                }
                for(int i = joueur.getTailleCorps(); i>=0; i--) //boucle faisant bouger le serpent en modifiant les ordonnées
                {
                    if(i==0) //on bouge dans un premier temps l'élément 0 du corps qui est la tête
                    {
                        joueur.getSerpent().get(i).setY(joueur.getSerpent().get(i).getY()-25); //coordonnées actuelles de la tête -25 px, taille correspondant à une case du jeu
                    }
                    else //puis ce sera au tour du reste du corps de bouger et donc de suivre la tête
                    {
                        joueur.getSerpent().get(i-1).setY(joueur.getSerpent().get(i-2).getY()); //une fois la tête bougée, l'élément suivant viendra prendre sa place et ainsi s'acroché a la tête; opération réalisée pour tout le reste du corps
                    }
                    if(joueur.getSerpent().get(i-1).getY()<100) //si la bordure du haut de la fenêtre est percutée
                    {
                        joueur.getSerpent().get(i-1).setY(650);
                    }
                }
                //repaint(); //rappelle la methode paint qui redessinera les éléments avec leurs nouvelles coordonnées
                break;
            case right:
                for (int i = joueur.getTailleCorps()-1; i>0; i--) //virage
                {
                    joueur.getSerpent().get(i).setY(joueur.getSerpent().get(i-1).getY());//fait suivre les éléments du corps jusqu'à la tête lors d'un virage
                }
                for(int i = joueur.getTailleCorps()-1; i>=0; i--) //boucle faisant bouger le serpent en modifiant les abscices
                {
                    if(i==0) //on bouge dans un premier temps l'élément 0 du corps qui est la tête
                    {
                        joueur.getSerpent().get(i).setX(joueur.getSerpent().get(i).getX()+25); //coordonnées actuelles de la tête +25 px, taille correspondant à une case du jeu
                    }
                    else //puis ce sera au tour du reste du corps de bouger et donc de suivre la tête
                    {
                        joueur.getSerpent().get(i).setX(joueur.getSerpent().get(i-1).getX()); //une fois la tête bougée, l'élément suivant viendra prendre sa place et ainsi s'acroché a la tête; opération réalisée pour tout le reste du corps
                    }
                    if(joueur.getSerpent().get(i).getX()<100) //si la bordure droite de la fenêtre est percutée
                    {
                        joueur.getSerpent().get(i).setX(25);
                    }
                }
           
                //repaint(); //rappelle la methode paint qui redessinera les éléments avec leurs nouvelles coordonnées
                break;
            case left:
                for (int i = joueur.getTailleCorps()-1; i>=0; i--) //virage
                {
                    joueur.getSerpent().get(i+1).setY(joueur.getSerpent().get(i).getY());//fait suivre les éléments du corps jusqu'à la tête lors d'un virage
                }
                for(int i = joueur.getTailleCorps(); i>=0; i--) //boucle faisant bouger le serpent en modifiant les abscices
                {
                    if(i==0) //on bouge dans un premier temps l'élément 0 du corps qui est la tête
                    {
                        joueur.getSerpent().get(i).setX(joueur.getSerpent().get(i).getX()-25); //coordonnées actuelles de la tête -25 px, taille correspondant à une case du jeu
                    }
                    else //puis ce sera au tour du reste du corps de bouger et donc de suivre la tête
                    {
                        joueur.getSerpent().get(i).setX(joueur.getSerpent().get(i-1).getX()); //une fois la tête bougée, l'élément suivant viendra prendre sa place et ainsi s'acroché a la tête; opération réalisée pour tout le reste du corps
                    }
                    if(joueur.getSerpent().get(i).getX()<25) //si la bordure gauche de la fenêtre est percutée
                    {
                        joueur.getSerpent().get(i).setX(850);
                    }
                }
                //repaint(); //rappelle la methode paint qui redessinera les éléments avec leurs nouvelles coordonnées
                break;
            case down:
                for (int i = joueur.getTailleCorps()-1; i>0; i--) //virage
                {
                    joueur.getSerpent().get(i).setX(joueur.getSerpent().get(i-1).getX());//fait suivre les éléments du corps jusqu'à la tête lors d'un virage
                }
                for(int i = joueur.getTailleCorps()-1; i>=0; i--) //boucle faisant bouger le serpent en modifiant les ordonnées
                {
                    if(i==0) //on bouge dans un premier temps l'élément 0 du corps qui est la tête
                    {
                        joueur.getSerpent().get(i).setY(joueur.getSerpent().get(i).getY()+25); //coordonnées actuelles de la tête +25 px, taille correspondant à une case du jeu
                    }
                    else //puis ce sera au tour du reste du corps de bouger et donc de suivre la tête
                    {
                        joueur.getSerpent().get(i).setY(joueur.getSerpent().get(i-1).getY());; //une fois la tête bougée, l'élément suivant viendra prendre sa place et ainsi s'acroché a la tête; opération réalisée pour tout le reste du corps
                    }
                    if(joueur.getSerpent().get(i).getY()>650) //si la bordure du bas de la fenêtre est percutée
                    {
                        joueur.getSerpent().get(i).setY(100);
                    }
                }
                //repaint(); //rappelle la methode paint qui redessinera les éléments avec leurs nouvelles coordonnées
                break;
            default:
                throw new AssertionError(joueur.getTete().getDir().name());
        }
        repaint(); //rappelle la methode paint qui redessinera les éléments avec leurs nouvelles coordonnées
        }
    public void stopTimer()
    {
        timer.stop();
    }
     @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException(""); //To change body of generated methods, choose Tools | Templates.
    }
     @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException(""); //To change body of generated methods, choose Tools | Templates.
    }
}
