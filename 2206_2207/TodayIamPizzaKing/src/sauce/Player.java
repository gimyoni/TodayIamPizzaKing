package sauce;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import code.Game;

public class Player extends Thread {
	private int x;
	private int y;

	public boolean left, right;

	private int floor;

	private int count = 0;

	private JLabel avatar;

	private int exitY;

	private boolean pause = false;

	private ArrayList<Beam> beamList = new ArrayList<>();

	private ImageIcon img;
	private ImageIcon standImage = new ImageIcon("images/sauce/sauceStandpizza.png");
	private ImageIcon runIamge = new ImageIcon("images/sauce/sauceRunPizza.png");
	private ImageIcon clearImage = new ImageIcon("images/sauce/sauceWithPizza.png");
	private ImageIcon deadImage = new ImageIcon("images/sauce/sauceSadPizza.png");

	SauceEnd sauceEnd;

	public Player(JLabel avatar, int exitY, Game game) {
		super();
		x = avatar.getX();
		y = avatar.getY();
		floor = 0;
		this.avatar = avatar;
		avatar.setIcon(standImage);
		this.exitY = exitY;

		sauceEnd = new SauceEnd(game);
	}

	@Override
	public void run() {
		while (true) {

			count++;

			if (left) {
				left();
			} else if (right) {
				right();
			}

			if (pause) {
				while (pause) {
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

			avatar.setLocation(x, y);
			avatar.getParent().repaint();

			try {
				sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void up() {
		if (y > 23) {
			y -= 142;
			floor--;
		}
	}

	public void down() {
		if (y < 595) {
			y += 142;
			floor++;
		}
	}

	public void left() {
		if (x > 10) {
			x -= 5;
		}
		if (count % 3 == 1) {
			img = standImage;
		} else {
			img = runIamge;
		}
		avatar.setIcon(img);
	}

	public void right() {
		if (x < 1280 - avatar.getWidth() - 10) {
			x += 5;
		}
		if (count % 3 == 1) {
			img = standImage;
		} else {
			img = runIamge;
		}
		avatar.setIcon(img);
	}

	public void checkExit() {
		if (x > 1174) {
			System.out.println("�ҽ� ȹ��");
			avatar.setIcon(clearImage);
			stop();
			for (int i = 0; i < beamList.size(); i++) {
				beamList.get(i).setStop(true);
			}
			
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter("bag.txt", true));
				bw.write("�ҽ� ");
				bw.flush();
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			sauceEnd.Success();

		}
	}

	public void dead() {
		//System.out.println("dead");
		avatar.setIcon(deadImage);
		stop();

		sauceEnd.Fail();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getFloor() {
		return floor;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}

	public ImageIcon getImg() {
		return img;
	}

	public void setImg(ImageIcon img) {
		this.img = img;
	}

	public ImageIcon getStandImage() {
		return standImage;
	}

	public void setStandImage() {
		img = standImage;
	}

	public ImageIcon getRunIamge() {
		return runIamge;
	}

	public void setRunIamge(ImageIcon runIamge) {
		this.runIamge = runIamge;
	}

	public ArrayList<Beam> getBeamList() {
		return beamList;
	}

	public void setBeamList(ArrayList<Beam> beamList) {
		this.beamList = beamList;
	}

}
