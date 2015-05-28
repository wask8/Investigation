package new_investigation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.PaintEvent;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.text.AttributedCharacterIterator;

import javax.imageio.ImageIO;
import javax.swing.*;

import mjkl.investigation.main.Chrono;
import mjkl.investigation.running.ChronoPanel;
import mjkl.investigation.running.ChronoTime;
import mjkl.investigation.running.TimerB;

public class PanelArcade extends JPanel {

	private JPanel fond = new JPanel(null);
	private JPanel panEntete = new JPanel();
	private JPanel panCarte = new JPanel();
	private JPanel panScore = new JPanel();
	private JPanel panQuestion = new JPanel();
	private JPanel panLieu = new JPanel();
	private JPanel panTemps = new JPanel();
	private JLabel titre = new JLabel("Investigation");
	private JButton abandon = new JButton("Abandonner la partie");
	
	private ChronoPanel chrono = new ChronoPanel();

	public PanelArcade(final Fenetre fen) {
		// FENETRE GLOBALE
		final int a = (int) fen.getWidth();
		final int b = (int) fen.getHeight();

		this.setPreferredSize(new Dimension(a, b));

		this.setLayout(null);
		this.setOpaque(false);
		this.setBackground(Color.black);
		Font f0 = new Font("Calibri", Font.PLAIN, 80);
		Font f1 = new Font("Calibri", Font.PLAIN, 50);
		Font f2 = new Font("Calibri", Font.PLAIN, 30);
		Font f3 = new Font("Calibri", Font.PLAIN, 18);
		Font f4 = new Font("Calibri", Font.PLAIN, 10);
		Font f5 = new Font("Calibri", Font.PLAIN, 13);

		// AJOUT PANEL panEntete ET ELEMENTS
		panEntete.setLayout(null);
		panEntete.setBackground(Color.DARK_GRAY);
		panEntete.setBounds(0, 0, a, (int) (b / 4));
		panEntete.setOpaque(false);
		panEntete.add(titre);
		panEntete.add(abandon);
		abandon.setLayout(null);
		abandon.setOpaque(true);
		abandon.setBounds((int) a / 1366 * 20, (int) b / 768 * 50,
				(int) a / 1366 * 170, (int) b / 768 * 30);
		abandon.setFont(f5);
		abandon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Popup(fen, a, b);

			}
		});
		abandon.setLayout(null);
		abandon.setOpaque(true);
		abandon.setBounds(1110, 20, 170, 25);
		abandon.setFont(f5);

		// AJOUT PANEL panCarte ET ELEMENTS
		panCarte.setLayout(null);
		panCarte.setOpaque(false);
		panCarte.setBounds(10, 100, 1050, 620); // AJOUTER RATIO DE PROPORTION
		panCarte.setBackground(Color.red);
		JLabel label = new JLabel();
		label.setIcon(new ImageIcon("Map_Laval,_Mayenne.jpg"));
		panCarte.add(label);
		label.setBounds(200, 10, 700, 671);

		// AJOUT PANEL panStat ET ELEMENTS
		panScore.setLayout(null);
		panScore.setOpaque(true);
		panScore.setBackground(Color.red);//trouver l'emplacement du panel.
		panScore.setBounds(1100, 300, 200, 120); // AJOUTER RATIO DE PROPORTION

		// AJOUT PANEL panQuestion ET ELEMENTS
		panQuestion.setLayout(null);
		panQuestion.setOpaque(true);
		panQuestion.setBounds(1100, 500, 200, 120); // AJOUTER RATIO DE
													// PROPORTION

		// AJOUT PANEL panLieu ET ELEMENTS
		panLieu.setLayout(null);
		panLieu.setOpaque(true);
		panLieu.setBounds(150, 10, 800, 75); // AJOUTER RATIO DE PROPORTION

		// AJOUT PANEL panTemps ET ELEMENTS
		panTemps.setOpaque(true);
		panTemps.setBackground(Color.yellow);
		panTemps.setBounds(1100, 150, 200, 70); // AJOUTER RATIO DE PROPORTION
		panTemps.add(new JProgressBar());
		
		chrono.setOpaque(true);
		chrono.setBounds(1100,150,200,70);
		
		
		this.add(panEntete);
		this.add(panCarte);
		this.add(panQuestion);
		this.add(panScore);
		this.add(panLieu);
		this.add(chrono);

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
