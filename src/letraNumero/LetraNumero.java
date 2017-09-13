package letraNumero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LetraNumero {

	private BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
	private boolean criptografar;
	private String fraseCripto;

	public LetraNumero(boolean criptografar) throws IOException {
		this.criptografar = criptografar;
		apresentacao();
	}
	
	public void apresentacao() throws IOException {
		char repetir;
		System.out.println("\nEssa cifra consiste em trocar as letras por suas posições no Alfabeto\nEx: A = 1, B = 2, ...");
		do {
			if (criptografar) {
				criptografar();
			} else {
				descriptografar();
			}
			System.out.print("Deseja fazer novamente? (S/N) ");
			repetir = scan.readLine().toLowerCase().charAt(0);
		} while (repetir == 'y' || repetir == 's' );
	}

	//todo: Cobrir caso de números
	//todo: Cobrir caso o separador informado esteja errado
	private void descriptografar() throws IOException
	{
		System.out.print("Entre com a frase a ser decriptografada: ");
		fraseCripto = scan.readLine();
		System.out.print("Qual foi o separador utilizado (caracter entre os números)? ");
		char separacao = scan.readLine().charAt(0);
		
		String[] palavras = fraseCripto.split(" ");
		for (int i = 0; i < palavras.length; i++) 
		{
			String[] letras = palavras[i].split(separacao+"");
			for (int j = 0; j < letras.length; j++) 
			{
				try 
				{
					System.out.print((char)(Integer.parseInt(letras[j])+96));
				} 
				catch (Exception e) 
				{
					System.out.print(letras[j]);
				}
			}
			System.out.print(" ");
		}
		System.out.println();
	}

	private void criptografar() throws IOException
	{
		System.out.print("Entre com a frase a ser criptografada: ");
		fraseCripto = scan.readLine().toLowerCase();
		char separacao = ' ';
		boolean sepValida = false;

		System.out.println("\nExemplos de separador: -,_,=,|");
		while (!sepValida)
		{
			System.out.print("Entre com o separador desejado: ");
			separacao = scan.readLine().charAt(0);
			if (separacao != '-' && separacao != '=' && separacao != '_' && separacao != '|') 
			{
				System.out.println("Separador inválido! Entre com - ou = ou _ ou |");
			}
			else
			{
				sepValida = true;
			}
		}
		
		System.out.println("\nResultado:");
		for (int i = 0; i < fraseCripto.length(); i++) {
			if (fraseCripto.charAt(i) >= ((char)97) &&  fraseCripto.charAt(i) <= ((char)122)) 
			{
				System.out.print(((int)fraseCripto.charAt(i))-96);
			}
			else if(fraseCripto.charAt(i) >= ((char)224) &&  fraseCripto.charAt(i) <= ((char)229))
			{
				System.out.print((int)'a'-96);
			}
			else if(fraseCripto.charAt(i) >= ((char)232) &&  fraseCripto.charAt(i) <= ((char)235))
			{
				System.out.print((int)'e'-96);
			}
			else if(fraseCripto.charAt(i) >= ((char)236) &&  fraseCripto.charAt(i) <= ((char)239))
			{
				System.out.print((int)'i'-96);
			}
			else if(fraseCripto.charAt(i) >= ((char)242) &&  fraseCripto.charAt(i) <= ((char)248))
			{
				System.out.print((int)'o'-96);
			}
			else if(fraseCripto.charAt(i) >= ((char)249) &&  fraseCripto.charAt(i) <= ((char)252))
			{
				System.out.print((int)'u'-96);
			}
			else if(fraseCripto.charAt(i) >= ((char)48) && fraseCripto.charAt(i) <= ((char)57))
			{
				System.out.print((int)fraseCripto.charAt(i));
			}
			else
			{
				System.out.print(fraseCripto.charAt(i));
			}
			
			if (i != fraseCripto.length()-1 && fraseCripto.charAt(i+1) != ' ' && fraseCripto.charAt(i) != ' ') 
			{
				System.out.print(separacao);
			}
		}
		System.out.println("\n");
	}
}
