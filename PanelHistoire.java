package new_investigation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.PaintEvent;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.text.AttributedCharacterIterator;

import javax.imageio.ImageIO;
import javax.swing.*;

public class PanelHistoire extends JPanel {

	int i = 0, question = 1;
	String parties[] = {
			"",
			"Assistance Eclipse\nBonjour jeune stagiaire, la police veut que vous vous rendiez en Mayenne, plus précisément sur Laval.\nPréparez-vous, et rendez vous sur Laval et je vous recontacterai une fois arrivé.PLACEZ LAVAL",
			"Assistante Eclipse\nBien, nous y voilà, l’équipe de police nous attend sur la place du 11 Novembre.\nPLACEZ LA PLACE DU 11 NOVEMBRE",
			"Capitaine Python\nC’est donc vous l’inspecteur ____ ? Bien, sans plus tarder, nous allons nous diriger sur \nles lieux du crime. Vous allez constater les faits par vous-même. \nLe crime a eu lieu à l’Institut Universitaire Technologique. PLACEZ L'IUT",
			"Capitaine Python\nUn témoin a vu une personne s’enfuir en courant. Il semblerait qu’il se dirigeait vers le département \ninformatique.\nPLACEZ LE DEPARTEMENT INFORMATIQUE",
			"Assistante Eclipse\nIl y a de la lumière dans l’une des salles au premier étage, c’est étrange... Il s’agit de la salle Gotham.\nPLACEZ LA SALLE GOTHAM",
			"Capitaine Python\n(au moment d’entrer dans la salle) Une vitre a été brisée ! Quelqu’un cours vers la Bibliothèque \nUniversitaire !\nPLACEZ LA BIBLIOTHEQUE UNIVERSITAIRE",
			"Assistante Eclipse\n(Dehors) Il est parti dans une voiture verte qui se dirige vers l'administration ! Retrouvons-le !\nPLACEZ L'ADMINISTRATION",
			"Capitaine Python\nUn témoin indique que la voiture se dirige vers la gare ! Vite retrouvons-le.\nPLACEZ LA GARE",
			"Assistante Eclipse\nLa voiture n’est plus là ! Il semblerait qu’elle ait quitté la gare il y a peu, elle se dirige vers le théâtre.\nPLACEZ LE THEATRE",
			"Capitaine Python\nNon ce n’était pas ici ! La voiture a été signalé à la sortie de la ville et se dirige vers Evron, il faut le \nretrouver au plus vite !\nPLACEZ EVRON",
			/* Si plus de 2 reponses fausses */"Assistante Eclipse\nC'est trop tard ! Nous avons pris trop de temps pour retrouver sa trace il s'est enfui.\nVOUS AVEZ PERDU ! Rejoignez votre équipe devant la PREFECTURE",
			/* Sinon */"Assistante Eclipse\nIl n’est pas loin ! On y est presque, il se dirige vers Mayenne !\nPLACEZ MAYENNE",
			"Capitaine Python\nIl faut le rattraper ! Il essaye de fuir vers la Manche, ne le laissez pas quitter la Mayenne.\nPLACEZ LE POINT A LA FRONTIERE AVEC LA MANCHE",
			"Capitaine Python\nNe bouge plus ! \nVous êtes en état d’arrestation pour avoir débranché le câble Ethernet et pour délit de fuite ! \nC’est un crime impardonnable ! RENDEZ VOUS A L'HOTEL DE POLICE",
			"Suspect Luna\nNON NON NON !!  ... Comment avez vous pu me rattraper ?! \nJe me vengerai !",
			"Capitaine Python\nBien joué détective ______ !\n Vu votre efficacité, vous ne pouvez qu'etre promu dans notre service, vous devenez Sergent !\nRENDEZ VOUS A LA PREFECTURE POUR FETER VOTRE PROMOTION",
			"Assistante Eclipse\nFélicitations _______ !! \nvous avez réussi avec brio votre mission, nous referons appel à vous rapidement.\nVOUS POUVEZ MAINTENANT DEGUSTER UN REPAS AU SUBWAY" };
	private JPanel panEntete = new JPanel();
	private JPanel panCarte = new JPanel();
	private JPanel panScore = new JPanel();
	private JPanel panQuestion = new JPanel();
	private JPanel panLieu = new JPanel();
	private JPanel panTemps = new JPanel();
	private JPanel panAvatar = new JPanel();
	private JLabel titre = new JLabel("Investigation");
	private JButton abandon = new JButton("Abandonner la partie");
	private JTextArea zoneScenario = new JTextArea(
			"\n\nCliquez sur le point d'interrogation pour demarrer la partie");
	private JLabel labelQuestion = new JLabel("<HTML><CENTER>Question : \n 0/"
			+ (parties.length - 1));
	private ChronoPanel chrono = new ChronoPanel();

	public PanelHistoire(final Fenetre fen) {
		// FENETRE GLOBALE
		final int a = (int) fen.getWidth();
		final int b = (int) fen.getHeight();

		this.setPreferredSize(new Dimension(a, b));

		this.setLayout(null);
		this.setOpaque(false);
		this.setBackground(Color.black);
		Font f2 = new Font("Calibri", Font.PLAIN, 30);
		Font f3 = new Font("Calibri", Font.PLAIN, 15);
		Font f5 = new Font("Calibri", Font.BOLD, 19);

		// AJOUT PANEL panEntete ET ELEMENTS
		panEntete.setLayout(null);
		panEntete.setBackground(Color.DARK_GRAY);
		panEntete.setBounds(0, 0, a, (int) (b / 4));
		panEntete.setOpaque(false);
		panEntete.add(titre);
		panEntete.add(abandon);
		abandon.setLayout(null);
		abandon.setOpaque(true);
		abandon.setFont(f3);
		abandon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Popup pop = new Popup(fen);
				fen.revalidate();
			}
		});

		abandon.setLayout(null);
		abandon.setOpaque(true);
		abandon.setBounds(a * 1110 / 1366, b * 20 / 768, a * 170 / 1366,
				b * 25 / 768);

		// AJOUT PANEL panCarte ET ELEMENTS
		panCarte.setLayout(null);
		panCarte.setOpaque(false);
		panCarte.setBounds(a * 10 / 1366, b * 120 / 768, a * 1050 / 1366,
				b * 620 / 768); // AJOUTER RATIO DE PROPORTION
		final JLabel label = new JLabel();
		label.setIcon(new ImageIcon("lol.jpg"));
		panCarte.add(label);
		label.setBounds(a * 200 / 1366, b * 10 / 768, a * 700 / 1366,
				b * 671 / 768);

		// AJOUT PANEL panStat ET ELEMENTS
		panScore.setLayout(null);
		panScore.setOpaque(true);
		panScore.setBounds(a * 1100 / 1366, b * 300 / 768, a * 200 / 1366,
				b * 120 / 768);

		// AJOUT PANEL panQuestion ET ELEMENTS
		panQuestion.setLayout(null);
		panQuestion.setOpaque(true);
		panQuestion.setBounds(a * 1100 / 1366, b * 500 / 768, a * 200 / 1366,
				b * 120 / 768);

		panQuestion.add(labelQuestion);
		labelQuestion.setFont(f2);
		labelQuestion.setBounds(a * 5 / 1366, b * 5 / 768, a * 200 / 1366,
				b * 70 / 768);

		// AJOUT PANEL panAvatar ET ELEMENTS
		panAvatar.setLayout(null);
		panAvatar.setOpaque(true);
		panAvatar.setBounds(75,5,50,100);

		// AJOUT PANEL panLeu ET ELEMENTS

		panLieu.setLayout(null);
		panLieu.setOpaque(true);
		panLieu.setBounds(a * 150 / 1366, b * 5 / 768, a * 800 / 1366,
				b * 100 / 768);

		panLieu.add(zoneScenario);
		zoneScenario.setBounds(a * 0 / 1366, b * 0 / 768, a * 800 / 1366,
				b * 100 / 768);
		zoneScenario.setFont(f5);
		zoneScenario.setEditable(false);
		this.setFocusable(true);
		this.requestFocus();
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

				// VERIFIER SI LE CLIC EST FAIT SUR LA CARTE : Recuperer
				// coordonnées du clic et comparer avec les coordonnées du label
				if (i == 0) {
					label.setIcon(new ImageIcon("CarteMayenne.gif"));

				}
				if (i == 1) {
					label.setIcon(new ImageIcon("Map_Laval,_Mayenne.jpg"));
				}
				if (i == 2) {
					label.setIcon(new ImageIcon("Map_Laval,_Mayenne.jpg"));
				}
				if (i == 3) {
					label.setIcon(new ImageIcon("campus.jpg"));
				}
				if (i == 4) {
					label.setIcon(new ImageIcon("planIUT2.jpg"));
				}
				if (i == 5) {
					label.setIcon(new ImageIcon("campus.jpg"));
				}
				if (i == 6) {
					label.setIcon(new ImageIcon("campus.jpg"));
				}
				if (i == 7) {
					label.setIcon(new ImageIcon("Map_Laval,_Mayenne.jpg"));
				}
				if (i == 8) {
					label.setIcon(new ImageIcon("Map_Laval,_Mayenne.jpg"));
				}
				if (i == 9) {
					label.setIcon(new ImageIcon("CarteMayenne.gif"));
				}
				if (i == 10) {
					// si 2 réponses fausses : break
					label.setIcon(new ImageIcon("Map_Laval,_Mayenne.jpg"));
					// sinon : i==12
				}
				if (i == 11) {
					label.setIcon(new ImageIcon("CarteMayenne.gif"));
				}
				if (i == 12) {
					label.setIcon(new ImageIcon("CarteMayenne.gif"));
				}
				if (i == 13) {
					label.setIcon(new ImageIcon("Map_Laval,_Mayenne.jpg"));
				}
				if (i == 14) {
					label.setIcon(new ImageIcon("lol.jpg"));
				}
				if (i == 15) {
					label.setIcon(new ImageIcon("CarteMayenne.gif"));
				}
				if (i == 16) {
					label.setIcon(new ImageIcon("Map_Laval,_Mayenne.jpg"));
				}
				if (i == 17) {
					label.setIcon(new ImageIcon("Map_Laval,_Mayenne.jpg"));
				}

				i++;
				zoneScenario.setText(parties[i]);
				labelQuestion.setText("<HTML>Question :<BR/><HTML> " + question
						+ "/" + (parties.length - 1));
				question++;

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
				// TODO Auto-generated method stub

			}
		});

		// AJOUT PANEL panTemps ET ELEMENTS
		panTemps.add(new JProgressBar());
		panTemps.add(chrono);
		chrono.setOpaque(false);
		chrono.setBounds(a * 1100 / 1366, b * 150 / 768, a * 200 / 1366,
				b * 100 / 768);

		this.add(panEntete);
		this.add(panCarte);
		this.add(panQuestion);
		this.add(panScore);
		this.add(panTemps);
		this.add(panLieu);
		this.add(chrono);

	}

}
