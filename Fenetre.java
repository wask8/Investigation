package new_investigation;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

public class Fenetre extends JFrame {
		
	private static final long serialVersionUID = 4371046657672853078L;

	public Fenetre()  {
		Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int b = (int) dim.getHeight();
		int a = (int) dim.getWidth();
		this.setTitle("Investigation");
		this.setSize(a, b);
		this.setContentPane(new PanelEntree(this));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.setResizable(false);
		this.setVisible(true);
	}



}
