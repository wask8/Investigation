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

public class PanelHistoire extends JPanel implements MouseListener {

	int i = 0, question = 1;
	String parties[] = {
			"<HTML><CENTER><B>Assistance Eclipse</B><BR/>Bonjour jeune stagiaire, la police veut que vous vous rendiez en Mayenne, plus précisément sur Laval.<BR/>Préparez-vous, et rendez vous sur Laval et je vous recontacterai une fois arrivé.<BR/> PLACEZ LAVAL</CENTER><HTML>",
			"<HTML><CENTER><B>Assistante Eclipse</B><BR/>Bien, nous y voilà, l’équipe de police nous attend sur la place du 11 Novembre.<BR/>PLACEZ LA PLACE DU 11 NOVEMBRE</CENTER></HTML>",
			"<HTML><CENTER><B>Capitaine Python</B><BR/>C’est donc vous l’inspecteur ____ ? Bien, sans plus tarder, nous allons nous diriger sur les lieux du crime.<BR/>Vous allez constater les faits par vous-même. Le crime a eu lieu à l’Institut Universitaire Technologique.<BR/>PLACEZ L'IUT</CENTER></HTML>",
			"<HTML><CENTER><B>Capitaine Python</B><BR/>Un témoin a vu une personne s’enfuir en courant. Il semblerait qu’il se dirigeait vers le département informatique.<BR/>PLACEZ LE DEPARTEMENT INFORMATIQUE</CENTER></HTML>",
			"<HTML><CENTER><B>Assistante Eclipse</B><BR/>Il y a de la lumière dans l’une des salles au premier étage, c’est étrange... Il s’agit de la salle Gotham.<BR/>PLACEZ LA SALLE GOTHAM</CENTER><HTML>",
			"<HTML><CENTER><B>Capitaine Python</B><BR/><I>(au moment d’entrer dans la salle)</I> Une vitre a été brisée ! Quelqu’un cours vers la Bibliothèque Universitaire !<BR/>PLACEZ LA BIBLIOTHEQUE UNIVERSITAIRE</CENTER></HTML>",
			"<HTML><CENTER><B>Assistante Eclipse</B><BR/><I>(Dehors)</I> Il est parti dans une voiture verte qui se dirige vers l'administration ! Retrouvons-le !<BR/>PLACEZ L'ADMINISTRATION",
			"<HTML><CENTER><B>Capitaine Python</B><BR/>Un témoin indique que la voiture se dirige vers la gare ! Vite retrouvons-le.<BR/>PLACEZ LA GARE</CENTER></HTML>",
			"<HTML><CENTER><B>Assistante Eclipse</B><BR/>La voiture n’est plus là ! Il semblerait qu’elle ait quitté la gare il y a peu, elle se dirige vers le théâtre.<BR/>PLACEZ LE THEATRE</CENTER></HTML>",
			"<HTML><CENTER><B>Capitaine Python</B><BR/>Non ce n’était pas ici ! La voiture a été signalé à la sortie de la ville et se dirige vers Evron, il faut le retrouver au plus vite !<BR/>PLACEZ EVRON</CENTER></HTML>",
			/* Si plus de 2 reponses fausses */"<HTML><CENTER><B>Assistante Eclipse</B><BR/>C'est trop tard ! Nous avons pris trop de temps pour retrouver sa trace il s'est enfui.<BR/>VOUS AVEZ PERDU ! Rejoignez votre équipe devant la PREFECTURE</CENTER></HTML>",
			/* Sinon */"<HTML><CENTER><B>Assistante Eclipse</B><BR/>Il n’est pas loin ! On y est presque, il se dirige vers Mayenne !<BR/>PLACEZ MAYENNE</CENTER></HTML>",
			"<HTML><CENTER><B>Capitaine Python</B><BR/>Il faut le rattraper ! Il essaye de fuir vers la Manche, ne le laissez pas quitter la Mayenne.<BR/>PLACEZ LE POINT A LA FRONTIERE AVEC LA MANCHE</CENTER></HTML>",
			"<HTML><CENTER><B>Capitaine Python</B><BR/>Ne bouge plus ! <BR/>Vous êtes en état d’arrestation pour avoir débranché le câble Ethernet et pour délit de fuite ! <BR/>C’est un crime impardonnable ! RENDEZ VOUS A L'HOTEL DE POLICE</CENTER></HTML>",
			"<HTML><CENTER><B>Suspect Luna</B><BR/>NON NON NON !!  ... Comment avez vous pu me rattraper ?! <BR/>Je me vengerai !</CENTER></HTML>",
			"<HTML><CENTER><B>Capitaine Python</B><BR/>Bien joué détective ______ !<BR/> Vu votre efficacité, vous ne pouvez qu'etre promu dans notre service, vous devenez Sergent !<BR/>RENDEZ VOUS A LA PREFECTURE POUR FETER VOTRE PROMOTION</CENTER></HTML>",
			"<HTML><CENTER>A<B>ssistante Eclipse</B><BR/>Félicitations _______ !! <BR/>vous avez réussi avec brio votre mission, nous referons appel à vous rapidement.<BR/>VOUS POUVEZ MAINTENANT DEGUSTER UN REPAS AU SUBWAY</CENTER></HTML>" };
	private JPanel panEntete = new JPanel();
	private JPanel panCarte = new JPanel();
	private JPanel panScore = new JPanel();
	private JPanel panQuestion = new JPanel();
	private JPanel panLieu = new JPanel();
	private JPanel panTemps = new JPanel();
	private JLabel titre = new JLabel("Investigation");
	private JButton abandon = new JButton("Abandonner la partie");
	private JLabel label1 = new JLabel(
			"Cliquez pour demarrer le scenario");
	private JLabel labelQuestion = new JLabel(
			"<HTML><CENTER>Question : <BR/> 0/" + (parties.length-1));
	private JLabel temps = new JLabel("<HTML>Temps restant</HTML>");
	private ChronoPanel chrono = new ChronoPanel();

	public PanelHistoire(final Fenetre fen) {
		// FENETRE GLOBALE
		final int a = (int) fen.getWidth();
		final int b = (int) fen.getHeight();

		this.setPreferredSize(new Dimension(a, b));

		this.setLayout(null);
		this.setOpaque(false);
		this.setBackground(Color.black);
		Font f0 = new Font("Calibri", Font.PLAIN, 80);
		Font f1 = new Font("Calibri", Font.PLAIN, 50);
		Font f2 = new Font("Calibri", Font.PLAIN, 30);
		Font f3 = new Font("Calibri", Font.PLAIN, 18);
		Font f4 = new Font("Calibri", Font.PLAIN, 10);
		Font f5 = new Font("Calibri", Font.PLAIN, 13);

		// AJOUT PANEL panEntete ET ELEMENTS
		panEntete.setLayout(null);
		panEntete.setBackground(Color.DARK_GRAY);
		panEntete.setBounds(0, 0, a, (int) (b / 4));
		panEntete.setOpaque(false);
		panEntete.add(titre);
		panEntete.add(abandon);
		abandon.setLayout(null);
		abandon.setOpaque(true);
		abandon.setFont(f5);
		abandon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fen.setContentPane(new PanelMenu(fen));
				fen.repaint();
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
		panCarte.setBackground(Color.red);
		JLabel label = new JLabel();
		label.setIcon(new ImageIcon("Map_Laval,_Mayenne.jpg"));
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

		// AJOUT PANEL panLeu ET ELEMENTS

		panLieu.setLayout(null);
		panLieu.setOpaque(true);
		panLieu.setBounds(a * 150 / 1366, b * 5 / 768, a * 800 / 1366,
				b * 100 / 768);

		// SCENARIO
		panLieu.add(label1);
		label1.setBounds(a * 0 / 1366, b * 0 / 768, a * 800 / 1366,
				b *100 / 768);
		label1.setFont(f5);
		this.setFocusable(true);
		this.requestFocus();
		this.addMouseListener(this);

		// AJOUT PANEL panTemps ET ELEMENTS
		panTemps.add(new JProgressBar());
		panTemps.add(chrono);
		chrono.setOpaque(true);
		chrono.setBounds(a * 1100 / 1366, b * 150 / 768, a * 200 / 1366,
				b * 60 / 768);

		this.add(panEntete);
		this.add(panCarte);
		this.add(panQuestion);
		this.add(panScore);
		this.add(panTemps);
		this.add(panLieu);
		this.add(chrono);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		i++;
		label1.setText(parties[i]);
		labelQuestion.setText("<HTML>Question :<BR/><HTML> " +question + "/" + (parties.length - 1));
		question++;
		if (i == 10) {
			// si 2 réponses fausses : i++
			// sinon : i==12
		}

		if (i == 15) {
			question--;
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
