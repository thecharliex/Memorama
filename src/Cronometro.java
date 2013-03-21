import javax.swing.JLabel;


public class Cronometro implements Runnable {
	private int hh;
	private int mm;
	private int ss;
	private JLabel label;

	public Cronometro(int hh, int mm, int ss) {
		this.hh = hh;
		this.mm = mm;
		this.ss = ss;
	}

	public Cronometro(int hh, int mm, int ss, JLabel label) {
		this.hh = hh;
		this.mm = mm;
		this.ss = ss;
		this.label = label;
	}

	@Override
	public void run() {
		
		try {
			while(hh != 0 || mm != 0 || ss != 0) {				
				label.setText(hh + ":" + mm + ":" + ss);
				ss--;
				Thread.sleep(1000);
				if(ss == -1) {
					mm--;
					ss = 59;					
				}
				
				if(mm == -1) {
					hh--;
					mm = 59;
				}
			}
			
			label.setText(hh + ":" + mm + ":" + ss);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return hh + ":" + mm + ":" + ss;
	}
}
