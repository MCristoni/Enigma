package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import cesarShift.CesarShift;

public class Main {

	private static BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		System.out.println("Bem vindo!");
		int opcao;
		do {
			System.out.println("Menu principal\n   [01] Criptografar\n   [02] Descriptografar\n   [00] Sair");
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
				menuDescriptografar();
				break;

			default:
				System.out.print("Opção inválida!       /\\\n\n");
				break;
			}
		} while (opcao != 00);
		scan.close();
		System.out.println("Programa encerrado!");
	}

	private static void menuDescriptografar() throws IOException {
		int opcao;
		do {
			System.out.println("\n\nMenu Descriptografar\n   [01] Criptografar\n   [02] Cifra de César\n   [00] Voltar para menu inicial");
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

	private static void menuCriptografar() {
		System.out.println("Opa fion");
		
	}

}
