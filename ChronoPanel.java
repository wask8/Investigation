package mjkl.investigation.running;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public class ChronoPanel extends JPanel{

	private JButton start = new JButton("Start");
	private JLabel label1 = new JLabel("Temps restant : 20s");
	private JProgressBar bar = new JProgressBar();
	
	public ChronoPanel(){
		add(label1);
		start.addActionListener(new Listener2());
		add(start);
		add(bar);
	}
	
	
	private class Listener2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			new SecondListener();
			
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
			bar.setValue(value);
			if(seconde<=0){
				timer.stop();
			}
		}
	}
	
}
