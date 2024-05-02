package view;

import javax.swing.JFrame;

import com.formdev.flatlaf.FlatDarkLaf;

public class SwingInterface {

	public void iniciar() {
		//style
		FlatDarkLaf.setup();
		
		//Construir Frame
		JFrame frame = new JFrame("Menu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(850, 600);
		frame.setLocationRelativeTo(null);
		
		
		
		
		
		frame.setVisible(true);
	}
}
