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

	private int a;
	private int b;
	private JPanel panTitre = new JPanel();
	private JPanel panTexte = new JPanel();
	private JPanel panBouton1 = new JPanel();
	private JPanel panBouton2 = new JPanel();
	private JLabel titre = new JLabel("Investigation");
	private JLabel soustitre = new JLabel("Options");
	private JLabel pseudo = new JLabel("Votre pseudo : ");
	private JLabel difficulte = new JLabel("<HTML>Choix de la difficult&eacute; : </HTML>");
	private JTextField zonePseudo = new JTextField("Player");
	private JRadioButton boxEasy = new JRadioButton(
			"<html>FACILE<br>(20s de temps de r&eacute;ponse)</html>");
	private JRadioButton boxHard = new JRadioButton(
			"<html>DIFFICILE<br>(10s de temps de r&eacute;ponse)</html>");
	private JButton boutonVal = new JButton("VALIDER");
	private JButton boutonretour = new JButton("RETOUR");
	private JLabel screenmode = new JLabel(" Mode : ");
	private JCheckBox fullscreened = new JCheckBox("<HTML> Plein &Eacute;cran </HTML>");
	private JCheckBox windowed = new JCheckBox("<HTML> Fen&ecirc;tr&eacute; </HTML>");
	private ButtonGroup group2 = new ButtonGroup();
	private ButtonGroup group = new ButtonGroup();

	public PanelOptions(Fenetre fen) {
		this.setLayout(null);
		// FENETRE GLOBALE
		
		 a = (int) fen.getWidth();
		 b = (int) fen.getHeight();
		

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
		pseudo.setBounds((int)(a*392/1366),0,(int)(a*500/1366),(int)( b*70/768));
		pseudo.setFont(f2);
		pseudo.setForeground(new Color(180, 187, 191));
		panTexte.add(difficulte);
		difficulte.setBounds((int)(a*310/1366),(int)(b*200/768),(int)(a*500/1366),(int)(b*70/768));
		difficulte.setFont(f2);
		difficulte.setForeground(new Color(180, 187, 191));

		// AJOUT ELEMENT PANEL BOUTON1 (Reponse options)
		panBouton1.setLayout(null);
		panBouton1.setBounds((int)(a*250/1366),(int)(b*200/768),(int)(a*1000/1366),(int)(b*1000/768));
		
		panBouton1.setOpaque(false);
		
		group2.add(fullscreened);
		group2.add(windowed);
		panBouton1.add(fullscreened);
		if (fen.isFullscreen() == true){
			fullscreened.setSelected(true);
		} else {
			windowed.setSelected(true);
		}
		
		
		panBouton1.add(windowed);
		panBouton1.add(screenmode);
		
		screenmode.setBounds((int)(a*225/1366),(int)(b*100/768),(int)(a*300/1366),(int)(b*35/768));
		screenmode.setFont(f2);
		screenmode.setForeground(new Color(180, 187, 191));
		fullscreened.setBounds((int)(a*410/1366),(int)(b*100/768),(int)(a*200/1366),(int)(b*35/768));
		fullscreened.setFont(f3);
		fullscreened.setFocusPainted(false);
		fullscreened.setOpaque(false);
		fullscreened.setForeground(new Color(180, 187, 191));
		windowed.setBounds((int)(a*650/1366),(int)(b*100/768),(int)(a*200/1366),(int)(b*35/768));
		windowed.setFont(f3);
		windowed.setFocusPainted(false);
		windowed.setOpaque(false);
		windowed.setForeground(new Color(180, 187, 191));
		
	
		
		
		
		panBouton1.add(zonePseudo);
		zonePseudo.setBounds((int)(a*410/1366),(int)(b*10/768),(int)(a*300/1366),(int)(b*35/768));
		zonePseudo.setFont(f2);
		
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
				fen.revalidate();
				
			}
		});
		boutonVal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		fullscreened.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fen.Fullscreen(true);
			}
		});
		windowed.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fen.Fullscreen(false);
				
			}
		});
		
		this.add(panTitre);
		this.add(panTexte);
		this.add(panBouton1);
		this.add(panBouton2);
		fen.getRootPane().addComponentListener(new ComponentListener() {
			
			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentResized(ComponentEvent e) {
				a= fen.getWidth();
				b = fen.getHeight();
				
				Font f0 = new Font("Calibri", Font.PLAIN, a*80/1366);
				Font f1 = new Font("Calibri", Font.PLAIN, a*50/1366);
				Font f2 = new Font("Calibri", Font.PLAIN, a*30/1366);
				Font f3 = new Font("Calibri", Font.PLAIN, a*18/1366);
				
				panTitre.setBounds(0, 0, a, (int) (b / 4));
				titre.setBounds((int)(a*470/1366),(int) (b*20/768),(int) (a*800/1366),(int) (b*70/768));
				soustitre.setBounds((int)(a*600/1366),(int) (b*100/768),(int) (a*800/1366),(int) (b*70/768));
				panTexte.setBounds(0, (int) ((b / 4) + 1), (int) (a / 2),
						(int) (b - (b / 4)));
				pseudo.setBounds((int)(a*392/1366),0,(int)(a*500/1366),(int)( b*70/768));
				difficulte.setBounds((int)(a*310/1366),(int)(b*200/768),(int)(a*500/1366),(int)(b*70/768));
				panBouton1.setBounds((int)(a*250/1366),(int)(b*200/768),(int)(a*1000/1366),(int)(b*1000/768));
				screenmode.setBounds((int)(a*225/1366),(int)(b*100/768),(int)(a*300/1366),(int)(b*35/768));
				fullscreened.setBounds((int)(a*410/1366),(int)(b*100/768),(int)(a*200/1366),(int)(b*35/768));
				windowed.setBounds((int)(a*650/1366),(int)(b*100/768),(int)(a*200/1366),(int)(b*35/768));
				zonePseudo.setBounds((int)(a*410/1366),(int)(b*10/768),(int)(a*300/1366),(int)(b*35/768));
				boxEasy.setBounds((int)(a*410/1366),(int)(b*180/768),(int)(a*200/1366),(int)(b*100/768));
				boxHard.setBounds((int)(a*410/1366),(int)(b*250/768),(int)(a*200/1366),(int)(a*100/768));
				panBouton2.setBounds(0,(int)(b*600/768),(int)(a*1000/1366),(int)(b*1000/768));
				boutonVal.setBounds((int)(a*750/1366), 0,(int) (a*150/1366),(int) (b*50/768));
				boutonretour.setBounds((int)(a*450/1366), 0,(int) (a*150/1366),(int) (b*50/768));
				
				titre.setFont(f0);
				soustitre.setFont(f1);
				pseudo.setFont(f2);
				difficulte.setFont(f2);
				screenmode.setFont(f2);
				fullscreened.setFont(f3);
				windowed.setFont(f3);
				zonePseudo.setFont(f2);
				boutonVal.setFont(f3);
				boutonretour.setFont(f3);
				
			fen.revalidate();
			}
			
			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
	
	
}
	
	/* Fond*/
	public void paintComponent(Graphics g) {
		try {
			Image img = ImageIO.read(new File("investigation.jpg"));
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
