package Exercici3;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class LlistaDirectoris {

	public static void main(String[] args) throws IOException {

			File directori = new File("/Users/oscarbarberoprieto/Documents/IT_Academy_BackUp");
			FileWriter fw = new FileWriter("llistaDirectoris.txt");
			PrintWriter pw = new PrintWriter(fw);

			llistaRecursiva(directori, pw, 0);
			pw.close();

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
}
