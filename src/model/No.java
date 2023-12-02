package model;

public class No {
	String nome;
	No proximo;
	No anterior;

	public No(String nome) {
		this.nome = nome;
		this.proximo = null;
		this.anterior = null;
	}

}