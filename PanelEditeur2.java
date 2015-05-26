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

public class PanelEditeur2 extends JPanel {

	private Panneau panneau = new Panneau();
	private JPanel panTitre = new JPanel();
	private JPanel panInstruction = new JPanel();
	private JPanel panBouton = new JPanel();
	private JLabel titre = new JLabel("Investigation");
	private JLabel soustitre = new JLabel("Editeur cartes/questions");
	private JLabel etape = new JLabel("2e étape : Définir les lieux à placer");
	private JLabel carte = new JLabel("Votre carte :");
	private JLabel indication1 = new JLabel("1) Nom du lieu à  placer :");
	private JTextField nomlieu = new JTextField();
	private JLabel indication2 = new JLabel(
			"<HTML>2) Cliquez sur la carte pour définir <br/>l'endroit où ce lieu est placé</HTML>");
	private JButton boutonVal = new JButton("Valider le placement");
	private JButton boutonAnnuDernier = new JButton(
			"Annuler le dernier placement");
	private JButton boutonNew = new JButton("Nouveau placement");
	private JButton boutonSauv = new JButton("Sauvegarder et quitter");
	private JButton boutonAnnu = new JButton("Annuler tous les placements");
	private JButton liste = new JButton("Liste des lieux placés");
	private ImageIcon imageCarte = new ImageIcon("mayenne04.gif");
	JLabel img = new JLabel(imageCarte);

	public PanelEditeur2(final Fenetre fen) {
		// Si clic sur la carte, fenetre qui demande si on valide le placement
		// Si clic sur la carte, verifier si zone de texte du lieu est remplie,
		// sinon message erreur

		// FENETRE GLOBALE
		Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int a = (int) dim.getWidth();
		int b = (int) dim.getHeight();

		this.setSize(a, b);
		// this.setTitle("Investigation - Editeur Partie 2");
		// this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// this.setLocationRelativeTo(null);
		Font f0 = new Font("Calibri", Font.PLAIN, 80);
		Font f1 = new Font("Calibri", Font.PLAIN, 50);
		Font f2 = new Font("Calibri", Font.PLAIN, 30);
		Font f3 = new Font("Calibri", Font.PLAIN, 18);

		// AJOUT PANEL panTitre ET ELEMENTS
		panTitre.setLayout(null);
		panTitre.setBounds(0, 0, a, (int) (b / 4));
		panTitre.setOpaque(false);
		panTitre.add(titre);
		titre.setBounds(470, 20, 800, 70);
		panTitre.add(soustitre);
		soustitre.setBounds(450, 100, 800, 70);
		titre.setFont(f0);
		titre.setForeground(new Color(180, 187, 191)); // 180,187,191
		soustitre.setFont(f1);
		soustitre.setForeground(new Color(180, 187, 191)); // 180,187,191

		// AJOUT PANEL panInstruction ET ELEMENTS
		panInstruction.setLayout(null);
		panInstruction.setBounds(0, b / 9 * 2, a, b / 4 * 3);
		panInstruction.setOpaque(false);

		panInstruction.add(etape);
		etape.setBounds(50, 0, 500, 30);
		etape.setFont(f2);
		etape.setForeground(new Color(180, 187, 191));

		panInstruction.add(carte);
		carte.setBounds(150, 50, 300, 30);
		carte.setFont(f2);
		carte.setForeground(new Color(180, 187, 191));

		panInstruction.add(img);
		img.setBounds(100, 85, 420, 435);

		panInstruction.add(indication1);
		indication1.setBounds(750, 50, 400, 30);
		indication1.setFont(f2);
		indication1.setForeground(new Color(180, 187, 191));

		panInstruction.add(nomlieu);
		nomlieu.setBounds(750, 100, 500, 30);
		nomlieu.setFont(f2);

		panInstruction.add(indication2);
		indication2.setBounds(750, 150, 600, 70);
		indication2.setFont(f2);
		indication2.setForeground(new Color(180, 187, 191));

		// AJOUT PANEL panBouton ET ELEMENTS
		panBouton.setLayout(null);
		panBouton.setBounds(a / 2, b / 9 * 5, a / 2, b / 9 * 4);
		panBouton.setOpaque(false);

		panBouton.add(boutonVal);
		boutonVal.setBounds(0, 30, 250, 50);
		boutonVal.setFont(f3);
		boutonVal.setForeground(new Color(180, 187, 191));
		boutonVal.setBackground(Color.darkGray);

		panBouton.add(boutonAnnuDernier);
		boutonAnnuDernier.setBounds(300, 30, 250, 50);
		boutonAnnuDernier.setFont(f3);
		boutonAnnuDernier.setForeground(new Color(180, 187, 191));
		boutonAnnuDernier.setBackground(Color.darkGray);

		panBouton.add(boutonNew);
		boutonNew.setBounds(0, 110, 250, 50);
		boutonNew.setFont(f3);
		boutonNew.setForeground(new Color(180, 187, 191));
		boutonNew.setBackground(Color.darkGray);

		panBouton.add(boutonAnnu);
		boutonAnnu.setBounds(300, 110, 250, 50);
		boutonAnnu.setFont(f3);
		boutonAnnu.setForeground(new Color(180, 187, 191));
		boutonAnnu.setBackground(Color.darkGray);

		panBouton.add(liste);
		liste.setBounds(0, 190, 250, 50);
		liste.setFont(f3);
		liste.setForeground(new Color(180, 187, 191));
		liste.setBackground(Color.darkGray);

		panBouton.add(boutonSauv);
		boutonSauv.setBounds(300, 190, 250, 50);
		boutonSauv.setFont(f3);
		boutonSauv.setForeground(new Color(180, 187, 191));
		boutonSauv.setBackground(Color.darkGray);

		boutonSauv.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				fen.setContentPane(new PanelMenu(fen));
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