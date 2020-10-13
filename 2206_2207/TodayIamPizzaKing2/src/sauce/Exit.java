package sauce;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Exit {
	private int x;
	private int y;
	
	private int[] exitY = {10, 152, 295, 437, 579};
	
	private Image img =  new ImageIcon("images/sauce/exit.png").getImage();

	public Exit() {
		x = 1280 - img.getWidth(null) - 5;
		y = exitY[(int)(Math.random() * 5)];
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

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}
}
