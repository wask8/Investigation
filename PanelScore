package mjkl.investigation.display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanelScore extends JPanel{


	private JPanel panTitre = new JPanel();
	private JPanel pantab1 = new JPanel();
	private JPanel pantab2 = new JPanel();
	private JPanel trait = new JPanel();
	private JPanel panbouton = new JPanel();
	private JLabel titre = new JLabel("Investigation");
	private JLabel soustitre = new JLabel("Meilleurs scores");
	private JLabel tab1 = new JLabel("Mode Histoire");
	private JLabel tab2 = new JLabel("Mode Arcade");
	private JTextArea zonetab1 = new JTextArea();
	private JTextArea zonetab2 = new JTextArea();
	private JButton bouton = new JButton("Retour au menu principal");
	private Fenetre fenetre;
	
	
	public PanelScore(final Fenetre fen){
		
		this.fenetre = fen;
		Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int a = (int) dim.getWidth();
		int b = (int) dim.getHeight();
		
		Font f0 = new Font("Calibri", Font.PLAIN, 80);
		Font f1 = new Font("Calibri", Font.PLAIN, 50);
		Font f2 = new Font("Calibri", Font.PLAIN, 30);
		Font f3 = new Font("Calibri", Font.PLAIN, 18);
		
		panTitre.setLayout(null);
		panTitre.setBounds(0, 0, a, (int) (b / 4));
		panTitre.setOpaque(false);
		panTitre.add(titre);
		titre.setBounds(470, 20, 800, 70);
		panTitre.add(soustitre);
		soustitre.setBounds(515, 100, 800, 70);
		titre.setFont(f0);
		titre.setForeground(new Color(180, 187, 191)); // 180,187,191
		soustitre.setFont(f1);
		soustitre.setForeground(new Color(180, 187, 191)); // 180,187,191
		
		pantab1.setLayout(null);
		pantab1.setBounds(0, 150, (a / 2) - 10, (b / 4) * 3);
		// pantab1.setBackground(Color.orange);
		pantab1.setOpaque(false);
		pantab1.add(tab1);
		tab1.setBounds(260, 10, 200, 50);
		tab1.setFont(f2);
		tab1.setForeground(new Color(180, 187, 191));
		pantab1.add(zonetab1);
		zonetab1.setBounds(100,100,500,300);

		// AJOUT PANEL pantab2 et ELEMENTS
		pantab2.setLayout(null);
		pantab2.setBounds((a / 2) + 10, 150, a / 2, (b / 4) * 3);
		// pantab2.setBackground(Color.red);
		pantab2.setOpaque(false);
		pantab2.add(tab2);
		tab2.setBounds(260, 10, 200, 50);
		tab2.setFont(f2);
		tab2.setForeground(new Color(180, 187, 191));
		pantab2.add(zonetab2);
		zonetab2.setBounds(70, 100, 500, 300);

		// AJOUT PANEL trait
		trait.setLayout(null);
		trait.setBounds((a / 2) - 10, 250, 3, 300);
		trait.setBackground(Color.white);
		trait.setOpaque(true);

		// AJOUT PANEL panbouton ET ELEMENT
		panbouton.setLayout(null);
		panbouton.setBounds(0, 590, 1500, 100);
		panbouton.setOpaque(false);
		
		panbouton.add(bouton);
		bouton.setBounds(540,10,250,50);
		bouton.setFont(f3);
		bouton.setForeground(new Color(180, 187, 191));
		bouton.setBackground(Color.darkGray);

		/* Bouton pas encore fonctionnel */
		bouton.addActionListener(new ActionListener()
		{
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == bouton){
						fen.removeAll();
						fen.repaint();
						fen.add(new PanelOption(fen));
						
					}
					
				}

		});
		// AFFICHAGE
		fen.add(panTitre);
		fen.add(pantab1);
		fen.add(pantab2);
		fen.add(trait);
		fen.add(panbouton);
		
		this.setFocusable(true);
		this.requestFocus();
		
		
		
	}
	
	/* Image de fond à mettre */
//	public void paintComponent(Graphics g) {
//		try {
//			Image img = ImageIO.read(new File("investigation.jpg"));
//			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
}
