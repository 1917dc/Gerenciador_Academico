package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class Pessoa implements Serializable {
	private String senha;
	private String nome;
	private String cpf;

	public Pessoa(String nome, String cpf, String senha) {
		setSenha(senha);
		setNome(nome);
		setCpf(cpf);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Pessoa [senha=" + senha + ", nome=" + nome + ", cpf=" + cpf + "]";
	}
}
