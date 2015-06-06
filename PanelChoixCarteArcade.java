package new_investigation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
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
	private JPanel panBouton = new JPanel();
	private JPanel panCartes = new JPanel();
	private JLabel titre = new JLabel("Investigation");
	private JLabel question = new JLabel(
			"Selectionnez la carte sur laquelle vous souhaitez jouer");
	private JButton bouton = new JButton("Retour au menu principal");
	
	/*DANS L'ATTENTE D'AUTRE CHOSE*/ private JButton boutonattente = new JButton("Bouton Provisoire (acces PanelArcade)");
	

	// private JScrollBar scroll = new JScrollBar();

	public PanelChoixCarteArcade(final Fenetre fen) {

		a = (int) fen.getWidth();
		b = (int) fen.getHeight();

		Font f0 = new Font("Calibri", Font.PLAIN, a * 80 / 1366);
		Font f1 = new Font("Calibri", Font.PLAIN, a * 50 / 1366);
		Font f2 = new Font("Calibri", Font.PLAIN, a * 18 / 1366);
		this.setBackground(Color.black);

		this.setLayout(null);
		panEntete.setBounds(0, 0, a, (int) (b / 4));
		panEntete.setOpaque(false);
		panEntete.add(titre);
		titre.setBounds((int) (a * 470 / 1366), (int) (b * 20 / 768),
				(int) (a * 800 / 1366), (int) (b * 70 / 768));
		panEntete.add(question);
		question.setBounds((int) (a * 600 / 1366), (int) (b * 100 / 768),
				(int) (a * 800 / 1366), (int) (b * 70 / 768));
		titre.setFont(f0);
		titre.setForeground(new Color(180, 187, 191));
		question.setFont(f1);
		question.setForeground(new Color(180, 187, 191));
		
		panBouton.setLayout(null);
		panBouton.setOpaque(false);
		panBouton.setBounds(0, (b/4), a, (b/40)*3);
		panBouton.add(bouton);
		bouton.setBounds((a*100/1366),0,a/6,30);
		bouton.setFont(f2);
		bouton.setForeground(new Color(180, 187, 191));
		bouton.setBackground(Color.darkGray);
		bouton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fen.setContentPane(new PanelMenu(fen));
				fen.revalidate();

			}
		});
		panCartes.setLayout(null);
		panCartes.setBounds(0,(b/40)*15 ,a,(b/40)*25);
		panCartes.setOpaque(false);
		panCartes.add(boutonattente);
		boutonattente.setBounds(a*525/1366,b/8,300,200);
		boutonattente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fen.setContentPane(new PanelArcade(fen));
				fen.revalidate();

			}
		});

		this.add(panEntete);
		this.add(panBouton);
		this.add(panCartes);

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
