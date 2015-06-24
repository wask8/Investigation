package new_investigation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.PaintEvent;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.text.AttributedCharacterIterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import new_investigation.ChronoPanel.SecondListener;

public class PanelArcade extends JPanel {

	private static final long serialVersionUID = 193869095035714316L;
	private int compteur = 0;
	private int nbcarte = 4;
	private int fenWidth;
	private int fenHeight;
	private JPanel panEntete = new JPanel();
	private JPanel panCarteext = new JPanel();
	private JPanel panCarte = new JPanel(new CardLayout());
	private JPanel panScore = new JPanel();
	private JPanel panQuestion = new JPanel();
	private JPanel panLieu = new JPanel();
	private JLabel titre = new JLabel("Investigation");
	private JButton abandon = new JButton("Abandonner la partie");
	private JTextArea label1;
	private JLabel labelQuestion = new JLabel("Question");
	private JLabel question = new JLabel(" 0 / 10");
	private JLabel labscore = new JLabel("Score");
	private JLabel espace = new JLabel(" ");
	private JLabel score = new JLabel("0");
	private double actualscore = 0;
	private ChronoPanel chrono ;
	private PanelOptions opt;
	private Cartes carte;
	private PanelArcade arcade = this;
	private Fenetre fen;
	private PanelMenu menu;
	private PanelChoixCarteArcade choixarcade;

	JPanel pan = this;

	public PanelArcade(final Fenetre fen, final Cartes carte, final PanelOptions opt, final PanelMenu menu,final PanelChoixCarteArcade choixCarteArcade) {
		// FENETRE GLOBALE
		fenWidth = (int) fen.getWidth();
		fenHeight = (int) fen.getHeight();
		this.opt = opt;	
		this.carte = carte;
		this.menu = menu;
		this.fen = fen;
		choixarcade = choixCarteArcade;
		chrono = new ChronoPanel(opt);
		this.setPreferredSize(new Dimension(fenWidth, fenHeight));
		this.setOpaque(false);
		this.setLayout(null);
		this.setBackground(Color.black);

		Font f2 = new Font("Calibri", Font.PLAIN, fenWidth * 30 / 1366);
		Font f3 = new Font("Calibri", Font.PLAIN, fenWidth * 18 / 1366);
		Font f5 = new Font("Calibri", Font.PLAIN, fenWidth * 13 / 1366);

		// AJOUT PANEL panEntete ET ELEMENTS
		panEntete.setLayout(null);
		panEntete.setBounds(0, 0, fenWidth, (int) (fenHeight / 4));
		panEntete.setOpaque(false);
		panEntete.add(titre);
		panEntete.add(abandon);
		abandon.setLayout(null);
		abandon.setOpaque(false);
		abandon.setFont(f5);
		abandon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Popup pop = new Popup(fen, menu, arcade, choixCarteArcade);
				pop.setAlwaysOnTop(true);
				pop.toFront();
				pop.setFocusable(true);
				pop.requestFocus();
			}
		});

		abandon.setBounds(fenWidth * 1110 / 1366, fenHeight * 20 / 768, fenWidth * 170 / 1366, fenHeight * 25 / 768);

		// AJOUT PANEL panCarte ET ELEMENTS
		panCarte.setOpaque(false);

		panCarte.setBounds(fenWidth * 200 / 1366, fenHeight * 130 / 768, fenWidth * 650 / 1366, fenHeight * 580 / 768);
		panCarteext.setBounds(fenWidth * 200 / 1366, fenHeight * 130 / 768, fenWidth * 650 / 1366, fenHeight * 580 / 768);
		panCarte.add(carte);

		panCarte.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(e.getX()+" "+e.getY());
				
			}
		});
		
		
		chrono.getLabel1().addComponentListener(new ComponentListener() {
			
			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentResized(ComponentEvent e) {
				
			}
			
			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentHidden(ComponentEvent e) {
				if (fen.getContentPane() instanceof PanelArcade){
				new Popupfindugame(fen, menu,arcade);
				}
				chrono.getListener().getTimer().stop();
				
			}
		});
		
			
			
		
		chrono.getStart().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				chrono.getStart().setVisible(false);
				if (opt.getBoxEasy().isSelected() == true) {
					for (int i = 0; i < 10; i++) {
						carte.getListdelist().get(compteur).get(i).setBounds(
								carte.getListdelist().get(compteur).get(i).getX(),
								carte.getListdelist().get(compteur).get(i).getY(), fenWidth * 18 / 1920, fenWidth * 18 / 1920);
						panCarteext.add(carte.getListdelist().get(compteur).get(i));
					}
				} else {
					for (int i = 0; i < carte.getListdelist().get(compteur).size(); i++) {
						carte.getListdelist().get(compteur).get(i).setBounds(
								carte.getListdelist().get(compteur).get(i).getX(),
								carte.getListdelist().get(compteur).get(i).getY(), fenWidth * 18 / 1920, fenWidth * 18 / 1920);
						panCarteext.add(carte.getListdelist().get(compteur).get(i));
					}
				}

				CarteMouselistener();
				label1.setText(carte.getQuestion().get(compteur));
				question.setText(compteur+1 + " / 10");
				panCarteext.repaint();
			}
		});

		panCarteext.setOpaque(false);
		panCarteext.setLayout(null);

		// AJOUT PANEL panStat ET ELEMENTS
		panScore.setLayout(new BoxLayout(panScore, BoxLayout.Y_AXIS));
		panScore.setOpaque(false);
		panScore.setBounds(fenWidth * 1100 / 1366, fenHeight * 300 / 768, fenWidth * 200 / 1366, fenHeight * 120 / 768);
		labscore.setFont(f2);
		labscore.setForeground(new Color(180, 187, 191));
		score.setFont(f3);
		score.setForeground(new Color(180, 187, 191));
		labscore.setAlignmentX(CENTER_ALIGNMENT);
		panScore.add(labscore);
		panScore.add(espace);
		score.setAlignmentX(CENTER_ALIGNMENT);
		panScore.add(score);

		// AJOUT PANEL panQuestion ET ELEMENTS
		panQuestion.setLayout(new BoxLayout(panQuestion, BoxLayout.Y_AXIS));
		panQuestion.setOpaque(false);
		panQuestion.setBounds(fenWidth * 1100 / 1366, fenHeight * 500 / 768, fenWidth * 200 / 1366, fenHeight * 120 / 768);

		labelQuestion.setFont(f2);
		labelQuestion.setForeground(new Color(180, 187, 191));
		labelQuestion.setAlignmentX(CENTER_ALIGNMENT);
		panQuestion.add(labelQuestion);
		panQuestion.add(espace);
		question.setAlignmentX(CENTER_ALIGNMENT);
		question.setFont(f3);
		question.setForeground(new Color(180, 187, 191));
		panQuestion.add(question);
		

		// AJOUT PANEL panLeu ET ELEMENTS
		panLieu.setLayout(null);
		panLieu.setOpaque(true);
		panLieu.setBounds(fenWidth * 150 / 1366, fenHeight * 25 / 768, fenWidth * 800 / 1366, fenHeight * 75 / 768);

		// SCENARIO
		label1 = new JTextArea();
		label1.setEditable(false);
		label1.setText("Cliquez sur Start pour commencer ");
		panLieu.add(label1);
		label1.setBounds(fenWidth * 0 / 1366, fenHeight * 0 / 768, fenWidth * 800 / 1366, fenHeight * 100 / 768);
		label1.setFont(f2);

		// AJOUT PANEL panTemps ET ELEMENTS

		chrono.setOpaque(false);
		chrono.setBounds(fenWidth * 1100 / 1366, fenHeight * 150 / 768, fenWidth * 200 / 1366, fenHeight * 80 / 768);
		this.add(panCarteext);
		this.add(panEntete);
		this.add(panCarte);
		this.add(panQuestion);
		this.add(panScore);
		this.add(chrono);
		this.add(panLieu);

		fen.getRootPane().addComponentListener(new ComponentListener() {

			@Override
			public void componentShown(ComponentEvent e) {

			}

			@Override
			public void componentResized(ComponentEvent e) {
				fenWidth = fen.getWidth();
				fenHeight = fen.getHeight();

				Font f0 = new Font("Calibri", Font.PLAIN, fenWidth * 80 / 1366);
				Font f1 = new Font("Calibri", Font.PLAIN, fenWidth * 50 / 1366);
				Font f2 = new Font("Calibri", Font.PLAIN, fenWidth * 30 / 1366);
				Font f3 = new Font("Calibri", Font.PLAIN, fenWidth * 18 / 1366);

				panEntete.setBounds(0, 0, fenWidth, (int) (fenHeight / 4));
				abandon.setBounds(fenWidth * 1110 / 1366, fenHeight * 20 / 768, fenWidth * 170 / 1366, fenHeight * 25 / 768);
				panCarte.setBounds(fenWidth * 200 / 1366, fenHeight * 130 / 768, fenWidth * 650 / 1366, fenHeight * 620 / 768);
				panCarteext.setBounds(fenWidth * 200 / 1366, fenHeight * 130 / 768, fenWidth * 650 / 1366, fenHeight * 580 / 768);
				panScore.setBounds(fenWidth * 1100 / 1366, fenHeight * 300 / 768, fenWidth * 200 / 1366, fenHeight * 120 / 768);
				panQuestion.setBounds(fenWidth * 1100 / 1366, fenHeight * 500 / 768, fenWidth * 200 / 1366, fenHeight * 120 / 768);
				labelQuestion.setBounds(fenWidth * 5 / 1366, fenHeight * 5 / 768, fenWidth * 200 / 1366, fenHeight * 70 / 768);
				panLieu.setBounds(fenWidth * 150 / 1366, fenHeight * 25 / 768, fenWidth * 800 / 1366, fenHeight * 75 / 768);
				label1.setBounds(fenWidth * 15 / 1366, fenHeight * 5 / 768, fenWidth * 800 / 1366, fenHeight * 100 / 768);
				chrono.setBounds(fenWidth * 1100 / 1366, fenHeight * 150 / 768, fenWidth * 200 / 1366, fenHeight * 60 / 768);

				for (int i = 0; i < carte.getListdelist().get(compteur).size(); i++) {
					carte.getListdelist().get(compteur).get(i).setBounds(
							carte.getListdelist().get(compteur).get(i).getX(),
							carte.getListdelist().get(compteur).get(i).getY(), fenWidth * 18 / 1920, fenWidth * 18 / 1920);
					panCarteext.add(carte.getListdelist().get(compteur).get(i));
				}

				fen.revalidate();
			}

			@Override
			public void componentMoved(ComponentEvent e) {

			}

			@Override
			public void componentHidden(ComponentEvent e) {

			}
		});

	}

	public void paintComponent(Graphics g) {
		try {
			Image img = ImageIO.read(getClass().getResource("investigation.jpg"));
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getNbcarte() {
		return nbcarte;
	}

	public void setNbcarte(int nbcarte) {
		this.nbcarte = nbcarte;
	}

	public JLabel getScore() {
		return score;
	}

	public void setScore(JLabel score) {
		this.score = score;
	}

	
	public void CarteMouselistener() {
		carte.getListdelist().get(compteur).get(0).addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
			
				if (opt.getBoxHard().isSelected() == true){
					actualscore = actualscore + (compteur+1)*(compteur+1)*100*(15-chrono.getListener().getSeconde())*Math.sqrt(15-chrono.getListener().getSeconde());
				
				} else {
					actualscore = actualscore + (compteur+1)*(compteur+1)*50*((30-chrono.getListener().getSeconde())/2)*Math.sqrt((30-chrono.getListener().getSeconde())/2);
					
				}

				System.out.println(chrono.getListener().getSeconde());
				score.setText(""+(int)(actualscore));
			
				
				try{
					compteur++;
				if (opt.getBoxEasy().isSelected() == true){
					for ( int i = 0 ; i < 10; i++ ){
						carte.getListdelist().get(compteur).get(i).setBounds(	carte.getListdelist().get(compteur).get(i).getX(), 	carte.getListdelist().get(compteur).get(i).getY(), fenWidth*18/1920, fenWidth*18/1920);
						panCarteext.add(	carte.getListdelist().get(compteur).get(i));
						}
				} else {
					for ( int i = 0 ; i < carte.getListdelist().get(compteur).size(); i++ ){
						carte.getListdelist().get(compteur).get(i).setBounds(	carte.getListdelist().get(compteur).get(i).getX(), 	carte.getListdelist().get(compteur).get(i).getY(), fenWidth*18/1920, fenWidth*18/1920);
						panCarteext.add(	carte.getListdelist().get(compteur).get(i));
						}
				}
				
				
				if (opt.getBoxEasy().isSelected() == true){
					for ( int i = 0 ; i < 10; i++ ){
						panCarteext.remove(	carte.getListdelist().get(compteur-1).get(i));
						}
				} else {
					for ( int i = 0 ; i < carte.getListdelist().get(compteur).size(); i++ ){
						panCarteext.remove(	carte.getListdelist().get(compteur-1).get(i));
						}
				}
				
				CarteMouselistener();
				
				
				label1.setText(carte.getQuestion().get(compteur));

				question.setText(compteur+1 + " / 10");
				panCarteext.repaint();
				} catch (Exception e1){
				Popupfindugame pop	= new Popupfindugame(fen, menu,arcade);
				pop.setAlwaysOnTop(true);
				pop.toFront();
				pop.setFocusable(true);
				pop.requestFocus();
					arcade.remove(chrono);
					arcade.repaint();
				}
				
				
			}
		});
	}

	public PanelChoixCarteArcade getChoixarcade() {
		return choixarcade;
	}

	public void setChoixarcade(PanelChoixCarteArcade choixarcade) {
		this.choixarcade = choixarcade;
	}
	public JButton getAbandon() {
		return abandon;
	}

	public void setAbandon(JButton abandon) {
		this.abandon = abandon;
	}

	public ChronoPanel getChrono() {
		return chrono;
	}

	public void setChrono(ChronoPanel chrono) {
		this.chrono = chrono;
	}
	public JLabel getQuestion() {
		return question;
	}

	public void setQuestion(JLabel question) {
		this.question = question;
	}

	public double getActualscore() {
		return actualscore;
	}

	public void setActualscore(double actualscore) {
		this.actualscore = actualscore;
	}


}
