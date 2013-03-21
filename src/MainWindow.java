import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainWindow extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private Tablero tablero;
	private JMenuBar menu_bar;
	private Thread thread;
	private JLabel label;
	private int nivel;

	public static void main(String[] args) { new MainWindow(); }

	public MainWindow() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Memorama");
		this.setSize(576,620);
		this.setResizable(false);
		this.nivel = 1;
		this.tablero = new Tablero(nivel);
		this.add(tablero, BorderLayout.CENTER);
		this.addLabel();
		
		this.addMenu();
		this.setVisible(true);
	}
	
	private void addLabel() {
		this.label = new JLabel();
		
		Runnable cronometro = new Cronometro(0,1,0, label);
		thread = new Thread(cronometro);
		thread.start();
		
		this.add(label, BorderLayout.SOUTH);
		
	}

	private void addMenu() {
		menu_bar = new JMenuBar();
		
		JMenu menu_juego = new JMenu("Juego");
		JMenu menu_nivel = new JMenu("Nivel");
		
		JMenuItem juego_nuevo = new JMenuItem("Nuevo");
		JMenuItem juego_salir = new JMenuItem("Salir");
		JMenuItem nivel_facil = new JMenuItem("Facil");
		JMenuItem nivel_intermedio = new JMenuItem("Intermedio");
		JMenuItem nivel_avanzado = new JMenuItem("Avanzado");
		
		juego_nuevo.addActionListener(this);
		juego_salir.addActionListener(this);
		nivel_facil.addActionListener(this);
		nivel_intermedio.addActionListener(this);
		nivel_avanzado.addActionListener(this);
		
		menu_juego.add(juego_nuevo);
		menu_juego.add(juego_salir);
		
		menu_nivel.add(nivel_facil);
		menu_nivel.add(nivel_intermedio);
		menu_nivel.add(nivel_avanzado);
		
		menu_bar.add(menu_juego);
		menu_bar.add(menu_nivel);
		
		this.setJMenuBar(menu_bar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem item = (JMenuItem) e.getSource();
		if(item.getText() == "Nuevo") {
			tablero.changeLevel(nivel);
			tablero.print();
		} else if(item.getText() == "Salir") { 
			this.dispose();
		} else if(item.getText() == "Facil") {
			this.nivel = 1;
			tablero.changeLevel(nivel);
			tablero.print();
		} else if(item.getText() == "Intermedio") {
			this.nivel = 2;
			tablero.changeLevel(nivel);
			tablero.print();
		} else if(item.getText() == "Avanzado") {
			this.nivel = 3;
			tablero.changeLevel(nivel);
			tablero.print();
		}
	}
}
