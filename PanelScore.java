package new_investigation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class PanelScore extends JPanel {

	
	private static final long serialVersionUID = 5842236064861476625L;
	private JPanel panTitre = new JPanel();
	private JPanel pantab1 = new JPanel();
	private JPanel pantab2 = new JPanel();
	private JPanel trait = new JPanel();
	private JPanel panbouton = new JPanel();
	private JLabel titre = new JLabel("Investigation");
	private JLabel soustitre = new JLabel("Meilleurs scores");
	private JLabel tab1 = new JLabel("Mode Histoire");
	private JLabel tab2 = new JLabel("Mode Arcade");
	private JTextArea zonetab1 = new JTextArea("Tableau score issu du XML du mode histoire");
	private JTextArea zonetab2 = new JTextArea("Tableau score issu du XML du mode arcade");
	private JButton bouton = new JButton("Retour au menu principal");

	public PanelScore(final Fenetre fen) {

		// FENETRE GLOBALE
		int a = (int) fen.getWidth();
		int b = (int) fen.getHeight();

		this.setPreferredSize(new Dimension(a, b));
//		this.setTitle("Investigation - Scores");
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		this.setLocationRelativeTo(null);
		Font f0 = new Font("Calibri", Font.PLAIN, a*80/1366);
		Font f1 = new Font("Calibri", Font.PLAIN, a*50/1366);
		Font f2 = new Font("Calibri", Font.PLAIN, a*30/1366);
		Font f3 = new Font("Calibri", Font.PLAIN, a*18/1366);
		
		// AJOUT ELEMENT PANEL TITRE
		panTitre.setLayout(null);
		panTitre.setBounds(0, 0, a, (int) (b / 4));
		panTitre.setOpaque(false);
		panTitre.add(titre);
		titre.setBounds((int)(a/1366*470), (int)(b/768*20),(int)(a/1366* 800), (int)(b/768*70));
		panTitre.add(soustitre);
		soustitre.setBounds((int)(a/1366*515), (int)(b/768*100),(int)(a/1366* 800), (int)(b/768*70));
		titre.setFont(f0);
		titre.setForeground(new Color(180, 187, 191)); // 180,187,191
		soustitre.setFont(f1);
		soustitre.setForeground(new Color(180, 187, 191)); // 180,187,191

		// AJOUT PANEL pantab1 et ELEMENTS
		pantab1.setLayout(null);
		pantab1.setBounds(0, (int)(b/768*150), (a / 2) - (int)(a/1366*10), (b / 4) * 3);
		// pantab1.setBackground(Color.orange);
		pantab1.setOpaque(false);
		pantab1.add(tab1);
		tab1.setBounds((int)(a/1366*260), (int)(b/768*10), (int)(a/1366*200), (int)(b/768*50));
		tab1.setFont(f2);
		tab1.setForeground(new Color(180, 187, 191));
		pantab1.add(zonetab1);
		zonetab1.setBounds((int)(a/1366*100),(int)(b/768*100),(int)(a/1366*500),(int)(b/768*300));
		zonetab1.setFont(f3);

		// AJOUT PANEL pantab2 et ELEMENTS
		pantab2.setLayout(null);
		pantab2.setBounds((a / 2) + (int)(a/1366*10), (int)(b/768*150), a / 2, (b / 4) * 3);
		// pantab2.setBackground(Color.red);
		pantab2.setOpaque(false);
		pantab2.add(tab2);
		tab2.setBounds((int)(a/1366*260), (int)(b/768*10), (int)(a/1366*200), (int)(b/768*50));
		tab2.setFont(f2);
		tab2.setForeground(new Color(180, 187, 191));
		pantab2.add(zonetab2);
		zonetab2.setBounds((int)(a/1366*70), (int)(b/768*100), (int)(a/1366*500), (int)(b/768*300));
		zonetab2.setFont(f3);

		// AJOUT PANEL trait
		trait.setLayout(null);
		trait.setBounds((a / 2) - (int)(a/1366*10), (int)(b/768*250), (int)(a/1366*3), (int)(b/768*300));
		trait.setBackground(Color.white);
		trait.setOpaque(true);

		// AJOUT PANEL panbouton ET ELEMENT
		panbouton.setLayout(null);
		panbouton.setBounds(0, (int)(b/768*590), (int)(a/1366*1500), (int)(b/768*100));
		panbouton.setOpaque(false);
		
		panbouton.add(bouton);
		bouton.setBounds((int)(a/1366*540),(int)(b/768*10),(int)(a/1366*250),(int)(b/768*50));
		bouton.setFont(f3);
		bouton.setForeground(new Color(180, 187, 191));
		bouton.setBackground(Color.darkGray);
		bouton.setFocusPainted(false);
		bouton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fen.setContentPane(new PanelMenu(fen));
				fen.repaint();
				fen.revalidate();
				
			}
		});

				
		// AFFICHAGE
		this.add(panTitre);
		this.add(pantab1);
		this.add(pantab2);
		this.add(trait);
		this.add(panbouton);

		this.setLayout(null);
	}
	//fond d'ecran
		public void paintComponent(Graphics g) {
			try {
				Image img = ImageIO.read(new File("investigation.jpg"));
				g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			} catch (IOException e) {
				e.printStackTrace();
			}


	}
	
}
