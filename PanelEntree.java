package new_investigation;

import java.awt.Color;
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

	private JPanel pan = new JPanel();
	private JLabel texte = new JLabel("Appuyez sur ENTREE pour commencer");
	private Fenetre fen;
	private PanelEntree entree = this;

	public PanelEntree(Fenetre fenetre) {
		this.fen = fenetre;
		// Fenetre globale
		this.setLayout(null);
		int a = (int) fen.getWidth();
		int b = (int) fen.getHeight();
		// Ajout et placement JPanel pan et JLabel texte

		pan.setOpaque(false);
		pan.setBounds(0, 0, a, b);
		pan.add(texte);
		pan.setLayout(null);
		texte.setBounds((int) (a * 425 / 1366), (int) (b * 450 / 768), (int) (a * 700 / 1366), (int) (b * 100 / 768));
		texte.setForeground(new Color(180, 187, 191));
		Font f2 = new Font("Calibri", Font.PLAIN, a * 30 / 1366);
		texte.setFont(f2);

		this.add(pan);
		this.setFocusable(true);
		this.requestFocus();
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					fen.setContentPane(new PanelMenu(fen));
					fen.revalidate();
					fen.remove(entree);
				}

			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					fen.setContentPane(new PanelMenu(fen));
					fen.revalidate();
					fen.remove(entree);
				}
			}
		});

	}

	public void paintComponent(Graphics g) {
		try {
			Image img = ImageIO.read(getClass().getResource("InvestigationEntree.jpg")); 
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
