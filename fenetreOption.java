package Investigation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.*;

public class fenetreOptions extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// DECLARATION ELEMENTS

	private Panneau fond = new Panneau();
	private JPanel panTitre = new JPanel();
	private JPanel panTexte = new JPanel();
	private JPanel panBouton1 = new JPanel();
	private JPanel panBouton2 = new JPanel();
	private JLabel titre = new JLabel("Investigation");
	private JLabel soustitre = new JLabel("Options");
	private JLabel pseudo = new JLabel("Votre pseudo : ");
	private JLabel difficulte = new JLabel("Choix de la difficulté : ");
	private JTextField zonePseudo = new JTextField("Player");
	private JRadioButton boxEasy = new JRadioButton(
			"<html>FACILE<br>(20s de temps de réponse)</html>");
	private JRadioButton boxHard = new JRadioButton(
			"<html>DIFFICILE<br>(10s de temps de réponse)</html>");
	private JButton boutonVal = new JButton("VALIDER");
	private JButton boutonAnnu = new JButton("ANNULER");

	public fenetreOptions() throws HeadlessException {
		super();

		// FENETRE GLOBALE
		Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int a = (int) dim.getWidth();
		int b = (int) dim.getHeight();

		this.setSize(a, b);
		this.setTitle("Investigation - Options");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		Font f0 = new Font("Calibri", Font.PLAIN, 80);
		Font f1 = new Font("Calibri", Font.PLAIN, 50);
		Font f2 = new Font("Calibri", Font.PLAIN, 30);
		Font f3 = new Font("Calibri", Font.PLAIN, 18);

		// AJOUT ELEMENT PANEL TITRE
		panTitre.setLayout(null);
		panTitre.setBounds(0, 0, a, (int) (b / 4));
		panTitre.setOpaque(false);
		panTitre.add(titre);
		titre.setBounds(470, 20, 800, 70);
		panTitre.add(soustitre);
		soustitre.setBounds(600, 100, 800, 70);
		titre.setFont(f0);
		titre.setForeground(new Color(180, 187, 191));
		soustitre.setFont(f1);
		soustitre.setForeground(new Color(180, 187, 191));

		// AJOUT ELEMENT PANEL TEXTE (Nom des types d'options)
		panTexte.setLayout(null);
		panTexte.setBounds(0, (int) ((b / 4) + 1), (int) (a / 2),
				(int) (b - (b / 4)));
		panTexte.setOpaque(false);
		panTexte.add(pseudo);
		pseudo.setBounds(392,100,500, 70);
		pseudo.setFont(f2);
		pseudo.setForeground(new Color(180, 187, 191));
		panTexte.add(difficulte);
		difficulte.setBounds(310,200,500,70);
		difficulte.setFont(f2);
		difficulte.setForeground(new Color(180, 187, 191));

		// AJOUT ELEMENT PANEL BOUTON1 (Reponse options)
		panBouton1.setLayout(null);
		panBouton1.setBounds(250,200,1000,1000);
		//(int) ((a / 2) + 1), (int) ((b / 4) + 1),(int) (a / 2), (int) (b / 2)
		panBouton1.setOpaque(false);
		
		panBouton1.add(zonePseudo);
		zonePseudo.setBounds(410,110,300,35);
		zonePseudo.setFont(f2);
		
		panBouton1.add(boxEasy);
		panBouton1.add(boxHard);
		boxEasy.setOpaque(false);
		boxEasy.setBounds(410,180,200,100);
		boxEasy.setForeground(new Color(180, 187, 191));
		boxHard.setOpaque(false);
		boxHard.setBounds(410,250,200,100);
		boxHard.setForeground(new Color(180, 187, 191));

		

		// AJOUT ELEMENT PANEL BOUTON2 (Reponse valider/annuler)
		panBouton2.setLayout(null);
		panBouton2.setBounds(0,600,1000,1000);
		panBouton2.setOpaque(false);
		
		panBouton2.add(boutonVal);
		boutonVal.setBounds(750, 0, 150, 50);
		boutonVal.setFont(f3);
		boutonVal.setForeground(new Color(180, 187, 191));
		boutonVal.setBackground(Color.darkGray);
		
		panBouton2.add(boutonAnnu);
		boutonAnnu.setBounds(450, 0, 150, 50);
		boutonAnnu.setFont(f3);
		boutonAnnu.setForeground(new Color(180, 187, 191));
		boutonAnnu.setBackground(Color.darkGray);

		// AJOUT PANELS SUR IMAGE DE FOND

		fond.add(panTitre);
		fond.add(panTexte);
		fond.add(panBouton1);
		fond.add(panBouton2);

		this.getContentPane().add(fond);
		this.setVisible(true);
	}
}
