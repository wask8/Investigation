package new_investigation;

import java.awt.GraphicsEnvironment;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Fenetre extends JFrame {
	private GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	private static final long serialVersionUID = 4371046657672853078L;
	private boolean fullscreen;
	private Fenetre fen = this;
	
	public Fenetre()  {
		
		this.setTitle("Investigation");
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setUndecorated(true);
		fullscreen = true;
		this.setResizable(false);
		ge.getDefaultScreenDevice().setFullScreenWindow(this);
		this.setContentPane(new PanelEntree(this));
		
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		}
		catch (UnsupportedLookAndFeelException e) {
			
		}
		this.setVisible(true);
	}
	
	public void Fullscreen(Boolean b) {
		if (b == true){
			fullscreen = true;
			
			
			this.setVisible(false);
			this.dispose();
			this.setLocationRelativeTo(null);
			this.setUndecorated(true);
			ge.getDefaultScreenDevice().setFullScreenWindow(fen);
			this.setResizable(false);
			this.setVisible(true);
			
		} else {
			fullscreen = false;
			this.setVisible(false);
			this.dispose();
			this.setUndecorated(false);
			this.setResizable(false);
			this.setSize(1366, 768);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
		}
		
	}
	
	public boolean isFullscreen(){
		return fullscreen;
	}
	


}
