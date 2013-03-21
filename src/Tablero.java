import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;


public class Tablero extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private Level level;
	private String[][] map;
	private EventManager manager;
	private int row;
	private int col;
	private GridLayout grid;
	private Carta[][] carta;

	public Tablero(int n) {
		this.row = 6;
		this.col = 6;
		this.level = new Level(n);
		this.map = level.getArr();
		this.manager = new EventManager();
		this.grid = new GridLayout(row, col);
		this.carta = new Carta[row][col];
		
		this.setLayout(grid);
		
		for(int r = 0; r < row; r++) {
			for(int c = 0; c < col; c++) {
				carta[r][c] = new Carta(map[r][c]);
				carta[r][c].addActionListener(manager);				
				this.add(carta[r][c]);
			}
		}
	}
	
	private class EventManager implements ActionListener {
		private Carta a;
		private Carta b;
		private int turno;
		
		public EventManager() {
			a = null;
			b = null;
			this.turno = 0;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			++turno;
			
			if(turno == 1) {
				a = (Carta) e.getSource();
				a.up();
			} else if(turno == 2) {
				b = (Carta) e.getSource();
				b.up();
				
				System.out.println(a.getType());
				System.out.println(b.getType());
				
				if(a.getType().equalsIgnoreCase(b.getType())) {
					System.out.println("Son iguales.");
				} else {
					System.out.println("Son distintos.");
					try {
						Thread.sleep(1000);
						a.down();
						b.down();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				a = null;
				b = null;
				
				turno = 0;
			}
		}
		
	}

	public void print() {
		level.printLavel();
		
	}
	
	public void changeLevel(int n) {
		this.level = new Level(n);
		this.map = level.getArr();
		
		for(int r = 0; r < row; r++) {
			for(int c = 0; c < col; c++) {
				carta[r][c].setType(map[r][c]);			
				this.add(carta[r][c]);
			}
		}
	}

}
