package new_investigation;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class PanelOptions extends JPanel {

	private static final long serialVersionUID = 1L;
	// DECLARATION ELEMENTS

	private int a;
	private int b;
	private JPanel panTitre = new JPanel();
	private JPanel panTexte = new JPanel();
	private JPanel panBouton1 = new JPanel();
	private JPanel panBouton2 = new JPanel();
	private JLabel titre = new JLabel("Investigation");
	private JLabel soustitre = new JLabel("Options");
	private JLabel pseudo = new JLabel("Votre pseudo : ");
	private JLabel difficulte = new JLabel("<HTML>Choix de la difficult&eacute; : </HTML>");
	private JLabel selectscreen = new JLabel("<HTML>S&eacute;lection de l'&eacute;cran: </HTML>");
	private JTextField zonePseudo = new JTextField("Player");
	private JTextField sauvzonePseudo = new JTextField("Player");
	private JRadioButton boxEasy = new JRadioButton("<html>FACILE</html>");
	private JRadioButton sauvboxEasy = new JRadioButton();
	private JRadioButton boxHard = new JRadioButton("<html>DIFFICILE</html>");
	public JRadioButton getBoxEasy() {
		return boxEasy;
	}

	public void setBoxEasy(JRadioButton boxEasy) {
		this.boxEasy = boxEasy;
	}

	public JRadioButton getBoxHard() {
		return boxHard;
	}

	public void setBoxHard(JRadioButton boxHard) {
		this.boxHard = boxHard;
	}

	private JRadioButton sauvboxHard = new JRadioButton();
	private JButton boutonVal = new JButton("VALIDER");
	private JButton boutonretour = new JButton("RETOUR");
	private JLabel screenmode = new JLabel(" Mode : ");
	private JCheckBox fullscreened = new JCheckBox("<HTML> Plein &Eacute;cran </HTML>");
	private JCheckBox windowed = new JCheckBox("<HTML> Fen&ecirc;tr&eacute; </HTML>");
	private JCheckBox sauvfullscreened = new JCheckBox("<HTML> Plein &Eacute;cran </HTML>");
	private JCheckBox sauvwindowed = new JCheckBox("<HTML> Fen&ecirc;tr&eacute; </HTML>");
	private ButtonGroup group2 = new ButtonGroup();
	private ButtonGroup group = new ButtonGroup();
	private JLabel ecran = new JLabel("1");
	private JLabel sauvecran = new JLabel("1");
	private JButton selectprev = new JButton();
	private JButton selectnext = new JButton();
	private int numecran = 0;
	private int sauvnumecran = 0;

	public PanelOptions(final Fenetre fen, final PanelMenu panelMenu) {
		sauvfullscreened.setSelected(fullscreened.isSelected());
		sauvwindowed.setSelected(windowed.isSelected());

		this.setLayout(null);
		// FENETRE GLOBALE
		fullscreened.setEnabled(false);
		windowed.setEnabled(true);
		a = (int) fen.getWidth();
		b = (int) fen.getHeight();

		Font f0 = new Font("Calibri", Font.PLAIN, a * 80 / 1366);
		Font f1 = new Font("Calibri", Font.PLAIN, a * 50 / 1366);
		Font f2 = new Font("Calibri", Font.PLAIN, a * 30 / 1366);
		Font f3 = new Font("Calibri", Font.PLAIN, a * 18 / 1366);

		// AJOUT ELEMENT PANEL TITRE

		panTitre.setLayout(new BoxLayout(panTitre, BoxLayout.Y_AXIS));
		panTitre.setBounds(0, 0, a, (int) (b / 4));
		panTitre.setOpaque(false);
		panTitre.add(titre);
		titre.setAlignmentX(CENTER_ALIGNMENT);
		panTitre.add(soustitre);
		soustitre.setAlignmentX(CENTER_ALIGNMENT);
		titre.setFont(f0);
		titre.setForeground(new Color(180, 187, 191));
		soustitre.setFont(f1);
		soustitre.setForeground(new Color(180, 187, 191));

		// AJOUT ELEMENT PANEL TEXTE (Nom des types d'options)
		panTexte.setLayout(null);
		panTexte.setBounds(0, (int) ((b / 4) + 1), (int) (a / 2), (int) (b - (b / 4)));
		panTexte.setOpaque(false);
		panTexte.add(pseudo);
		pseudo.setBounds((int) (a * 392 / 1366), 0, (int) (a * 500 / 1366), (int) (b * 70 / 768));
		pseudo.setFont(f2);
		pseudo.setForeground(new Color(180, 187, 191));
		panTexte.add(difficulte);
		difficulte.setBounds((int) (a * 285 / 1366), (int) (b * 220 / 768), (int) (a * 500 / 1366),
				(int) (b * 70 / 768));
		difficulte.setFont(f2);
		difficulte.setForeground(new Color(180, 187, 191));

		ecran.setBounds((int) (a * 550 / 1366), (int) (b * 140 / 768), (int) (a * 100 / 1366), (int) (b * 70 / 768));

		selectnext.setBounds((int) (a * 625 / 1366), (int) (b * 165 / 768), (int) (a * 20 / 1366),
				(int) (b * 20 / 768));

		selectprev.setBounds((int) (a * 475 / 1366), (int) (b * 165 / 768), (int) (a * 20 / 1366),
				(int) (b * 20 / 768));

		selectnext.setIcon(new ImageIcon(getClass().getResource("flechedroite.png")));
		selectnext.setBackground(new Color(0, 0, 0, 0));
		selectnext.setFocusPainted(false);
		selectnext.setPressedIcon(new ImageIcon(getClass().getResource("flechedroite.png")));
		selectnext.setBorder(null);

		selectprev.setIcon(new ImageIcon(getClass().getResource("flechegauche.png")));
		selectprev.setBackground(new Color(0, 0, 0, 0));
		selectprev.setFocusPainted(false);
		selectprev.setPressedIcon(new ImageIcon(getClass().getResource("flechegauche.png")));
		selectprev.setBorder(null);
		selectscreen.setForeground(new Color(180, 187, 191));
		selectscreen.setBounds((int) (a * 305 / 1366), (int) (b * 140 / 768), (int) (a * 500 / 1366),
				(int) (b * 70 / 768));
		selectscreen.setFont(f2);
		panTexte.add(selectscreen);
		ecran.setFont(f3);
		ecran.setForeground(new Color(180, 187, 191));

		if (fen.getListScreen().length == 1) {
			selectnext.setEnabled(false);
			selectprev.setEnabled(false);
		}

		panBouton1.add(selectnext);
		panBouton1.add(selectprev);
		panBouton1.add(ecran);

		selectnext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (numecran < fen.getListScreen().length - 1) {
					numecran++;
					ecran.setText(numecran+1+"");
					showOnScreen(numecran, fen);
				}
			}
		});

		selectprev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (numecran > 0) {
					numecran--;
					ecran.setText(numecran+1+"");
					showOnScreen(numecran, fen);

				}

			}
		});

		// AJOUT ELEMENT PANEL BOUTON1 (Reponse options)
		panBouton1.setLayout(null);
		panBouton1.setBounds((int) (a * 250 / 1366), (int) (b * 200 / 768), (int) (a * 1000 / 1366),
				(int) (b * 1000 / 768));

		panBouton1.setOpaque(false);

		group2.add(fullscreened);
		group2.add(windowed);
		panBouton1.add(fullscreened);
		if (fen.isFullscreen() == true) {
			fullscreened.setSelected(true);
		} else {
			windowed.setSelected(true);
		}
		sauvfullscreened.setSelected(fullscreened.isSelected());
		sauvwindowed.setSelected(windowed.isSelected());

		panBouton1.add(windowed);
		panBouton1.add(screenmode);

		screenmode.setBounds((int) (a * 253 / 1366), (int) (b * 80 / 768), (int) (a * 300 / 1366),
				(int) (b * 35 / 768));
		screenmode.setFont(f2);
		screenmode.setForeground(new Color(180, 187, 191));
		fullscreened.setBounds((int) (a * 410 / 1366), (int) (b * 80 / 768), (int) (a * 200 / 1366),
				(int) (b * 35 / 768));
		fullscreened.setFont(f3);
		fullscreened.setFocusPainted(false);
		fullscreened.setOpaque(false);
		fullscreened.setForeground(new Color(180, 187, 191));
		windowed.setBounds((int) (a * 650 / 1366), (int) (b * 80 / 768), (int) (a * 200 / 1366), (int) (b * 35 / 768));
		windowed.setFont(f3);
		windowed.setFocusPainted(false);
		windowed.setOpaque(false);
		windowed.setForeground(new Color(180, 187, 191));

		panBouton1.add(zonePseudo);
		zonePseudo.setBounds((int) (a * 410 / 1366), (int) (b * 10 / 768), (int) (a * 300 / 1366),
				(int) (b * 35 / 768));
		zonePseudo.setFont(f2);

		group.add(boxEasy);
		group.add(boxHard);
		panBouton1.add(boxEasy);
		panBouton1.add(boxHard);

		boxEasy.setOpaque(false);
		boxEasy.setSelected(true);
		sauvboxEasy.setSelected(true);
		sauvboxHard.setSelected(false);
		boxEasy.setBounds((int) (a * 410 / 1366), (int) (b * 200 / 768), (int) (a * 200 / 1366), (int) (b * 100 / 768));
		boxEasy.setForeground(new Color(180, 187, 191));
		boxEasy.setFocusPainted(false);

		boxHard.setOpaque(false);
		boxHard.setBounds((int) (a * 410 / 1366), (int) (b * 270 / 768), (int) (a * 200 / 1366), (int) (a * 50 / 768));
		boxHard.setForeground(new Color(180, 187, 191));
		boxHard.setFocusPainted(false);

		// AJOUT ELEMENT PANEL BOUTON2 (Reponse valider/annuler)
		panBouton2.setLayout(null);
		panBouton2.setBounds(0, (int) (b * 600 / 768), (int) (a * 1000 / 1366), (int) (b * 1000 / 768));
		panBouton2.setOpaque(false);

		panBouton2.add(boutonVal);
		boutonVal.setBounds((int) (a * 750 / 1366), 0, (int) (a * 150 / 1366), (int) (b * 50 / 768));
		boutonVal.setFont(f3);
		boutonVal.setForeground(new Color(180, 187, 191));
		boutonVal.setBackground(Color.darkGray);
		boutonVal.setFocusPainted(false);

		panBouton2.add(boutonretour);
		boutonretour.setBounds((int) (a * 450 / 1366), 0, (int) (a * 150 / 1366), (int) (b * 50 / 768));
		boutonretour.setFont(f3);
		boutonretour.setForeground(new Color(180, 187, 191));
		boutonretour.setBackground(Color.darkGray);
		boutonretour.setFocusPainted(false);

		// AJOUT PANELS SUR IMAGE DE FOND

		boutonretour.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (fullscreened.isSelected() != sauvfullscreened.isSelected()) {
					if (fullscreened.isSelected() == true) {
						fullscreened.setSelected(false);
						fullscreened.setEnabled(true);
						windowed.setSelected(true);
						windowed.setEnabled(false);
						fen.Fullscreen(false);
						fen.setVisible(true);
					}

				}
				if (windowed.isSelected() != sauvwindowed.isSelected()) {
					if (windowed.isSelected() == true) {
						windowed.setSelected(false);
						windowed.setEnabled(true);
						fullscreened.setSelected(true);
						fullscreened.setEnabled(false);
						fen.Fullscreen(true);
						fen.setVisible(true);
					}

				}
				if (boxEasy.isSelected() != sauvboxEasy.isSelected()) {
					if (boxEasy.isSelected() == true) {
						boxEasy.setSelected(false);
						boxHard.setSelected(true);

					} else {
						boxEasy.setSelected(true);
						boxHard.setSelected(false);
					}
				}
				numecran = sauvnumecran;
				zonePseudo.setText(sauvzonePseudo.getText());
				ecran.setText(sauvecran.getText());
				
				
				if (sauvecran.getText() != ecran.getText()){
				showOnScreen((Integer.parseInt(sauvecran.getText())-1), fen);
				}
				
				
				fen.setContentPane(panelMenu);
				fen.revalidate();

			}
		});
		boutonVal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sauvnumecran = numecran;
				sauvecran.setText(ecran.getText());
				sauvboxEasy.setSelected(boxEasy.isSelected());
				sauvboxHard.setSelected(boxHard.isSelected());
				sauvfullscreened.setSelected(fullscreened.isSelected());
				sauvwindowed.setSelected(windowed.isSelected());
				sauvzonePseudo.setText(zonePseudo.getText());
				fen.setContentPane(panelMenu);
				fen.revalidate();

			}
		});

		fullscreened.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fullscreened.setEnabled(false);
				windowed.setEnabled(true);
				fen.Fullscreen(true);
				if (fen.getListScreen().length > 1) {
					selectnext.setEnabled(true);
					selectprev.setEnabled(true);
				}
			}
		});
		windowed.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ecran.setText("1");
				fullscreened.setEnabled(true);
				windowed.setEnabled(false);
				fen.Fullscreen(false);
				selectnext.setEnabled(false);
				selectprev.setEnabled(false);

			}
		});

		this.add(panTitre);
		this.add(panTexte);
		this.add(panBouton1);
		this.add(panBouton2);
		fen.getRootPane().addComponentListener(new ComponentListener() {

			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub

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
				panTexte.setBounds(0, (int) ((b / 4) + 1), (int) (a / 2), (int) (b - (b / 4)));
				pseudo.setBounds((int) (a * 392 / 1366), 0, (int) (a * 500 / 1366), (int) (b * 70 / 768));
				difficulte.setBounds((int) (a * 285 / 1366), (int) (b * 220 / 768), (int) (a * 500 / 1366),
						(int) (b * 70 / 768));
				panBouton1.setBounds((int) (a * 250 / 1366), (int) (b * 200 / 768), (int) (a * 1000 / 1366),
						(int) (b * 1000 / 768));
				screenmode.setBounds((int) (a * 253 / 1366), (int) (b * 80 / 768), (int) (a * 300 / 1366),
						(int) (b * 35 / 768));
				fullscreened.setBounds((int) (a * 410 / 1366), (int) (b * 80 / 768), (int) (a * 200 / 1366),
						(int) (b * 35 / 768));
				windowed.setBounds((int) (a * 650 / 1366), (int) (b * 80 / 768), (int) (a * 200 / 1366),
						(int) (b * 35 / 768));
				zonePseudo.setBounds((int) (a * 410 / 1366), (int) (b * 10 / 768), (int) (a * 300 / 1366),
						(int) (b * 35 / 768));
				boxEasy.setBounds((int) (a * 410 / 1366), (int) (b * 200 / 768), (int) (a * 200 / 1366),
						(int) (b * 100 / 768));
				boxHard.setBounds((int) (a * 410 / 1366), (int) (b * 270 / 768), (int) (a * 200 / 1366),
						(int) (a * 50 / 768));
				panBouton2.setBounds(0, (int) (b * 600 / 768), (int) (a * 1000 / 1366), (int) (b * 1000 / 768));
				boutonVal.setBounds((int) (a * 750 / 1366), 0, (int) (a * 150 / 1366), (int) (b * 50 / 768));
				boutonretour.setBounds((int) (a * 450 / 1366), 0, (int) (a * 150 / 1366), (int) (b * 50 / 768));
				ecran.setBounds((int) (a * 550 / 1366), (int) (b * 140 / 768), (int) (a * 100 / 1366),
						(int) (b * 70 / 768));

				selectnext.setBounds((int) (a * 625 / 1366), (int) (b * 165 / 768), (int) (a * 20 / 1366),
						(int) (b * 20 / 768));

				selectprev.setBounds((int) (a * 475 / 1366), (int) (b * 165 / 768), (int) (a * 20 / 1366),
						(int) (b * 20 / 768));
				selectscreen.setBounds((int) (a * 305 / 1366), (int) (b * 140 / 768), (int) (a * 500 / 1366),
						(int) (b * 70 / 768));
				
				
				ecran.setFont(f3);
				selectscreen.setFont(f2);
				titre.setFont(f0);
				soustitre.setFont(f1);
				pseudo.setFont(f2);
				difficulte.setFont(f2);
				screenmode.setFont(f2);
				fullscreened.setFont(f3);
				windowed.setFont(f3);
				zonePseudo.setFont(f2);
				boutonVal.setFont(f3);
				boutonretour.setFont(f3);

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

	public static void showOnScreen(int screen, JFrame frame) {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] gs = ge.getScreenDevices();
		if (screen > -1 && screen < gs.length) {
			frame.setVisible(false);
			frame.dispose();
			gs[screen].setFullScreenWindow(frame);
			frame.setVisible(true);
			
		} else if (gs.length > 0) {
			frame.setVisible(false);
			frame.dispose();
			gs[0].setFullScreenWindow(frame);
			frame.setVisible(true);
		} else {
			throw new RuntimeException("No Screens Found");
		}
	}

	public JTextField getZonePseudo() {
		return zonePseudo;
	}

	public void setZonePseudo(JTextField zonePseudo) {
		this.zonePseudo = zonePseudo;
	}

	/* Fond */
	public void paintComponent(Graphics g) {
		try {
			Image img = ImageIO.read(getClass().getResource("investigation.jpg")); 
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
