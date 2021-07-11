package br.Documents.Jogo.JogoDaVelha;

import java.util.Scanner;

public class Pessoa extends Jogador {
	public Scanner entrada = new Scanner(System.in);
	
	public Pessoa (int jogador) {
		super(jogador);
		this.jogador = jogador;
		System.out.println("Jogador 'Pessoa' criado!");
	}
	@Override
	public void jogar (Tabuleiro tabuleiro) {
		Tentativa (tabuleiro);
		tabuleiro.setPosicao (tentativa, jogador);
	}
	@Override
	public void Tentativa (Tabuleiro tabuleiro) {
		do {
			do {
				System.out.println("Linha: ");
				tentativa[0]= entrada.nextInt();
				
				if (tentativa[0] > 3 || tentativa[0] < 1)
					System.out.println("Linha inválida. Escolha 1, 2 ou 3");
				
			}while (tentativa[0] >3 || tentativa [0] < 1);
			
			do {
				System.out.print("Coluna: ");
				tentativa[1] = entrada.nextInt();
				
				if (tentativa[1] >3 || tentativa[0] <1);
				System.out.println("Coluna inválida. Escolha 1, 2 ou 3");
				
			}while (tentativa[1] > 3 || tentativa[1] < 1);
			tentativa[0]--;
			tentativa[1]--;
			
			if (!checaTentativa(tentativa, tabuleiro))
				System.out.println("Esse local já foi marcado, tente novamente");
		}while (!checaTentativa(tentativa, tabuleiro));
	}
}
     