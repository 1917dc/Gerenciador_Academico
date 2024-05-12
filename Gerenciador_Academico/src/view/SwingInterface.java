package view;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import controller.ChecarLogin;

public class SwingInterface {
	ChecarLogin checarLogin;
	
	public SwingInterface() {
		this.checarLogin = new ChecarLogin();
	}

	public void iniciar() {
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
				if (checarLogin.checarTipo()) {
                    ConstrutorDeComponentes.criarFrameLogadoAluno(checarLogin.getPessoaLogada().getNome());
                } else {
                	ConstrutorDeComponentes.criarFrameLogadoProfessor(checarLogin.getPessoaLogada().getNome());
                }
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
}
