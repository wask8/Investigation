package new_investigation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public class ChronoPanel extends JPanel {

	ChronoPanel chrono = this;
	private JButton start = new JButton("Start");
	public JLabel getLabel1() {
		return label1;
	}

	public void setLabel1(JLabel label1) {
		this.label1 = label1;
	}

	private JLabel label1 = new JLabel();
	private JProgressBar bar = new JProgressBar();
	private JPanel pan1 = new JPanel();
	private JPanel pan3 = new JPanel();
	private int i = 0;
	private PanelOptions opt;
	int seconde = 0;

	public ChronoPanel(PanelOptions opt) {
		if (opt.getBoxHard().isSelected() == true) {
			label1.setText("Temps restant : 15s");
			seconde = 15;
			
		} else {
			label1.setText("Temps restant : 30s");
			seconde = 30;
			
		}
		this.opt = opt;
		this.setOpaque(false);
		this.setLayout(new GridLayout(3, 1));
		pan1.setOpaque(false);
		pan3.setOpaque(false);
		pan1.add(label1);
		label1.setForeground(new Color(190, 187, 191));
		add(pan1);
		start.addActionListener(new Listener2(opt, seconde, this));
				
		add(bar);
		pan3.add(start);
		add(pan3);
		
		
	}
	
	
	

	private class Listener2 implements ActionListener{

		ChronoPanel chronoPanel;
		public Listener2(PanelOptions opt, int seconde, ChronoPanel chronoPanel) {
			this.chronoPanel = chronoPanel;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(i<1){
				start.setVisible(false);
			new SecondListener( opt,  seconde, chronoPanel);
			i++;
			}
		}
	}
	
	
	
	



	class SecondListener implements ActionListener{
	
		int seconde = 0;
		public int getSeconde() {
			return seconde;
		}

		public void setSeconde(int seconde) {
			this.seconde = seconde;
		}

		private Timer timer;
		private float value = 100;
		public float getValue() {
			return value;
		}

		public void setValue(float value) {
			this.value = value;
		}

		int i =0;
		
		
		public SecondListener(PanelOptions opt, int seconde, ChronoPanel chronoPanel){
			chrono.setListener(this);
			timer = new Timer(1000, this);
			timer.start();
			this.seconde = seconde;
			bar.setValue((int) value);
		}

		public void actionPerformed(ActionEvent e) {
			seconde--;
			if (opt.getBoxEasy().isSelected() == true){
			value-=3.4;
			} else {
				value-=6.7;
			}
			ChronoPanel.this.label1.setText("Temps restant: "+seconde+"s");
			if (seconde==1) {
				ChronoPanel.this.label1.setText("Temps restant: "+seconde+"s");
			}
			bar.setValue((int) value);
			if(seconde<=0){
				chrono.getLabel1().setVisible(false);
				timer.stop();
			}
		}

		public Timer getTimer() {
			return timer;
		}

		public void setTimer(Timer timer) {
			this.timer = timer;
		}
	}

	public JProgressBar getBar() {
		return bar;
	}

	public void setBar(JProgressBar bar) {
		this.bar = bar;
	}

	public JButton getStart() {
		return start;
	}

	public void setStart(JButton start) {
		this.start = start;
	}

	private SecondListener listener;

	public SecondListener getListener() {
		return listener;
	}

	public void setListener(SecondListener second) {
		this.listener = second;
	}


}
