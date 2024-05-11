package view;

<<<<<<< Updated upstream
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
=======
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.formdev.flatlaf.FlatDarculaLaf;

import controller.ChecarLogin;

public class SwingInterface {
	ChecarLogin checarLogin;
	
	public SwingInterface() {
		this.checarLogin = new ChecarLogin();
	}

	public void iniciar() {
		FlatDarculaLaf.setup();
		
        JFrame frameLogin = new JFrame("Login e cadastro");		
        frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLogin.setSize(400, 300);
        frameLogin.setLocationRelativeTo(null);
        
        JPanel painelLoginForm = new JPanel(new GridBagLayout());
        JTextField cpf = ConstrutorDeComponentes.criarTextField("CPF:", 0, 0, painelLoginForm);
        JTextField senha = ConstrutorDeComponentes.criarTextField("Senha:", 0, 1, painelLoginForm);
        
        JButton botaoLogin = new JButton("Login");
        botaoLogin.addActionListener(e -> {
			if (checarLogin.logar(cpf.getText(), senha.getText())) {
				frameLogin.dispose();
			}
        });
        painelLoginForm.add(botaoLogin, ConstrutorDeComponentes.posicionar(0, 2));
        
        JPanel panelCadastroForm = new JPanel(new GridBagLayout());
        
        
        JTabbedPane tabby = new JTabbedPane();
        tabby.addTab("Login", painelLoginForm);
        tabby.addTab("Cadastro", panelCadastroForm);
        frameLogin.add(tabby);
        
        frameLogin.setVisible(true);
	}
	
>>>>>>> Stashed changes
}
