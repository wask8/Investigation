package new_investigation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class PanelEditeur2 extends JPanel {

	private int a;
	private int b;
	private JPanel panTitre = new JPanel();
	private JPanel panInstruction = new JPanel();
	private JPanel panBouton = new JPanel();
	private JLabel titre = new JLabel("Investigation");
	private JLabel soustitre = new JLabel("Editeur cartes/questions");
	private JLabel etape = new JLabel("2e ï¿½tape : Dï¿½finir les lieux ï¿½ placer");
	private JLabel carte = new JLabel("Votre carte :");
	private JLabel indication1 = new JLabel("1) Nom du lieu ï¿½ placer :");
	private JTextField nomlieu = new JTextField();
	private JLabel indication2 = new JLabel(
			"<HTML>2) Cliquez sur la carte pour dï¿½finir <br/>l'endroit oï¿½ ce lieu est placï¿½</HTML>");
	private JButton boutonVal = new JButton("Valider le placement");
	private JButton boutonAnnuDernier = new JButton("Annuler le dernier placement");
	private JButton boutonNew = new JButton("Nouveau placement");
	private JButton boutonSauv = new JButton("Sauvegarder et quitter");
	private JButton boutonAnnu = new JButton("Annuler tous les placements");
	private JButton liste = new JButton("Liste des lieux placï¿½s");
	private ImageIcon imageCarte = new ImageIcon("mayenne04.gif");
	JLabel img = new JLabel(imageCarte);

	public PanelEditeur2(final Fenetre fen) {
		// Si clic sur la carte, fenetre qui demande si on valide le placement
		// Si clic sur la carte, verifier si zone de texte du lieu est remplie,
		// sinon message erreur

		// FENETRE GLOBALE

		a = (int) fen.getWidth();
		b = (int) fen.getHeight();

		this.setSize(a, b);

		Font f0 = new Font("Calibri", Font.PLAIN, a * 80 / 1366);
		Font f1 = new Font("Calibri", Font.PLAIN, a * 50 / 1366);
		Font f2 = new Font("Calibri", Font.PLAIN, a * 30 / 1366);
		Font f3 = new Font("Calibri", Font.PLAIN, a * 18 / 1366);

		// AJOUT PANEL panTitre ET ELEMENTS
		panTitre.setLayout(null);
		panTitre.setBounds(0, 0, a, (int) (b / 4));
		panTitre.setOpaque(false);
		panTitre.add(titre);
		titre.setBounds((int) (a * 470 / 1366), (int) (b * 20 / 768), (int) (a * 800 / 1366), (int) (b * 150 / 1366));
		panTitre.add(soustitre);
		soustitre.setBounds((int) (a * 450 / 1366), (int) (b * 100 / 768), (int) (a * 800 / 1366),
				(int) (b * 70 / 768));
		titre.setFont(f0);
		titre.setForeground(new Color(180, 187, 191)); // 180,187,191
		soustitre.setFont(f1);
		soustitre.setForeground(new Color(180, 187, 191)); // 180,187,191

		// AJOUT PANEL panInstruction ET ELEMENTS
		panInstruction.setLayout(null);
		panInstruction.setBounds(0, b / 9 * 2, a, b / 4 * 3);
		panInstruction.setOpaque(false);

		panInstruction.add(etape);
		etape.setBounds((int) (a * 50 / 1366), 0, (int) (a * 500 / 1366), (int) (b * 30 / 768));
		etape.setFont(f2);
		etape.setForeground(new Color(180, 187, 191));

		panInstruction.add(carte);
		carte.setBounds((int) (a * 150 / 1366), (int) (b * 50 / 768), (int) (a * 300 / 1366), (int) (b * 30 / 768));
		carte.setFont(f2);
		carte.setForeground(new Color(180, 187, 191));

		panInstruction.add(img);
		img.setBounds((int) (a * 100 / 1366), (int) (b * 85 / 768), (int) (a * 420 / 1366), (int) (a * 435 / 1366));

		panInstruction.add(indication1);
		indication1.setBounds((int) (a * 750 / 1366), (int) (b * 50 / 768), (int) (a * 400 / 1366),
				(int) (b * 30 / 768));
		indication1.setFont(f2);
		indication1.setForeground(new Color(180, 187, 191));

		panInstruction.add(nomlieu);
		nomlieu.setBounds((int) (a * 750 / 1366), (int) (b * 100 / 768), (int) (a * 500 / 1366), (int) (b * 30 / 768));
		nomlieu.setFont(f2);

		panInstruction.add(indication2);
		indication2.setBounds((int) (a * 750 / 1366), (int) (b * 150 / 768), (int) (a * 600 / 1366),
				(int) (b * 70 / 768));
		indication2.setFont(f2);
		indication2.setForeground(new Color(180, 187, 191));

		// AJOUT PANEL panBouton ET ELEMENTS
		panBouton.setLayout(null);
		panBouton.setBounds(a / 2, b / 9 * 5, a / 2, b / 9 * 4);
		panBouton.setOpaque(false);

		panBouton.add(boutonVal);
		boutonVal.setBounds(0, (int) (b * 30 / 768), (int) (a * 250 / 1366), (int) (b * 50 / 768));
		boutonVal.setFont(f3);
		boutonVal.setForeground(new Color(180, 187, 191));
		boutonVal.setBackground(Color.darkGray);

		panBouton.add(boutonAnnuDernier);
		boutonAnnuDernier.setBounds((int) (a * 300 / 1366), (int) (b * 30 / 768), (int) (a * 250 / 1366),
				(int) (b * 50 / 768));
		boutonAnnuDernier.setFont(f3);
		boutonAnnuDernier.setForeground(new Color(180, 187, 191));
		boutonAnnuDernier.setBackground(Color.darkGray);

		panBouton.add(boutonNew);
		boutonNew.setBounds(0, (int) (b * 110 / 768), (int) (a * 250 / 1366), (int) (b * 50 / 768));
		boutonNew.setFont(f3);
		boutonNew.setForeground(new Color(180, 187, 191));
		boutonNew.setBackground(Color.darkGray);

		panBouton.add(boutonAnnu);
		boutonAnnu.setBounds((int) (a * 300 / 1366), (int) (b * 110 / 768), (int) (a * 250 / 1366),
				(int) (b * 50 / 768));
		boutonAnnu.setFont(f3);
		boutonAnnu.setForeground(new Color(180, 187, 191));
		boutonAnnu.setBackground(Color.darkGray);

		panBouton.add(liste);
		liste.setBounds(0, (int) (b * 190 / 768), (int) (a * 250 / 1366), (int) (b * 50 / 768));
		liste.setFont(f3);
		liste.setForeground(new Color(180, 187, 191));
		liste.setBackground(Color.darkGray);

		panBouton.add(boutonSauv);
		boutonSauv.setBounds((int) (a * 300 / 1366), (int) (b * 190 / 768), (int) (a * 250 / 1366),
				(int) (b * 50 / 768));
		boutonSauv.setFont(f3);
		boutonSauv.setForeground(new Color(180, 187, 191));
		boutonSauv.setBackground(Color.darkGray);

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

				a = fen.getWidth();
				b = fen.getHeight();

				Font f0 = new Font("Calibri", Font.PLAIN, a * 80 / 1366);
				Font f1 = new Font("Calibri", Font.PLAIN, a * 50 / 1366);
				Font f2 = new Font("Calibri", Font.PLAIN, a * 30 / 1366);
				Font f3 = new Font("Calibri", Font.PLAIN, a * 18 / 1366);

				panTitre.setBounds(0, 0, a, (int) (b / 4));
				titre.setBounds((int) (a * 470 / 1366), (int) (b * 20 / 768), (int) (a * 800 / 1366),
						(int) (b * 130 / 1366));
				soustitre.setBounds((int) (a * 450 / 1366), (int) (b * 100 / 768), (int) (a * 800 / 1366),
						(int) (b * 70 / 768));
				panInstruction.setBounds(0, b / 9 * 2, a, b / 4 * 3);
				etape.setBounds((int) (a * 50 / 1366), 0, (int) (a * 500 / 1366), (int) (b * 30 / 768));
				carte.setBounds((int) (a * 150 / 1366), (int) (b * 50 / 768), (int) (a * 300 / 1366),
						(int) (b * 30 / 768));
				img.setBounds((int) (a * 100 / 1366), (int) (b * 85 / 768), (int) (a * 420 / 1366),
						(int) (a * 435 / 1366));
				indication1.setBounds((int) (a * 750 / 1366), (int) (b * 50 / 768), (int) (a * 400 / 1366),
						(int) (b * 30 / 768));
				nomlieu.setBounds((int) (a * 750 / 1366), (int) (b * 100 / 768), (int) (a * 500 / 1366),
						(int) (b * 30 / 768));
				indication2.setBounds((int) (a * 750 / 1366), (int) (b * 150 / 768), (int) (a * 600 / 1366),
						(int) (b * 70 / 768));
				panBouton.setBounds(a / 2, b / 9 * 5, a / 2, b / 9 * 4);
				boutonVal.setBounds(0, (int) (b * 30 / 768), (int) (a * 250 / 1366), (int) (b * 50 / 768));
				boutonAnnuDernier.setBounds((int) (a * 300 / 1366), (int) (b * 30 / 768), (int) (a * 250 / 1366),
						(int) (b * 50 / 768));
				boutonNew.setBounds(0, (int) (b * 110 / 768), (int) (a * 250 / 1366), (int) (b * 50 / 768));
				boutonAnnu.setBounds((int) (a * 300 / 1366), (int) (b * 110 / 768), (int) (a * 250 / 1366),
						(int) (b * 50 / 768));
				liste.setBounds(0, (int) (b * 190 / 768), (int) (a * 250 / 1366), (int) (b * 50 / 768));
				boutonSauv.setBounds((int) (a * 300 / 1366), (int) (b * 190 / 768), (int) (a * 250 / 1366),
						(int) (b * 50 / 768));

				titre.setFont(f0);
				soustitre.setFont(f1);
				etape.setFont(f2);
				carte.setFont(f2);
				indication1.setFont(f2);
				nomlieu.setFont(f2);
				indication2.setFont(f2);
				boutonVal.setFont(f3);
				boutonAnnuDernier.setFont(f3);
				boutonNew.setFont(f3);
				boutonSauv.setFont(f3);
				liste.setFont(f3);
				boutonAnnu.setFont(f3);

				fen.revalidate();
			}

			@Override
			public void componentMoved(ComponentEvent e) {

			}

			@Override
			public void componentHidden(ComponentEvent e) {

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
