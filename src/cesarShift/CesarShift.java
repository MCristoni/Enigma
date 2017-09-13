package cesarShift;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CesarShift {
	private BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
	private String fraseCripto;
	private char[] padraoMin = new char[26];
	private char[] padraoMai = new char[26];
	private boolean criptografar;
	
	public CesarShift(boolean criptografar) throws IOException {
		this.criptografar = criptografar;
		apresentacao();
	}

	public void apresentacao() throws IOException {
		char repetir;
		System.out.println("\nA Cifra de César ou Cesar Shift consiste em mover cada letra do alfabeto \num número de vezes fixo para baixo ou para cima.\nExemplo:\nUma troca de 3 para baixo fará com que o A no texto normal vire D no texto cifrado,\nB vira E e assim por diante.");		
		criaPadrao();
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

	private void criptografar() throws IOException 
	{
		System.out.print("Entre com a frase a ser criptografada: ");
		fraseCripto = scan.readLine();
		int trocas = 0;
		boolean numValido = false;

		System.out.println("\nEx: -5 -> E passaria a ser A");
		System.out.println("Ex: 5 -> A passaria a ser E");
		while (!numValido)
		{
			System.out.print("Entre com o número de trocas (-25 a 25 ≠ 0): ");
			try
			{
				trocas = Integer.parseInt(scan.readLine());
				if (trocas == 0 || trocas < -25 ||trocas > 25) 
				{
					System.out.println("Número inválido! Entre com um número entre -25 e 25 com excessão do 0");
				}
				else
				{
					numValido = true;
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Entrada inválida!");
				trocas = 0;
			}
		}
		
		if (trocas < 0) 
		{
			trocas = trocas+26;
		}
		
		System.out.println("\nResultado:");
		for (int i = 0; i < fraseCripto.length(); i++) {
			if (fraseCripto.charAt(i) >= ((char)97) &&  fraseCripto.charAt(i) <= ((char)122)) {
				for (int j = 0; j < padraoMin.length; j++) {
					if (fraseCripto.charAt(i) == padraoMin[j]) 
					{
						System.out.print(padraoMin[(trocas+j)%26]);
						break;
					}
				}
			}
			else if (fraseCripto.charAt(i) >= ((char)65) && fraseCripto.charAt(i) <= ((char)90))
				{
					for (int j = 0; j < padraoMai.length; j++) {
						if (fraseCripto.charAt(i) == padraoMai[j]) 
						{
							System.out.print(padraoMai[(trocas+j)%26]);
							break;
						}
					}
				}
			else
			{
				System.out.print(fraseCripto.charAt(i));
			}
		}
		System.out.println("\n");
	}

	private void descriptografar() throws IOException {
		
		System.out.print("\nEntre com a frase a ser decriptografada: ");
		fraseCripto = scan.readLine();
		System.out.println("\nAs 25 possibilidades de troca serão mostradas.\nPressione ENTER para continuar");
		scan.readLine();
		
		for (int k = 1; k <= 25; k++) {
			for (int i = 0; i < fraseCripto.length(); i++) {
				if (fraseCripto.charAt(i) >= ((char)97) &&  fraseCripto.charAt(i) <= ((char)122)) {
						for (int j = 0; j < padraoMin.length; j++) {
							if (fraseCripto.charAt(i) == padraoMin[j]) 
							{
								System.out.print(padraoMin[(k+j)%26]);
								break;
							}
						}
				}
				else if (fraseCripto.charAt(i) >= ((char)65) && fraseCripto.charAt(i) <= ((char)90))
					{
						for (int j = 0; j < padraoMai.length; j++) {
							if (fraseCripto.charAt(i) == padraoMai[j]) 
							{
								System.out.print(padraoMai[(k+j)%26]);
								break;
							}
						}
					}
				else
				{
					System.out.print(fraseCripto.charAt(i));
				}
			}
			System.out.print(" -> +" + k +"\n");
		}
	}

	private void criaPadrao() {
		for (int i = 0; i < 26; i++) {
			padraoMin[i] = (char)(97+i);
			padraoMai[i] = (char)(65+i);
			//System.out.println("pos: " + i + padrao[i]);
		}
	}
	
}
