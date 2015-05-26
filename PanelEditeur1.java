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

public class PanelEditeur1 extends JPanel {


	private static final long serialVersionUID = 2203873567037380737L;

	private JPanel panTitre = new JPanel();
	private JPanel panInstruction = new JPanel();
	private JPanel panBouton = new JPanel();
	private JLabel titre = new JLabel("Investigation");
	private JLabel soustitre = new JLabel("Editeur cartes/questions");
	private JLabel etape = new JLabel("1ere Etape : Importer une carte");
	private JLabel indications = new JLabel(
			"Veuillez importer l'image qui servira de carte : ");
	private JTextField zoneimport = new JTextField();
	private JButton boutonimport = new JButton("Parcourir ... ");
	private JButton boutonAnnu = new JButton(
			"ANNULER et revenir au menu principal");
	private JButton boutonVal = new JButton("VALIDER et passer a l'Etape 2");

	public PanelEditeur1(final Fenetre fen) {
		// FENETRE GLOBALE
		Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int a = (int) dim.getWidth();
		int b = (int) dim.getHeight();

		this.setPreferredSize(new Dimension(a, b));
//		this.setTitle("Investigation - Editeur Partie 1");
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		this.setLocationRelativeTo(null);
		Font f0 = new Font("Calibri", Font.PLAIN, a*80/1366);
		Font f1 = new Font("Calibri", Font.PLAIN, a*50/1366);
		Font f2 = new Font("Calibri", Font.PLAIN, 30);
		Font f3 = new Font("Calibri", Font.PLAIN, 18);
		
		// AJOUT PANEL panTitre ET ELEMENTS
		panTitre.setLayout(null);
		panTitre.setBounds(0, 0, a, (int) (b / 4));
		panTitre.setOpaque(false);
		panTitre.add(titre);
		titre.setBounds((int)(a/1366*650), (int)(b/768*20),(int)(a/1366*800), (int)(b/768*130));
		panTitre.add(soustitre);
		soustitre.setBounds((int)(a/1366*620), (int)(b/768*100), (int)(a/1366*800), (int)(b/768*130));
		titre.setFont(f0);
		titre.setForeground(new Color(180, 187, 191)); // 180,187,191
		soustitre.setFont(f1);
		soustitre.setForeground(new Color(180, 187, 191)); // 180,187,191
		
		//AJOUT PANEL panInstruction ET ELEMENTS
		panInstruction.setLayout(null);
		panInstruction.setBounds(0, b/7*2, a, b/4*3);
		panInstruction.setOpaque(false);
		
		panInstruction.add(etape);
		etape.setBounds((int)(a/1366*50),(int)(b/768*20),(int)(a/1366*500),(int)(b/768*30));
		etape.setFont(f2);
		etape.setForeground(new Color(180, 187, 191));
		
		panInstruction.add(indications);
		indications.setBounds((int)(a/1366*150),(int)(b/768*130),(int)(a/1366*800),(int)(b/768*30));
		indications.setFont(f2);
		indications.setForeground(new Color(180, 187, 191));
		
		panInstruction.add(zoneimport);
		zoneimport.setBounds((int)(a/1366*300),(int)(b/768*230),(int)(a/1366*400),(int)(b/768*30));
		zoneimport.setEditable(false);
		zoneimport.setFont(f2);
		zoneimport.setBorder(BorderFactory.createLineBorder(Color.gray));
		
		panInstruction.add(boutonimport);
		boutonimport.setBounds((int)(a/1366*850),(int)(b/768*230),(int)(a/1366*150),(int)(b/768*30));
		boutonimport.setFont(f3);
		boutonimport.setForeground(new Color(180, 187, 191));
		boutonimport.setBackground(Color.darkGray);
		
		
		//AJOUT PANEL panBouton ET ELEMENTS
		panBouton.setLayout(null);
		panBouton.setBounds(0,(int)(b/768*540),(int)(a/1366*1500),(int)(b/768*250));
		panBouton.setOpaque(false);
		
		panBouton.add(boutonAnnu);
		boutonAnnu.setBounds((int)(a/1366*200),(int)(b/768*50),(int)(a/1366*400),(int)(b/768*50));
		boutonAnnu.setFont(f3);
		boutonAnnu.setForeground(new Color(180, 187, 191));
		boutonAnnu.setBackground(Color.darkGray);
		boutonAnnu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fen.setContentPane(new PanelMenu(fen));
				fen.repaint();
				fen.revalidate();
			}
		});
		
		panBouton.add(boutonVal);
		boutonVal.setBounds((int)(a/1366*720),(int)(b/768*50),(int)(a/1366*400),(int)(b/768*50));
		boutonVal.setFont(f3);
		boutonVal.setForeground(new Color(180, 187, 191));
		boutonVal.setBackground(Color.darkGray);
		
		boutonVal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				fen.setContentPane(new PanelEditeur2(fen));
				fen.repaint();
				fen.revalidate();
				
			}
		});
		
		
		this.add(panTitre);
		this.add(panInstruction);
		this.add(panBouton);
		
		

		this.setLayout(null);
	}
	
	
	public void paintComponent(Graphics g) {
		try {
			Image img = ImageIO.read(new File("investigation.jpg"));
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}
}
}
