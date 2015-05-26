package new_investigation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Popup extends JDialog {
	
	private static final long serialVersionUID = -3088405816054794231L;
	private JPanel pan = new JPanel();
	private JPanel pan2 = new JPanel();
	private JTextArea text = new JTextArea("Voulez-vous vraiment abandonner?");
	private JButton btn = new JButton("Oui");
	private JButton btn2 = new JButton("Non");
	

	public Popup( final Fenetre fen, int a, int b) {
		
			
			this.setSize((int)(a/5), (int)(b/5));
			this.setLayout(null);
			pan.setBounds(0, 0,(int) (a/10),(int)(b/10-1));
			pan2.setBounds(0, (int)(b/10),(int) (a/20),(int)(b/50));
			pan.setLayout(new BorderLayout());
			btn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					fen.setContentPane(fen);
					
				}
			});
			btn2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			pan.setBackground(Color.DARK_GRAY);
			text.setEditable(false);
			pan.add(text,BorderLayout.SOUTH);
			pan2.setLayout(new GridLayout(1,2,(int)(a/50),0));
			pan2.add(btn2);
			pan2.add(btn);
			this.add(pan);
			this.add(pan2);
			this.setBackground(Color.DARK_GRAY);
			
			
	

		
	}

	

}
