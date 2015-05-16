package Investigation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

public class fenetreEntree extends JFrame {
	private Panneau2 fond = new Panneau2();
	private JPanel pan = new JPanel();
	private JLabel texte = new JLabel("Appuyez sur une touche pour commencer",JLabel.CENTER);
	
	public fenetreEntree() {
		//Fenetre globale
		Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int a = (int) dim.getWidth();
		int b = (int) dim.getHeight();

		this.setSize(a, b);
		this.setTitle("Investigation - Entrée");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		//Ajout et placement JPanel pan et JLabel texte
		fond.add(pan);
		pan.setOpaque(false);
		pan.setBounds(0, 0, a, b);
		pan.add(texte);
		pan.setBounds(325, 450, 700, 100);
		texte.setForeground(new Color(180,187,191));
		Font f2 = new Font("Calibri", Font.PLAIN, 30);
		texte.setFont(f2);
				
		
		this.getContentPane().add(fond);
		this.setVisible(true);
	}

}
