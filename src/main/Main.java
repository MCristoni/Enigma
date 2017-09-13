package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import cesarShift.CesarShift;
import letraNumero.LetraNumero;

public class Main {

	private static BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		System.out.println("Bem vindo!");
		int opcao;
		do {
			System.out.println("Menu principal\n   [01] Criptografar\n   [02] Decriptografar\n   [00] Sair");
			System.out.print("Selecione uma opção:  ");
			try {
				opcao = Integer.parseInt(scan.readLine());
			} catch (NumberFormatException e) {
				opcao = -1;
			}
			
			switch (opcao) {
			case 00:
				break;
				
			case 01:
				menuCriptografar();
				break;
				
			case 02:
				menuDecriptografar();
				break;

			default:
				System.out.print("Opção inválida!       /\\\n\n");
				break;
			}
		} while (opcao != 00);
		scan.close();
		System.out.println("Programa encerrado!");
	}

	private static void menuDecriptografar() throws IOException {
		int opcao;
		do {
			System.out.println("\n\nMenu Decriptografar\n   [01] Letra para número\n   [02] Cifra de César\n   [00] Voltar para menu inicial");
			System.out.print("Selecione uma opção:  ");
			try {
				opcao = Integer.parseInt(scan.readLine());
			} catch (NumberFormatException e) {
				opcao = -1;
			}
			
			switch (opcao) {
			case 00:
				System.out.println();
				break;
				
			case 01:
				new LetraNumero(false);
				break;
				
			case 02:
				new CesarShift(false);
				break;

			default:
				System.out.print("Opção inválida!       /\\\n\n");
				break;
			}
		} while (opcao != 00);
	}

	private static void menuCriptografar() throws IOException {
		int opcao;
		do {
			System.out.println("\n\nMenu Criptografar\n   [01] Número para letra\n   [02] Cifra de César\n   [00] Voltar para menu inicial");
			System.out.print("Selecione uma opção: ");
			try {
				opcao = Integer.parseInt(scan.readLine());
			} catch (NumberFormatException e) {
				opcao = -1;
			}
			
			switch (opcao) {
			case 00:
				System.out.println();
				break;
				
			case 01:
				new LetraNumero(true);
				break;
				
			case 02:
				new CesarShift(true);
				break;

			default:
				System.out.print("Opção inválida!       /\\\n\n");
				break;
			}
		} while (opcao != 00);
		
	}

}
