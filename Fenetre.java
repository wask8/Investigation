package new_investigation;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

public class Fenetre extends JFrame {
		
	private static final long serialVersionUID = 4371046657672853078L;
	boolean fullscreen;
	public Fenetre()  {
		Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int b = (int) dim.getHeight();
		int a = (int) dim.getWidth();
		this.setTitle("Investigation");
		this.setSize(a, b);
		this.setContentPane(new PanelEntree(this));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setUndecorated(true);
		fullscreen = true;
		this.setResizable(false);
		this.setVisible(true);
		
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		}
		catch (UnsupportedLookAndFeelException e) {
			
		}
	}
	
	public void Fullscreen(Boolean b) {
		if (b == true){
			fullscreen = true;
			Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
			int c = (int) dim.getHeight();
			int  a = (int) dim.getWidth();
			this.setSize(a,c);
			this.setVisible(false);
			this.dispose();
			this.setLocationRelativeTo(null);
			this.setUndecorated(true);
			this.setResizable(false);
			this.setVisible(true);
			
		} else {
			fullscreen = false;
			this.setVisible(false);
			this.dispose();
			this.setUndecorated(false);
			this.setResizable(true);
			this.setSize(1366, 768);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
		}
		
	}
	
	public boolean isFullscreen(){
		return fullscreen;
	}
	


}
