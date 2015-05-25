package mjkl.investigation.display;

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
	//private Panneau fond = new Panneau();
	private JPanel pan = new JPanel(new BorderLayout());
	private JLabel texte = new JLabel("Appuyez sur ENTREE pour commencer");
	
	public PanelEntree(final Fenetre fen) {
		//Fenetre globale
		Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int a = (int) dim.getWidth();
		int b = (int) dim.getHeight();

		this.setPreferredSize(new Dimension(a, b));
		
		//Ajout et placement JPanel pan et JLabel texte
	
		pan.setOpaque(false);
		pan.setBounds(0, 0, a, b);
		pan.add(texte);
		pan.setBounds(325, 450, 700, 100);
		texte.setForeground(new Color(180,187,191));
		Font f2 = new Font("Calibri", Font.PLAIN, 30);
		texte.setFont(f2);
				
		this.add(pan);
		this.setFocusable(true);
		this.requestFocus();
		this.addKeyListener(new KeyListener() {
		
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					fen.setContentPane(new PanelMenu(fen));
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
			Image img = ImageIO.read(new File("investigation.jpg"));
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
