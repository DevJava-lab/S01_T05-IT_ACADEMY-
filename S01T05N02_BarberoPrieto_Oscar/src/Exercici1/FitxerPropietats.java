package Exercici1;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Properties;

public class FitxerPropietats {

	public static void main(String[] args) {

		crearArxiuPropietats();

		try {

			Properties propietats = new Properties();
			FileReader entrada = new FileReader("dades.properties");

			propietats.load(entrada);

			llistaRecursiva(new File(propietats.getProperty("directori")),
					new PrintWriter(new FileWriter(propietats.getProperty("nomArxiu"))), 0);

		} catch (FileNotFoundException e) {
			System.out.println("Error : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error : " + e.getMessage());
		}

	}

	public static void llistaRecursiva(File directori, PrintWriter pw, int nivell) throws IOException {

		String[] contingutDirectori = directori.list();
		Arrays.sort(contingutDirectori);
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");

		for (String nom : contingutDirectori) {

			File fitxer = new File(directori, nom);

			for (int i = 0; i < nivell; i++) {
				pw.print("\t");
			}

			if (fitxer.isDirectory()) {

				pw.println(nom + " (D) " + data.format(fitxer.lastModified()));
				llistaRecursiva(fitxer, pw, nivell + 1);

			} else {
				pw.println(nom + " (F) " + data.format(fitxer.lastModified()));
			}
		}
	}

	public static void crearArxiuPropietats() {

		try {
			Properties propietats = new Properties();

			propietats.setProperty("directori", "/Users/oscarbarberoprieto/Documents/IT_Academy_BackUp");
			propietats.setProperty("nomArxiu", "llistaDirectoris.txt");

			FileWriter fw = new FileWriter("dades.properties");
			propietats.store(fw, "Dades de l'App");

		} catch (FileNotFoundException e) {
			System.out.println("Error : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error : " + e.getMessage());
		}
	}
}
