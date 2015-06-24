package new_investigation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
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
	private int a;
	private int b;

	public PanelEditeur1(final Fenetre fen) {
		// FENETRE GLOBALE
		 a = (int) fen.getWidth();
		 b = (int) fen.getHeight();

		this.setPreferredSize(new Dimension(a, b));

		Font f0 = new Font("Calibri", Font.PLAIN, a*80/1366);
		Font f1 = new Font("Calibri", Font.PLAIN, a*50/1366);
		Font f2 = new Font("Calibri", Font.PLAIN, 30);
		Font f3 = new Font("Calibri", Font.PLAIN, 18);
		
		// AJOUT PANEL panTitre ET ELEMENTS
		panTitre.setLayout(null);
		panTitre.setBounds(0, 0, a, (int) (b / 4));
		panTitre.setOpaque(false);
		panTitre.add(titre);
		titre.setBounds((int)(a*490/1366), (int)(b*10/768),(int)(a*800/1366), (int)(b*130/768));
		panTitre.add(soustitre);
		soustitre.setBounds((int)(a*460/1366), (int)(b*90/768), (int)(a*800/1366), (int)(b*130/768));
		titre.setFont(f0);
		titre.setForeground(new Color(180, 187, 191)); // 180,187,191
		soustitre.setFont(f1);
		soustitre.setForeground(new Color(180, 187, 191)); // 180,187,191
		
		//AJOUT PANEL panInstruction ET ELEMENTS
		panInstruction.setLayout(null);
		panInstruction.setBounds(0, b*2/7, a, b*3/4);
		panInstruction.setOpaque(false);
		
		panInstruction.add(etape);
		etape.setBounds((int)(a*50/1366),(int)(b*20/768),(int)(a*500/1366),(int)(b*30/768));
		etape.setFont(f2);
		etape.setForeground(new Color(180, 187, 191));
		
		panInstruction.add(indications);
		indications.setBounds((int)(a*150/1366),(int)(b*130/768),(int)(a*800/1366),(int)(b*30/768));
		indications.setFont(f2);
		indications.setForeground(new Color(180, 187, 191));
		
		panInstruction.add(zoneimport);
		zoneimport.setBounds((int)(a*300/1366),(int)(b*230/768),(int)(a*400/1366),(int)(b*30/768));
		zoneimport.setEditable(false);
		zoneimport.setFont(f2);
		zoneimport.setBorder(BorderFactory.createLineBorder(Color.gray));
		
		panInstruction.add(boutonimport);
		boutonimport.setBounds((int)(a*850/1366),(int)(b*230/768),(int)(a*150/1366),(int)(b*30/768));
		boutonimport.setFont(f3);
		boutonimport.setForeground(new Color(180, 187, 191));
		boutonimport.setBackground(Color.darkGray);
		
		boutonimport.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		        JFileChooser chooser = new JFileChooser();
		        int returnVal = chooser.showOpenDialog(fen);
		        if(returnVal == JFileChooser.APPROVE_OPTION) {
		           System.out.println("Fichier choisi : " +
		                chooser.getSelectedFile().getName());
		        }}});
		
		//AJOUT PANEL panBouton ET ELEMENTS
		panBouton.setLayout(null);
		panBouton.setBounds(0,(int)(b*540/768),(int)(a*1500/1366),(int)(b*250/768));
		panBouton.setOpaque(false);
		
		panBouton.add(boutonAnnu);
		boutonAnnu.setBounds((int)(a*200/1366),(int)(b*50/768),(int)(a*400/1366),(int)(b*50/768));
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
		boutonVal.setBounds((int)(a*720/1366),(int)(b*50/768),(int)(a*400/1366),(int)(b*50/768));
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


		fen.getRootPane().addComponentListener(new ComponentListener() {
			
			@Override
			public void componentShown(ComponentEvent e) {
				
				
			}
			
			@Override
			public void componentResized(ComponentEvent e) {
				
				Font f0 = new Font("Calibri", Font.PLAIN, a*80/1366);
				Font f1 = new Font("Calibri", Font.PLAIN, a*50/1366);
				Font f2 = new Font("Calibri", Font.PLAIN, a*30/1366);
				Font f3 = new Font("Calibri", Font.PLAIN, a*18/1366);
				
				panTitre.setBounds(0, 0, a, (int) (b / 4));
				titre.setBounds((int)(a*450/1366), (int)(b*20/768),(int)(a*800/1366), (int)(b*130/768));
				soustitre.setBounds((int)(a*430/1366), (int)(b*100/768), (int)(a*800/1366), (int)(b*130/768));
				panInstruction.setBounds(0, b/7*2, a, b/4*3);
				etape.setBounds((int)(a*50/1366),(int)(b*20/768),(int)(a*500/1366),(int)(b*30/768));
				indications.setBounds((int)(a*150/1366),(int)(b*130/768),(int)(a*800/1366),(int)(b*30/768));
				zoneimport.setBounds((int)(a*300/1366),(int)(b*230/768),(int)(a*400/1366),(int)(b*30/768));
				boutonimport.setBounds((int)(a*850/1366),(int)(b*230/768),(int)(a*150/1366),(int)(b*30/768));
				panBouton.setBounds(0,(int)(b*540/768),(int)(a*1500/1366),(int)(b*250/768));
				boutonAnnu.setBounds((int)(a*200/1366),(int)(b*50/768),(int)(a*400/1366),(int)(b*50/768));
				boutonVal.setBounds((int)(a*720/1366),(int)(b*50/768),(int)(a*400/1366),(int)(b*50/768));

				
				titre.setFont(f0);
				soustitre.setFont(f1);
				etape.setFont(f2);
				indications.setFont(f2);
				zoneimport.setFont(f2);
				boutonimport.setFont(f3);
				boutonAnnu.setFont(f3);
				boutonVal.setFont(f3);
				
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

	public void paintComponent(Graphics g) {
		try {
			Image img = ImageIO.read(getClass().getResource("investigation.jpg")); 
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
