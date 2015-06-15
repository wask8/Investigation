package testScenarioModeHistoire;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.TabableView;

public class Fenetre extends JFrame implements KeyListener {

	private JPanel panel = new JPanel();
	private JLabel label1 = new JLabel("<HTML><I>Appuyer sur entrée pour demarrer le scenario</I></HTML>");

	public Fenetre() {

		this.setSize(800, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel.setBounds(0, 0, 800, 500);
		panel.setBackground(Color.gray);
		panel.add(label1);
		addKeyListener(this);
		this.setContentPane(panel);
		this.setVisible(true);

	}

	int i = 0;
	String parties[] = {
			"<HTML><CENTER>Assistance Eclipse<BR/>Bonjour jeune stagiaire, la police veut que vous vous rendiez en Mayenne, plus précisément sur Laval.<BR/>Préparez-vous, et rendez vous sur Laval et je vous recontacterai une fois arrivé.<BR/> PLACEZ LAVAL</CENTER><HTML>",
			"<HTML><CENTER>Assistante Eclipse<BR/>Bien, nous y voilà, l’équipe de police nous attend sur la place du 11 Novembre.<BR/>PLACEZ LA PLACE DU 11 NOVEMBRE</CENTER></HTML>",
			"<HTML><CENTER>Capitaine Python<BR/>C’est donc vous l’inspecteur ____ ? Bien, sans plus tarder, nous allons nous diriger sur les lieux du crime.<BR/>Vous allez constater les faits par vous-même. Le crime a eu lieu à l’Institut Universitaire Technologique.<BR/>PLACEZ L'IUT</CENTER></HTML>",
			"<HTML><CENTER>Capitaine Python<BR/>Un témoin a vu une personne s’enfuir en courant. Il semblerait qu’il se dirigeait vers le département informatique.<BR/>PLACEZ LE DEPARTEMENT INFORMATIQUE</CENTER></HTML>",
			"<HTML><CENTER>Assistante Eclipse<BR/>Il y a de la lumière dans l’une des salles au premier étage, c’est étrange... Il s’agit de la salle Gotham.<BR/>PLACEZ LA SALLE GOTHAM</CENTER><HTML>",
			"<HTML><CENTER>Capitaine Python<BR/><I>(au moment d’entrer dans la salle)</I> Une vitre a été brisée ! Quelqu’un cours en bas !</CENTER></HTML>",
			"<HTML><CENTER>Assistante Eclipse<BR/><I>(Dehors)</I> Il est parti dans une voiture verte ! Retrouvons-le !",
			"<HTML><CENTER>Capitaine Python<BR/>Un témoin indique que la voiture se dirige vers la gare ! Vite retrouvons-le.<BR/>PLACEZ LA GARE</CENTER></HTML>",
			"<HTML><CENTER>Assistante Eclipse<BR/>La voiture n’est plus là ! Il semblerait qu’elle ait quitté la gare il y a peu, elle se dirige vers le théâtre.<BR/>PLACEZ LE THEATRE</CENTER></HTML>",
			"<HTML><CENTER>Capitaine Python<BR/>Non ce n’était pas ici ! La voiture a été signalé à la sortie de la ville et se dirige vers Evron, il faut le retrouver au plus vite !<BR/>PLACEZ EVRON</CENTER></HTML>",
			/* Si plus de 2 reponses fausses */"<HTML><CENTER>Assistante Eclipse - C'est trop tard ! Nous avons pris trop de temps pour retrouver sa trace il s'est enfui</CENTER></HTML>",
			/* Sinon */"<HTML><CENTER>Assistante Eclipse<BR/>Il n’est pas loin ! On y est presque !</CENTER></HTML>",
			"<HTML><CENTER>Capitaine Python<BR/>Il faut le rattraper ! Il essaye de fuir vers la Manche, ne le laissez pas quitter la Mayenne.<BR/>PLACEZ LE POINT A LA FRONTIERE AVEC LA MANCHE</CENTER></HTML>",
			"<HTML><CENTER>Capitaine Python<BR/>Ne bouge plus ! <BR/>Vous êtes en état d’arrestation pour avoir débranché le câble Ethernet et pour délit de fuite ! <BR/>C’est un crime impardonnable !</CENTER></HTML>",
			"<HTML><CENTER>Suspect Luna<BR/>NON NON NON !!  ... Comment avez vous pu me rattraper ?! <BR/>Je me vengerai !</CENTER></HTML>",
			"<HTML><CENTER>Capitaine Python<BR/>Bien joué détective ______ !<BR/> Vu votre efficacité, vous ne pouvez qu'etre promu dans notre service, vous devenez Sergent !</CENTER></HTML>",
			"<HTML><CENTER>Assistante Eclipse<BR/>Félicitations _______ !! <BR/>vous avez réussi avec brio votre mission, nous referons appel à vous rapidement.</CENTER></HTML>" };

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyChar() == 10) {
			label1.setText(parties[i]);
			// Incrémentation (on passe à la partie suivante)
			i++;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
