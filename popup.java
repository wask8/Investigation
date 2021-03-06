package new_investigation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Popup extends JDialog {

	private static final long serialVersionUID = -3737769809307992182L;
	private JPanel fond = new JPanel();
	private JLabel titre = new JLabel();
	private JButton quitter = new JButton("Retour");
	private JButton valider = new JButton("Valider");
	private Popup popup = this;
	private JPanel pan = new JPanel();
	private int a = 0;
	
	public Popup(final Fenetre fen, final PanelMenu menu, final PanelArcade arcade, final PanelChoixCarteArcade choixCarteArcade) {
		super(fen,true);
		a=fen.getWidth();
		this.setSize((int) (fen.getWidth() / 4), (int) (fen.getHeight() / 4));
		this.toFront();
		this.setLocationRelativeTo(fen);
		this.setAlwaysOnTop(true);
		this.setUndecorated(true);
		this.setModal(true);
		fond.setLayout(null);
		fond.setBackground(new Color(48, 48, 48));
		if (arcade.getChrono().getStart().isVisible() == false){
		arcade.getChrono().getListener().getTimer().stop();
		}
		
		valider.setFocusable(false);
		quitter.setFocusable(false);
		pan.setOpaque(false);

		titre.setFont(new Font("Calibri", Font.PLAIN, a*18/1366));
		titre.setText("Voulez-vous vraiment abandonner?");
		titre.setForeground(new Color(180, 187, 191));
		

		pan.setBounds(0,(int)(this.getHeight()/3), this.getWidth(), (int)(this.getHeight()/3));
		valider.setBounds((int) (this.getWidth() * 2 / 3 - 10), (int) (this.getHeight() * 2 / 3 + 20), (int)(fen.getWidth()*75/1200), (int)(fen.getHeight()*30/675));
		quitter.setBounds((int) (this.getWidth() * 1 / 3 - 10), (int) (this.getHeight() * 2 / 3 + 20),(int)(fen.getWidth()*75/1200), (int)(fen.getHeight()*30/675));

		
		valider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fen.setContentPane(menu);
				fen.revalidate();
				fen.remove(choixCarteArcade);
				fen.remove(arcade);
				popup.dispose();
			}
		});

		quitter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				popup.dispose();
				arcade.getChrono().getListener().getTimer().restart();

			}
		});
		
		
		pan.add(titre);
		fond.add(pan);
		fond.add(valider);
		fond.add(quitter);
		this.add(fond);

		this.setVisible(true);

	}

	public Popup(final Fenetre fen, final PanelMenu menu, final PanelHistoire histoire) {
		a=fen.getWidth();
		this.setSize((int) (fen.getWidth() / 4), (int) (fen.getHeight() / 4));
		this.toFront();
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true);
		this.setUndecorated(true);
		this.setModal(true);
		fond.setLayout(null);
		fond.setBackground(new Color(48, 48, 48));
		
		valider.setFocusable(false);
		quitter.setFocusable(false);
		pan.setOpaque(false);

		titre.setFont(new Font("Calibri", Font.PLAIN, a*18/1366));
		titre.setText("Voulez-vous vraiment abandonner?");
		titre.setForeground(new Color(180, 187, 191));
		

		pan.setBounds(0,(int)(this.getHeight()/3), this.getWidth(), (int)(this.getHeight()/3));
		valider.setBounds((int) (this.getWidth() * 2 / 3 - 10), (int) (this.getHeight() * 2 / 3 + 20), (int)(fen.getWidth()*75/1200), (int)(fen.getHeight()*30/675));
		quitter.setBounds((int) (this.getWidth() * 1 / 3 - 10), (int) (this.getHeight() * 2 / 3 + 20),(int)(fen.getWidth()*75/1200), (int)(fen.getHeight()*30/675));

		
		valider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fen.setContentPane(menu);
				fen.revalidate();
				fen.remove(histoire);
				popup.dispose();
			}
		});

		quitter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				popup.dispose();

			}
		});
		
		
		pan.add(titre);
		fond.add(pan);
		fond.add(valider);
		fond.add(quitter);
		this.add(fond);

		this.setVisible(true);
	}

}
