package new_investigation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanelChoixCarteArcade extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4125389561295280131L;
	private int a;
	private int b;
	private JPanel panEntete = new JPanel();
	private JPanel entete = new JPanel();
	private JPanel panQuestion = new JPanel();
	private JPanel panCartes = new JPanel();
	private JPanel panRetour = new JPanel();
	private JLabel titre = new JLabel("Investigation");
	private JLabel question = new JLabel("Selectionnez la carte sur laquelle vous souhaitez jouer");
	private JButton bouton = new JButton("Retour");
	private JScrollPane scroll;
	private PanelChoixCarteArcade choixArcade = this;
	private Cartes mayenne;
	private JPanel pan;
	private Cartes laval;
	private JPanel pan1;
	private Cartes iut;
	private JPanel pan2;
	private Cartes informatique;
	private JPanel pan3;
	private List<Cartes> listCarteXML = new ArrayList<Cartes>();
	private List<String> questionArcade = new ArrayList<String>();


	public PanelChoixCarteArcade(final Fenetre fen, final PanelMenu menu, PanelOptions opt) {

		a = (int) fen.getWidth();
		b = (int) fen.getHeight();

		// Carte Mayenne//
		List<Point> listpoint;
		List<List<Point>> listdelistdepoint = new ArrayList<List<Point>>();
		// question1
		listpoint = new ArrayList<Point>();
		questionArcade = new ArrayList<String>();
		questionArcade.add("Cherchez Laval");
		for (int i = 0; i < 19; i++) {
			if (i < 1) {
				listpoint.add(new Point((int) (a * 374 / 1920), (int) (b * 506 / 1080), true));
			} else {
				listpoint.add(new Point((int) (a * (Math.random() * (913 - 20)) / 1920),
						(int) (b * (Math.random() * (815 - 20)) / 1080), false));
			}

		}
		listdelistdepoint.add(listpoint);
		// question2
		listpoint = new ArrayList<Point>();
		questionArcade.add("Cherchez Mayenne");
		for (int i = 0; i < 19; i++) {
			if (i < 1) {
				listpoint.add(new Point((int) (a * 345 / 1366), (int) (b * 200 / 768), true));
			} else {
				listpoint.add(new Point((int) (a * (Math.random() * (913 - 20)) / 1920),
						(int) (b * (Math.random() * (815 - 20)) / 1080), false));
			}

		}
		listdelistdepoint.add(listpoint);
		// question3
		questionArcade.add("Cherchez Evron");
		listpoint = new ArrayList<Point>();
		for (int i = 0; i < 19; i++) {
			if (i < 1) {
				listpoint.add(new Point((int) (a * 445 / 1366), (int) (b * 295 / 768), true));
			} else {
				listpoint.add(new Point((int) (a * (Math.random() * (913 - 20)) / 1920),
						(int) (b * (Math.random() * (815 - 20)) / 1080), false));
			}

		}
		listdelistdepoint.add(listpoint);
		questionArcade.add("Cherchez ChÃ¢teau-gontier");
		// question4
		listpoint = new ArrayList<Point>();
		for (int i = 0; i < 19; i++) {
			if (i < 1) {
				listpoint.add(new Point((int) (a * 301 / 1366), (int) (b * 505 / 768), true));
			} else {
				listpoint.add(new Point((int) (a * (Math.random() * (913 - 20)) / 1920),
						(int) (b * (Math.random() * (815 - 20)) / 1080), false));
			}

		}
		listdelistdepoint.add(listpoint);
		// question5
		questionArcade.add("Cherchez RenazÃ©");
		listpoint = new ArrayList<Point>();
		for (int i = 0; i < 19; i++) {
			if (i < 1) {
				listpoint.add(new Point((int) (a * 136 / 1366), (int) (b * 515 / 768), true));
			} else {
				listpoint.add(new Point((int) (a * (Math.random() * (913 - 20)) / 1920),
						(int) (b * (Math.random() * (815 - 20)) / 1080), false));
			}

		}
		listdelistdepoint.add(listpoint);
		// question6
		questionArcade.add("Cherchez BiernÃ©");
		listpoint = new ArrayList<Point>();
		for (int i = 0; i < 19; i++) {
			if (i < 1) {
				listpoint.add(new Point((int) (a * 386 / 1366), (int) (b * 508 / 768), true));
			} else {
				listpoint.add(new Point((int) (a * (Math.random() * (913 - 20)) / 1920),
						(int) (b * (Math.random() * (815 - 20)) / 1080), false));
			}

		}
		listdelistdepoint.add(listpoint);
		// question7
		questionArcade.add("Cherchez ErnÃ©e");
		listpoint = new ArrayList<Point>();
		for (int i = 0; i < 19; i++) {
			if (i < 1) {
				listpoint.add(new Point((int) (a * 179 / 1366), (int) (b * 202 / 768), true));
			} else {
				listpoint.add(new Point((int) (a * (Math.random() * (913 - 20)) / 1920),
						(int) (b * (Math.random() * (815 - 20)) / 1080), false));
			}

		}
		listdelistdepoint.add(listpoint);
		// question8
		questionArcade.add("Cherchez Goron");
		listpoint = new ArrayList<Point>();
		for (int i = 0; i < 19; i++) {
			if (i < 1) {
				listpoint.add(new Point((int) (a * 243 / 1366), (int) (b * 135 / 768), true));
			} else {
				listpoint.add(new Point((int) (a * (Math.random() * (913 - 20)) / 1920),
						(int) (b * (Math.random() * (815 - 20)) / 1080), false));
			}

		}
		listdelistdepoint.add(listpoint);
		// question9
		questionArcade.add("Cherchez Villaines la Juhel");
		listpoint = new ArrayList<Point>();
		for (int i = 0; i < 19; i++) {
			if (i < 1) {
				listpoint.add(new Point((int) (a * 484 / 1366), (int) (b * 162 / 768), true));
			} else {
				listpoint.add(new Point((int) (a * (Math.random() * (913 - 20)) / 1920),
						(int) (b * (Math.random() * (815 - 20)) / 1080), false));
			}

		}
		listdelistdepoint.add(listpoint);
		// question10
		questionArcade.add("Cherchez Saint Aignan sur RoÃ«");
		listpoint = new ArrayList<Point>();
		for (int i = 0; i < 19; i++) {
			if (i < 1) {
				listpoint.add(new Point((int) (a * 94 / 1366), (int) (b * 482 / 768), true));
			} else {
				listpoint.add(new Point((int) (a * (Math.random() * (913 - 20)) / 1920),
						(int) (b * (Math.random() * (815 - 20)) / 1080), false));
			}

		}
		listdelistdepoint.add(listpoint);
		// Carte Mayenne//

		mayenne = new Cartes(new Dimension(a * 650 / 1366, b * 580 / 768), fen, getClass().getResource("Mayenne.png"),
				"Mayenne", listdelistdepoint, questionArcade, opt, menu, choixArcade);
		pan = mayenne.getMiniature();

		// Carte Laval//
		
		questionArcade = new ArrayList<String>();
		listdelistdepoint = new ArrayList<List<Point>>();
		// question1
		questionArcade.add("Cherchez le PrÃ©fecture de Mayenne");
		listpoint = new ArrayList<Point>();
		for (int i = 0; i < 19; i++) {
			if (i < 1) {
				listpoint.add(new Point((int) (a * 290 / 1366), (int) (b * 292 / 768), true));
			} else {
				listpoint.add(new Point((int) (a * (Math.random() * (913 - 20)) / 1920),
						(int) (b * (Math.random() * (815 - 20)) / 1080), false));
			}

		}
		listdelistdepoint.add(listpoint);
		// question2
		questionArcade.add("Cherchez l'IUT");
		listpoint = new ArrayList<Point>();
		for (int i = 0; i < 19; i++) {
			if (i < 1) {
				listpoint.add(new Point((int) (a * 366 / 1366), (int) (b * 104 / 768), true));
			} else {
				listpoint.add(new Point((int) (a * (Math.random() * (913 - 20)) / 1920),
						(int) (b * (Math.random() * (815 - 20)) / 1080), false));
			}

		}
		listdelistdepoint.add(listpoint);
		// question3
		questionArcade.add("Cherchez la gare");
		listpoint = new ArrayList<Point>();
		for (int i = 0; i < 19; i++) {
			if (i < 1) {
				listpoint.add(new Point((int) (a * 367 / 1366), (int) (b * 217 / 768), true));
			} else {
				listpoint.add(new Point((int) (a * (Math.random() * (913 - 20)) / 1920),
						(int) (b * (Math.random() * (815 - 20)) / 1080), false));
			}

		}
		listdelistdepoint.add(listpoint);
		// question4
		questionArcade.add("Cherchez le tribunal de grande instance");
		listpoint = new ArrayList<Point>();
		for (int i = 0; i < 19; i++) {
			if (i < 1) {
				listpoint.add(new Point((int) (a * 224 / 1366), (int) (b * 297 / 768), true));
			} else {
				listpoint.add(new Point((int) (a * (Math.random() * (913 - 20)) / 1920),
						(int) (b * (Math.random() * (815 - 20)) / 1080), false));
			}

		}
		listdelistdepoint.add(listpoint);
		// question5
		questionArcade.add("Cherchez le centre hospitalier");
		listpoint = new ArrayList<Point>();
		for (int i = 0; i < 19; i++) {
			if (i < 1) {
				listpoint.add(new Point((int) (a * 141 / 1366), (int) (b * 355 / 768), true));
			} else {
				listpoint.add(new Point((int) (a * (Math.random() * (913 - 20)) / 1920),
						(int) (b * (Math.random() * (815 - 20)) / 1080), false));
			}

		}
		questionArcade.add("Cherchez la CAF de la Mayenne");
		listdelistdepoint.add(listpoint);
		// question6
		listpoint = new ArrayList<Point>();
		for (int i = 0; i < 19; i++) {
			if (i < 1) {
				listpoint.add(new Point((int) (a * 276 / 1366), (int) (b * 313 / 768), true));
			} else {
				listpoint.add(new Point((int) (a * (Math.random() * (913 - 20)) / 1920),
						(int) (b * (Math.random() * (815 - 20)) / 1080), false));
			}

		}
		listdelistdepoint.add(listpoint);
		// question7
		questionArcade.add("Cherchez la Mairie");
		listpoint = new ArrayList<Point>();
		for (int i = 0; i < 19; i++) {
			if (i < 1) {
				listpoint.add(new Point((int) (a * 217 / 1366), (int) (b * 286 / 768), true));
			} else {
				listpoint.add(new Point((int) (a * (Math.random() * (913 - 20)) / 1920),
						(int) (b * (Math.random() * (815 - 20)) / 1080), false));
			}

		}

		listdelistdepoint.add(listpoint);
		// question8
		questionArcade.add("Cherchez le cinÃ©ville");
		listpoint = new ArrayList<Point>();
		for (int i = 0; i < 19; i++) {
			if (i < 1) {
				listpoint.add(new Point((int) (a * 242 / 1366), (int) (b * 265 / 768), true));
			} else {
				listpoint.add(new Point((int) (a * (Math.random() * (913 - 20)) / 1920),
						(int) (b * (Math.random() * (815 - 20)) / 1080), false));
			}

		}
		listdelistdepoint.add(listpoint);
		// question9
		questionArcade.add("Cherchez le square de Boston");
		listpoint = new ArrayList<Point>();
		for (int i = 0; i < 19; i++) {
			if (i < 1) {
				listpoint.add(new Point((int) (a * 244 / 1366), (int) (b * 246 / 768), true));
			} else {
				listpoint.add(new Point((int) (a * (Math.random() * (913 - 20)) / 1920),
						(int) (b * (Math.random() * (815 - 20)) / 1080), false));
			}

		}
		listdelistdepoint.add(listpoint);
		// question10
		questionArcade.add("Cherchez la basilique notre Dame d'AvesniÃ¨res");
		listpoint = new ArrayList<Point>();
		for (int i = 0; i < 19; i++) {
			if (i < 1) {
				listpoint.add(new Point((int) (a * 322 / 1366), (int) (b * 407 / 768), true));
			} else {
				listpoint.add(new Point((int) (a * (Math.random() * (913 - 20)) / 1920),
						(int) (b * (Math.random() * (815 - 20)) / 1080), false));
			}

		}
		listdelistdepoint.add(listpoint);
		// Carte Laval//

		laval = new Cartes(new Dimension(a * 650 / 1366, b * 580 / 768), fen, getClass().getResource("Laval.jpg"),
				"Laval", listdelistdepoint, questionArcade, opt, menu, choixArcade);
		pan1 = laval.getMiniature();

		// Carte iut//
		listdelistdepoint = new ArrayList<List<Point>>();
		// Question1 Dep Info

		questionArcade = new ArrayList<String>();
		questionArcade.add("Cherchez le dÃ©partement Informatique");

		listpoint = new ArrayList<Point>();

		listpoint.add(new Point((int) (a * 169 / 1366), (int) (b * 236 / 768), true)); // info

		listpoint.add(new Point((int) (a * 231 / 1366), (int) (b * 198 / 768), false));// mmi

		listpoint.add(new Point((int) (a * 565 / 1366), (int) (b * 310 / 768), false)); // ArrÃªt
		// TUL

		listpoint.add(new Point((int) (a * 405 / 1366), (int) (b * 305 / 768), false)); // cafet
																						// iut

		listpoint.add(new Point((int) (a * 465 / 1366), (int) (b * 136 / 768), false));// RU

		listpoint.add(new Point((int) (a * 368 / 1366), (int) (b * 332 / 768), false));// GB

		listpoint.add(new Point((int) (a * 216 / 1366), (int) (b * 390 / 768), false));// la
																						// dormerie

		listpoint.add(new Point((int) (a * 145 / 1366), (int) (b * 286 / 768), false)); // Parking
																						// info

		listpoint.add(new Point((int) (a * 279 / 1366), (int) (b * 289 / 768), false)); // BU

		listpoint.add(new Point((int) (a * 276 / 1366), (int) (b * 258 / 768), false)); // Sall
																						// d'exam

		listpoint.add(new Point((int) (a * 167 / 1366), (int) (b * 174 / 768), false)); // la
																						// mare
																						// Ã 
																						// crapaud

		listpoint.add(new Point((int) (a * 366 / 1366), (int) (b * 278 / 768), false)); // Amphi
																						// 1

		listpoint.add(new Point((int) (a * 364 / 1366), (int) (b * 289 / 768), false)); // Amphi
																						// 2

		listpoint.add(new Point((int) (a * 359 / 1366), (int) (b * 146 / 768), false)); // champ

		listpoint.add(new Point((int) (a * 226 / 1366), (int) (b * 442 / 768), false)); // aleatoire1

		listpoint.add(new Point((int) (a * 469 / 1366), (int) (b * 284 / 768), false)); // aleatoire2

		listpoint.add(new Point((int) (a * 397 / 1366), (int) (b * 457 / 768), false)); // aleatoire
																						// 3

		listpoint.add(new Point((int) (a * 455 / 1366), (int) (b * 385 / 768), false)); // ConseillÃ¨re
																						// Social

		listpoint.add(new Point((int) (a * 549 / 1366), (int) (b * 264 / 768), false)); // Aleatoire
																						// 4

		listpoint.add(new Point((int) (a * 343 / 1366), (int) (b * 222 / 768), false));// tc

		listdelistdepoint.add(listpoint);
		// Question2 RU

		questionArcade.add("Cherchez le Restaurant Universitaire");

		listpoint = new ArrayList<Point>();

		listpoint.add(new Point((int) (a * 465 / 1366), (int) (b * 136 / 768), true));// RU

		listpoint.add(new Point((int) (a * 169 / 1366), (int) (b * 236 / 768), false)); // info

		listpoint.add(new Point((int) (a * 565 / 1366), (int) (b * 310 / 768), false)); // ArrÃªt
		// TUL

		listpoint.add(new Point((int) (a * 231 / 1366), (int) (b * 198 / 768), false));// mmi

		listpoint.add(new Point((int) (a * 405 / 1366), (int) (b * 305 / 768), false)); // cafet
																						// iut

		listpoint.add(new Point((int) (a * 368 / 1366), (int) (b * 332 / 768), false));// GB

		listpoint.add(new Point((int) (a * 216 / 1366), (int) (b * 390 / 768), false));// la
																						// dormerie

		listpoint.add(new Point((int) (a * 145 / 1366), (int) (b * 286 / 768), false)); // Parking
																						// info

		listpoint.add(new Point((int) (a * 279 / 1366), (int) (b * 289 / 768), false)); // BU

		listpoint.add(new Point((int) (a * 276 / 1366), (int) (b * 258 / 768), false)); // Sall
																						// d'exam

		listpoint.add(new Point((int) (a * 167 / 1366), (int) (b * 174 / 768), false)); // la
																						// mare
																						// Ã 
																						// crapaud

		listpoint.add(new Point((int) (a * 366 / 1366), (int) (b * 278 / 768), false)); // Amphi
																						// 1

		listpoint.add(new Point((int) (a * 364 / 1366), (int) (b * 289 / 768), false)); // Amphi
																						// 2

		listpoint.add(new Point((int) (a * 359 / 1366), (int) (b * 146 / 768), false)); // champ

		listpoint.add(new Point((int) (a * 226 / 1366), (int) (b * 442 / 768), false)); // aleatoire1

		listpoint.add(new Point((int) (a * 469 / 1366), (int) (b * 284 / 768), false)); // aleatoire2

		listpoint.add(new Point((int) (a * 397 / 1366), (int) (b * 457 / 768), false)); // aleatoire
																						// 3

		listpoint.add(new Point((int) (a * 455 / 1366), (int) (b * 385 / 768), false)); // ConseillÃ¨re
																						// Social

		listpoint.add(new Point((int) (a * 549 / 1366), (int) (b * 264 / 768), false)); // Aleatoire
																						// 4

		listpoint.add(new Point((int) (a * 343 / 1366), (int) (b * 222 / 768), false));// tc

		listdelistdepoint.add(listpoint);
		// Question3 Dorm

		questionArcade.add("Cherchez la rÃ©sidence du CROUS La Dormerie");
		listpoint = new ArrayList<Point>();

		listpoint.add(new Point((int) (a * 216 / 1366), (int) (b * 390 / 768), true));// la
																						// dormerie

		listpoint.add(new Point((int) (a * 565 / 1366), (int) (b * 310 / 768), false)); // ArrÃªt
		// TUL

		listpoint.add(new Point((int) (a * 169 / 1366), (int) (b * 236 / 768), false)); // info

		listpoint.add(new Point((int) (a * 231 / 1366), (int) (b * 198 / 768), false));// mmi

		listpoint.add(new Point((int) (a * 405 / 1366), (int) (b * 305 / 768), false)); // cafet
																						// iut

		listpoint.add(new Point((int) (a * 465 / 1366), (int) (b * 136 / 768), false));// RU

		listpoint.add(new Point((int) (a * 368 / 1366), (int) (b * 332 / 768), false));// GB

		listpoint.add(new Point((int) (a * 145 / 1366), (int) (b * 286 / 768), false)); // Parking
																						// info

		listpoint.add(new Point((int) (a * 279 / 1366), (int) (b * 289 / 768), false)); // BU

		listpoint.add(new Point((int) (a * 276 / 1366), (int) (b * 258 / 768), false)); // Sall
																						// d'exam

		listpoint.add(new Point((int) (a * 167 / 1366), (int) (b * 174 / 768), false)); // la
																						// mare
																						// Ã 
																						// crapaud

		listpoint.add(new Point((int) (a * 366 / 1366), (int) (b * 278 / 768), false)); // Amphi
																						// 1

		listpoint.add(new Point((int) (a * 364 / 1366), (int) (b * 289 / 768), false)); // Amphi
																						// 2

		listpoint.add(new Point((int) (a * 359 / 1366), (int) (b * 146 / 768), false)); // champ

		listpoint.add(new Point((int) (a * 226 / 1366), (int) (b * 442 / 768), false)); // aleatoire1

		listpoint.add(new Point((int) (a * 469 / 1366), (int) (b * 284 / 768), false)); // aleatoire2

		listpoint.add(new Point((int) (a * 397 / 1366), (int) (b * 457 / 768), false)); // aleatoire
																						// 3

		listpoint.add(new Point((int) (a * 455 / 1366), (int) (b * 385 / 768), false)); // ConseillÃ¨re
																						// Social

		listpoint.add(new Point((int) (a * 549 / 1366), (int) (b * 264 / 768), false)); // Aleatoire
																						// 4

		listpoint.add(new Point((int) (a * 343 / 1366), (int) (b * 222 / 768), false));// tc

		listdelistdepoint.add(listpoint);
		// Question4 GB

		questionArcade.add("Cherchez le dÃ©partement GÃ©nie Biologique");

		listpoint = new ArrayList<Point>();

		listpoint.add(new Point((int) (a * 368 / 1366), (int) (b * 332 / 768), true));// GB

		listpoint.add(new Point((int) (a * 565 / 1366), (int) (b * 310 / 768), false)); // ArrÃªt
		// TUL

		listpoint.add(new Point((int) (a * 169 / 1366), (int) (b * 236 / 768), false)); // info

		listpoint.add(new Point((int) (a * 231 / 1366), (int) (b * 198 / 768), false));// mmi

		listpoint.add(new Point((int) (a * 405 / 1366), (int) (b * 305 / 768), false)); // cafet
																						// iut

		listpoint.add(new Point((int) (a * 465 / 1366), (int) (b * 136 / 768), false));// RU

		listpoint.add(new Point((int) (a * 216 / 1366), (int) (b * 390 / 768), false));// la
																						// dormerie

		listpoint.add(new Point((int) (a * 145 / 1366), (int) (b * 286 / 768), false)); // Parking
																						// info

		listpoint.add(new Point((int) (a * 279 / 1366), (int) (b * 289 / 768), false)); // BU

		listpoint.add(new Point((int) (a * 276 / 1366), (int) (b * 258 / 768), false)); // Sall
																						// d'exam

		listpoint.add(new Point((int) (a * 167 / 1366), (int) (b * 174 / 768), false)); // la
																						// mare
																						// Ã 
																						// crapaud

		listpoint.add(new Point((int) (a * 366 / 1366), (int) (b * 278 / 768), false)); // Amphi
																						// 1

		listpoint.add(new Point((int) (a * 364 / 1366), (int) (b * 289 / 768), false)); // Amphi
																						// 2

		listpoint.add(new Point((int) (a * 359 / 1366), (int) (b * 146 / 768), false)); // champ

		listpoint.add(new Point((int) (a * 226 / 1366), (int) (b * 442 / 768), false)); // aleatoire1

		listpoint.add(new Point((int) (a * 469 / 1366), (int) (b * 284 / 768), false)); // aleatoire2

		listpoint.add(new Point((int) (a * 397 / 1366), (int) (b * 457 / 768), false)); // aleatoire
																						// 3

		listpoint.add(new Point((int) (a * 455 / 1366), (int) (b * 385 / 768), false)); // ConseillÃ¨re
																						// Social

		listpoint.add(new Point((int) (a * 549 / 1366), (int) (b * 264 / 768), false)); // Aleatoire
																						// 4

		listpoint.add(new Point((int) (a * 343 / 1366), (int) (b * 222 / 768), false));// tc

		listdelistdepoint.add(listpoint);

		// Question5 Salle d'exam

		questionArcade.add("Cherchez la Salle d'examen");

		listpoint = new ArrayList<Point>();

		listpoint.add(new Point((int) (a * 276 / 1366), (int) (b * 258 / 768), true)); // Salle
																						// d'exam

		listpoint.add(new Point((int) (a * 565 / 1366), (int) (b * 310 / 768), false)); // ArrÃªt
		// TUL

		listpoint.add(new Point((int) (a * 169 / 1366), (int) (b * 236 / 768), false)); // info

		listpoint.add(new Point((int) (a * 231 / 1366), (int) (b * 198 / 768), false));// mmi

		listpoint.add(new Point((int) (a * 405 / 1366), (int) (b * 305 / 768), false)); // cafet
																						// iut

		listpoint.add(new Point((int) (a * 465 / 1366), (int) (b * 136 / 768), false));// RU

		listpoint.add(new Point((int) (a * 368 / 1366), (int) (b * 332 / 768), false));// GB

		listpoint.add(new Point((int) (a * 216 / 1366), (int) (b * 390 / 768), false));// la
																						// dormerie

		listpoint.add(new Point((int) (a * 145 / 1366), (int) (b * 286 / 768), false)); // Parking
																						// info

		listpoint.add(new Point((int) (a * 279 / 1366), (int) (b * 289 / 768), false)); // BU

		listpoint.add(new Point((int) (a * 167 / 1366), (int) (b * 174 / 768), false)); // la
																						// mare
																						// Ã 
																						// crapaud

		listpoint.add(new Point((int) (a * 366 / 1366), (int) (b * 278 / 768), false)); // Amphi
																						// 1

		listpoint.add(new Point((int) (a * 364 / 1366), (int) (b * 289 / 768), false)); // Amphi
																						// 2

		listpoint.add(new Point((int) (a * 359 / 1366), (int) (b * 146 / 768), false)); // champ

		listpoint.add(new Point((int) (a * 226 / 1366), (int) (b * 442 / 768), false)); // aleatoire1

		listpoint.add(new Point((int) (a * 469 / 1366), (int) (b * 284 / 768), false)); // aleatoire2

		listpoint.add(new Point((int) (a * 397 / 1366), (int) (b * 457 / 768), false)); // aleatoire
																						// 3

		listpoint.add(new Point((int) (a * 455 / 1366), (int) (b * 385 / 768), false)); // ConseillÃ¨re
																						// Social

		listpoint.add(new Point((int) (a * 549 / 1366), (int) (b * 264 / 768), false)); // Aleatoire
																						// 4

		listpoint.add(new Point((int) (a * 343 / 1366), (int) (b * 222 / 768), false));// tc

		listdelistdepoint.add(listpoint);

		// Question6 Cafet

		questionArcade.add("Cherchez la Cafeteria de l'administration de l'IUT");

		listpoint = new ArrayList<Point>();

		listpoint.add(new Point((int) (a * 405 / 1366), (int) (b * 305 / 768), true)); // cafet
																						// iut

		listpoint.add(new Point((int) (a * 565 / 1366), (int) (b * 310 / 768), false)); // ArrÃªt
		// TUL

		listpoint.add(new Point((int) (a * 169 / 1366), (int) (b * 236 / 768), false));// info

		listpoint.add(new Point((int) (a * 231 / 1366), (int) (b * 198 / 768), false));// mmi

		listpoint.add(new Point((int) (a * 465 / 1366), (int) (b * 136 / 768), false));// RU

		listpoint.add(new Point((int) (a * 368 / 1366), (int) (b * 332 / 768), false));// GB

		listpoint.add(new Point((int) (a * 216 / 1366), (int) (b * 390 / 768), false));// la
																						// dormerie

		listpoint.add(new Point((int) (a * 145 / 1366), (int) (b * 286 / 768), false)); // Parking
																						// info

		listpoint.add(new Point((int) (a * 279 / 1366), (int) (b * 289 / 768), false)); // BU

		listpoint.add(new Point((int) (a * 276 / 1366), (int) (b * 258 / 768), false)); // Sall
																						// d'exam

		listpoint.add(new Point((int) (a * 167 / 1366), (int) (b * 174 / 768), false)); // la
																						// mare
																						// Ã 
																						// crapaud

		listpoint.add(new Point((int) (a * 366 / 1366), (int) (b * 278 / 768), false)); // Amphi
																						// 1

		listpoint.add(new Point((int) (a * 364 / 1366), (int) (b * 289 / 768), false)); // Amphi
																						// 2

		listpoint.add(new Point((int) (a * 359 / 1366), (int) (b * 146 / 768), false)); // champ

		listpoint.add(new Point((int) (a * 226 / 1366), (int) (b * 442 / 768), false)); // aleatoire1

		listpoint.add(new Point((int) (a * 469 / 1366), (int) (b * 284 / 768), false)); // aleatoire2

		listpoint.add(new Point((int) (a * 397 / 1366), (int) (b * 457 / 768), false)); // aleatoire
																						// 3

		listpoint.add(new Point((int) (a * 455 / 1366), (int) (b * 385 / 768), false)); // ConseillÃ¨re
																						// Social

		listpoint.add(new Point((int) (a * 549 / 1366), (int) (b * 264 / 768), false)); // Aleatoire
																						// 4

		listpoint.add(new Point((int) (a * 343 / 1366), (int) (b * 222 / 768), false));// tc

		listdelistdepoint.add(listpoint);

		// Question7 Amphi 1

		questionArcade.add("Cherchez la BibliothÃ¨que Universitaire");

		listpoint = new ArrayList<Point>();

		listpoint.add(new Point((int) (a * 279 / 1366), (int) (b * 289 / 768), true)); // BU

		listpoint.add(new Point((int) (a * 565 / 1366), (int) (b * 310 / 768), false)); // ArrÃªt
		// TUL

		listpoint.add(new Point((int) (a * 169 / 1366), (int) (b * 236 / 768), false)); // info

		listpoint.add(new Point((int) (a * 231 / 1366), (int) (b * 198 / 768), false));// mmi

		listpoint.add(new Point((int) (a * 405 / 1366), (int) (b * 305 / 768), false)); // cafet
																						// iut

		listpoint.add(new Point((int) (a * 465 / 1366), (int) (b * 136 / 768), false));// RU

		listpoint.add(new Point((int) (a * 368 / 1366), (int) (b * 332 / 768), false));// GB

		listpoint.add(new Point((int) (a * 216 / 1366), (int) (b * 390 / 768), false));// la
																						// dormerie

		listpoint.add(new Point((int) (a * 145 / 1366), (int) (b * 286 / 768), false)); // Parking
																						// info

		listpoint.add(new Point((int) (a * 276 / 1366), (int) (b * 258 / 768), false)); // Sall
																						// d'exam

		listpoint.add(new Point((int) (a * 167 / 1366), (int) (b * 174 / 768), false)); // la
																						// mare
																						// Ã 
																						// crapaud

		listpoint.add(new Point((int) (a * 366 / 1366), (int) (b * 278 / 768), false)); // Amphi
		// 1

		listpoint.add(new Point((int) (a * 364 / 1366), (int) (b * 289 / 768), false)); // Amphi
																						// 2

		listpoint.add(new Point((int) (a * 359 / 1366), (int) (b * 146 / 768), false)); // champ

		listpoint.add(new Point((int) (a * 226 / 1366), (int) (b * 442 / 768), false)); // aleatoire1

		listpoint.add(new Point((int) (a * 469 / 1366), (int) (b * 284 / 768), false)); // aleatoire2

		listpoint.add(new Point((int) (a * 397 / 1366), (int) (b * 457 / 768), false)); // aleatoire
																						// 3

		listpoint.add(new Point((int) (a * 455 / 1366), (int) (b * 385 / 768), false)); // ConseillÃ¨re
																						// Social

		listpoint.add(new Point((int) (a * 549 / 1366), (int) (b * 264 / 768), false)); // Aleatoire
																						// 4

		listpoint.add(new Point((int) (a * 343 / 1366), (int) (b * 222 / 768), false));// tc

		listdelistdepoint.add(listpoint);

		// Question8 ArrÃªt Tul

		questionArcade.add("Cherchez l'ArrÃªt du TUL Ã  l'IUT");

		listpoint = new ArrayList<Point>();

		listpoint.add(new Point((int) (a * 565 / 1366), (int) (b * 310 / 768), true)); // ArrÃªt
																						// TUL

		listpoint.add(new Point((int) (a * 169 / 1366), (int) (b * 236 / 768), false)); // info

		listpoint.add(new Point((int) (a * 231 / 1366), (int) (b * 198 / 768), false));// mmi

		listpoint.add(new Point((int) (a * 405 / 1366), (int) (b * 305 / 768), false)); // cafet
																						// iut

		listpoint.add(new Point((int) (a * 465 / 1366), (int) (b * 136 / 768), false));// RU

		listpoint.add(new Point((int) (a * 368 / 1366), (int) (b * 332 / 768), false));// GB

		listpoint.add(new Point((int) (a * 216 / 1366), (int) (b * 390 / 768), false));// la
																						// dormerie

		listpoint.add(new Point((int) (a * 145 / 1366), (int) (b * 286 / 768), false)); // Parking
																						// info

		listpoint.add(new Point((int) (a * 279 / 1366), (int) (b * 289 / 768), false)); // BU

		listpoint.add(new Point((int) (a * 276 / 1366), (int) (b * 258 / 768), false)); // Sall
																						// d'exam

		listpoint.add(new Point((int) (a * 167 / 1366), (int) (b * 174 / 768), false)); // la
																						// mare
																						// Ã 
																						// crapaud

		listpoint.add(new Point((int) (a * 366 / 1366), (int) (b * 278 / 768), false)); // Amphi
																						// 1

		listpoint.add(new Point((int) (a * 364 / 1366), (int) (b * 289 / 768), false)); // Amphi
																						// 2

		listpoint.add(new Point((int) (a * 359 / 1366), (int) (b * 146 / 768), false)); // champ

		listpoint.add(new Point((int) (a * 226 / 1366), (int) (b * 442 / 768), false)); // aleatoire1

		listpoint.add(new Point((int) (a * 469 / 1366), (int) (b * 284 / 768), false)); // aleatoire2

		listpoint.add(new Point((int) (a * 397 / 1366), (int) (b * 457 / 768), false)); // aleatoire
																						// 3

		listpoint.add(new Point((int) (a * 455 / 1366), (int) (b * 385 / 768), false)); // ConseillÃ¨re
																						// Social

		listpoint.add(new Point((int) (a * 549 / 1366), (int) (b * 264 / 768), false)); // Aleatoire
																						// 4

		listpoint.add(new Point((int) (a * 343 / 1366), (int) (b * 222 / 768), false));// tc

		listdelistdepoint.add(listpoint);

		// Question9 MMI

		questionArcade.add("Cherchez le dÃ©partement MMI");

		listpoint = new ArrayList<Point>();

		listpoint.add(new Point((int) (a * 231 / 1366), (int) (b * 198 / 768), true));// mmi

		listpoint.add(new Point((int) (a * 565 / 1366), (int) (b * 310 / 768), false)); // ArrÃªt
																						// TUL

		listpoint.add(new Point((int) (a * 169 / 1366), (int) (b * 236 / 768), false)); // info

		listpoint.add(new Point((int) (a * 405 / 1366), (int) (b * 305 / 768), false)); // cafet
																						// iut

		listpoint.add(new Point((int) (a * 465 / 1366), (int) (b * 136 / 768), false));// RU

		listpoint.add(new Point((int) (a * 368 / 1366), (int) (b * 332 / 768), false));// GB

		listpoint.add(new Point((int) (a * 216 / 1366), (int) (b * 390 / 768), false));// la
																						// dormerie

		listpoint.add(new Point((int) (a * 145 / 1366), (int) (b * 286 / 768), false)); // Parking
																						// info

		listpoint.add(new Point((int) (a * 279 / 1366), (int) (b * 289 / 768), false)); // BU

		listpoint.add(new Point((int) (a * 276 / 1366), (int) (b * 258 / 768), false)); // Sall
																						// d'exam

		listpoint.add(new Point((int) (a * 167 / 1366), (int) (b * 174 / 768), false)); // la
																						// mare
																						// Ã 
																						// crapaud

		listpoint.add(new Point((int) (a * 366 / 1366), (int) (b * 278 / 768), false)); // Amphi
																						// 1

		listpoint.add(new Point((int) (a * 364 / 1366), (int) (b * 289 / 768), false)); // Amphi
																						// 2

		listpoint.add(new Point((int) (a * 359 / 1366), (int) (b * 146 / 768), false)); // champ

		listpoint.add(new Point((int) (a * 226 / 1366), (int) (b * 442 / 768), false)); // aleatoire1

		listpoint.add(new Point((int) (a * 469 / 1366), (int) (b * 284 / 768), false)); // aleatoire2

		listpoint.add(new Point((int) (a * 397 / 1366), (int) (b * 457 / 768), false)); // aleatoire
																						// 3

		listpoint.add(new Point((int) (a * 455 / 1366), (int) (b * 385 / 768), false)); // ConseillÃ¨re
																						// Social

		listpoint.add(new Point((int) (a * 549 / 1366), (int) (b * 264 / 768), false)); // Aleatoire
																						// 4

		listpoint.add(new Point((int) (a * 343 / 1366), (int) (b * 222 / 768), false));// tc

		listdelistdepoint.add(listpoint);

		// Question10 Parking Info

		questionArcade.add("Cherchez le parking du dÃ©partement Informatique");

		listpoint = new ArrayList<Point>();

		listpoint.add(new Point((int) (a * 145 / 1366), (int) (b * 286 / 768), true)); // Parking
																						// info
		listpoint.add(new Point((int) (a * 565 / 1366), (int) (b * 310 / 768), false)); // ArrÃªt
																						// TUL

		listpoint.add(new Point((int) (a * 169 / 1366), (int) (b * 236 / 768), false)); // info

		listpoint.add(new Point((int) (a * 231 / 1366), (int) (b * 198 / 768), false));// mmi

		listpoint.add(new Point((int) (a * 405 / 1366), (int) (b * 305 / 768), false)); // cafet
																						// iut

		listpoint.add(new Point((int) (a * 465 / 1366), (int) (b * 136 / 768), false));// RU

		listpoint.add(new Point((int) (a * 368 / 1366), (int) (b * 332 / 768), false));// GB

		listpoint.add(new Point((int) (a * 216 / 1366), (int) (b * 390 / 768), false));// la
																						// dormerie

		listpoint.add(new Point((int) (a * 279 / 1366), (int) (b * 289 / 768), false)); // BU

		listpoint.add(new Point((int) (a * 276 / 1366), (int) (b * 258 / 768), false)); // Sall
																						// d'exam

		listpoint.add(new Point((int) (a * 167 / 1366), (int) (b * 174 / 768), false)); // la
																						// mare
																						// Ã 
																						// crapaud

		listpoint.add(new Point((int) (a * 366 / 1366), (int) (b * 278 / 768), false)); // Amphi
																						// 1

		listpoint.add(new Point((int) (a * 364 / 1366), (int) (b * 289 / 768), false)); // Amphi
																						// 2

		listpoint.add(new Point((int) (a * 359 / 1366), (int) (b * 146 / 768), false)); // champ

		listpoint.add(new Point((int) (a * 226 / 1366), (int) (b * 442 / 768), false)); // aleatoire1

		listpoint.add(new Point((int) (a * 469 / 1366), (int) (b * 284 / 768), false)); // aleatoire2

		listpoint.add(new Point((int) (a * 397 / 1366), (int) (b * 457 / 768), false)); // aleatoire
																						// 3

		listpoint.add(new Point((int) (a * 455 / 1366), (int) (b * 385 / 768), false)); // ConseillÃ¨re
																						// Social

		listpoint.add(new Point((int) (a * 549 / 1366), (int) (b * 264 / 768), false)); // Aleatoire
																						// 4

		listpoint.add(new Point((int) (a * 343 / 1366), (int) (b * 222 / 768), false));// tc

		listdelistdepoint.add(listpoint);
		// Carte Iut//

		iut = new Cartes(new Dimension(a * 650 / 1366, b * 580 / 768), fen, getClass().getResource("IUT.png"),
				"Campus IUT de Laval", listdelistdepoint, questionArcade, opt , menu, choixArcade);
		pan2 = iut.getMiniature();

		// Carte Dep Info//
		listdelistdepoint = new ArrayList<List<Point>>();
		// question1 
		questionArcade = new ArrayList<String>();
		questionArcade.add("Cherchez la salle de rÃ©union");
		listpoint = new ArrayList<Point>();
																						

		listpoint.add(new Point((int) (a * 87 / 1366), (int) (b * 427 / 768), true)); // Salle rÃ©union
		// TUL

		listpoint.add(new Point((int) (a * 565 / 1366), (int) (b * 494 / 768), false)); // TD1

		listpoint.add(new Point((int) (a * 381 / 1366), (int) (b * 231 / 768), false)); // TP1

		listpoint.add(new Point((int) (a * 78 / 1366), (int) (b * 205 / 768), false)); // TDM2 

		listpoint.add(new Point((int) (a * 266 / 1366), (int) (b * 233 / 768), false)); // TP2
		
		listpoint.add(new Point((int) (a * 130 / 1366), (int) (b * 527 / 768), false)); // Bureau ERNET / VIEILLARD

		listpoint.add(new Point((int) (a * 174 / 1366), (int) (b * 346 / 768), false)); // Bureau Pierre LAFORCADE

		listpoint.add(new Point((int) (a * 257 / 1366), (int) (b * 529 / 768), false)); // Bureau Chef du DÃ©partement Yann WALKOWIAK

		listpoint.add(new Point((int) (a * 504 / 1366), (int) (b * 465 / 768), false)); //  Machine Ã  cafÃ©

		listpoint.add(new Point((int) (a * 52 / 1366), (int) (b * 363 / 768), false)); // Salle Ã  cafÃ©
		
		listpoint.add(new Point((int) (a * 72 / 1366), (int) (b * 89 / 768), false)); //TDM 3
		
		listpoint.add(new Point((int) (a * 562 / 1366), (int) (b * 377 / 768), false)); // TD2

		listpoint.add(new Point((int) (a * 232 / 1366), (int) (b * 59 / 768), false)); // TP3

		listpoint.add(new Point((int) (a * 108 / 1366), (int) (b * 343 / 768), false)); // SEBASTIEN GORGE 

		listpoint.add(new Point((int) (a * 307 / 1366), (int) (b * 344 / 768), false)); // TIBBS / KACEM

		listpoint.add(new Point((int) (a * 247 / 1366), (int) (b * 339 / 768), false)); // Vincent BARRE ET LAhCEN OUBAHSSI

		listpoint.add(new Point((int) (a * 571 / 1366), (int) (b * 89 / 768), false)); // TDM4

		listpoint.add(new Point((int) (a * 566 / 1366), (int) (b * 200 / 768), false)); // TDM1

		listpoint.add(new Point((int) (a * 58 / 1366), (int) (b * 524 / 768), false)); // IZA MARFISI ET LUDOVIC HAMON

		listpoint.add(new Point((int) (a * 200 / 1366), (int) (b * 522 / 768), false)); // Salle Nour EL MAWAS /Jean-Pierre CLAYER

		listdelistdepoint.add(listpoint);
		// question2
		questionArcade.add("Cherchez la salle TD1");
		listpoint = new ArrayList<Point>();
		

		listpoint.add(new Point((int) (a * 565 / 1366), (int) (b * 494 / 768), true)); // TD1
		
		listpoint.add(new Point((int) (a * 87 / 1366), (int) (b * 427 / 768), false)); // Salle rÃ©union

		listpoint.add(new Point((int) (a * 381 / 1366), (int) (b * 231 / 768), false)); // TP1

		listpoint.add(new Point((int) (a * 78 / 1366), (int) (b * 205 / 768), false)); // TDM2 

		listpoint.add(new Point((int) (a * 266 / 1366), (int) (b * 233 / 768), false)); // TP2
		
		listpoint.add(new Point((int) (a * 130 / 1366), (int) (b * 527 / 768), false)); // Bureau ERNET / VIEILLARD

		listpoint.add(new Point((int) (a * 174 / 1366), (int) (b * 346 / 768), false)); // Bureau Pierre LAFORCADE

		listpoint.add(new Point((int) (a * 257 / 1366), (int) (b * 529 / 768), false)); // Bureau Chef du DÃ©partement Yann WALKOWIAK

		listpoint.add(new Point((int) (a * 504 / 1366), (int) (b * 465 / 768), false)); //  Machine Ã  cafÃ©

		listpoint.add(new Point((int) (a * 52 / 1366), (int) (b * 363 / 768), false)); // Salle Ã  cafÃ©
		
		listpoint.add(new Point((int) (a * 72 / 1366), (int) (b * 89 / 768), false)); //TDM 3
		
		listpoint.add(new Point((int) (a * 562 / 1366), (int) (b * 377 / 768), false)); // TD2

		listpoint.add(new Point((int) (a * 232 / 1366), (int) (b * 59 / 768), false)); // TP3

		listpoint.add(new Point((int) (a * 108 / 1366), (int) (b * 343 / 768), false)); // SEBASTIEN GORGE 

		listpoint.add(new Point((int) (a * 307 / 1366), (int) (b * 344 / 768), false)); // TIBBS / KACEM

		listpoint.add(new Point((int) (a * 247 / 1366), (int) (b * 339 / 768), false)); // Vincent BARRE ET LAhCEN OUBAHSSI

		listpoint.add(new Point((int) (a * 571 / 1366), (int) (b * 89 / 768), false)); // TDM4

		listpoint.add(new Point((int) (a * 566 / 1366), (int) (b * 200 / 768), false)); // TDM1

		listpoint.add(new Point((int) (a * 58 / 1366), (int) (b * 524 / 768), false)); // IZA MARFISI ET LUDOVIC HAMON

		listpoint.add(new Point((int) (a * 200 / 1366), (int) (b * 522 / 768), false)); // Salle Nour EL MAWAS /Jean-Pierre CLAYER

		listdelistdepoint.add(listpoint);
		// question3
		questionArcade.add("Cherchez la salle TP1");
		listpoint = new ArrayList<Point>();
		

		listpoint.add(new Point((int) (a * 381 / 1366), (int) (b * 231 / 768), true)); // TP1
		
		
		listpoint.add(new Point((int) (a * 87 / 1366), (int) (b * 427 / 768), false)); // Salle rÃ©union
		// TUL

		listpoint.add(new Point((int) (a * 565 / 1366), (int) (b * 494 / 768), false)); // TD1

		listpoint.add(new Point((int) (a * 78 / 1366), (int) (b * 205 / 768), false)); // TDM2 

		listpoint.add(new Point((int) (a * 266 / 1366), (int) (b * 233 / 768), false)); // TP2
		
		listpoint.add(new Point((int) (a * 130 / 1366), (int) (b * 527 / 768), false)); // Bureau ERNET / VIEILLARD

		listpoint.add(new Point((int) (a * 174 / 1366), (int) (b * 346 / 768), false)); // Bureau Pierre LAFORCADE

		listpoint.add(new Point((int) (a * 257 / 1366), (int) (b * 529 / 768), false)); // Bureau Chef du DÃ©partement Yann WALKOWIAK

		listpoint.add(new Point((int) (a * 504 / 1366), (int) (b * 465 / 768), false)); //  Machine Ã  cafÃ©

		listpoint.add(new Point((int) (a * 52 / 1366), (int) (b * 363 / 768), false)); // Salle Ã  cafÃ©
		
		listpoint.add(new Point((int) (a * 72 / 1366), (int) (b * 89 / 768), false)); //TDM 3
		
		listpoint.add(new Point((int) (a * 562 / 1366), (int) (b * 377 / 768), false)); // TD2

		listpoint.add(new Point((int) (a * 232 / 1366), (int) (b * 59 / 768), false)); // TP3

		listpoint.add(new Point((int) (a * 108 / 1366), (int) (b * 343 / 768), false)); // SEBASTIEN GORGE 

		listpoint.add(new Point((int) (a * 307 / 1366), (int) (b * 344 / 768), false)); // TIBBS / KACEM

		listpoint.add(new Point((int) (a * 247 / 1366), (int) (b * 339 / 768), false)); // Vincent BARRE ET LAhCEN OUBAHSSI

		listpoint.add(new Point((int) (a * 571 / 1366), (int) (b * 89 / 768), false)); // TDM4

		listpoint.add(new Point((int) (a * 566 / 1366), (int) (b * 200 / 768), false)); // TDM1

		listpoint.add(new Point((int) (a * 58 / 1366), (int) (b * 524 / 768), false)); // IZA MARFISI ET LUDOVIC HAMON

		listpoint.add(new Point((int) (a * 200 / 1366), (int) (b * 522 / 768), false)); // Salle Nour EL MAWAS /Jean-Pierre CLAYER

		listdelistdepoint.add(listpoint);
		// question4
		questionArcade.add("Cherchez la salle TDM2");
		listpoint = new ArrayList<Point>();


		listpoint.add(new Point((int) (a * 78 / 1366), (int) (b * 205 / 768), true)); // TDM2 
		
		listpoint.add(new Point((int) (a * 87 / 1366), (int) (b * 427 / 768), false)); // Salle rÃ©union
		
		listpoint.add(new Point((int) (a * 565 / 1366), (int) (b * 494 / 768), false)); // TD1

		listpoint.add(new Point((int) (a * 381 / 1366), (int) (b * 231 / 768), false)); // TP1

		listpoint.add(new Point((int) (a * 266 / 1366), (int) (b * 233 / 768), false)); // TP2
		
		listpoint.add(new Point((int) (a * 130 / 1366), (int) (b * 527 / 768), false)); // Bureau ERNET / VIEILLARD

		listpoint.add(new Point((int) (a * 174 / 1366), (int) (b * 346 / 768), false)); // Bureau Pierre LAFORCADE

		listpoint.add(new Point((int) (a * 257 / 1366), (int) (b * 529 / 768), false)); // Bureau Chef du DÃ©partement Yann WALKOWIAK

		listpoint.add(new Point((int) (a * 504 / 1366), (int) (b * 465 / 768), false)); //  Machine Ã  cafÃ©

		listpoint.add(new Point((int) (a * 52 / 1366), (int) (b * 363 / 768), false)); // Salle Ã  cafÃ©
		
		listpoint.add(new Point((int) (a * 72 / 1366), (int) (b * 89 / 768), false)); //TDM 3
		
		listpoint.add(new Point((int) (a * 562 / 1366), (int) (b * 377 / 768), false)); // TD2

		listpoint.add(new Point((int) (a * 232 / 1366), (int) (b * 59 / 768), false)); // TP3

		listpoint.add(new Point((int) (a * 108 / 1366), (int) (b * 343 / 768), false)); // SEBASTIEN GORGE 

		listpoint.add(new Point((int) (a * 307 / 1366), (int) (b * 344 / 768), false)); // TIBBS / KACEM

		listpoint.add(new Point((int) (a * 247 / 1366), (int) (b * 339 / 768), false)); // Vincent BARRE ET LAhCEN OUBAHSSI

		listpoint.add(new Point((int) (a * 571 / 1366), (int) (b * 89 / 768), false)); // TDM4

		listpoint.add(new Point((int) (a * 566 / 1366), (int) (b * 200 / 768), false)); // TDM1

		listpoint.add(new Point((int) (a * 58 / 1366), (int) (b * 524 / 768), false)); // IZA MARFISI ET LUDOVIC HAMON

		listpoint.add(new Point((int) (a * 200 / 1366), (int) (b * 522 / 768), false)); // Salle Nour EL MAWAS /Jean-Pierre CLAYER

		listdelistdepoint.add(listpoint);
		// question5
		questionArcade.add("Cherchez la salle TP2");
		listpoint = new ArrayList<Point>();
		

		listpoint.add(new Point((int) (a * 266 / 1366), (int) (b * 233 / 768), true)); // TP2
		
		listpoint.add(new Point((int) (a * 87 / 1366), (int) (b * 427 / 768), false)); // Salle rÃ©union

		listpoint.add(new Point((int) (a * 565 / 1366), (int) (b * 494 / 768), false)); // TD1

		listpoint.add(new Point((int) (a * 381 / 1366), (int) (b * 231 / 768), false)); // TP1

		listpoint.add(new Point((int) (a * 78 / 1366), (int) (b * 205 / 768), false)); // TDM2 

		listpoint.add(new Point((int) (a * 130 / 1366), (int) (b * 527 / 768), false)); // Bureau ERNET / VIEILLARD

		listpoint.add(new Point((int) (a * 174 / 1366), (int) (b * 346 / 768), false)); // Bureau Pierre LAFORCADE

		listpoint.add(new Point((int) (a * 257 / 1366), (int) (b * 529 / 768), false)); // Bureau Chef du DÃ©partement Yann WALKOWIAK

		listpoint.add(new Point((int) (a * 504 / 1366), (int) (b * 465 / 768), false)); //  Machine Ã  cafÃ©

		listpoint.add(new Point((int) (a * 52 / 1366), (int) (b * 363 / 768), false)); // Salle Ã  cafÃ©
		
		listpoint.add(new Point((int) (a * 72 / 1366), (int) (b * 89 / 768), false)); //TDM 3
		
		listpoint.add(new Point((int) (a * 562 / 1366), (int) (b * 377 / 768), false)); // TD2

		listpoint.add(new Point((int) (a * 232 / 1366), (int) (b * 59 / 768), false)); // TP3

		listpoint.add(new Point((int) (a * 108 / 1366), (int) (b * 343 / 768), false)); // SEBASTIEN GORGE 

		listpoint.add(new Point((int) (a * 307 / 1366), (int) (b * 344 / 768), false)); // TIBBS / KACEM

		listpoint.add(new Point((int) (a * 247 / 1366), (int) (b * 339 / 768), false)); // Vincent BARRE ET LAhCEN OUBAHSSI

		listpoint.add(new Point((int) (a * 571 / 1366), (int) (b * 89 / 768), false)); // TDM4

		listpoint.add(new Point((int) (a * 566 / 1366), (int) (b * 200 / 768), false)); // TDM1

		listpoint.add(new Point((int) (a * 58 / 1366), (int) (b * 524 / 768), false)); // IZA MARFISI ET LUDOVIC HAMON

		listpoint.add(new Point((int) (a * 200 / 1366), (int) (b * 522 / 768), false)); // Salle Nour EL MAWAS /Jean-Pierre CLAYER

		listdelistdepoint.add(listpoint);
		// question6
		questionArcade.add("Cherchez la salle des bureaux de Bruno ERNET \n et Natalie VIEILLARD");
		listpoint = new ArrayList<Point>();
		
		
		listpoint.add(new Point((int) (a * 130 / 1366), (int) (b * 527 / 768), true)); // Bureau ERNET / VIEILLARD

		listpoint.add(new Point((int) (a * 87 / 1366), (int) (b * 427 / 768), false)); // Salle rÃ©union
		// TUL

		listpoint.add(new Point((int) (a * 565 / 1366), (int) (b * 494 / 768), false)); // TD1

		listpoint.add(new Point((int) (a * 381 / 1366), (int) (b * 231 / 768), false)); // TP1

		listpoint.add(new Point((int) (a * 78 / 1366), (int) (b * 205 / 768), false)); // TDM2 

		listpoint.add(new Point((int) (a * 266 / 1366), (int) (b * 233 / 768), false)); // TP2
		
	listpoint.add(new Point((int) (a * 174 / 1366), (int) (b * 346 / 768), false)); // Bureau Pierre LAFORCADE

		listpoint.add(new Point((int) (a * 257 / 1366), (int) (b * 529 / 768), false)); // Bureau Chef du DÃ©partement Yann WALKOWIAK

		listpoint.add(new Point((int) (a * 504 / 1366), (int) (b * 465 / 768), false)); //  Machine Ã  cafÃ©

		listpoint.add(new Point((int) (a * 52 / 1366), (int) (b * 363 / 768), false)); // Salle Ã  cafÃ©
		
		listpoint.add(new Point((int) (a * 72 / 1366), (int) (b * 89 / 768), false)); //TDM 3
		
		listpoint.add(new Point((int) (a * 562 / 1366), (int) (b * 377 / 768), false)); // TD2

		listpoint.add(new Point((int) (a * 232 / 1366), (int) (b * 59 / 768), false)); // TP3

		listpoint.add(new Point((int) (a * 108 / 1366), (int) (b * 343 / 768), false)); // SEBASTIEN GORGE 

		listpoint.add(new Point((int) (a * 307 / 1366), (int) (b * 344 / 768), false)); // TIBBS / KACEM

		listpoint.add(new Point((int) (a * 247 / 1366), (int) (b * 339 / 768), false)); // Vincent BARRE ET LAhCEN OUBAHSSI

		listpoint.add(new Point((int) (a * 571 / 1366), (int) (b * 89 / 768), false)); // TDM4

		listpoint.add(new Point((int) (a * 566 / 1366), (int) (b * 200 / 768), false)); // TDM1

		listpoint.add(new Point((int) (a * 58 / 1366), (int) (b * 524 / 768), false)); // IZA MARFISI ET LUDOVIC HAMON

		listpoint.add(new Point((int) (a * 200 / 1366), (int) (b * 522 / 768), false)); // Salle Nour EL MAWAS /Jean-Pierre CLAYER

		listdelistdepoint.add(listpoint);
		// question7
		questionArcade.add("Cherchez le bureau de Pierre LAFORCADE");
		listpoint = new ArrayList<Point>();

		listpoint.add(new Point((int) (a * 174 / 1366), (int) (b * 346 / 768), true)); // Bureau Pierre LAFORCADE

		listpoint.add(new Point((int) (a * 87 / 1366), (int) (b * 427 / 768), false)); // Salle rÃ©union
		// TUL

		listpoint.add(new Point((int) (a * 565 / 1366), (int) (b * 494 / 768), false)); // TD1

		listpoint.add(new Point((int) (a * 381 / 1366), (int) (b * 231 / 768), false)); // TP1

		listpoint.add(new Point((int) (a * 78 / 1366), (int) (b * 205 / 768), false)); // TDM2 

		listpoint.add(new Point((int) (a * 266 / 1366), (int) (b * 233 / 768), false)); // TP2
		
		listpoint.add(new Point((int) (a * 130 / 1366), (int) (b * 527 / 768), false)); // Bureau ERNET / VIEILLARD

		listpoint.add(new Point((int) (a * 257 / 1366), (int) (b * 529 / 768), false)); // Bureau Chef du DÃ©partement Yann WALKOWIAK

		listpoint.add(new Point((int) (a * 504 / 1366), (int) (b * 465 / 768), false)); //  Machine Ã  cafÃ©

		listpoint.add(new Point((int) (a * 52 / 1366), (int) (b * 363 / 768), false)); // Salle Ã  cafÃ©
		
		listpoint.add(new Point((int) (a * 72 / 1366), (int) (b * 89 / 768), false)); //TDM 3
		
		listpoint.add(new Point((int) (a * 562 / 1366), (int) (b * 377 / 768), false)); // TD2

		listpoint.add(new Point((int) (a * 232 / 1366), (int) (b * 59 / 768), false)); // TP3

		listpoint.add(new Point((int) (a * 108 / 1366), (int) (b * 343 / 768), false)); // SEBASTIEN GORGE 

		listpoint.add(new Point((int) (a * 307 / 1366), (int) (b * 344 / 768), false)); // TIBBS / KACEM

		listpoint.add(new Point((int) (a * 247 / 1366), (int) (b * 339 / 768), false)); // Vincent BARRE ET LAhCEN OUBAHSSI

		listpoint.add(new Point((int) (a * 571 / 1366), (int) (b * 89 / 768), false)); // TDM4

		listpoint.add(new Point((int) (a * 566 / 1366), (int) (b * 200 / 768), false)); // TDM1

		listpoint.add(new Point((int) (a * 58 / 1366), (int) (b * 524 / 768), false)); // IZA MARFISI ET LUDOVIC HAMON

		listpoint.add(new Point((int) (a * 200 / 1366), (int) (b * 522 / 768), false)); // Salle Nour EL MAWAS /Jean-Pierre CLAYER

		listdelistdepoint.add(listpoint);
		// question8
		questionArcade.add("Cherchez le bureau du Chef du DÃ©partement : Yann WALKOWIAK");
		listpoint = new ArrayList<Point>();
		

		listpoint.add(new Point((int) (a * 257 / 1366), (int) (b * 529 / 768), true)); // Bureau Chef du DÃ©partement Yann WALKOWIAK

		listpoint.add(new Point((int) (a * 87 / 1366), (int) (b * 427 / 768), false)); // Salle rÃ©union
		// TUL

		listpoint.add(new Point((int) (a * 565 / 1366), (int) (b * 494 / 768), false)); // TD1

		listpoint.add(new Point((int) (a * 381 / 1366), (int) (b * 231 / 768), false)); // TP1

		listpoint.add(new Point((int) (a * 78 / 1366), (int) (b * 205 / 768), false)); // TDM2 

		listpoint.add(new Point((int) (a * 266 / 1366), (int) (b * 233 / 768), false)); // TP2
		
		listpoint.add(new Point((int) (a * 130 / 1366), (int) (b * 527 / 768), false)); // Bureau ERNET / VIEILLARD

		listpoint.add(new Point((int) (a * 174 / 1366), (int) (b * 346 / 768), false)); // Bureau Pierre LAFORCADE

		listpoint.add(new Point((int) (a * 504 / 1366), (int) (b * 465 / 768), false)); //  Machine Ã  cafÃ©

		listpoint.add(new Point((int) (a * 52 / 1366), (int) (b * 363 / 768), false)); // Salle Ã  cafÃ©
		
		listpoint.add(new Point((int) (a * 72 / 1366), (int) (b * 89 / 768), false)); //TDM 3
		
		listpoint.add(new Point((int) (a * 562 / 1366), (int) (b * 377 / 768), false)); // TD2

		listpoint.add(new Point((int) (a * 232 / 1366), (int) (b * 59 / 768), false)); // TP3

		listpoint.add(new Point((int) (a * 108 / 1366), (int) (b * 343 / 768), false)); // SEBASTIEN GORGE 

		listpoint.add(new Point((int) (a * 307 / 1366), (int) (b * 344 / 768), false)); // TIBBS / KACEM

		listpoint.add(new Point((int) (a * 247 / 1366), (int) (b * 339 / 768), false)); // Vincent BARRE ET LAhCEN OUBAHSSI

		listpoint.add(new Point((int) (a * 571 / 1366), (int) (b * 89 / 768), false)); // TDM4

		listpoint.add(new Point((int) (a * 566 / 1366), (int) (b * 200 / 768), false)); // TDM1

		listpoint.add(new Point((int) (a * 58 / 1366), (int) (b * 524 / 768), false)); // IZA MARFISI ET LUDOVIC HAMON

		listpoint.add(new Point((int) (a * 200 / 1366), (int) (b * 522 / 768), false)); // Salle Nour EL MAWAS /Jean-Pierre CLAYER

		listdelistdepoint.add(listpoint);
		// question9
		questionArcade.add("Cherchez la machine Ã  cafÃ©");
		listpoint = new ArrayList<Point>();

		listpoint.add(new Point((int) (a * 504 / 1366), (int) (b * 465 / 768), true)); //  Machine Ã  cafÃ©

		listpoint.add(new Point((int) (a * 87 / 1366), (int) (b * 427 / 768), false)); // Salle rÃ©union
		// TUL

		listpoint.add(new Point((int) (a * 565 / 1366), (int) (b * 494 / 768), false)); // TD1

		listpoint.add(new Point((int) (a * 381 / 1366), (int) (b * 231 / 768), false)); // TP1

		listpoint.add(new Point((int) (a * 78 / 1366), (int) (b * 205 / 768), false)); // TDM2 

		listpoint.add(new Point((int) (a * 266 / 1366), (int) (b * 233 / 768), false)); // TP2
		
		listpoint.add(new Point((int) (a * 130 / 1366), (int) (b * 527 / 768), false)); // Bureau ERNET / VIEILLARD

		listpoint.add(new Point((int) (a * 174 / 1366), (int) (b * 346 / 768), false)); // Bureau Pierre LAFORCADE

		listpoint.add(new Point((int) (a * 257 / 1366), (int) (b * 529 / 768), false)); // Bureau Chef du DÃ©partement Yann WALKOWIAK

		listpoint.add(new Point((int) (a * 52 / 1366), (int) (b * 363 / 768), false)); // Salle Ã  cafÃ©
		
		listpoint.add(new Point((int) (a * 72 / 1366), (int) (b * 89 / 768), false)); //TDM 3
		
		listpoint.add(new Point((int) (a * 562 / 1366), (int) (b * 377 / 768), false)); // TD2

		listpoint.add(new Point((int) (a * 232 / 1366), (int) (b * 59 / 768), false)); // TP3

		listpoint.add(new Point((int) (a * 108 / 1366), (int) (b * 343 / 768), false)); // SEBASTIEN GORGE 

		listpoint.add(new Point((int) (a * 307 / 1366), (int) (b * 344 / 768), false)); // TIBBS / KACEM

		listpoint.add(new Point((int) (a * 247 / 1366), (int) (b * 339 / 768), false)); // Vincent BARRE ET LAhCEN OUBAHSSI

		listpoint.add(new Point((int) (a * 571 / 1366), (int) (b * 89 / 768), false)); // TDM4

		listpoint.add(new Point((int) (a * 566 / 1366), (int) (b * 200 / 768), false)); // TDM1

		listpoint.add(new Point((int) (a * 58 / 1366), (int) (b * 524 / 768), false)); // IZA MARFISI ET LUDOVIC HAMON

		listpoint.add(new Point((int) (a * 200 / 1366), (int) (b * 522 / 768), false)); // Salle Nour EL MAWAS /Jean-Pierre CLAYER

		listdelistdepoint.add(listpoint);
		// question10
		questionArcade.add("Cherchez la salle de rÃ©union");
		listpoint = new ArrayList<Point>();
		

		listpoint.add(new Point((int) (a * 52 / 1366), (int) (b * 363 / 768), true)); // Salle Ã  cafÃ©
		

		listpoint.add(new Point((int) (a * 87 / 1366), (int) (b * 427 / 768), false)); // Salle rÃ©union

		listpoint.add(new Point((int) (a * 565 / 1366), (int) (b * 494 / 768), false)); // TD1

		listpoint.add(new Point((int) (a * 381 / 1366), (int) (b * 231 / 768), false)); // TP1

		listpoint.add(new Point((int) (a * 78 / 1366), (int) (b * 205 / 768), false)); // TDM2 

		listpoint.add(new Point((int) (a * 266 / 1366), (int) (b * 233 / 768), false)); // TP2
		
		listpoint.add(new Point((int) (a * 130 / 1366), (int) (b * 527 / 768), false)); // Bureau ERNET / VIEILLARD

		listpoint.add(new Point((int) (a * 174 / 1366), (int) (b * 346 / 768), false)); // Bureau Pierre LAFORCADE

		listpoint.add(new Point((int) (a * 257 / 1366), (int) (b * 529 / 768), false)); // Bureau Chef du DÃ©partement Yann WALKOWIAK

		listpoint.add(new Point((int) (a * 504 / 1366), (int) (b * 465 / 768), false)); //  Machine Ã  cafÃ©

		listpoint.add(new Point((int) (a * 72 / 1366), (int) (b * 89 / 768), false)); //TDM 3
		
		listpoint.add(new Point((int) (a * 562 / 1366), (int) (b * 377 / 768), false)); // TD2

		listpoint.add(new Point((int) (a * 232 / 1366), (int) (b * 59 / 768), false)); // TP3

		listpoint.add(new Point((int) (a * 108 / 1366), (int) (b * 343 / 768), false)); // SEBASTIEN GORGE 

		listpoint.add(new Point((int) (a * 307 / 1366), (int) (b * 344 / 768), false)); // TIBBS / KACEM

		listpoint.add(new Point((int) (a * 247 / 1366), (int) (b * 339 / 768), false)); // Vincent BARRE ET LAhCEN OUBAHSSI

		listpoint.add(new Point((int) (a * 571 / 1366), (int) (b * 89 / 768), false)); // TDM4

		listpoint.add(new Point((int) (a * 566 / 1366), (int) (b * 200 / 768), false)); // TDM1

		listpoint.add(new Point((int) (a * 58 / 1366), (int) (b * 524 / 768), false)); // IZA MARFISI ET LUDOVIC HAMON

		listpoint.add(new Point((int) (a * 200 / 1366), (int) (b * 522 / 768), false)); // Salle Nour EL MAWAS /Jean-Pierre CLAYER

		listdelistdepoint.add(listpoint);
		// Carte Dep Info//

		informatique = new Cartes(new Dimension(a * 650 / 1366, b * 580 / 768), fen,
				getClass().getResource("informatique.png"), "DÃ©partement Informatique de l'IUT de Laval",
				listdelistdepoint, questionArcade, opt, menu, choixArcade);

		Font f0 = new Font("Calibri", Font.PLAIN, a * 80 / 1366);
		Font f1 = new Font("Calibri", Font.PLAIN, a * 25 / 1366);
		Font f2 = new Font("Calibri", Font.PLAIN, a * 18 / 1366);
		this.setBackground(Color.black);

		this.setLayout(null);
		panEntete.setLayout(null);
		panEntete.setBounds(0, 0, a, (int) (b / 4));
		panEntete.setOpaque(false);
		panEntete.add(entete);
		entete.setBounds(0, (int) (panEntete.getHeight() / 3), panEntete.getWidth(),
				(int) (panEntete.getHeight() * 2 / 3));
		entete.setOpaque(false);
		bouton.setSize(new Dimension(a * 107 / 1920, b * 60 / 1080));
		panRetour.add(bouton);
		panRetour.setBounds((int) (a * 9 / 10), (int) (b * 50 / 1080), (int) (a / 10), (int) (b / 4));
		panRetour.setOpaque(false);
		entete.add(titre);
		panEntete.add(entete);
		panEntete.add(panRetour);

		titre.setFont(f0);
		titre.setForeground(new Color(180, 187, 191));
		question.setFont(f1);
		question.setForeground(new Color(180, 187, 191));

		panQuestion.setOpaque(false);
		panQuestion.setBounds(0, (b / 4), a, (b / 40) * 3);
		panQuestion.add(question);
		bouton.setFont(f2);
		bouton.setForeground(new Color(180, 187, 191));
		bouton.setBackground(Color.darkGray);
		bouton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fen.setContentPane(menu);
				fen.remove(choixArcade);
				fen.revalidate();

			}
		});

		panCartes.setPreferredSize(new Dimension((int) (2 * a / 3 - a * 20 / 1920), (int) (b * 500 * 4 / 1920)));

		if (listCarteXML.size() == 0) {
			panCartes.setLayout(new GridLayout(2, 2, a * 40 / 1920, a * 40 / 1920));
		} else {
			panCartes.setLayout(new GridLayout(((listCarteXML.size() + 4) / 3), 3, a * 40 / 1920, a * 40 / 1920));
		}

		panCartes.add(laval.getMiniature());
		panCartes.add(mayenne.getMiniature());
		panCartes.add(iut.getMiniature());
		panCartes.add(informatique.getMiniature());

		panCartes.setOpaque(false);

		scroll = new JScrollPane(panCartes);
		scroll.setForeground(new Color(255, 255, 255, 0));
		scroll.setBounds(a / 6, (b / 40) * 15, 2 * a / 3, (b / 2));
		scroll.setOpaque(false);
		scroll.setBackground(new Color(255, 255, 255, 0));
		scroll.setBorder(null);
		scroll.getVerticalScrollBar().setUnitIncrement(16);

		this.add(panEntete);
		this.add(panQuestion);
		this.add(scroll);

	}

	// fond d'ecran
	public void paintComponent(Graphics g) {
		try {
			Image img = ImageIO.read(getClass().getResource("investigation.jpg"));
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
