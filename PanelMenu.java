package new_investigation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelMenu extends JPanel{

	
	private static final long serialVersionUID = 6012171395347130275L;
	private JPanel panBouton = new JPanel();
	//private JPanel panBouton2 = new JPanel();
	private JPanel panBtnQuitter = new JPanel();
	private JPanel panEntete = new JPanel();
	private JLabel titre = new JLabel("Investigation");
	private JButton boutonHistoire = new JButton(
			"<html><center>JOUER<br>Mode Histoire</center></html>");
	private JButton boutonArcade = new JButton(
			"<html><center>JOUER<br>Mode Arcade</center></html>");
	private JButton boutonScore = new JButton("Scores");
	private JButton boutonOptions = new JButton("Options");
	private JButton boutonEditeur = new JButton("Editeur");
	private JButton boutonQuitter = new JButton("Quitter");
	
	
	public PanelMenu(final Fenetre fen) {
		//dimension du panel menu
		
		int a = (int)(fen.getWidth());
		int b = (int)(fen.getHeight());
		this.setPreferredSize(new Dimension(a,b));
		
		// fonts et paramètres boutons
		Font f0 = new Font("Calibri", Font.PLAIN, a*80/1366);
		Font f1 = new Font("Calibri", Font.PLAIN, 50);
		Font f2 = new Font("Calibri", Font.PLAIN, 30);
		Font f3 = new Font("Calibri", Font.PLAIN, 18);
		Font f4 = new Font("Calibri", Font.PLAIN, 10);
		titre.setFont(f0);
		titre.setForeground(new Color(180, 187, 191));
		
		boutonHistoire.setFont(f2);
		boutonHistoire.setForeground(new Color(180, 187, 191));
		boutonHistoire.setBackground(Color.darkGray);
		boutonHistoire.setFocusPainted(false);
		
		boutonArcade.setFont(f2);
		boutonArcade.setForeground(new Color(180, 187, 191));
		boutonArcade.setBackground(Color.darkGray);
		boutonArcade.setFocusPainted(false);
		
		boutonScore.setFont(f2);
		boutonScore.setForeground(new Color(180, 187, 191));
		boutonScore.setBackground(Color.darkGray);
		boutonScore.setFocusPainted(false);
		
		boutonOptions.setFont(f2);
		boutonOptions.setForeground(new Color(180, 187, 191));
		boutonOptions.setBackground(Color.darkGray);
		boutonOptions.setFocusPainted(false);
		
		boutonEditeur.setFont(f2);
		boutonEditeur.setForeground(new Color(180, 187, 191));
		boutonEditeur.setBackground(Color.darkGray);
		boutonEditeur.setFocusPainted(false);
		
		boutonQuitter.setFont(f3);
		boutonQuitter.setForeground(new Color(180, 187, 191)); // 180,187,191
		boutonQuitter.setBackground(Color.darkGray);
		boutonQuitter.setFocusPainted(false);
		
		//Dispositions des panels
		this.setLayout(null);
		int ratiolarg = (int)(a-1.5*a*(0.0732)-1);
		panEntete.setBounds(0, 0,ratiolarg,(int)(b/3));
		panEntete.setOpaque(false);
		panEntete.setLayout(null);
		panBouton.setBounds(0,(int)(b*100/768),ratiolarg,(int)(b));
		panBouton.setOpaque(false);
		panBouton.setLayout(null);
		panBtnQuitter.setBounds( ratiolarg+1,(int)(50*b/1080),(int)(a-ratiolarg-50*a/1920),(int)(b/20));
		panBtnQuitter.setOpaque(false);
		panBtnQuitter.setLayout(new BorderLayout());
		
		
		//Disposition des Boutons /textes
		titre.setBounds( (int)(a*470/1366),(int)(b*50/768) ,(int)(b*800/1366),(int)(a*70/768));
		boutonHistoire.setBounds((int)(a*375/1366),(int)(b*200/768), (int)(a*200/1366),(int)(b*100/768));
		boutonArcade.setBounds((int)(a*725/1366),(int)(b*200/768), (int)(a*200/1366),(int)(b*100/768));
		boutonScore.setBounds((int)(a*580/1366),(int)(b*450/768),(int)(a*150/1366),(int)(b*100/768));
		boutonEditeur.setBounds((int)(a*950/1366),(int)(b*450/768),(int)(a*150/1366),(int)(b*100/768));
		boutonOptions.setBounds((int)(a*200/1366),(int)(b*450/768),(int)(a*150/1366),(int)(b*100/768));
	//	boutonQuitter.setBounds((int)(a*1250/1366),(int)(b*100/768),(int)(a*80/1366),(int)(b*30/768));
		
			
		
		
		
		//ajout des boutons/textes aux panels
		
		panEntete.add(titre);
		panBouton.add(boutonArcade);
		panBouton.add(boutonEditeur);
		panBouton.add(boutonHistoire);
		panBouton.add(boutonOptions);
		panBtnQuitter.add(boutonQuitter,BorderLayout.CENTER);
		panBouton.add(boutonScore);
		
		
		//ajout des panels au panel menu
		this.add(panEntete);
		this.add(panBouton);
		//this.add(panBouton2);
		this.add(panBtnQuitter);
		
		// Actions des boutons
		
		boutonQuitter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
				
			}
		});
		
		boutonArcade.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fen.setContentPane(new PanelArcade(fen));
				fen.repaint();
				fen.revalidate();
				
			}
		});
		
		boutonHistoire.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fen.setContentPane(new PanelHistoire(fen));
				fen.repaint();
				fen.revalidate();
				
			}
		});
		
		boutonOptions.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fen.setContentPane(new PanelOptions(fen));
				fen.repaint();
				fen.revalidate();
				
			}
		});
		boutonScore.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fen.setContentPane(new PanelScore(fen));
				fen.repaint();
				fen.revalidate();
				
			}
		});
		boutonEditeur.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fen.setContentPane(new PanelEditeur1(fen));
				fen.repaint();
				fen.revalidate();
				
			}
		});
		
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
