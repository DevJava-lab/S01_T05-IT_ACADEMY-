package Exercici4;

import java.io.*;

public class LlegirText {

	public static void main(String[] args) {

		try {

			File fitxer = new File("llistaDirectoris.txt");
			FileReader fr = new FileReader(fitxer);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			
			while (br.readLine() != null) {

				linea = br.readLine();
				System.out.println(linea);

			}

			br.close();

		} catch (IOException e) {
			System.out.println("Error al llegir el fitxer." + e.getMessage());
		}
	}

}
