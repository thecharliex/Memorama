import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Carta extends JButton {
	private static final long serialVersionUID = 1L;
	
	private String type;
	public boolean reverse = true;

	public Carta(String type) {
		this.type = type;
		this.setIcon(new ImageIcon("img/z.png"));
		this.setFocusable(false);
		this.setBackground(Color.LIGHT_GRAY);
		this.setBorderPainted(false);
	}
	
	public void up() {
		this.setIcon(new ImageIcon("img/"+ type +".png"));
	}
	
	public void down() {
		this.setIcon(new ImageIcon("img/z.png"));
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
		this.setIcon(new ImageIcon("img/z.png"));
	}
}
