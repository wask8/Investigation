package Investigation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

public class fenetreEditeur1 extends JFrame {

	private Panneau fond = new Panneau();
	private JPanel panTitre = new JPanel();
	private JPanel panInstruction = new JPanel();
	private JPanel panBouton = new JPanel();
	private JLabel titre = new JLabel("Investigation");
	private JLabel soustitre = new JLabel("Editeur cartes/questions");
	private JLabel etape = new JLabel("1ere étape : Importer une carte");
	private JLabel indications = new JLabel(
			"Veuillez importer l'image qui servira de carte : ");
	private JTextField zoneimport = new JTextField();
	private JButton boutonimport = new JButton("Parcourir ... ");
	private JButton boutonAnnu = new JButton(
			"ANNULER et revenir au menu principal");
	private JButton boutonVal = new JButton("VALIDER et passer à l'étape 2");

	public fenetreEditeur1() {
		// FENETRE GLOBALE
		Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int a = (int) dim.getWidth();
		int b = (int) dim.getHeight();

		this.setSize(a, b);
		this.setTitle("Investigation - Editeur Partie 1");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		Font f0 = new Font("Calibri", Font.PLAIN, 80);
		Font f1 = new Font("Calibri", Font.PLAIN, 50);
		Font f2 = new Font("Calibri", Font.PLAIN, 30);
		Font f3 = new Font("Calibri", Font.PLAIN, 18);

		// AJOUT PANEL panTitre ET ELEMENTS
		panTitre.setLayout(null);
		panTitre.setBounds(0, 0, a, (int) (b / 4));
		panTitre.setOpaque(false);
		panTitre.add(titre);
		titre.setBounds(470, 20, 800, 70);
		panTitre.add(soustitre);
		soustitre.setBounds(450, 100, 800, 70);
		titre.setFont(f0);
		titre.setForeground(new Color(180, 187, 191)); // 180,187,191
		soustitre.setFont(f1);
		soustitre.setForeground(new Color(180, 187, 191)); // 180,187,191
		
		//AJOUT PANEL panInstruction ET ELEMENTS
		panInstruction.setLayout(null);
		panInstruction.setBounds(0, b/7*2, a, b/4*3);
		panInstruction.setOpaque(false);
		
		panInstruction.add(etape);
		etape.setBounds(50,20,500,30);
		etape.setFont(f2);
		etape.setForeground(new Color(180, 187, 191));
		
		panInstruction.add(indications);
		indications.setBounds(150,130,800,30);
		indications.setFont(f2);
		indications.setForeground(new Color(180, 187, 191));
		
		panInstruction.add(zoneimport);
		zoneimport.setBounds(300,230,400,30);
		zoneimport.setEditable(false);
		zoneimport.setFont(f2);
		zoneimport.setBorder(BorderFactory.createLineBorder(Color.gray));
		
		panInstruction.add(boutonimport);
		boutonimport.setBounds(850,230,150,30);
		boutonimport.setFont(f3);
		boutonimport.setForeground(new Color(180, 187, 191));
		boutonimport.setBackground(Color.darkGray);
		
		
		//AJOUT PANEL panBouton ET ELEMENTS
		panBouton.setLayout(null);
		panBouton.setBounds(0,540,1500,250);
		panBouton.setOpaque(false);
		
		panBouton.add(boutonAnnu);
		boutonAnnu.setBounds(200,50,400,50);
		boutonAnnu.setFont(f3);
		boutonAnnu.setForeground(new Color(180, 187, 191));
		boutonAnnu.setBackground(Color.darkGray);
		
		panBouton.add(boutonVal);
		boutonVal.setBounds(720,50,400,50);
		boutonVal.setFont(f3);
		boutonVal.setForeground(new Color(180, 187, 191));
		boutonVal.setBackground(Color.darkGray);

		
		fond.add(panTitre);
		fond.add(panInstruction);
		fond.add(panBouton);
		
		

		this.getContentPane().add(fond);
		this.setVisible(true);

	}
}
