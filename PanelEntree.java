package new_investigation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class PanelEntree extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	Panneau panneau = new Panneau();
	private JPanel pan = new JPanel(new BorderLayout());
	private JLabel texte = new JLabel("Appuyez sur ENTREE pour commencer");
	
	public PanelEntree(final Fenetre fen) {
		//Fenetre globale
		this.setLayout(null);
		Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int a = (int) dim.getWidth();
		int b = (int) dim.getHeight();

		this.setPreferredSize(new Dimension(a, b));
		
		//Ajout et placement JPanel pan et JLabel texte
	
		pan.setOpaque(false);
		pan.setBounds(0, 0, a, b);
		pan.add(texte);
		pan.setLayout(null);
		texte.setBounds((int)(a*425/1366), (int)(b*450/768),(int) (a*700/1366),(int) (b*100/768));
		texte.setForeground(new Color(180,187,191));
		Font f2 = new Font("Calibri", Font.PLAIN, a*30/1366);
		texte.setFont(f2);
				
		this.add(pan);
		this.setFocusable(true);
		this.requestFocus();
		this.addKeyListener(new KeyListener() {
		
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					fen.setContentPane(new PanelMenu(fen));
					fen.repaint();
					fen.revalidate();
				}
				
			}


			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
		
	}
	
	public void paintComponent(Graphics g) {
		try {
			Image img = ImageIO.read(new File("InvestigationEntree.jpg"));
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
