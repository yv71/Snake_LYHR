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

/**
 *
 * @author remil
 */
public class Jouable extends JPanel implements KeyListener, ActionListener{
    private boolean start = true;
    private boolean gameover = false;
    //tableaux représentants la tête et le corps du serpent
    private int[]tailleSnakeX = new int [750];
    private int[]tailleSnakeY = new int [750];
    
    //tableaux représentants les aliments (une image faisant 25px explique que les éléments des tableaux soit des multiples de 25)
    private int[]alimentposX = {25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475, 500, 525, 550, 575, 600, 625, 650, 675, 700, 725, 750, 775, 800, 825, 850};
    private int[]alimentposY = {100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475, 500, 525, 550, 575, 600, 625, 650};
    
    //booléens représentants les directions du serpent
    private boolean up = false;
    private boolean right = false;
    private boolean left = false;
    private boolean down = false;
    
    //images correspondant au corps et à la direction de la tête
     private ImageIcon teteDroite;
     private ImageIcon teteGauche;
     private ImageIcon teteHaut;
     private ImageIcon teteBas;
     private ImageIcon corps;
     private ImageIcon aliment;
     private ImageIcon smiley;
     private ImageIcon ImageTitre;
     private ImageIcon Imagesolo;
     private ImageIcon RessourceTeteDroite1 = new ImageIcon(Jouable.class.getResource("tete_right.png"));
     private ImageIcon RessourceTeteDroite2 = new ImageIcon(Jouable.class.getResource("tete_right2.png"));
     private ImageIcon RessourceTeteGauche1 = new ImageIcon(Jouable.class.getResource("tete_left.png"));
     private ImageIcon RessourceTeteGauche2 = new ImageIcon(Jouable.class.getResource("tete_left2.png"));
     private ImageIcon RessourceTeteHaut1 = new ImageIcon(Jouable.class.getResource("tete_up.png"));
     private ImageIcon RessourceTeteHaut2 = new ImageIcon(Jouable.class.getResource("tete_up2.png"));
     private ImageIcon RessourceTeteBas1 = new ImageIcon(Jouable.class.getResource("tete_down.png"));
     private ImageIcon RessourceTeteBas2 = new ImageIcon(Jouable.class.getResource("tete_down2.png"));
     private ImageIcon RessourceTeteDroite3 = new ImageIcon(Jouable.class.getResource("tete_right3.png"));
     private ImageIcon RessourceTeteDroite4 = new ImageIcon(Jouable.class.getResource("tete_right4.png"));
     private ImageIcon RessourceTeteGauche3 = new ImageIcon(Jouable.class.getResource("tete_left3.png"));
     private ImageIcon RessourceTeteGauche4 = new ImageIcon(Jouable.class.getResource("tete_left4.png"));
     private ImageIcon RessourceTeteHaut3 = new ImageIcon(Jouable.class.getResource("tete_up3.png"));
     private ImageIcon RessourceTeteHaut4 = new ImageIcon(Jouable.class.getResource("tete_up4.png"));
     private ImageIcon RessourceTeteBas3 = new ImageIcon(Jouable.class.getResource("tete_down3.png"));
     private ImageIcon RessourceTeteBas4 = new ImageIcon(Jouable.class.getResource("tete_down4.png"));
     private ImageIcon RessourceCorps1 = new ImageIcon(Jouable.class.getResource("corps.png"));
     private ImageIcon RessourceCorps2 = new ImageIcon(Jouable.class.getResource("corps2.png"));
     private ImageIcon RessourceCorps3 = new ImageIcon(Jouable.class.getResource("corps3.png"));
     private ImageIcon RessourceCorps4 = new ImageIcon(Jouable.class.getResource("corps4.png"));
     private ImageIcon RessourceAliment1 = new ImageIcon(Jouable.class.getResource("pomme.png"));
     private ImageIcon RessourceAliment2 = new ImageIcon(Jouable.class.getResource("pomme2.png"));
     private ImageIcon RessourceSmiley1 = new ImageIcon(Jouable.class.getResource("smiley1.png"));
     private ImageIcon RessourceSmiley2 = new ImageIcon(Jouable.class.getResource("smiley2.png"));
     private ImageIcon RessourceImageTitre1 = new ImageIcon(Jouable.class.getResource("titre.png"));
     private ImageIcon RessourceImageTitre2 = new ImageIcon(Jouable.class.getResource("titre2.png"));
     private ImageIcon RessourceImageSolo1 = new ImageIcon(Jouable.class.getResource("solo1.png"));
     private ImageIcon RessourceImageSolo2 = new ImageIcon(Jouable.class.getResource("solo2.png"));
     private ImageIcon RessourceImageSoleil = new ImageIcon(Jouable.class.getResource("soleil.png"));
     private ImageIcon RessourceImageSoleil2 = new ImageIcon(Jouable.class.getResource("soleil2.png"));
     private ImageIcon RessourceBonus1 = new ImageIcon(Jouable.class.getResource("bonus1.png"));
     private ImageIcon RessourceBonus2 = new ImageIcon(Jouable.class.getResource("bonus2.png"));
     private ImageIcon RessourceBonus3 = new ImageIcon(Jouable.class.getResource("bonus3.png"));
     private ImageIcon RessourceBonus4 = new ImageIcon(Jouable.class.getResource("bonus4.png"));
     private ImageIcon RessourceBonus5 = new ImageIcon(Jouable.class.getResource("bonus5.png"));
     
    private Random aleatoire = new Random();
    private int posX = aleatoire.nextInt(34); //aleatoire parmi les 34 positions possible pour les abscices des aliments
    private int posY = aleatoire.nextInt(23); //aleatoire parmi les 23 positions possible pour les ordonnées des aliments
     
    private int tailleCorps = 3;
    private int deplacement = 0;
    private int score = 0;
    int point = 50;
     
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

    final JFXPanel fxPanel = new JFXPanel();
    private MediaView mv;
    private MediaPlayer mediaplayer;
   
    public Jouable()
    {
        addKeyListener(this); //déclaration de l'écouteur clavier
        setFocusable(true); //Garde le focus sur l'ecran de jeu
        setFocusTraversalKeysEnabled(false);
        
        timer = new Timer(delai, this);//timer gerant la vitesse du serpent
        Lecteur.play("Disco Descent.mp3", 0.2);
        Lecteur.playVideo("DiscoDescentRL.mp4");
        
      
    }
    public void paint(Graphics g) //Méthode chargée de définir l'interface graphique
    {
        //définition arriere plan de la fenetre
        g.setColor(couleurFond);
        g.fillRect(0, 0, 1210, 690); //coordonnées x,y,largeur,longueur
        
        if (deplacement ==0) //position de départ
        {
            tailleSnakeX[0] = 100; //Place le premier élément du tableau (la tête du serpent) a l'abscisse 100;
            tailleSnakeX[1] = 75; //Les elements suivants du tableau correspondent au reste du corps du serpent
            tailleSnakeX[2] = 50;
   
            tailleSnakeY[0] = 125; //Place le premier élément du tableau (la tête du serpent) a l'ordonnée 100;
            tailleSnakeY[1] = 125; //Les elements suivants du tableau correspondent au reste du corps du serpent
            tailleSnakeY[2] = 125;
       
        }
        
        
       
       if(boucle%1040 == 0)
       {
              ImageTitre = RessourceImageTitre1;  //récupère la ressource dans le chemin suivant : NomProjet/src/NomProjet/NomFichier.extension

              if(!lecteurVideo && pulsation >= 160 && pulsation <= 208)
              {
                  
                   lecteurVideo = true;
                   Lecteur.playVideo("DiscoDescentRL.mp4");
                              
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
              teteBas = RessourceTeteBas3;
              teteDroite = RessourceTeteDroite3; 
              teteHaut = RessourceTeteHaut3;
              teteGauche = RessourceTeteGauche3; 
              corps = RessourceCorps3;
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
              teteBas = RessourceTeteBas1;
              teteDroite = RessourceTeteDroite1; 
              teteHaut = RessourceTeteHaut1;
              teteGauche = RessourceTeteGauche1; 
              corps = RessourceCorps1;
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
               teteBas = RessourceTeteBas4;
              teteDroite = RessourceTeteDroite4; 
              teteHaut = RessourceTeteHaut4;
              teteGauche = RessourceTeteGauche4; 
              corps = RessourceCorps4;
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
              teteBas = RessourceTeteBas2;
              teteDroite = RessourceTeteDroite2; 
              teteHaut = RessourceTeteHaut2;
              teteGauche = RessourceTeteGauche2; 
              corps = RessourceCorps2;
              
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
       g.drawString("" +score, 830, 40); //affciahge de la zone de texte (chaine à afficher, coordonnées x,y de la zone de texte)
 
       //définition de la zone de texte de la taille du serpent
       g.setColor(couleurTaille);
       g.setFont(new Font("arial", Font.PLAIN,14)); //définition de l'écriture (police, type d'écriture, taille)
       g.drawString("Taille : ", 783, 60); //affciahge de la zone de texte (chaine à afficher, coordonnées x,y de la zone de texte)
       g.setColor(couleurLabelTaille);
       g.setFont(new Font("arial", Font.PLAIN,14)); //définition de l'écriture (police, type d'écriture, taille)
       g.drawString("" +tailleCorps, 830, 60); //affciahge de la zone de texte (chaine à afficher, coordonnées x,y de la zone de texte)
 
       //définition de l'arrière plan du jeu
       g.setColor(Color.BLACK);
       g.fillRect(25, 100, 850, 575);//coordonnées x,y,largeur,longueur
       if(start)
       {
           Lecteur.stopAllAudio();
           Lecteur.stopVideo();
           start = false;
           teteBas= RessourceTeteBas1;
           teteHaut = RessourceTeteHaut1;
           teteGauche = RessourceTeteGauche1;
           teteDroite = RessourceTeteDroite1; //récupère la ressource dans le chemin suivant : NomProjet/src/NomProjet/NomFichier.extension
           teteDroite.paintIcon(this, g, tailleSnakeX[0], tailleSnakeY[0]); //affiche l'image la où les coordonnées x,y sont indiqués, correspondant au coin supérieur gauche de l'image
       }
       
     
       for(int i = 0; i< tailleCorps; i++) //i va dans un premier temps être à 0, ce qui va dessiner l'element [0] à savoir la tête du serpent
       {
           if(i==0 && right) //si le serpent se dirige vers la droite, la tête "droite" sera alors afficher
           {
               
                teteDroite.paintIcon(this, g, tailleSnakeX[i], tailleSnakeY[i]); //affiche l'image la où les coordonnées x,y sont indiqués, correspondant au coin supérieur gauche de l'image
        
           }
           if(i==0 && down) //si le serpent se dirige vers le bas, la tête "bas" sera alors afficher
           {
                
               
               teteBas.paintIcon(this, g, tailleSnakeX[i], tailleSnakeY[i]); //affiche l'image la où les coordonnées x,y sont indiqués, correspondant au coin supérieur gauche de l'image
        
           }
           if(i==0 && left) //si le serpent se dirige vers la gauche, la tête "gauche" sera alors afficher
           {
               
                teteGauche.paintIcon(this, g, tailleSnakeX[i], tailleSnakeY[i]); //affiche l'image la où les coordonnées x,y sont indiqués, correspondant au coin supérieur gauche de l'image
        
           }
           if(i==0 && up) //si le serpent se dirige vers le haut, la tête "haut" sera alors afficher
           {
               
                teteHaut.paintIcon(this, g, tailleSnakeX[i], tailleSnakeY[i]); //affiche l'image la où les coordonnées x,y sont indiqués, correspondant au coin supérieur gauche de l'image
                
           }
           if(i!=0) //si le serpent possède déja une tête, c'est une partie du corps qui sera affichée en supplément
           {
                      
               
               corps.paintIcon(this, g, tailleSnakeX[i], tailleSnakeY[i]); //affiche l'image la où les coordonnées x,y sont indiqués, correspondant au coin supérieur gauche de l'image
        
           }
       }
       
       
       if(alimentposX[posX] == tailleSnakeX[0] && alimentposY[posY] == tailleSnakeY[0]) //si les abscices ET ordonnées d'un aliment et de la tête correspondent le serpent se nourrit de l'aliment
       {
           tailleCorps++; //la taille du serpent augmente
           score += point; //le score augmente
           posX = aleatoire.nextInt(34); //une position du nouvel aliment doit être généré parmi les 34 positions possible pour les abscices des aliments
           posY = aleatoire.nextInt(23); //une position du nouvel aliment doit être généré parmi les 23 positions possible pour les ordonnées des aliments
       }
       aliment.paintIcon(this, g, alimentposX[posX], alimentposY[posY]); //affiche l'image la où les coordonnées x,y sont indiqués, correspondant au coin supérieur gauche de l'image
         
       
       for(int i = 1; i< tailleCorps; i++) //boucle vérifiant si la tête a percutée un élément du corps
       {
           if (tailleSnakeX[i] == tailleSnakeX[0] && tailleSnakeY[i] == tailleSnakeY[0])
           { 
               //affiche un rectangle qui masque smiley
               g.setColor(couleurFond);
               g.fillRect(915, 0, 600, 800);
               right = false;
               left = false;
               up = false;
               down = false;
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
        
        if((deplacement == 0 && e.getKeyCode()== KeyEvent.VK_UP)|| (deplacement == 0 && e.getKeyCode()== KeyEvent.VK_DOWN)||(deplacement == 0 && e.getKeyCode()== KeyEvent.VK_RIGHT))
        {
            
            Lecteur.play("Disco Descent.mp3", 0.2);
            
           
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
            deplacement = 0;
            tailleCorps = 3;
            score = 0;
            pisteboucle = 1;
            corps = RessourceCorps1;
            teteDroite = RessourceTeteDroite1;
            repaint();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) //Si flèche droite appuyée        
        {
            if(!gameover)
            {
                
                deplacement++; //on incrémente cette variable pour éviter que le joueur reste sur la position de démarrage
                right = true; 
                if(!left) //si le serpent ne se dirigeait pas vers la gauche il est apte à se diriger à droite
                {
                    right = true;

                }
                else //le serpent ne peut pas faire de demi-tour, mais uniquement des quarts de tour
                {
                    right = false;
                    left = true;
                }

                up = false;
                down = false;
            }
            
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT && timer.isRunning()) //Si flèche gauche appuyée        
        {
            if(!gameover)
            {
               
                deplacement++; //on incrémente cette variable pour éviter que le joueur reste sur la position de démarrage
                left = true; 
                if(!right) //si le serpent ne se dirigeait pas vers la droite il est apte à se diriger à gauche
                {
                    left = true;

                }
                else //le serpent ne peut pas faire de demi-tour, mais uniquement des quarts de tour
                {
                    left = false;
                    right = true;
                }

                up = false;
                down = false;
            }
            
        }
        if(e.getKeyCode() == KeyEvent.VK_UP) //Si flèche haut appuyée        
        {
            if(!gameover)
            {
               
                deplacement++; //on incrémente cette variable pour éviter que le joueur reste sur la position de démarrage
                up = true; 
                if(!down) //si le serpent ne se dirigeait pas vers le bas il est apte à se diriger vers le haut
                {
                    up = true;

                }
                else //le serpent ne peut pas faire de demi-tour, mais uniquement des quarts de tour
                {
                    up = false;
                    down = true;
                }
                right = false;
                left = false;
            }
            
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) //Si flèche bas appuyée        
        {
            if(!gameover)
            {
                
                deplacement++; //on incrémente cette variable pour éviter que le joueur reste sur la position de démarrage
                down = true; 
                if(!up) //si le serpent ne se dirigeait pas vers le haut il est apte à se diriger vers le bas
                {
                    down = true;

                }
                else //le serpent ne peut pas faire de demi-tour, mais uniquement des quarts de tour
                {
                    down = false;
                    up = true;
                }
                right = false;
                left = false;
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
        Lecteur.play("DiscoDescentBoucle.mp3", 0.2);
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
                Lecteur.play("DiscoDescentBoucle2.mp3", 0.2);
                pisteboucle = 2;
                }
                else
                {
                    Lecteur.play("DiscoDescentBoucle.mp3", 0.2);
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
        if(right) //Si le serpent doit aller à droite
        {       
             for (int i = tailleCorps-1; i>=0; i--) //virage
            {
                tailleSnakeY[i+1] = tailleSnakeY[i];//fait suivre les éléments du corps jusqu'à la tête lors d'un virage
            }
            for(int i = tailleCorps; i>=0; i--) //boucle faisant bouger le serpent en modifiant les abscices
            {
                if(i==0) //on bouge dans un premier temps l'élément 0 du corps qui est la tête
                {
                    tailleSnakeX[i] = tailleSnakeX [i] + 25; //coordonnées actuelles de la tête +25 px, taille correspondant à une case du jeu
                }
                else //puis ce sera au tour du reste du corps de bouger et donc de suivre la tête
                {
                    tailleSnakeX[i] = tailleSnakeX[i-1]; //une fois la tête bougée, l'élément suivant viendra prendre sa place et ainsi s'acroché a la tête; opération réalisée pour tout le reste du corps
                }
                if(tailleSnakeX[i]>850) //si la bordure droite de la fenêtre est percutée
                {
                    tailleSnakeX[i] = 25;
                }
            }
           
            repaint(); //rappelle la methode paint qui redessinera les éléments avec leurs nouvelles coordonnées
        }
        if(left) //Si le serpent doit aller à gauche
        {       
             for (int i = tailleCorps-1; i>=0; i--) //virage
            {
                tailleSnakeY[i+1] = tailleSnakeY[i];//fait suivre les éléments du corps jusqu'à la tête lors d'un virage
            }
            for(int i = tailleCorps; i>=0; i--) //boucle faisant bouger le serpent en modifiant les abscices
            {
                if(i==0) //on bouge dans un premier temps l'élément 0 du corps qui est la tête
                {
                    tailleSnakeX[i] = tailleSnakeX [i] - 25; //coordonnées actuelles de la tête -25 px, taille correspondant à une case du jeu
                }
                else //puis ce sera au tour du reste du corps de bouger et donc de suivre la tête
                {
                    tailleSnakeX[i] = tailleSnakeX[i-1]; //une fois la tête bougée, l'élément suivant viendra prendre sa place et ainsi s'acroché a la tête; opération réalisée pour tout le reste du corps
                }
                if(tailleSnakeX[i]<25) //si la bordure gauche de la fenêtre est percutée
                {
                    tailleSnakeX[i] = 850;
                }
            }
           
            repaint(); //rappelle la methode paint qui redessinera les éléments avec leurs nouvelles coordonnées
        }
        if(up) //Si le serpent doit aller en haut
        {       
             for (int i = tailleCorps-1; i>=0; i--) //virage
            {
                tailleSnakeX[i+1] = tailleSnakeX[i];//fait suivre les éléments du corps jusqu'à la tête lors d'un virage
            }
            for(int i = tailleCorps; i>=0; i--) //boucle faisant bouger le serpent en modifiant les ordonnées
            {
                if(i==0) //on bouge dans un premier temps l'élément 0 du corps qui est la tête
                {
                    tailleSnakeY[i] = tailleSnakeY [i] - 25; //coordonnées actuelles de la tête -25 px, taille correspondant à une case du jeu
                }
                else //puis ce sera au tour du reste du corps de bouger et donc de suivre la tête
                {
                    tailleSnakeY[i] = tailleSnakeY[i-1]; //une fois la tête bougée, l'élément suivant viendra prendre sa place et ainsi s'acroché a la tête; opération réalisée pour tout le reste du corps
                }
                if(tailleSnakeY[i]<100) //si la bordure du haut de la fenêtre est percutée
                {
                    tailleSnakeY[i] = 650;
                }
            }
           
            repaint(); //rappelle la methode paint qui redessinera les éléments avec leurs nouvelles coordonnées
        }
         if(down) //Si le serpent doit aller en bas
        {       
             for (int i = tailleCorps-1; i>=0; i--) //virage
            {
                tailleSnakeX[i+1] = tailleSnakeX[i];//fait suivre les éléments du corps jusqu'à la tête lors d'un virage
            }
            for(int i = tailleCorps; i>=0; i--) //boucle faisant bouger le serpent en modifiant les ordonnées
            {
                if(i==0) //on bouge dans un premier temps l'élément 0 du corps qui est la tête
                {
                    tailleSnakeY[i] = tailleSnakeY [i] + 25; //coordonnées actuelles de la tête +25 px, taille correspondant à une case du jeu
                }
                else //puis ce sera au tour du reste du corps de bouger et donc de suivre la tête
                {
                    tailleSnakeY[i] = tailleSnakeY[i-1]; //une fois la tête bougée, l'élément suivant viendra prendre sa place et ainsi s'acroché a la tête; opération réalisée pour tout le reste du corps
                }
                if(tailleSnakeY[i]>650) //si la bordure du bas de la fenêtre est percutée
                {
                    tailleSnakeY[i] = 100;
                }
            }
           
            repaint(); //rappelle la methode paint qui redessinera les éléments avec leurs nouvelles coordonnées
        }
        
           
    }
     @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException(""); //To change body of generated methods, choose Tools | Templates.
    }
     @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException(""); //To change body of generated methods, choose Tools | Templates.
    }
}
