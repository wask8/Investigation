package new_investigation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

public class PanelHistoire extends JPanel {

	private static final long serialVersionUID = 193869095035714316L;
	private int compteur = 0;
	private int nbcarte = 4;
	private int a;
	private int b;
	private JPanel panEntete = new JPanel();
	private JPanel panCarteext = new JPanel();
	private JPanel panCarte = new JPanel(new CardLayout());
	private CardLayout card = (CardLayout) panCarte.getLayout();
	private JPanel panLieu = new JPanel();
	private JLabel titre = new JLabel("Investigation");
	private JButton abandon = new JButton("Abandonner la partie");
	private JTextArea label1;
	private PanelOptions opt;
	private PanelHistoire histoire = this;
	private Fenetre fen;
	private PanelMenu menu;
	private CartesHistoire carteMayenne;
	private CartesHistoire carteLaval;
	private CartesHistoire carteIUT;
	private CartesHistoire carteDepartement;
	private List<String> question;
	private JScrollPane scroll;
	private List<Point> listpoint;
	private List<List<Point>> listdelistdepoint;
	private JButton commencer = new JButton("Commencer");
	// private List<CartesHistoire> cartes;

	JPanel pan = this;

	public PanelHistoire(final Fenetre fen, PanelOptions opt, final PanelMenu menu) {

		carteMayenne = new CartesHistoire(getClass().getResource("Mayenne.png"), panCarte.getSize());
		carteLaval = new CartesHistoire(getClass().getResource("Laval.jpg"), panCarte.getSize());
		carteIUT = new CartesHistoire(getClass().getResource("IUT.png"), panCarte.getSize());
		carteDepartement = new CartesHistoire(getClass().getResource("informatique.png"), panCarte.getSize());
		panCarte.add(carteMayenne, "1");
		panCarte.add(carteLaval, "2");
		panCarte.add(carteIUT, "3");
		panCarte.add(carteDepartement, "4");
		a = (int) fen.getWidth();
		b = (int) fen.getHeight();
		// PrÃ©paration de l'histoire

		// LAVAL 1

		listdelistdepoint = new ArrayList<List<Point>>();

		listpoint = new ArrayList<Point>();
		for (int i = 0; i < 19; i++) {
			if (i < 1) {
				listpoint.add(new Point((int) (a * 374 / 1920), (int) (b * 506 / 1080), true));
			} else {
				listpoint.add(new Point((int) (a * (Math.random() * (913 - 20)) / 1920),
						(int) (b * (Math.random() * (815 - 20)) / 1080), false));
			}

		}
		listdelistdepoint.add(listpoint);
		// __________________________________________________________________________________________________________________________________________

		// PLACE DU 11 2

		listpoint = new ArrayList<Point>();
		for (int i = 0; i < 20; i++) {
			if (i < 1) {
				listpoint.add(new Point((int) (a * 240 / 1366), (int) (b * 280 / 768), true));
			} else {
				listpoint.add(new Point((int) (a * (Math.random() * (913 - 20)) / 1920),
						(int) (b * (Math.random() * (815 - 20)) / 1080), false));
			}

		}
		listdelistdepoint.add(listpoint);

		// __________________________________________________________________________________________________________________________________________

		// IUT 3

		listpoint = new ArrayList<Point>();
		for (int i = 0; i < 20; i++) {
			if (i < 1) {
				listpoint.add(new Point((int) (a * 362 / 1366), (int) (b * 103 / 768), true));
			} else {
				listpoint.add(new Point((int) (a * (Math.random() * (913 - 20)) / 1920),
						(int) (b * (Math.random() * (815 - 20)) / 1080), false));
			}

		}
		listdelistdepoint.add(listpoint);

		// __________________________________________________________________________________________________________________________________________

		// DEP Info 4
		listpoint = new ArrayList<Point>();

		listpoint.add(new Point((int) (a * 169 / 1366), (int) (b * 236 / 768), true)); // info

		listpoint.add(new Point((int) (a * 145 / 1366), (int) (b * 286 / 768), false)); // Parking
																						// info

		listpoint.add(new Point((int) (a * 565 / 1366), (int) (b * 310 / 768), false)); // Arret
																						// TUL

		listpoint.add(new Point((int) (a * 231 / 1366), (int) (b * 198 / 768), false));// mmi

		listpoint.add(new Point((int) (a * 405 / 1366), (int) (b * 305 / 768), false)); // cafet
																						// iut

		listpoint.add(new Point((int) (a * 465 / 1366), (int) (b * 136 / 768), false));// RU

		listpoint.add(new Point((int) (a * 368 / 1366), (int) (b * 332 / 768), false));// GB

		listpoint.add(new Point((int) (a * 216 / 1366), (int) (b * 390 / 768), false));// la
																						// dormerie

		listpoint.add(new Point((int) (a * 279 / 1366), (int) (b * 289 / 768), false)); // BU

		listpoint.add(new Point((int) (a * 276 / 1366), (int) (b * 258 / 768), false)); // Salle
																						// d'exam

		listpoint.add(new Point((int) (a * 167 / 1366), (int) (b * 174 / 768), false)); // la
																						// marre
																						// aux
																						// crapauds

		listpoint.add(new Point((int) (a * 366 / 1366), (int) (b * 278 / 768), false)); // Amphi
																						// 1

		listpoint.add(new Point((int) (a * 364 / 1366), (int) (b * 289 / 768), false)); // Amphi
																						// 2

		listpoint.add(new Point((int) (a * 359 / 1366), (int) (b * 146 / 768), false)); // champ

		listpoint.add(new Point((int) (a * 226 / 1366), (int) (b * 442 / 768), false)); // aleatoire1

		listpoint.add(new Point((int) (a * 469 / 1366), (int) (b * 284 / 768), false)); // aleatoire2

		listpoint.add(new Point((int) (a * 397 / 1366), (int) (b * 457 / 768), false)); // aleatoire3

		listpoint.add(new Point((int) (a * 455 / 1366), (int) (b * 385 / 768), false)); // Conseillere
																						// sociale

		listpoint.add(new Point((int) (a * 549 / 1366), (int) (b * 264 / 768), false)); // Aleatoire4

		listpoint.add(new Point((int) (a * 343 / 1366), (int) (b * 222 / 768), false));// tc

		listpoint.add(new Point((int) (a * 408 / 1366), (int) (b * 267 / 768), false)); // Admin

		listdelistdepoint.add(listpoint);

		// __________________________________________________________________________________________________________________________________________

		// Gotham 5

		listpoint = new ArrayList<Point>();

		listpoint.add(new Point((int) (a * 232 / 1366), (int) (b * 59 / 768), true)); // TP3

		listpoint.add(new Point((int) (a * 72 / 1366), (int) (b * 89 / 768), false)); // TDM
																						// 3

		listpoint.add(new Point((int) (a * 87 / 1366), (int) (b * 427 / 768), false)); // Salle
																						// rÃ©union

		listpoint.add(new Point((int) (a * 565 / 1366), (int) (b * 494 / 768), false)); // TD1

		listpoint.add(new Point((int) (a * 381 / 1366), (int) (b * 231 / 768), false)); // TP1

		listpoint.add(new Point((int) (a * 78 / 1366), (int) (b * 205 / 768), false)); // TDM2

		listpoint.add(new Point((int) (a * 266 / 1366), (int) (b * 233 / 768), false)); // TP2

		listpoint.add(new Point((int) (a * 130 / 1366), (int) (b * 527 / 768), false)); // Bureau
																						// ERNET
																						// /
																						// VIEILLARD

		listpoint.add(new Point((int) (a * 174 / 1366), (int) (b * 346 / 768), false)); // Bureau
																						// Pierre
																						// LAFORCADE

		listpoint.add(new Point((int) (a * 257 / 1366), (int) (b * 529 / 768), false)); // Bureau
																						// Chef
																						// du
																						// DÃ©partement
																						// Yann
																						// WALKOWIAK

		listpoint.add(new Point((int) (a * 504 / 1366), (int) (b * 465 / 768), false)); // Machine
																						// Ã 
																						// cafÃ©

		listpoint.add(new Point((int) (a * 52 / 1366), (int) (b * 363 / 768), false)); // Salle
																						// Ã 
																						// cafÃ©

		listpoint.add(new Point((int) (a * 562 / 1366), (int) (b * 377 / 768), false)); // TD2

		listpoint.add(new Point((int) (a * 108 / 1366), (int) (b * 343 / 768), false)); // SEBASTIEN
																						// GORGE

		listpoint.add(new Point((int) (a * 307 / 1366), (int) (b * 344 / 768), false)); // TIBBS
																						// /
																						// KACEM

		listpoint.add(new Point((int) (a * 247 / 1366), (int) (b * 339 / 768), false)); // Vincent
																						// BARRE
																						// ET
																						// LAhCEN
																						// OUBAHSSI

		listpoint.add(new Point((int) (a * 571 / 1366), (int) (b * 89 / 768), false)); // TDM4

		listpoint.add(new Point((int) (a * 566 / 1366), (int) (b * 200 / 768), false)); // TDM1

		listpoint.add(new Point((int) (a * 58 / 1366), (int) (b * 524 / 768), false)); // IZA
																						// MARFISI
																						// ET
																						// LUDOVIC
																						// HAMON

		listpoint.add(new Point((int) (a * 200 / 1366), (int) (b * 522 / 768), false)); // Salle
																						// Nour
																						// EL
																						// MAWAS
																						// /Jean-Pierre
																						// CLAYER

		listdelistdepoint.add(listpoint);

		// __________________________________________________________________________________________________________________________________________

		// BU 6

		listpoint = new ArrayList<Point>();

		listpoint.add(new Point((int) (a * 279 / 1366), (int) (b * 289 / 768), true)); // BU

		listpoint.add(new Point((int) (a * 408 / 1366), (int) (b * 267 / 768), false)); // Admin

		listpoint.add(new Point((int) (a * 169 / 1366), (int) (b * 236 / 768), false)); // info

		listpoint.add(new Point((int) (a * 145 / 1366), (int) (b * 286 / 768), false)); // Parking
																						// info

		listpoint.add(new Point((int) (a * 565 / 1366), (int) (b * 310 / 768), false)); // Arret
																						// TUL

		listpoint.add(new Point((int) (a * 231 / 1366), (int) (b * 198 / 768), false));// mmi

		listpoint.add(new Point((int) (a * 405 / 1366), (int) (b * 305 / 768), false)); // cafet
																						// iut

		listpoint.add(new Point((int) (a * 465 / 1366), (int) (b * 136 / 768), false));// RU

		listpoint.add(new Point((int) (a * 368 / 1366), (int) (b * 332 / 768), false));// GB

		listpoint.add(new Point((int) (a * 216 / 1366), (int) (b * 390 / 768), false));// la
																						// dormerie

		listpoint.add(new Point((int) (a * 276 / 1366), (int) (b * 258 / 768), false)); // Salle
																						// d'exam

		listpoint.add(new Point((int) (a * 167 / 1366), (int) (b * 174 / 768), false)); // la
																						// marre
																						// aux
																						// crapauds

		listpoint.add(new Point((int) (a * 366 / 1366), (int) (b * 278 / 768), false)); // Amphi
																						// 1

		listpoint.add(new Point((int) (a * 364 / 1366), (int) (b * 289 / 768), false)); // Amphi
																						// 2

		listpoint.add(new Point((int) (a * 359 / 1366), (int) (b * 146 / 768), false)); // champ

		listpoint.add(new Point((int) (a * 226 / 1366), (int) (b * 442 / 768), false)); // aleatoire1

		listpoint.add(new Point((int) (a * 469 / 1366), (int) (b * 284 / 768), false)); // aleatoire2

		listpoint.add(new Point((int) (a * 397 / 1366), (int) (b * 457 / 768), false)); // aleatoire3

		listpoint.add(new Point((int) (a * 455 / 1366), (int) (b * 385 / 768), false)); // Conseillere
																						// sociale

		listpoint.add(new Point((int) (a * 549 / 1366), (int) (b * 264 / 768), false)); // Aleatoire4

		listpoint.add(new Point((int) (a * 343 / 1366), (int) (b * 222 / 768), false));// tc

		listdelistdepoint.add(listpoint);

		// __________________________________________________________________________________________________________________________________________

		// Admin 7

		listpoint = new ArrayList<Point>();

		listpoint.add(new Point((int) (a * 408 / 1366), (int) (b * 267 / 768), true)); // Admin

		listpoint.add(new Point((int) (a * 169 / 1366), (int) (b * 236 / 768), false)); // info

		listpoint.add(new Point((int) (a * 145 / 1366), (int) (b * 286 / 768), false)); // Parking
																						// info

		listpoint.add(new Point((int) (a * 565 / 1366), (int) (b * 310 / 768), false)); // Arret
																						// TUL

		listpoint.add(new Point((int) (a * 231 / 1366), (int) (b * 198 / 768), false));// mmi

		listpoint.add(new Point((int) (a * 405 / 1366), (int) (b * 305 / 768), false)); // cafet
																						// iut

		listpoint.add(new Point((int) (a * 465 / 1366), (int) (b * 136 / 768), false));// RU

		listpoint.add(new Point((int) (a * 368 / 1366), (int) (b * 332 / 768), false));// GB

		listpoint.add(new Point((int) (a * 216 / 1366), (int) (b * 390 / 768), false));// la
																						// dormerie

		listpoint.add(new Point((int) (a * 279 / 1366), (int) (b * 289 / 768), false)); // BU

		listpoint.add(new Point((int) (a * 276 / 1366), (int) (b * 258 / 768), false)); // Salle
																						// d'exam

		listpoint.add(new Point((int) (a * 167 / 1366), (int) (b * 174 / 768), false)); // la
																						// marre
																						// aux
																						// crapauds

		listpoint.add(new Point((int) (a * 366 / 1366), (int) (b * 278 / 768), false)); // Amphi
																						// 1

		listpoint.add(new Point((int) (a * 364 / 1366), (int) (b * 289 / 768), false)); // Amphi
																						// 2

		listpoint.add(new Point((int) (a * 359 / 1366), (int) (b * 146 / 768), false)); // champ

		listpoint.add(new Point((int) (a * 226 / 1366), (int) (b * 442 / 768), false)); // aleatoire1

		listpoint.add(new Point((int) (a * 469 / 1366), (int) (b * 284 / 768), false)); // aleatoire2

		listpoint.add(new Point((int) (a * 397 / 1366), (int) (b * 457 / 768), false)); // aleatoire3

		listpoint.add(new Point((int) (a * 455 / 1366), (int) (b * 385 / 768), false)); // Conseillere
																						// sociale

		listpoint.add(new Point((int) (a * 549 / 1366), (int) (b * 264 / 768), false)); // Aleatoire4

		listpoint.add(new Point((int) (a * 343 / 1366), (int) (b * 222 / 768), false));// tc

		listdelistdepoint.add(listpoint);

		// __________________________________________________________________________________________________________________________________________

		// Gare 8

		listpoint = new ArrayList<Point>();
		for (int i = 0; i < 20; i++) {
			if (i < 1) {
				listpoint.add(new Point((int) (a * 369 / 1366), (int) (b * 216 / 768), true));
			} else {
				listpoint.add(new Point((int) (a * (Math.random() * (913 - 20)) / 1920),
						(int) (b * (Math.random() * (815 - 20)) / 1080), false));
			}

		}
		listdelistdepoint.add(listpoint);

		// __________________________________________________________________________________________________________________________________________

		// Theatre 9

		listpoint = new ArrayList<Point>();
		for (int i = 0; i < 20; i++) {
			if (i < 1) {
				listpoint.add(new Point((int) (a * 286 / 1366), (int) (b * 279 / 768), true));
			} else {
				listpoint.add(new Point((int) (a * (Math.random() * (913 - 20)) / 1920),
						(int) (b * (Math.random() * (815 - 20)) / 1080), false));
			}

		}
		listdelistdepoint.add(listpoint);

		// __________________________________________________________________________________________________________________________________________

		// Evron 10

		listpoint = new ArrayList<Point>();
		for (int i = 0; i < 20; i++) {
			if (i < 1) {
				listpoint.add(new Point((int) (a * 445 / 1366), (int) (b * 295 / 768), true));
			} else {
				listpoint.add(new Point((int) (a * (Math.random() * (913 - 20)) / 1920),
						(int) (b * (Math.random() * (815 - 20)) / 1080), false));
			}

		}
		listdelistdepoint.add(listpoint);

		// __________________________________________________________________________________________________________________________________________

		// Mayenne 11
		//
		// listpoint = new ArrayList<Point>();
		// for (int i = 0; i < 20; i++) {
		// if (i < 1) {
		// listpoint.add(new Point((int) (a * 345 / 1366), (int) (b * 200 /
		// 768), true));
		// } else {
		// listpoint.add(new Point((int) (a * (Math.random() * (913 - 20)) /
		// 1920),
		// (int) (b * (Math.random() * (815 - 20)) / 1080), false));
		// }
		//
		// }
		// listdelistdepoint.add(listpoint);

		// __________________________________________________________________________________________________________________________________________

		// Frontiere manche 11

		listpoint = new ArrayList<Point>();
		for (int i = 0; i < 20; i++) {
			if (i < 1) {
				listpoint.add(new Point((int) (a * 159 / 1366), (int) (b * 91 / 768), true));
			} else {
				listpoint.add(new Point((int) (a * (Math.random() * (913 - 20)) / 1920),
						(int) (b * (Math.random() * (815 - 20)) / 1080), false));
			}

		}
		listdelistdepoint.add(listpoint);

		// __________________________________________________________________________________________________________________________________________

		// Hotel de police 12

		listpoint = new ArrayList<Point>();
		for (int i = 0; i < 20; i++) {
			if (i < 1) {
				listpoint.add(new Point((int) (a * 198 / 1366), (int) (b * 361 / 768), true));
			} else {
				listpoint.add(new Point((int) (a * (Math.random() * (913 - 20)) / 1920),
						(int) (b * (Math.random() * (815 - 20)) / 1080), false));
			}

		}
		listdelistdepoint.add(listpoint);

		// __________________________________________________________________________________________________________________________________________

		// Prefecture 13

		listpoint = new ArrayList<Point>();
		for (int i = 0; i < 20; i++) {
			if (i < 1) {
				listpoint.add(new Point((int) (a * 290 / 1366), (int) (b * 292 / 768), true));
			} else {
				listpoint.add(new Point((int) (a * (Math.random() * (913 - 20)) / 1920),
						(int) (b * (Math.random() * (815 - 20)) / 1080), false));
			}

		}
		listdelistdepoint.add(listpoint);

		// __________________________________________________________________________________________________________________________________________
		// cartes = new ArrayList<CartesHistoire>();
		question = new ArrayList<String>();
		question.add("Assistance Eclipse : Bonjour jeune apprenti " + opt.getZonePseudo().getText()
				+ ", la police veut que vous vous rendiez \nen Mayenne, plus prÃ©cisÃ©ment sur Laval.\nPrÃ©parez-vous, et rendez vous sur Laval et je vous recontacterai une fois arrivÃ©. "
				+ "\nALLEZ A LAVAL");
		// cartes.add(carteMayenne);
		question.add(
				"Assistante Eclipse : Bien, nous y voilÃ , l'Ã©quipe de police nous attend sur la place\n du 11 Novembre.\nALLEZ A LA PLACE DU 11 NOVEMBRE");
		// cartes.add(carteLaval);
		question.add("Capitaine Python : C'est donc vous l'apprenti " + opt.getZonePseudo().getText()
				+ " ?\n Bien, sans plus tarder, nous allons nous diriger sur les lieux du crime.\n Vous allez constater les faits par vous-mÃªme.\n Le crime a eu lieu Ã  l'Institut Universitaire Technologique.\n ALLEZ A L'IUT");
		// cartes.add(carteLaval);
		question.add(
				"Capitaine Python : Un tÃ©moin a vu une personne s'enfuir en courant.\n Il semblerait qu'il se dirigeait vers le dÃ©partement informatique.\nPLACEZ LE DEPARTEMENT INFORMATIQUE");
		// cartes.add(carteIUT);
		question.add(
				"Assistante Eclipse : Il y a de la lumiÃ¨re dans l'une des salles au premier Ã©tage.\n C'est Ã©trange... Il s'agit de la salle Gotham.\n ALLEZ A LA SALLE GOTHAM");
		// cartes.add(carteDepartement);
		question.add(
				"Capitaine Python : (au moment d'entrer dans la salle) Une vitre a Ã©tÃ© brisÃ©e !\nQuelqu'un cours vers la BibliothÃ¨que Universitaire !\nALLEZ A LA BIBLIOTHEQUE UNIVERSITAIRE");
		// cartes.add(carteDepartement);
		question.add(
				"Assistante Eclipse : Dehors) : Il est parti dans une voiture verte qui se dirige vers\n l'administration ! Retrouvons-le !\n ALLEZ A L'ADMINISTRATION");
		// cartes.add(carteDepartement);
		question.add(
				"Capitaine Python : Un tÃ©moin indique que la voiture se dirige vers la gare !\n Vite retrouvons-le.\nALLEZ A LA GARE");
		// cartes.add(carteLaval);
		question.add(
				"Assistante Eclipse : La voiture n'est plus lÃ  !\nIl semblerait qu'elle ait quittÃ© la gare il y a peu, elle se dirige vers le thÃ©Ã¢tre.\nALLEZ AU THEATRE");
		// cartes.add(carteLaval);
		question.add(
				"Capitaine Python : Non ce n'Ã©tait pas ici !\nLa voiture a Ã©tÃ© signalÃ© Ã  la sortie de la ville \net se dirige vers Evron, il faut le retrouver au plus vite !");
		// cartes.add(carteMayenne);
		question.add(
				"Capitaine Python : Il faut le rattraper !\nIl essaye de fuir vers la Manche, ne le laissez pas quitter la Mayenne.\nALLEZ AU POINT A LA FRONTIERE AVEC LA MANCHE");
		// cartes.add(carteMayenne);
		question.add(
				"Capitaine Python : Ne bouge plus !\nVous Ãªtes en Ã©tat d'arrestation pour avoir dÃ©branchÃ© le cÃ¢ble Ethernet\n et pour dÃ©lit de fuite !\nC'est un crime impardonnable !\nRENDEZ VOUS A L'HOTEL DE POLICE");

		question.add(
				"Suspect Luna : NON NON NON !!  ... Comment avez vous pu me rattraper ?!\n Je me vengerai ! \n Appuyer sur le bouton Suivant");

		question.add("Capitaine Python : Bien jouÃ© apprenti " + opt.getZonePseudo().getText()
				+ "! Vu votre efficacitÃ©,\nvous ne pouvez qu'etre promu dans notre service, vous devenez Sergent !\nRENDEZ VOUS A LA PREFECTURE POUR FETER VOTRE PROMOTION");

		question.add("Assistante Eclipse : FÃ©licitations " + opt.getZonePseudo().getText()
				+ "!!\nvous avez rÃ©ussi avec brio votre mission, nous referons appel Ã  vous rapidement.");

		// FENETRE GLOBALE

		this.opt = opt;
		this.menu = menu;
		this.fen = fen;
		this.setPreferredSize(new Dimension(a, b));
		this.setOpaque(false);
		this.setLayout(null);

		Font f2 = new Font("Calibri", Font.PLAIN, a * 30 / 1366);
		Font f3 = new Font("Calibri", Font.PLAIN, a * 18 / 1366);
		Font f5 = new Font("Calibri", Font.PLAIN, a * 13 / 1366);

		// AJOUT PANEL panEntete ET ELEMENTS
		panEntete.setLayout(null);
		panEntete.setBounds(0, 0, a, (int) (b / 4));
		panEntete.setOpaque(false);
		panEntete.add(commencer);
		panEntete.add(abandon);
		abandon.setLayout(null);
		abandon.setOpaque(false);
		abandon.setFont(f5);
		abandon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Popup pop = new Popup(fen, menu, histoire);
				fen.revalidate();
			}
		});

		abandon.setBounds(a * 1110 / 1366, b * 20 / 768, a * 170 / 1366, b * 25 / 768);
		commencer.setBounds(a * 1110 / 1366, b * 70 / 768, a * 100 / 1366, b * 25 / 768);
		commencer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panEntete.remove(commencer);
				panEntete.repaint();
				for (int i = 0; i < listdelistdepoint.get(compteur).size(); i++) {
					listdelistdepoint.get(compteur).get(i).setBounds(listdelistdepoint.get(compteur).get(i).getX(),
							listdelistdepoint.get(compteur).get(i).getY(), a * 18 / 1920, a * 18 / 1920);

					panCarteext.add(listdelistdepoint.get(compteur).get(i));
				}

				CarteMouselistener();
				label1.setText(question.get(compteur));
				panCarteext.repaint();

			}
		});

		// AJOUT PANEL panCarte ET ELEMENTS
		panCarte.setOpaque(false);
		panCarte.setBounds((a - (a * 650 / 1366)) / 2, b * 130 / 768, a * 650 / 1366, b * 580 / 768);
		panCarteext.setBounds((a - (a * 650 / 1366)) / 2, b * 130 / 768, a * 650 / 1366, b * 580 / 768);
		// panCarte.add(cartes.get(compteur));
		panCarteext.setOpaque(false);
		panCarteext.setLayout(null);

		// AJOUT PANEL panLeu ET ELEMENTS
		panLieu.setLayout(null);
		panLieu.setOpaque(true);
		panLieu.setBounds(a * 150 / 1366, b * 25 / 768, a * 800 / 1366, b * 75 / 768);

		// SCENARIO
		label1 = new JTextArea();
		label1.setEditable(false);
		label1.setText("Cliquez sur Commencer pour dÃ©marrer l'histoire ");
		scroll = new JScrollPane(label1);
		panLieu.add(scroll);
		scroll.setOpaque(false);
		scroll.setBounds(a * 0 / 1366, b * 0 / 768, a * 800 / 1366, b * 75 / 768);

		label1.setFont(f3);

		this.add(panCarteext);
		this.add(panEntete);
		this.add(panCarte);
		this.add(panLieu);

		fen.getRootPane().addComponentListener(new ComponentListener() {

			@Override
			public void componentShown(ComponentEvent e) {

			}

			@Override
			public void componentResized(ComponentEvent e) {
				a = fen.getWidth();
				b = fen.getHeight();

				Font f0 = new Font("Calibri", Font.PLAIN, a * 80 / 1366);
				Font f1 = new Font("Calibri", Font.PLAIN, a * 50 / 1366);
				Font f2 = new Font("Calibri", Font.PLAIN, a * 30 / 1366);
				Font f3 = new Font("Calibri", Font.PLAIN, a * 18 / 1366);

				panLieu.setBounds(a * 150 / 1366, b * 25 / 768, a * 800 / 1366, b * 75 / 768);
				panEntete.setBounds(0, 0, a, (int) (b / 4));
				abandon.setBounds(a * 1110 / 1366, b * 20 / 768, a * 170 / 1366, b * 25 / 768);
				panCarte.setBounds((a - (a * 650 / 1366)) / 2, b * 130 / 768, a * 650 / 1366, b * 620 / 768);
				panCarteext.setBounds((a - (a * 650 / 1366)) / 2, b * 130 / 768, a * 650 / 1366, b * 580 / 768);
				panLieu.setBounds(a * 150 / 1366, b * 25 / 768, a * 800 / 1366, b * 75 / 768);
				scroll.setBounds(a * 15 / 1366, b * 5 / 768, a * 800 / 1366, b * 75 / 768);

				fen.revalidate();
			}

			@Override
			public void componentMoved(ComponentEvent e) {

			}

			@Override
			public void componentHidden(ComponentEvent e) {

			}
		});

	}

	public void CarteMouselistener() {
		listdelistdepoint.get(compteur).get(0).addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					compteur++;
					if (compteur < 1) {

					} else if (compteur < 3) {
						card.show(panCarte, "2");
					} else if (compteur < 4) {
						card.show(panCarte, "3");

					} else if (compteur < 5) {
						card.show(panCarte, "4");
					} else if (compteur < 7) {
						card.show(panCarte, "3");
					} else if (compteur < 9) {
						card.show(panCarte, "2");
					} else if (compteur < 11) {
						card.show(panCarte, "1");
					} else if (compteur < 12) {
						card.show(panCarte, "2");
					} else {
						final JButton btn = new JButton("Suivant");
						for (int i = 0; i < listdelistdepoint.get(compteur - 1).size(); i++) {
							panCarteext.remove(listdelistdepoint.get(compteur - 1).get(i));
						}
						btn.setBounds(a * 1110 / 1366, b * 70 / 768, a * 100 / 1366, b * 25 / 768);
						panEntete.add(btn);
						panEntete.repaint();
						btn.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								compteur++;
								label1.setText(question.get(compteur));
								if (compteur == 13) {
									for (int i = 0; i < listdelistdepoint.get(listdelistdepoint.size() - 1)
											.size(); i++) {
										listdelistdepoint.get(listdelistdepoint.size() - 1).get(i)
												.setBounds(listdelistdepoint.get(listdelistdepoint.size() - 1).get(i)
														.getX(),
												listdelistdepoint.get(listdelistdepoint.size() - 1).get(i).getY(),
												a * 18 / 1920, a * 18 / 1920);
										panCarteext.add(listdelistdepoint.get(listdelistdepoint.size() - 1).get(i));
									}
									btn.setVisible(false);
									listdelistdepoint.get(listdelistdepoint.size() - 1).get(0)
											.addMouseListener(new MouseListener() {

										@Override
										public void mouseReleased(MouseEvent e) {
											// TODO Auto-generated method stub

										}

										@Override
										public void mousePressed(MouseEvent e) {
											// TODO Auto-generated method stub

										}

										@Override
										public void mouseExited(MouseEvent e) {
											// TODO Auto-generated method stub

										}

										@Override
										public void mouseEntered(MouseEvent e) {
											// TODO Auto-generated method stub

										}

										@Override
										public void mouseClicked(MouseEvent e) {
											btn.setVisible(false);
											compteur++;
											label1.setText(question.get(compteur));

											histoire.remove(panCarteext);

											JButton fin = new JButton("Fin");
											fin.setBounds(a * 1110 / 1366, b * 70 / 768, a * 100 / 1366, b * 25 / 768);
											panEntete.add(fin);
											fin.addActionListener(new ActionListener() {

												@Override
												public void actionPerformed(ActionEvent e) {
													fen.setContentPane(menu);
													fen.remove(histoire);

												}
											});
											panEntete.remove(btn);
											panEntete.repaint();
										}
									});
									panCarteext.repaint();

								}
								if (compteur == 14) {

								}

							}
						});
					}
					if (compteur < 12) {
						for (int i = 0; i < listdelistdepoint.get(compteur).size(); i++) {
							listdelistdepoint.get(compteur).get(i).setBounds(
									listdelistdepoint.get(compteur).get(i).getX(),
									listdelistdepoint.get(compteur).get(i).getY(), a * 18 / 1920, a * 18 / 1920);
							panCarteext.add(listdelistdepoint.get(compteur).get(i));
						}

						for (int i = 0; i < listdelistdepoint.get(compteur - 1).size(); i++) {
							panCarteext.remove(listdelistdepoint.get(compteur - 1).get(i));
						}

						CarteMouselistener();
					}
					;
					label1.setText(question.get(compteur));
					panCarte.repaint();
					panCarteext.repaint();

				} catch (Exception e1) {
					System.out.println("erreur");
				}

			}
		});
	}

	public void paintComponent(Graphics g) {
		try {
			Image img = ImageIO.read(getClass().getResource("investigation.jpg"));
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getNbcarte() {
		return nbcarte;
	}

	public void setNbcarte(int nbcarte) {
		this.nbcarte = nbcarte;
	}

	public JButton getAbandon() {
		return abandon;
	}

	public void setAbandon(JButton abandon) {
		this.abandon = abandon;
	}

}
