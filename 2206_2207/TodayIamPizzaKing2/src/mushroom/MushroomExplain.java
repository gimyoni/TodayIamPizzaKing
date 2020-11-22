package mushroom;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import code.Game;

public class MushroomExplain extends JDialog{

	Game game;
	
	private ImageIcon explainImg = new ImageIcon("images/mushroom/mushExplain.png");
	
	
	public JButton mushGameBtn = new JButton();
	JPanel jp;
	JLabel back;
	
	
	public MushroomExplain(Game game) {
		//setLayout(null);
		//setBounds((1280/2)-(explainImg.getWidth(null)/2) , (720/2)-(explainImg.getHeight(null)/2), 900, 600);
		setTitle("Mushroom Stage Explain");
		setSize(915, 645);
		setLocationRelativeTo(null);	
		setModal(true);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		this.game = game;
		
		jp = new JPanel();
		
		jp.setLayout(null);
		jp.setBounds(0,0, 900, 600);
		
		back = new JLabel(explainImg);
		back.setBounds(0,0, 900, 600);
		jp.add(back);
		
		mushGameBtn.setVisible(true);
		mushGameBtn.setBounds(525, 460, 328, 92);
		mushGameBtn.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				game.stageSelectPanel.setVisible(false);
				game.mushroomPanel.setVisible(true);
				game.mushroomPanel.setFocusable(true);	
				game.mushroomPanel.requestFocus();
				game.mushroomPanel.startGame();
				
			}
		});
		jp.add(mushGameBtn);
		
		mushGameBtn.setBorderPainted(false);
		mushGameBtn.setContentAreaFilled(false);
		
		add(jp);
		jp.setVisible(true);
	}

	/*
	 * @Override public void paintComponent(Graphics g) { super.paintComponent(g);
	 * g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null); }
	 */

}