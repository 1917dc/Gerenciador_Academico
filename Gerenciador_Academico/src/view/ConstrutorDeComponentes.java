package view;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class ConstrutorDeComponentes {
	
	
	//funcao para criar textFields, ela retorna apenas o text field. Por padrão 
	//o text field é acompanhado por um label, o posicionamento do label esta 
	//no parametro da funcao
	//o posicionamento do text field é somar x ao x do label
	public static JTextField criarTextField(String lbl, int x, int y, JPanel painel) {
		painel.add(new JLabel(lbl), posicionar(x, y));
		
        JTextField textField = new JTextField(20);		
        painel.add(textField, posicionar(x+1, y));
		
		return textField;
    }
	
	public static GridBagConstraints posicionar(int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.insets = new Insets(5, 5, 5, 5);
        return gbc;
    }
}
