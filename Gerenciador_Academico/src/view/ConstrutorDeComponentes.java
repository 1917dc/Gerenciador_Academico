package view;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.DisciplinasDAO;

public abstract class ConstrutorDeComponentes {
	static DisciplinasDAO disciplinasDAO = new DisciplinasDAO();
	
	static ImageIcon img = new ImageIcon("D:\\DownloadsHD\\download.png");
	
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

	public static JFrame criarFrameLogadoAluno(String pessoaLogadaNome) {
		JFrame frameLogadoAluno = new JFrame("Bem-vindo " + pessoaLogadaNome);
		frameLogadoAluno.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frameLogadoAluno.setIconImage(img.getImage());
		frameLogadoAluno.setSize(800, 600);
		frameLogadoAluno.setLocationRelativeTo(null);
		
		JPanel painelLogadoAluno = new JPanel(new GridBagLayout());
		JLabel labelTabelaMaterias = new JLabel("Disciplinas inscritas: ");
		
		Object[][] dados = disciplinasDAO.getDisciplinasParaTabela(pessoaLogadaNome);
		String[] colunas = {"Disciplinas", "Professor", "Nota", "Horário"};
		JTable tabelaMaterias = new JTable(dados, colunas);
		
		JScrollPane scrollPane = new JScrollPane(tabelaMaterias);
		painelLogadoAluno.add(labelTabelaMaterias, posicionar(0, 0));
		painelLogadoAluno.add(scrollPane, posicionar(0, 1));
		
		JPanel painelBotoes = new JPanel(new GridBagLayout());
		JButton botaoInscricao = new JButton("Inscrever-se em disciplinas");
		//JButton botaoHistorico = new JButton("Ver histórico");
		JButton botaoFeedback = new JButton("Feedback");
		JButton botaoSair = new JButton("Sair");
		
		botaoFeedback.addActionListener(e -> {
			String titulo = JOptionPane.showInputDialog(null, "Digite o título do feedback: ", "Feedback", JOptionPane.PLAIN_MESSAGE);
			String corpo = JOptionPane.showInputDialog(null, "Digite o corpo do feedback: ", "Feedback", JOptionPane.PLAIN_MESSAGE);
			
			disciplinasDAO.addFeedback(pessoaLogadaNome, titulo, corpo, tabelaMaterias.getValueAt(tabelaMaterias.getSelectedRow(), 1).toString());
		});
		
		botaoInscricao.addActionListener(e -> {
			frameLogadoAluno.dispose();
			criarFrameInscricao(pessoaLogadaNome);
		});
		
		botaoSair.addActionListener(e -> {
			frameLogadoAluno.dispose();
			new SwingInterface().iniciar();
		});
		
		painelBotoes.add(botaoInscricao, posicionar(0, 2));
		painelBotoes.add(botaoFeedback, posicionar(1, 2));
		//painelBotoes.add(botaoHistorico, posicionar(1, 2));
		painelBotoes.add(botaoSair, posicionar(2, 2));
		
		painelLogadoAluno.add(painelBotoes, posicionar(0, 2));
		frameLogadoAluno.add(painelLogadoAluno);
		
		frameLogadoAluno.setVisible(true);
		
		return frameLogadoAluno;
	}

	public static JFrame criarFrameLogadoProfessor(String pessoaLogadaNome) {
		JFrame frameLogadoProfessor = new JFrame("Bem-vindo(a) " + pessoaLogadaNome);
		frameLogadoProfessor.setLayout(new GridBagLayout());
		frameLogadoProfessor.setIconImage(img.getImage());
		frameLogadoProfessor.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frameLogadoProfessor.setSize(800, 600);
		frameLogadoProfessor.setLocationRelativeTo(null);

		JButton buttonRegistrarNotas = new JButton("Registrar notas");
		JButton botaoCronograma = new JButton("Cronograma");
		JButton botaoFeedbacks = new JButton("Ver feedbacks");
		
		botaoFeedbacks.addActionListener(e -> {
			frameLogadoProfessor.dispose();
			criarFrameFeedback(pessoaLogadaNome);
		});

		buttonRegistrarNotas.addActionListener(e -> {
			criarFrameRegistrarNotas(pessoaLogadaNome);
			frameLogadoProfessor.dispose();
		});
		botaoCronograma.addActionListener(e -> {
			frameLogadoProfessor.dispose();
			criarFrameCronograma(pessoaLogadaNome);
		});
		
		JButton buttonSair = new JButton("Sair");
		buttonSair.addActionListener(e -> {
			frameLogadoProfessor.dispose();
			new SwingInterface().iniciar();
		});

		frameLogadoProfessor.add(buttonRegistrarNotas, posicionar(0, 0));
		frameLogadoProfessor.add(botaoCronograma, posicionar(0, 1));
		frameLogadoProfessor.add(buttonSair, posicionar(0, 2));
		frameLogadoProfessor.add(botaoFeedbacks, posicionar(0, 3));
		frameLogadoProfessor.setVisible(true);
		return frameLogadoProfessor;
	}

	private static void criarFrameFeedback(String pessoaLogadaNome) {
		JFrame frameFeedback = new JFrame("Feedbacks");
		frameFeedback.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frameFeedback.setIconImage(img.getImage());
		frameFeedback.setSize(800, 600);
		frameFeedback.setLocationRelativeTo(null);
		frameFeedback.setLayout(new GridBagLayout());
		
		JPanel painelFeedback = new JPanel(new GridBagLayout());
		JLabel labelTabelaFeedback = new JLabel("Feedbacks: ");
		Object[][] dados = disciplinasDAO.getFeedbacks(pessoaLogadaNome);
		String[] colunas = {"Aluno", "Feedback"};
		JTable tabelaFeedback = new JTable(dados, colunas);
		JScrollPane scrollPane = new JScrollPane(tabelaFeedback);
		
		JButton botaoAbrirFeedbacks = new JButton("Detalhar feedback");
		botaoAbrirFeedbacks.addActionListener(e -> {
			String corpo = disciplinasDAO.getFeedbackBody(tabelaFeedback.getSelectedRow());
			corpo = "<html><body><p style='width: 200px;'>" + corpo + "</p></body></html>";
			JOptionPane.showMessageDialog(null, corpo, "Feedback:", JOptionPane.PLAIN_MESSAGE);
			
		});
		
		JButton botaoSair = new JButton("Sair");
		botaoSair.addActionListener(e -> {
			frameFeedback.dispose();
			criarFrameLogadoProfessor(pessoaLogadaNome);
		});
		
		painelFeedback.add(labelTabelaFeedback, posicionar(0, 0));
		painelFeedback.add(scrollPane, posicionar(0, 1));
		painelFeedback.add(botaoAbrirFeedbacks, posicionar(0, 2));
		painelFeedback.add(botaoSair, posicionar(0, 3));		
		
		frameFeedback.add(painelFeedback);
		
		frameFeedback.setVisible(true);
	}

	private static JFrame criarFrameRegistrarNotas(String pessoaLogadaNome){
		String pessoaLogadaCpf = disciplinasDAO.getCpfProfessor(pessoaLogadaNome);
		String[] disciplinas = disciplinasDAO.getDisciplinasProfessor(pessoaLogadaCpf);

		JFrame frameRegistrarNotas = new JFrame("Registrar notas");
		frameRegistrarNotas.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frameRegistrarNotas.setIconImage(img.getImage());
		frameRegistrarNotas.setSize(800, 600);
		frameRegistrarNotas.setLocationRelativeTo(null);

		JPanel painelRegistrarNotas = new JPanel(new GridBagLayout());
		JLabel labelTabelaMaterias = new JLabel("Selecione uma disciplina: ");
		JButton botaoRegistrar = new JButton("Registrar");
		JButton botaoSair = new JButton("Sair");
		botaoSair.addActionListener(e -> {
			frameRegistrarNotas.dispose();
			criarFrameLogadoProfessor(pessoaLogadaNome);
		});

		JComboBox<String> comboBoxDisciplinas = new JComboBox<String>(disciplinas);

		painelRegistrarNotas.add(labelTabelaMaterias, posicionar(0, 0));
		painelRegistrarNotas.add(comboBoxDisciplinas, posicionar(0, 1));
		painelRegistrarNotas.add(botaoRegistrar, posicionar(0, 2));
		painelRegistrarNotas.add(botaoSair, posicionar(0, 3));

		botaoRegistrar.addActionListener(e -> {
			frameRegistrarNotas.dispose();
			frameRegistrarNotas(comboBoxDisciplinas, pessoaLogadaNome);
		});

		frameRegistrarNotas.add(painelRegistrarNotas);
		frameRegistrarNotas.setVisible(true);
		return frameRegistrarNotas;
	}

	private static JFrame criarFrameCronograma(String pessoaLogadaNome) {
		JFrame frameCronograma = new JFrame("Cronograma");
		frameCronograma.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frameCronograma.setIconImage(img.getImage());
		frameCronograma.setSize(800, 600);
		frameCronograma.setLocationRelativeTo(null);

		JButton botaoSair = new JButton("Sair");
		botaoSair.addActionListener(e -> {
			frameCronograma.dispose();
			criarFrameLogadoProfessor(pessoaLogadaNome);
		});

		JPanel painelCronograma = new JPanel(new GridBagLayout());
		JLabel labelTabelaMaterias = new JLabel("Disciplinas ministradas: ");
		Object[][] dados = disciplinasDAO.getDisciplinasParaTabelaProfessor(pessoaLogadaNome);
		String[] colunas = {"Disciplinas", "Horário", "Sala"};
		JTable tabelaMaterias = new JTable(dados, colunas);

		JScrollPane scrollPane = new JScrollPane(tabelaMaterias);
		painelCronograma.add(labelTabelaMaterias, posicionar(0, 0));
		painelCronograma.add(scrollPane, posicionar(0, 1));
		painelCronograma.add(botaoSair, posicionar(0, 2));

		frameCronograma.add(painelCronograma);
		frameCronograma.setVisible(true);
		return frameCronograma;
	}

	public static JFrame frameRegistrarNotas(JComboBox<String> comboBoxDisciplinas, String pessoaLogadaNome){
		String disciplinaSelecionada = (String) comboBoxDisciplinas.getSelectedItem();
		JFrame frameRegistrarNotasDisciplina = new JFrame("Registrar notas de " + disciplinaSelecionada);
		frameRegistrarNotasDisciplina.setIconImage(img.getImage());
		frameRegistrarNotasDisciplina.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frameRegistrarNotasDisciplina.setSize(800, 600);
		frameRegistrarNotasDisciplina.setLocationRelativeTo(null);

		JPanel painelRegistrarNotasDisciplina = new JPanel(new GridBagLayout());
		JLabel labelTabelaAlunos = new JLabel("Alunos inscritos: ");

		Object[][] dados = disciplinasDAO.getDisciplinasParaTabelaProfessorNotas(pessoaLogadaNome, disciplinaSelecionada);
		String[] colunas = {"Aluno", "Nota", "CPF"};
		JTable tabelaMaterias = new JTable(dados, colunas);

		JPanel painelBotoes = new JPanel(new GridBagLayout());
		JButton botaoEditar = new JButton("Editar");
		JButton botaoSair = new JButton("Sair");

		botaoSair.addActionListener(e -> {
			frameRegistrarNotasDisciplina.dispose();
			criarFrameLogadoProfessor(pessoaLogadaNome);
		});
		botaoEditar.addActionListener(e -> {
			criarFrameEditarNota(tabelaMaterias.getSelectedRow(), dados, disciplinaSelecionada, tabelaMaterias, pessoaLogadaNome);
		});

		painelRegistrarNotasDisciplina.add(labelTabelaAlunos, posicionar(0, 0));
		painelRegistrarNotasDisciplina.add(new JScrollPane(tabelaMaterias), posicionar(0, 1));
		painelBotoes.add(botaoEditar, posicionar(0, 2));
		painelBotoes.add(botaoSair, posicionar(1, 2));

		painelRegistrarNotasDisciplina.add(painelBotoes, posicionar(0, 2));
		frameRegistrarNotasDisciplina.add(painelRegistrarNotasDisciplina);
		frameRegistrarNotasDisciplina.setVisible(true);
		return frameRegistrarNotasDisciplina;
	}

	private static JFrame criarFrameEditarNota(int selectedRow, Object[][] dados, String disciplinaSelecionada, JTable tabelaMaterias, String pessoaLogadaNome) {
		JFrame frameEditarNota = new JFrame("Editar nota");
		frameEditarNota.setIconImage(img.getImage());
		frameEditarNota.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frameEditarNota.setSize(800, 600);
		frameEditarNota.setLocationRelativeTo(null);

		JPanel painelEditarNota = new JPanel(new GridBagLayout());
		JLabel labelNota = new JLabel("Nota: ");
		JTextField textFieldNota = new JTextField(20);
		JLabel labelAluno = new JLabel("Aluno: " + dados[selectedRow][0]);
		JButton botaoSalvar = new JButton("Salvar");

		painelEditarNota.add(labelAluno, posicionar(0, 0));
		painelEditarNota.add(labelNota, posicionar(0, 1));
		painelEditarNota.add(textFieldNota, posicionar(1, 1));
		painelEditarNota.add(botaoSalvar, posicionar(0, 2));

		botaoSalvar.addActionListener(e -> {
			frameEditarNota.dispose();
			DisciplinasDAO.save(dados[selectedRow][2].toString(), disciplinaSelecionada, Double.valueOf(textFieldNota.getText()));
			tabelaMaterias.setModel(new DefaultTableModel(disciplinasDAO.getDisciplinasParaTabelaProfessorNotas(pessoaLogadaNome, disciplinaSelecionada), new String[]{"Aluno", "Nota", "CPF"}));
		});

		frameEditarNota.add(painelEditarNota);
		frameEditarNota.setVisible(true);
		return frameEditarNota;
	}
	
	public static void criarFrameInscricao(String pessoaLogadaNome) {
		JFrame frameInscricao = new JFrame("Inscrição em disciplinas");
		frameInscricao.setIconImage(img.getImage());
		frameInscricao.setLayout(new GridBagLayout());
		frameInscricao.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameInscricao.setSize(800, 600);
		frameInscricao.setLocationRelativeTo(null);
		
		JPanel painelInscricao = new JPanel(new GridBagLayout());
		JLabel labelTabelaMaterias = new JLabel("Disciplinas disponíveis: ");
		Object[][] dados = disciplinasDAO.getDisciplinasParaTabelaInscricao(pessoaLogadaNome);
		String[] colunas = {"Disciplinas", "Professor", "Horário"};
		JTable tabelaMaterias = new JTable(dados, colunas);
		JScrollPane scrollPane = new JScrollPane(tabelaMaterias);
		
		JButton botaoInscricao = new JButton("Inscrever-se");
		JButton botaoSair = new JButton("Sair");
		
		botaoInscricao.addActionListener(e -> {
			frameInscricao.dispose();
			disciplinasDAO.inscreverAluno(pessoaLogadaNome,
					(String) tabelaMaterias.getValueAt(tabelaMaterias.getSelectedRow(), 0));
			criarFrameLogadoAluno(pessoaLogadaNome);
		});
		
		botaoSair.addActionListener(e -> {
			frameInscricao.dispose();
			criarFrameLogadoAluno(pessoaLogadaNome);
		});
		
		painelInscricao.add(labelTabelaMaterias, posicionar(0, 0));
		painelInscricao.add(scrollPane, posicionar(0, 1));
		painelInscricao.add(botaoInscricao, posicionar(0, 2));
		painelInscricao.add(botaoSair, posicionar(1, 2));
		
		frameInscricao.add(painelInscricao);
		
		frameInscricao.setVisible(true);
	}
}
