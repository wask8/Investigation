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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.PaintEvent;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.text.AttributedCharacterIterator;

import javax.imageio.ImageIO;
import javax.swing.*;

public class PanelArcade extends JPanel implements MouseListener {

	private JPanel panEntete = new JPanel();
	private JPanel panCarte = new JPanel();
	private JPanel panScore = new JPanel();
	private JPanel panQuestion = new JPanel();
	private JPanel panLieu = new JPanel();
	private JPanel panTemps = new JPanel();
	private JLabel titre = new JLabel("Investigation");
	private JButton abandon = new JButton("Abandonner la partie");
	private JLabel labelQuestion = new JLabel(
			"<HTML>Nombre de <br/>questions</HTML>");
	private JLabel score = new JLabel("<HTML>Score<br/>données XML</HTML>");
	private JLabel zoneLieu = new JLabel("Cliquez pour afficher les lieux à placer");
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
		abandon.setFont(f5);
		abandon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fen.setContentPane(new PanelMenu(fen));
				fen.repaint();
				fen.revalidate();
			}
		});

		// @Override
		// public void actionPerformed(ActionEvent e) {
		// new Popup(fen, a, b);
		//
		// }
		// });
		abandon.setLayout(null);
		abandon.setOpaque(true);
		abandon.setBounds(a * 1110 / 1366, b * 20 / 768, a * 170 / 1366,
				b * 25 / 768);
		abandon.setFont(f5);

		// AJOUT PANEL panCarte ET ELEMENTS
		panCarte.setLayout(null);
		panCarte.setOpaque(false);
		panCarte.setBounds(a * 10 / 1366, b * 120 / 768, a * 1050 / 1366,
				b * 620 / 768);
		panCarte.setBackground(Color.red);
		JLabel label = new JLabel();
		label.setIcon(new ImageIcon("planIUT2.jpg"));
		panCarte.add(label);
		label.setBounds(a * 200 / 1366, b * 10 / 768, a * 700 / 1366,
				b * 671 / 768);

		// AJOUT PANEL panStat ET ELEMENTS
		panScore.setLayout(null);
		panScore.setOpaque(true);
		panScore.setBounds(a * 1100 / 1366, b * 300 / 768, a * 200 / 1366,
				b * 120 / 768);
		panScore.add(score);
		score.setFont(f2);
		score.setBounds(a * 10 / 1366, b * 5 / 768, a * 200 / 1366,
				b * 120 / 768);

		// AJOUT PANEL panQuestion ET ELEMENTS
		panQuestion.setLayout(null);
		panQuestion.setOpaque(true);
		panQuestion.setBounds(a * 1100 / 1366, b * 500 / 768, a * 200 / 1366,
				b * 120 / 768);
		panQuestion.add(labelQuestion);
		labelQuestion.setFont(f2);
		labelQuestion.setBounds(a * 5 / 1366, b * 5 / 768, a * 200 / 1366,
				b * 120 / 768);

		// AJOUT PANEL panLieu ET ELEMENTS
		panLieu.setLayout(null);
		panLieu.setOpaque(true);
		panLieu.setBounds(a * 150 / 1366, b * 25 / 768, a * 800 / 1366,
				b * 75 / 768);
		panLieu.add(zoneLieu);
		zoneLieu.setFont(f2);
		zoneLieu.setBounds(a * 10 / 1366, b * 10 / 1366, a * 800 / 1366,
				b * 75 / 768);
		this.setFocusable(true);
		this.requestFocus();
		addMouseListener(this);

		// AJOUT PANEL panTemps ET ELEMENTS

		panTemps.add(new JProgressBar());
		panTemps.add(chrono);
		chrono.setOpaque(true);
		chrono.setBounds(a * 1100 / 1366, b * 150 / 768, a * 200 / 1366,
				b * 60 / 768);

		this.add(panEntete);
		this.add(panCarte);
		this.add(panQuestion);
		this.add(panScore);
		this.add(panTemps);
		this.add(panLieu);
		this.add(chrono);

	}

	String lieuMayenne[] = { "LAVAL", "MAYENNE", "EVRON", "ERNEE","CHATEAU GONTIER","CRAON","POINT A LA FRONTIERE AVEC LA MANCHE" }; //AJOUTER LES LIEUX A PLACER SUR LA MAP MAYENNE
	String lieuLaval[] = {"MAIRIE","PREFECTURE","THEATRE","GARE","IUT","SQUARE DE BOSTON","SALLE POLYVALENTE","PLACE DU 11 NOVEMBRE","CENTRE HOSPITALIER","CATHEDRALE"}; // AJOUTER LES LIEUX A PLACER SUR MAP LAVAL
	String lieuIUT[] = {"DEPARTEMENT INFO","DEPARTEMENT MMI","DEPARTEMENT TC","DEPARTEMENT TC","ADMINISTRATION","RESTAURANT UNIVERSITAIRE","RESIDENCE LA DORMERIE","AMPHI 1","AMPHI 2"}; //AJOUTER LES LIEUX A PLACER SUR MAP IUT
	String lieuINFO[] = {""};//AJOUTER LIEUX A PLACER SUR MAP DepINFO
	
	int i = 0;

	@Override
	public void mouseClicked(MouseEvent e) {
		//VERIFIER SI LE CLIC EST FAIT SUR LA CARTE : Recuperer coordonnées du clic et comparer avec les coordonnées du label
		
		
		//si carte choisie = Carte Mayenne
		//zoneLieu.setText("Lieu à placer : " + lieuMayenne[i]);
		//i++;
		//labelQuestion.setText("<HTML>Question : <BR/>"+i+"/"+lieuMayenne.length);
		//si carte choisie = Carte Laval
		zoneLieu.setText("Lieu à placer : " + lieuLaval[i]);
		i++;
		labelQuestion.setText("<HTML>Question : <BR/>"+i+"/"+lieuLaval.length);
		//si carte choisie = Carte IUT
		//zoneLieu.setText("Lieu à placer : " + lieuIUT[i]);
		//i++;
		//labelQuestion.setText("<HTML>Question : <BR/>"+i+"/"+lieuIUT.length);
		//si carte chosie = Plan DepINFO
		//zoneLieu.setText("Lieu à placer : " + lieuINFO[i]);
		//i++;
		//labelQuestion.setText("<HTML>Question : <BR/>"+i+"/"+lieuINFO.length);
		

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/*
	 * public void paintComponent(Graphics g) { try { Image img =
	 * ImageIO.read(new File("investigation.jpg")); g.drawImage(img, 0, 0,
	 * getWidth(), getHeight(), this); } catch (IOException e) {
	 * e.printStackTrace(); } }
	 */
}
