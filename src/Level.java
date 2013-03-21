
public class Level {
	private int nivel = 3;
	private int row = 6;
	private int col = 6;
	private String arr[][];

	public Level(int level) {
		this.nivel = level;
		arr = new String[row][col];
		crear(nivel);
		repartir();
		//printLavel();
	}
	
	private void crear(int nivel) {
		int mode = 0;
		char ch = 'a';
		int i = 0;
		
		switch(nivel) {
			case 1: mode = 6; break;
			case 2: mode = 4; break;
			case 3: mode = 2;  break;
			default: break;
		}

		for(int r = 0; r < row; r++) {
			for(int c = 0; c < col; c++) {
				i++;
				arr[r][c] = "" + ch;
				if(i % mode == 0) {
					ch++;
				}
			}
		}
	}

	private void repartir() {
		int x = 0;
		int y = 0;
		String t = "";
		
		for(int r = 0; r < row * 20; r++) {
			for(int c = 0; c < col * 20; c++) {
				x = (int)(Math.random() * 6);
				y = (int)(Math.random() * 6);
				t = arr[x][y];
				arr[x][y] = arr[y][x];
				arr[y][x] = t;
			}
		}
	}

	void printLavel() {
		for(int r = 0; r < row; r++) {
			for(int c = 0; c < col; c++) {
				System.out.print(arr[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public String[][] getArr() {
		return arr;
	}

}
