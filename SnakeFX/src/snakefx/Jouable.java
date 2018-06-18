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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import static java.lang.Thread.sleep;
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
import snakefx.Highscore;

/**
 * Classe gérant les éléments du jeu, les évènements qui leurs sont liés ainsi
 * que leur affichage.
 *
 * @author remil
 */
public class Jouable extends JPanel implements KeyListener, ActionListener {

    private boolean start = true;
    private boolean touche = false;
    private boolean gameover = false;

    //private ImageIcon aliment;
    private ImageIcon smiley;
    private ImageIcon ImageTitre;
    private ImageIcon Imagesolo;

    private final HighscorePanel pseudo;
    private Highscore highscore;

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

    private Joueur joueur;
    private Aliment aliment;
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

    private MediaView mv;
    private MediaPlayer mediaplayer;
    private int indexRessource = 0;
    private int indexRessourceAliment = 0;

    /**
     * Initialises les ressources images du joueur et de l'aliment.
     *
     * @param j correspond au joueur.
     * @param a correspond à l'aliment.
     */
    public void init(Joueur j, Aliment a) {

        a.getRessourcesAliment().add(RessourceAliment1);
        a.getRessourcesAliment().add(RessourceAliment2);
        a.getRessourcesAliment().add(RessourceImageSoleil);
        a.getRessourcesAliment().add(RessourceImageSoleil2);

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

    /**
     * Constructeur de jouable, créant un joueur( le serpent) et un premier
     * aliment, lançant musique et vidéo ainsi que le timer et initalisant les
     * ressources du joueur et de l'aliment.
     */
    public Jouable() throws IOException, FileNotFoundException, ClassNotFoundException {
        addKeyListener(this); //déclaration de l'écouteur clavier
        setFocusable(true); //Garde le focus sur l'ecran de jeu
        setFocusTraversalKeysEnabled(false);

        aliment = new Aliment(this);
        joueur = new Joueur(this);
        init(joueur, aliment);
        timer = new Timer(delai, this);//timer gerant la vitesse du serpent
        Lecteur.play("RessourcesSon/Disco Descent.mp3", 0.2);
        Lecteur.playVideo("RessourcesSon/DiscoDescentRL.mp4");
        pseudo = new HighscorePanel();
        pseudo.setTitle("Score");
        pseudo.setBounds(350, 350, 398, 200);
        pseudo.setJoueur(joueur);
        highscore = new Highscore();
        highscore.loadMe();
        if (highscore.getNomJoueur() == null) {
            highscore.setNomJoueur("");
        }
        if (highscore.getNomJoueur2() == null) {
            highscore.setNomJoueur2("");
        }
        if (highscore.getNomJoueur3() == null) {
            highscore.setNomJoueur3("");
        }
        pseudo.setHighscore(highscore);
    }

    /**
     * Définit l'interface graphique.
     *
     * @param g correspond à la zone graphique.
     */
    public void paint(Graphics g) {
        //définition arriere plan de la fenetre
        touche = false;
        g.setColor(couleurFond);
        g.fillRect(0, 0, 1210, 690); //coordonnées x,y,largeur,longueur        

        if (boucle % 1040 == 0) {
            ImageTitre = RessourceImageTitre1;  //récupère la ressource dans le chemin suivant : NomProjet/src/NomProjet/NomFichier.extension

            if (!lecteurVideo && pulsation >= 160 && pulsation <= 208) {
                lecteurVideo = true;
                Lecteur.playVideo("RessourcesSon/DiscoDescentRL.mp4");
            }
            if (pulsation > 207) {
                Lecteur.stopVideo();
            }
            if (pulsation >= 160 && pulsation <= 207) {
                smiley = RessourceSmiley1;
                Imagesolo = RessourceImageSolo1;
                indexRessourceAliment = 2;
                indexRessource = 2;

                couleurScore = Color.YELLOW;
                couleurLabelScore = Color.CYAN;
                couleurTaille = Color.CYAN;
                couleurLabelTaille = Color.YELLOW;
                couleurBordJeu = Color.RED;
                couleurBordTitre = Color.YELLOW;
                timer.setDelay(delai / 2);
                aliment.setPoint(100);
            } else {
                smiley = null;
                indexRessourceAliment = 0;
                indexRessource = 0;
                couleurScore = Color.YELLOW;
                couleurLabelScore = Color.CYAN;
                couleurTaille = Color.CYAN;
                couleurLabelTaille = Color.YELLOW;
                couleurBordJeu = Color.PINK;
                couleurBordTitre = Color.GREEN;
            }
        } else if (boucle % 520 == 0) {
            ImageTitre = RessourceImageTitre2;  //récupère la ressource dans le chemin suivant : NomProjet/src/NomProjet/NomFichier.extension
            if (pulsation >= 160 && pulsation <= 208) {
                smiley = RessourceSmiley2;
                Imagesolo = RessourceImageSolo2;
                indexRessourceAliment = 3;
                indexRessource = 3;
                couleurScore = Color.CYAN;
                couleurLabelScore = Color.YELLOW;
                couleurTaille = Color.YELLOW;
                couleurLabelTaille = Color.CYAN;
                couleurBordJeu = Color.YELLOW;
                couleurBordTitre = Color.RED;
            } else {
                smiley = null;
                indexRessourceAliment = 1;
                indexRessource = 1;

                couleurScore = Color.CYAN;
                couleurLabelScore = Color.YELLOW;
                couleurTaille = Color.YELLOW;
                couleurLabelTaille = Color.CYAN;
                couleurBordJeu = Color.GREEN;
                couleurBordTitre = Color.PINK;
            }
        }
        if (pulsation >= 160 && pulsation <= 207) {
            if ((boucle - (520 * pulsation)) % 520 == 0) {
                ImageTitre = RessourceBonus5;
            } else {
                if ((boucle - (520 * pulsation)) % 416 == 0) {
                    ImageTitre = RessourceBonus4;

                } else {
                    if ((boucle - (520 * pulsation)) % 312 == 0) {
                        ImageTitre = RessourceBonus3;
                    } else {
                        if ((boucle - (520 * pulsation)) % 208 == 0) {
                            ImageTitre = RessourceBonus2;
                        } else {
                            if ((boucle - (520 * pulsation)) % 104 == 0) {
                                ImageTitre = RessourceBonus1;

                            }
                        }
                    }
                }
            }
        }
        if (smiley != null) {
            smiley.paintIcon(this, g, 815, 250); //affiche l'image la où les coordonnées x,y sont indiqués, correspondant au coin supérieur gauche de l'image
            Imagesolo.paintIcon(this, g, 950, 230);
        } else {
            //affiche un rectangle qui masque smiley
            //g.setColor(couleurFond);
            //g.fillRect(651, 0, 600, 800);

            lecteurVideo = false;
            aliment.setPoint(50);
            timer.setDelay(delai);

        }
        ImageTitre.paintIcon(this, g, 25, 21); //affiche l'image la où les coordonnées x,y sont indiqués, correspondant au coin supérieur gauche de l'image
        this.dessineInterface(g);

        if (start) {
            Lecteur.stopAllAudio();
            Lecteur.stopVideo();
            start = false;
            indexRessource = 0; //récupère la ressource dans le chemin suivant : NomProjet/src/NomProjet/NomFichier.extension
            indexRessourceAliment = 0;
        }
        if (this.collisionSnake())//on verifie si la tête du snake percute un élément du corps
        {
            this.effetCollisionSnake();
        }
        for (int i = 0; i < joueur.getSerpent().size(); i++) //i va dans un premier temps être à 0, ce qui va dessiner l'element [0] à savoir la tête du serpent
        {
            if (i == 0 && !gameover) {
                switch (joueur.getTete().getDir()) {
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

            if (i != 0 && !gameover) //si le serpent possède déja une tête, c'est une partie du corps qui sera affichée en supplément
            {
                joueur.getRessourceCorps().get(indexRessource).paintIcon(this, g, joueur.getSerpent().get(i).getX(), joueur.getSerpent().get(i).getY()); //affiche l'image la où les coordonnées x,y sont indiqués, correspondant au coin supérieur gauche de l'image
            }
        }

        if (this.collisionAliment()) //si les abscices ET ordonnées d'un aliment et de la tête correspondent le serpent se nourrit de l'aliment
        {
            this.effetCollisionAliment();
        }
        if (!gameover) {
            aliment.getRessourcesAliment().get(indexRessourceAliment).paintIcon(this, g, aliment.getX(), aliment.getY()); //affiche l'image la où les coordonnées x,y sont indiqués, correspondant au coin supérieur gauche de l'image     
        }

        if (gameover) {
            try {
                this.affichageGameOver(g, joueur);
            } catch (IOException ex) {
                // Logger.getLogger(Jouable.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                //Logger.getLogger(Jouable.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                // Logger.getLogger(Jouable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        g.dispose();
    }

    /**
     * Permet de tout arrêter et remet tout à 0.
     *
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException
     */
    public void gameOver() throws IOException, FileNotFoundException, ClassNotFoundException, InterruptedException {
        Lecteur.stopAllAudio();
        Lecteur.stopVideo();
        if (highscore.getHighscore3() < joueur.getScore()) {
            pseudo.setJoueur(joueur);
            pseudo.setHighscore(highscore);
            pseudo.setText("");
            pseudo.setVisible(true);
            pseudo.toFront();
        }
        timer.stop();
        boucle = 0;
        pulsation = 0;
        lecteurVideo = false;
        test = false;
        start = true;
        joueur = new Joueur(this);
        aliment = new Aliment(this);
        init(joueur, aliment);
        pisteboucle = 1;
    }

    public HighscorePanel getPseudo() {
        return this.pseudo;
    }

    @Override
    public void keyPressed(KeyEvent e) //Evenement déclenché lors de l'appui sur une touche clavier (KeyListener)
    {
        if (((joueur.getDeplacement() == 0 && e.getKeyCode() == KeyEvent.VK_UP) || (joueur.getDeplacement() == 0 && e.getKeyCode() == KeyEvent.VK_DOWN) || (joueur.getDeplacement() == 0 && e.getKeyCode() == KeyEvent.VK_RIGHT)) && !gameover) {
            Lecteur.play("RessourcesSon/Disco Descent.mp3", 0.2);
            timer.start();
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (gameover) {
                gameover = false;
                repaint();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT && timer.isRunning() && !touche) //Si flèche droite appuyée        
        {
            if (!gameover) {
                joueur.increaseDeplacement();
                if (joueur.getTete().getDir() != left) {
                    joueur.getTete().setDir(right);
                }
                if (joueur.getTete().getDir() != right) {
                    touche = true;
                }

            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT && timer.isRunning() && !touche) //Si flèche gauche appuyée        
        {
            if (!gameover) {
                joueur.increaseDeplacement(); //on incrémente cette variable pour éviter que le joueur reste sur la position de démarrage
                if (joueur.getTete().getDir() != right) {
                    joueur.getTete().setDir(left);
                }
                if (joueur.getTete().getDir() != left) {
                    touche = true;
                }
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_UP && timer.isRunning() && !touche) //Si flèche haut appuyée        
        {
            if (!gameover) {
                joueur.increaseDeplacement(); //on incrémente cette variable pour éviter que le joueur reste sur la position de démarrage
                if (joueur.getTete().getDir() != down) {
                    joueur.getTete().setDir(up);
                }
                if (joueur.getTete().getDir() != up) {
                    touche = true;
                }
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN && timer.isRunning() && !touche) //Si flèche bas appuyée        
        {
            if (!gameover) {
                joueur.increaseDeplacement(); //on incrémente cette variable pour éviter que le joueur reste sur la position de démarrage
                if (joueur.getTete().getDir() != up) {
                    joueur.getTete().setDir(down);
                }
                if (joueur.getTete().getDir() != down) {
                    touche = true;
                }
            }
        }
    }

    /**
     * Méthode correspondant à l'action déroulée quand un évènement est
     * déclenché, ici, lorsqu'une touche a bien été appuyée.
     *
     * @param e correspond à l'évènement déclenché.
     */
    @Override
    public void actionPerformed(ActionEvent e) //Evenement déclenché lorsqu'une touche a bien été appuyée (ActionListener)
    {

        boucle += timer.getDelay();

        if (pulsation == 336 && !test) //2:55:500 //175500
        {
            test = true;
            Lecteur.play("RessourcesSon/DiscoDescentBoucle.mp3", 0.2);
            boucle = 1768;
            pulsation = 17;
            pisteboucle = 1;
        } else {
            if (pulsation == 336 && test) //2:47:060 //167060
            {
                if (pisteboucle == 1) {
                    Lecteur.play("RessourcesSon/DiscoDescentBoucle2.mp3", 0.2);
                    pisteboucle = 2;
                } else {
                    Lecteur.play("RessourcesSon/DiscoDescentBoucle.mp3", 0.2);
                    pisteboucle = 1;
                }
                boucle = 1768;
                pulsation = 17;
            }
        }
        if (boucle % 520 == 0) {
            pulsation++;
        }
        this.direction(joueur);
        repaint(); //rappelle la methode paint qui redessinera les éléments avec leurs nouvelles coordonnées
    }

    /**
     * Permet d'arrêter le timer du jeu.
     */
    public void stopTimer() {
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

    /**
     * Si le joueur percute un mur et qu'il se trouve en phase "bonus" (pulsaton
     * entre 160 et 207), le serpent peut traverser le mur, sinon, le joueur
     * perd.
     *
     * @param index correspond à un index qui permettra de localiser une partie
     * du corps du serpent et de le déplacer.
     */
    public void effetCollisionMur(int index) {
        if (pulsation >= 160 && pulsation <= 207) {
            switch (joueur.getTete().getDir()) {
                case up:
                    joueur.getSerpent().get(index).setY(650);
                    break;
                case right:
                    joueur.getSerpent().get(index).setX(25);
                    break;
                case left:
                    joueur.getSerpent().get(index).setX(850);
                    break;
                case down:
                    joueur.getSerpent().get(index).setY(100);
                    break;
                default:
            }
        } else {
            gameover = true;
        }
    }

    /**
     * Si le joueur percute un aliment (soleil ou pomme), le serpent sera
     * composé d'un nouvel élément, son score sera incrémenté de la valeur de
     * l'aliment, un aliment sera disposé de manière aléatoire et si l'aliment
     * est généré sur le corps du serpent, on change sa position.
     */
    public void effetCollisionAliment() {
        joueur.ajouterPartieCorps(); //la taille du serpent augmente
        joueur.addScore(aliment.getPoint()); //le score augmente
        aliment.placementAleatoire(); //génération d'une nouvelle position parmis les 34 positions possibles en abscisses et les 23 posistions possibles en ordonnées
        while (this.collisionCorpsFruit()) { //si le fruit est généré sur une partie du corps du serpent, on change ses coordonnées
            aliment.placementAleatoire();
        }
    }

    /**
     * Si le joueur se percute lui-même, la partie est perdue.
     */
    public void effetCollisionSnake() {
        gameover = true;
    }

    /**
     * Vérifie si le joueur (la tête du serpent) percute un aliment ou non.
     *
     * @return vrai si le joueur percute l'aliment et faux dans le cas
     * contraire.
     */
    public boolean collisionAliment() {
        boolean retour = false;
        if (joueur.getTete().getX() == aliment.getX() && joueur.getTete().getY() == aliment.getY()) {
            retour = true;
        }
        return retour;
    }

    /**
     * Vérifie si le joueur se percute lui-même.
     *
     * @return vrai si il se percute et faux dans le cas contraire.
     */
    public boolean collisionSnake() {
        boolean retour = false;
        for (int i = 1; i < joueur.getSerpent().size(); i++) {
            if (joueur.getTete().getX() == joueur.getSerpent().get(i).getX() && joueur.getTete().getY() == joueur.getSerpent().get(i).getY()) {
                retour = true;
            }
        }
        return retour;
    }

    /**
     * Vérifie si le corps du serpent a percuté un aliment.
     *
     * @return vrai si le corps du serpent a percuté un aliment et faux dans le
     * cas contraire.
     */
    public boolean collisionCorpsFruit() {
        boolean retour = false;
        for (int i = 0; i < joueur.getSerpent().size(); i++) {
            if (aliment.getX() == joueur.getSerpent().get(i).getX() && aliment.getY() == joueur.getSerpent().get(i).getY()) {
                retour = true;
            }
        }
        return retour;
    }

    /**
     * Vérifie si le joueur percute un mur que ce soit le droit, le gauche, le
     * bas ou le haut).
     *
     * @param index correspond à un index qui permettra de localiser une partie
     * du corps du serpent.
     * @return vrai si le joueur percute un mur et faux dans le cas contraire.
     */
    public boolean collisionMur(int index) {
        boolean retour = false;
        if ((joueur.getSerpent().get(index).getY() < 100) || (joueur.getSerpent().get(index).getX() > 850) || (joueur.getSerpent().get(index).getX() < 25) || (joueur.getSerpent().get(index).getY() > 650)) {
            retour = true;
        }
        return retour;
    }

    /**
     * Permet d'afficher l'écran de partie perdue.
     *
     * @param g correspond à une zone graphique.
     */
    public void affichageGameOver(Graphics g, Joueur j) throws IOException, FileNotFoundException, ClassNotFoundException, InterruptedException {
        //affiche un rectangle qui cache le smiley
        g.setColor(couleurFond);
        g.fillRect(880, 0, 600, 800);
        g.setColor(Color.white);
        g.setFont(new Font("algerian", Font.BOLD, 50)); //définition de l'écriture (police, type d'écriture, taille)
        g.drawString("GAME OVER !", 200, 300); //affciahge de la zone de texte (chaine à afficher, coordonnées x,y de la zone de texte)          
        g.setFont(new Font("algerian", Font.BOLD, 50)); //définition de l'écriture (police, type d'écriture, taille)
        g.drawString("Press SPACE To Restart !", 50, 450); //affciahge de la zone de texte (chaine à afficher, coordonnées x,y de la zone de texte)
        this.gameOver();
    }

    /**
     * Permet de diriger le corps du serpent selon la direction de la tête de ce
     * dernier.
     *
     * @param j correspond au joueur, donc au serpent.
     */
    public void direction(Joueur j) {
        if (!gameover) {
            switch (joueur.getTete().getDir()) {
                case up:
                    for (int i = joueur.getSerpent().size() - 1; i > 0; i--) //virage
                    {
                        joueur.getSerpent().get(i).setX(joueur.getSerpent().get(i - 1).getX());//fait suivre les éléments du corps jusqu'à la tête lors d'un virage
                    }
                    for (int i = joueur.getSerpent().size() - 1; i >= 0; i--) //boucle faisant bouger le serpent en modifiant les ordonnées
                    {
                        if (i == 0) //on bouge dans un premier temps l'élément 0 du corps qui est la tête
                        {
                            joueur.getSerpent().get(i).setY(joueur.getSerpent().get(i).getY() - 25); //coordonnées actuelles de la tête -25 px, taille correspondant à une case du jeu
                        } else //puis ce sera au tour du reste du corps de bouger et donc de suivre la tête
                        {
                            joueur.getSerpent().get(i).setY(joueur.getSerpent().get(i - 1).getY()); //une fois la tête bougée, l'élément suivant viendra prendre sa place et ainsi s'acroché a la tête; opération réalisée pour tout le reste du corps
                        }
                        if (this.collisionMur(i)) {
                            this.effetCollisionMur(i);
                        }
                    }
                    break;
                case right:
                    for (int i = joueur.getSerpent().size() - 1; i > 0; i--) //virage
                    {
                        joueur.getSerpent().get(i).setY(joueur.getSerpent().get(i - 1).getY());//fait suivre les éléments du corps jusqu'à la tête lors d'un virage
                    }
                    for (int i = joueur.getSerpent().size() - 1; i >= 0; i--) //boucle faisant bouger le serpent en modifiant les abscices
                    {
                        if (i == 0) //on bouge dans un premier temps l'élément 0 du corps qui est la tête
                        {
                            joueur.getSerpent().get(i).setX(joueur.getSerpent().get(i).getX() + 25); //coordonnées actuelles de la tête +25 px, taille correspondant à une case du jeu
                        } else //puis ce sera au tour du reste du corps de bouger et donc de suivre la tête
                        {
                            joueur.getSerpent().get(i).setX(joueur.getSerpent().get(i - 1).getX()); //une fois la tête bougée, l'élément suivant viendra prendre sa place et ainsi s'acroché a la tête; opération réalisée pour tout le reste du corps
                        }
                        if (this.collisionMur(i)) {
                            this.effetCollisionMur(i);
                        }
                    }

                    break;
                case left:
                    for (int i = joueur.getSerpent().size() - 1; i > 0; i--) //virage
                    {
                        joueur.getSerpent().get(i).setY(joueur.getSerpent().get(i - 1).getY());//fait suivre les éléments du corps jusqu'à la tête lors d'un virage
                    }
                    for (int i = joueur.getSerpent().size() - 1; i >= 0; i--) //boucle faisant bouger le serpent en modifiant les abscices
                    {
                        if (i == 0) //on bouge dans un premier temps l'élément 0 du corps qui est la tête
                        {
                            joueur.getSerpent().get(i).setX(joueur.getSerpent().get(i).getX() - 25); //coordonnées actuelles de la tête -25 px, taille correspondant à une case du jeu
                        } else //puis ce sera au tour du reste du corps de bouger et donc de suivre la tête
                        {
                            joueur.getSerpent().get(i).setX(joueur.getSerpent().get(i - 1).getX()); //une fois la tête bougée, l'élément suivant viendra prendre sa place et ainsi s'acroché a la tête; opération réalisée pour tout le reste du corps
                        }
                        if (this.collisionMur(i)) {
                            this.effetCollisionMur(i);
                        }
                    }
                    break;
                case down:
                    for (int i = joueur.getSerpent().size() - 1; i > 0; i--) //virage
                    {
                        joueur.getSerpent().get(i).setX(joueur.getSerpent().get(i - 1).getX());//fait suivre les éléments du corps jusqu'à la tête lors d'un virage
                    }
                    for (int i = joueur.getSerpent().size() - 1; i >= 0; i--) //boucle faisant bouger le serpent en modifiant les ordonnées
                    {
                        if (i == 0) //on bouge dans un premier temps l'élément 0 du corps qui est la tête
                        {
                            joueur.getSerpent().get(i).setY(joueur.getSerpent().get(i).getY() + 25); //coordonnées actuelles de la tête +25 px, taille correspondant à une case du jeu
                        } else //puis ce sera au tour du reste du corps de bouger et donc de suivre la tête
                        {
                            joueur.getSerpent().get(i).setY(joueur.getSerpent().get(i - 1).getY());; //une fois la tête bougée, l'élément suivant viendra prendre sa place et ainsi s'acroché a la tête; opération réalisée pour tout le reste du corps
                        }

                        if (this.collisionMur(i)) {
                            this.effetCollisionMur(i);
                        }
                    }
                    break;
                default:
                //throw new AssertionError(joueur.getTete().getDir().name());
            }
        }
    }

    /**
     * Permet d'afficher l'écran de jeu.
     *
     * @param g correspond à la zone graphique.
     */
    public void dessineInterface(Graphics g) {
        //définition des bords de l'image titre (dessine un rectangle)
        g.setColor(couleurBordTitre);
        g.drawRect(24, 20, 851, 55); //coordonnées x,y,largeur,longueur

        //définition des bords du jeu
        g.setColor(couleurBordJeu);
        g.drawRect(24, 99, 851, 576); //coordonnées x,y,largeur,longueur

        //définition de la zone de texte du score
        g.setColor(couleurScore);
        g.setFont(new Font("arial", Font.PLAIN, 14)); //définition de l'écriture (police, type d'écriture, taille)
        g.drawString("Score : ", 780, 40); //affciahge de la zone de texte (chaine à afficher, coordonnées x,y de la zone de texte)
        g.setColor(couleurLabelScore);
        g.setFont(new Font("arial", Font.PLAIN, 14)); //définition de l'écriture (police, type d'écriture, taille)
        g.drawString("" + joueur.getScore(), 830, 40); //affciahge de la zone de texte (chaine à afficher, coordonnées x,y de la zone de texte)

        //définition de la zone de texte de la taille du serpent
        g.setColor(couleurTaille);
        g.setFont(new Font("arial", Font.PLAIN, 14)); //définition de l'écriture (police, type d'écriture, taille)
        g.drawString("Taille : ", 783, 60); //affciahge de la zone de texte (chaine à afficher, coordonnées x,y de la zone de texte)
        g.setColor(couleurLabelTaille);
        g.setFont(new Font("arial", Font.PLAIN, 14)); //définition de l'écriture (police, type d'écriture, taille)
        g.drawString("" + joueur.getSerpent().size(), 830, 60); //affciahge de la zone de texte (chaine à afficher, coordonnées x,y de la zone de texte)

        //définition de l'arrière plan du jeu
        g.setColor(Color.BLACK);
        g.fillRect(25, 100, 850, 575);//coordonnées x,y,largeur,longueur        

        //définition de la zone highscore
        g.setColor(couleurLabelScore);
        g.setFont(new Font("arial", Font.PLAIN, 12));
        g.drawString("Highscore 1 : ", 30, 37);
        g.setColor(couleurLabelTaille);
        g.setFont(new Font("arial", Font.PLAIN, 12));
        g.drawString(highscore.getNomJoueur() + " - " + highscore.getHighscore1(), 110, 37);

        g.setColor(couleurLabelTaille);
        g.setFont(new Font("arial", Font.PLAIN, 12));
        g.drawString("Highscore 2 : ", 30, 51);
        g.setColor(couleurLabelScore);
        g.setFont(new Font("arial", Font.PLAIN, 12));
        g.drawString(highscore.getNomJoueur2() + " - " + highscore.getHighscore2(), 110, 51);

        g.setColor(couleurLabelScore);
        g.setFont(new Font("arial", Font.PLAIN, 12));
        g.drawString("Highscore 3 : ", 30, 65);
        g.setColor(couleurLabelTaille);
        g.setFont(new Font("arial", Font.PLAIN, 12));
        g.drawString(highscore.getNomJoueur3() + " - " + highscore.getHighscore3(), 110, 65);
    }
}
