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
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;

public class PanelScore extends JPanel {

	
	private static final long serialVersionUID = 5842236064861476625L;
	private JPanel panTitre = new JPanel();
	private JPanel pantab2 = new JPanel();

	private JPanel panbouton = new JPanel();
	private JLabel titre = new JLabel("Investigation");
	private JLabel soustitre = new JLabel("Meilleurs scores Arcade");
	private JPanel zonetab2 = new JPanel();
	private JLabel score = new JLabel("Score");
	private JLabel pseudo = new JLabel("Pseudo");
	private JButton bouton = new JButton("Retour au menu principal");
	private DocumentBuilder builder;
	private PanelScore panScore = this;
	

	public PanelScore( final Fenetre fen, final PanelMenu menu) {

		// FENETRE GLOBALE
		final int a = (int) fen.getWidth();
		final int b = (int) fen.getHeight();

		this.setPreferredSize(new Dimension(a, b));
		final Font f0 = new Font("Calibri", Font.PLAIN, a*80/1366);
		final Font f1 = new Font("Calibri", Font.PLAIN, a*50/1366);
		final Font f2 = new Font("Calibri", Font.PLAIN, a*30/1366);
		final Font f3 = new Font("Calibri", Font.PLAIN, a*16/1366);
		
		// AJOUT ELEMENT PANEL TITRE
		panTitre.setLayout(new BoxLayout(panTitre, BoxLayout.Y_AXIS));
		panTitre.setBounds(0, 0, a, (int) (b / 4));
		panTitre.setOpaque(false);
		panTitre.add(titre);
		panTitre.add(soustitre);
		titre.setAlignmentX(CENTER_ALIGNMENT);
		titre.setFont(f0);
		titre.setForeground(new Color(180, 187, 191)); // 180,187,191
		soustitre.setAlignmentX(CENTER_ALIGNMENT);
		soustitre.setFont(f1);
		soustitre.setForeground(new Color(180, 187, 191)); // 180,187,191



		// AJOUT PANEL pantab2 et ELEMENTS
		pantab2.setLayout(null);
		pantab2.setBounds((a / 4) , (int)(b*150/768), a / 2, (b * 3/ 4) );
		pantab2.setOpaque(false);

		pantab2.add(zonetab2);
		zonetab2.setBounds((int)(a*0/1366), (int)(b*70/768), (int)(a/2), (int)(b*330/768));
		zonetab2.setFont(f3);
		zonetab2.setOpaque(false);
		zonetab2.add(score);
		score.setFont(f3);
		score.setForeground(new Color(180, 187, 191));
		zonetab2.add(pseudo);
		pseudo.setFont(f3);
		pseudo.setForeground(new Color(180, 187, 191));
		zonetab2.setLayout(null);
		pseudo.setBounds(a*350/1920,0 , a*100/1920, a*50/1920);
		score.setBounds(a*810/1920,0 , a*100/1920, a*50/1920);
		XMLScore xml = new XMLScore();
		final List<ObjetScore> list = xml.getListScoreXML();
		final List<JLabel> listlabelnum = new ArrayList<JLabel>();
		int x = 0;
		int y = a*60/1920;
		for (int i = 0; i<list.size(); i++ ){
			if (i < 10){
			listlabelnum.add(new JLabel(i+1+""));
			listlabelnum.get(i).setBounds(x, y, a*100/1920, a*50/1920);
			listlabelnum.get(i).setFont(f3);
			listlabelnum.get(i).setForeground(new Color(180, 187, 191));
			zonetab2.add(listlabelnum.get(i));
			JLabel lab = new JLabel(list.get(i).getPseudo());
			lab.setBounds(x+a*100/1920, y, a*500/1920, a*50/1920);
			lab.setFont(f3);
			lab.setForeground(new Color(180, 187, 191));
			zonetab2.add(lab);
			JLabel lab2 = new JLabel(list.get(i).getScore()+"");
			lab2.setBounds(x+a*800/1920, y, a*100/1920, a*50/1920);
			lab2.setFont(f3);lab2.setForeground(new Color(180, 187, 191));
			zonetab2.add(lab2);
			y = y+a*40/1920;
			} 
		}
		
		
		panbouton.setBounds(0, (int)(b*590/768), (int)(a*1500/1366), (int)(b*100/768));
		panbouton.setOpaque(false);
		panbouton.setLayout(null);
		
		


		panbouton.add(bouton);
		bouton.setBounds((int)(a*540/1366),(int)(b*10/768),(int)(a*250/1366),(int)(b*50/768));
		bouton.setFont(f3);
		bouton.setForeground(new Color(180, 187, 191));
		bouton.setBackground(Color.darkGray);
		bouton.setFocusPainted(false);
		bouton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fen.setContentPane(menu);
				fen.remove(panScore);
				fen.repaint();
				fen.revalidate();
				
			}
		});
		
		
		

		
		
		
		
		
		
		

				
		// AFFICHAGE
		this.add(panTitre);
		this.add(pantab2);
		this.add(panbouton);

		this.setLayout(null);
		fen.getRootPane().addComponentListener(new ComponentListener() {
			
			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentResized(ComponentEvent e) {
				panTitre.setBounds(0, 0, a, (int) (b / 4));
				pantab2.setBounds((a / 4) + (int)(a*10/1366), (int)(b*150/768), a / 2, (b * 3/ 4) );
				zonetab2.setBounds((int)(a*70/1366), (int)(b*100/768), (int)(a*500/1366), (int)(b*300/768));
				panbouton.setBounds(0, (int)(b*590/768), (int)(a*1500/1366), (int)(b*100/768));
				bouton.setBounds((int)(a*540/1366),(int)(b*10/768),(int)(a*250/1366),(int)(b*50/768));

				int x = 0;
				int y = a*40/1920;
				for (int i = 0; i<list.size(); i++ ){
					if (i < 10){
					listlabelnum.add(new JLabel(i+1+""));
					listlabelnum.get(i).setBounds(x, y, a*100/1920, a*50/1920);
					listlabelnum.get(i).setFont(f3);
					listlabelnum.get(i).setForeground(new Color(180, 187, 191));
					zonetab2.add(listlabelnum.get(i));
					JLabel lab = new JLabel(list.get(i).getPseudo());
					lab.setBounds(x+a*100/1920, y, a*500/1920, a*50/1920);
					lab.setFont(f3);
					lab.setForeground(new Color(180, 187, 191));
					zonetab2.add(lab);
					JLabel lab2 = new JLabel(list.get(i).getScore()+"");
					lab2.setBounds(x+a*770/1920, y, a*100/1920, a*50/1920);
					lab2.setFont(f3);lab2.setForeground(new Color(180, 187, 191));
					zonetab2.add(lab2);
					y = y+a*40/1920;
					} 
				}

				titre.setFont(f0);
				soustitre.setFont(f1);
				zonetab2.setFont(f3);
				bouton.setFont(f3);
				score.setFont(f3);
				pseudo.setFont(f3);
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
	//fond d'ecran
	public void paintComponent(Graphics g) {
		try {
			Image img = ImageIO.read(getClass().getResource("investigation.jpg")); 
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	
	
}
