package new_investigation;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class PanelOptions extends JPanel {

	private static final long serialVersionUID = 1L;
	// DECLARATION ELEMENTS

	
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
	private JButton boutonretour = new JButton("RETOUR");

	public PanelOptions(final Fenetre fen) {
		this.setLayout(null);
		// FENETRE GLOBALE
		
		int a = (int) fen.getWidth();
		int b = (int) fen.getHeight();

		Font f0 = new Font("Calibri", Font.PLAIN, a*80/1366);
		Font f1 = new Font("Calibri", Font.PLAIN, a*50/1366);
		Font f2 = new Font("Calibri", Font.PLAIN, a*30/1366);
		Font f3 = new Font("Calibri", Font.PLAIN, a*18/1366);
		
		
		

		// AJOUT ELEMENT PANEL TITRE
		
		panTitre.setLayout(null);
		panTitre.setBounds(0, 0, a, (int) (b / 4));
		panTitre.setOpaque(false);
		panTitre.add(titre);
		titre.setBounds((int)(a*470/1366),(int) (b*20/768),(int) (a*800/1366),(int) (b*70/768));
		panTitre.add(soustitre);
		soustitre.setBounds((int)(a*600/1366),(int) (b*100/768),(int) (a*800/1366),(int) (b*70/768));
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
		pseudo.setBounds((int)(a*392/1366),(int)(b*100/768),(int)(a*500/1366),(int)( b*70/768));
		pseudo.setFont(f2);
		pseudo.setForeground(new Color(180, 187, 191));
		panTexte.add(difficulte);
		difficulte.setBounds((int)(a*310/1366),(int)(b*200/768),(int)(a*500/1366),(int)(b*70/768));
		difficulte.setFont(f2);
		difficulte.setForeground(new Color(180, 187, 191));

		// AJOUT ELEMENT PANEL BOUTON1 (Reponse options)
		panBouton1.setLayout(null);
		panBouton1.setBounds((int)(a*250/1366),(int)(b*200/768),(int)(a*1000/1366),(int)(b*1000/768));
		//(int) ((a / 2) + 1), (int) ((b / 4) + 1),(int) (a / 2), (int) (b / 2)
		panBouton1.setOpaque(false);
		
		panBouton1.add(zonePseudo);
		zonePseudo.setBounds((int)(a*410/1366),(int)(b*110/768),(int)(a*300/1366),(int)(b*35/768));
		zonePseudo.setFont(f2);
		ButtonGroup group = new ButtonGroup();
		group.add(boxEasy);
		group.add(boxHard);
		panBouton1.add(boxEasy);
		panBouton1.add(boxHard);
		
		boxEasy.setOpaque(false);
		boxEasy.setBounds((int)(a*410/1366),(int)(b*180/768),(int)(a*200/1366),(int)(b*100/768));
		boxEasy.setForeground(new Color(180, 187, 191));
		boxEasy.setFocusPainted(false);
		
		boxHard.setOpaque(false);
		boxHard.setBounds((int)(a*410/1366),(int)(b*250/768),(int)(a*200/1366),(int)(a*100/768));
		boxHard.setForeground(new Color(180, 187, 191));
		boxHard.setFocusPainted(false);
		

		

		// AJOUT ELEMENT PANEL BOUTON2 (Reponse valider/annuler)
		panBouton2.setLayout(null);
		panBouton2.setBounds(0,(int)(b*600/768),(int)(a*1000/1366),(int)(b*1000/768));
		panBouton2.setOpaque(false);
		
		panBouton2.add(boutonVal);
		boutonVal.setBounds((int)(a*750/1366), 0,(int) (a*150/1366),(int) (b*50/768));
		boutonVal.setFont(f3);
		boutonVal.setForeground(new Color(180, 187, 191));
		boutonVal.setBackground(Color.darkGray);
		boutonVal.setFocusPainted(false);
		
		panBouton2.add(boutonretour);
		boutonretour.setBounds((int)(a*450/1366), 0,(int) (a*150/1366),(int) (b*50/768));
		boutonretour.setFont(f3);
		boutonretour.setForeground(new Color(180, 187, 191));
		boutonretour.setBackground(Color.darkGray);
		boutonretour.setFocusPainted(false);

		// AJOUT PANELS SUR IMAGE DE FOND
		
		boutonretour.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fen.setContentPane(new PanelMenu(fen));
				fen.repaint();
				fen.revalidate();
				
			}
		});
		boutonVal.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) { //PENSER A SAUVEGARDER LE CHOIX DE L'UTILISATEUR
				fen.setContentPane(new PanelMenu(fen));
				fen.repaint();
				fen.revalidate();
				
			}
		});

		this.add(panTitre);
		this.add(panTexte);
		this.add(panBouton1);
		this.add(panBouton2);
		
//		this.setFocusable(true);
//		this.requestFocus();
		
	
	
}
	
	/* Image de fond à mettre */
	public void paintComponent(Graphics g) {
		try {
			Image img = ImageIO.read(new File("investigation.jpg"));
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
