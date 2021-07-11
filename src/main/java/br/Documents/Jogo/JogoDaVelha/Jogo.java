package br.Documents.Jogo.JogoDaVelha;

public class Jogo {
	
	private static Jogo jogo;

	public static void main (String[] args) {
		setJogo(new Jogo());
	}

	public static Jogo getJogo() {
		return jogo;
	}

	public static void setJogo(Jogo jogo) {
		Jogo.jogo = jogo;
	} 
}
