package new_investigation;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public class ChronoPanel extends JPanel{

	private JButton start = new JButton("Appuyer pour commencer la partie");
	private JLabel label1 = new JLabel("Temps restant : 20s");
	private JProgressBar bar = new JProgressBar();
	private JPanel pan1 = new JPanel();
	private JPanel pan3 = new JPanel();
	private int i = 0;
	
	public ChronoPanel(){
		this.setOpaque(false);
		this.setLayout(new GridLayout(3,1));
		pan1.setOpaque(false);
		pan3.setOpaque(false);
		pan1.add(label1);
		label1.setForeground(new Color(180,187,191));
		add(pan1);
		start.addActionListener(new Listener2());
		add(bar);
		pan3.add(start);
		add(pan3);
	}
	
	
	private class Listener2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(i<1){
				start.setVisible(false);
			new SecondListener();
			i++;
			}
		}
	}
	
	private class SecondListener implements ActionListener{
		int seconde=20;
		Timer timer;
		private int value = 100;
		
		
		
		public SecondListener(){
			timer = new Timer(1000, this);
			timer.start();
			bar.setValue(value);
		}

		public void actionPerformed(ActionEvent e) {
			seconde--;
			value-=5;
			ChronoPanel.this.label1.setText("Temps restant: "+seconde+"s");
			if (seconde==1) {
				ChronoPanel.this.label1.setText("Temps restant: "+seconde);
			}
			bar.setValue(value);
			if(seconde<=0){
				timer.stop();
			}
		}
	}
	
}
