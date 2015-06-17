package new_investigation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class PanelChoixCarteArcade extends JPanel {

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

	/* DANS L'ATTENTE D'AUTRE CHOSE */
	private JButton boutonattente = new JButton("Bouton Provisoire (acces PanelArcade)");

	// private JScrollBar scroll = new JScrollBar();

	public PanelChoixCarteArcade(final Fenetre fen, PanelMenu menu) {

		a = (int) fen.getWidth();
		b = (int) fen.getHeight();

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
		
		
		panCartes.setPreferredSize(new Dimension((int)(2*a/3-a*20/1920),(int)(b*500*4/1920)));
		panCartes.setLayout(new GridLayout(4, 3, a * 40 / 1920, a * 40 / 1920));
		panCartes.add(boutonattente);
		panCartes.add(new JButton());
		panCartes.add(new JButton());
		panCartes.add(new JButton());
		panCartes.add(new JButton());
		panCartes.add(new JButton());
		panCartes.add(new JButton());
		panCartes.add(new JButton());
		panCartes.add(new JButton());
		panCartes.add(new JButton());
		panCartes.add(new JButton());

		panCartes.setOpaque(false);
		scroll = new JScrollPane(panCartes);
		scroll.setBounds(a / 6, (b / 40) * 15, 2*a/3, (b / 2));
		scroll.setOpaque(false);
		scroll.setBorder(null);
		/* Espace tempo */

		boutonattente.setBounds(a * 525 / 1366, b / 8, 300, 200);
		boutonattente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fen.setContentPane(new PanelArcade(fen));
				fen.revalidate();

			}
		});
		/* Espace tempo */

		this.add(panEntete);
		this.add(panQuestion);
		this.add(scroll);

	}

	// fond d'ecran
	public void paintComponent(Graphics g) {
		try {
			Image img = ImageIO.read(new File("investigation.jpg"));
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
