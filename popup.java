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
	private JButton quitter = new JButton("Non");
	private JButton valider = new JButton("Oui");
	private Popup popup = this;
	private JPanel pan = new JPanel();
	private int a = 0;
	
	public Popup(final Fenetre fen) {
		a=fen.getWidth();
		this.setSize((int) (fen.getWidth() / 4), (int) (fen.getHeight() / 4));
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(fen);
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
		valider.setBounds((int) (this.getWidth() * 2 / 3 - 35), (int) (this.getHeight() * 2 / 3 + 20), (int)(fen.getWidth()*75/1200), (int)(fen.getHeight()*30/675));
		quitter.setBounds((int) (this.getWidth() * 1 / 3 - 35), (int) (this.getHeight() * 2 / 3 + 20),(int)(fen.getWidth()*75/1200), (int)(fen.getHeight()*30/675));

		
		valider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fen.setContentPane(new PanelMenu(fen));
				fen.revalidate();
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
