package br.Documents.Jogo.JogoDaVelha;

import java.util.Scanner;

public class jogodavelha {
	private Tabuleiro tabuleiro;
	private int rodada=1, vez=1;
	private Jogador jogador1;
	private Jogador jogador2;
	public Scanner entrada = new Scanner (System.in);
	
	
	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}
	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
	public int getRodada() {
		return rodada;
	}
	public void setRodada(int rodada) {
		this.rodada = rodada;
	}
	public int getVez() {
		return vez;
	}
	public void setVez(int vez) {
		this.vez = vez;
	}
	public Jogador getJogador1() {
		return jogador1;
	}
	public void setJogador1(Jogador jogador1) {
		this.jogador1 = jogador1;
	}
	public Jogador getJogador2() {
		return jogador2;
	}
	public void setJogador2(Jogador jogador2) {
		this.jogador2 = jogador2;
	}
	public Scanner getEntrada() {
		return entrada;
	}
	public void setEntrada(Scanner entrada) {
		this.entrada = entrada;
	}
	
	
	public void Jogo() {
		tabuleiro = new Tabuleiro(rodada);
		iniciarJogadores();
		
		while(Jogar());
	}
	public void iniciarJogadores() {
		System.out.println("Quem será o jogador 1?");
		if (escolherJogador () == 1)
			this.jogador1 = new Pessoa(1);
		else 
			this.jogador1 = new Computador(1);
		
		System.out.println("Quem será o jogador 2?");
		if (escolherJogador() == 1)
			this.jogador2 = new Pessoa(2);
		else 
			this.jogador2 = new Computador(2);
	}
	
	public int escolherJogador() {
		int opcao = 0;
		
		do {
			System.out.println("1. Pessoa");
			System.out.println("2. Computador\n");
			System.out.println("Opcao: ");
			opcao = entrada.nextInt();
			
			if (opcao != 1 && opcao != 2)
				System.out.println("Opção inválida! Tente novamente");
		}while (opcao != 1 && opcao != 2);
			
		return opcao;
		}
	public boolean Jogar () {
		if (ganhou () == 0) {
			System.out.println("\nRodada " + rodada);
			System.out.println("É a vez do jogador " + vez());
			
			if (vez() == 1)
				jogador1.jogar (tabuleiro);
			else 
				jogador2.jogar (tabuleiro);
		}
		else if (tabuleiro.tabuleiroCompleto()) {
			System.out.println("Tabuleiro completo. Jogo empatado");
			return false;
		}
		
		vez++;
		rodada++;
		
		if (ganhou() == -1) {
			System.out.println("Jogador 1 venceu!!!");
		}
		else {
			System.out.println("Jogador 2 venceu!!!");
		}
	
		return false;
	}
	
	public int vez () {
		if (vez%2 == 1)
			return 1;
		else
			return 2;
	}
	
	public int ganhou() {
		if (tabuleiro.checaLinhas() == 1)
			return 1;
		if (tabuleiro.checaColunas() == 1)
			return 1;
		if (tabuleiro.checaDiagonais() == 1)
			return 1;
		
		if (tabuleiro.checaLinhas() == -1)
			return -1;
		if (tabuleiro.checaColunas() == -1)
			return -1;
		if (tabuleiro.checaDiagonais() == -1)
			return -1;
		
		return 0;

	}
}