package Exercici2;

import java.io.File;
import java.util.Arrays;
import java.text.SimpleDateFormat;

public class LlistaArxiusAlfabeticament {

	public static void main(String[] args) {

		File directori = new File("/Users/oscarbarberoprieto/Documents/IT_Academy_S01");

		getLlistaFitxers(directori, " ");

	}

	public static void getLlistaFitxers(File directori, String separador) {

		File[] fitxers = directori.listFiles();
		Arrays.sort(fitxers);
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		if (fitxers != null) {

			for (int x = 0; x < fitxers.length; x++) {

				if (fitxers[x].isDirectory()) {

					System.out.println(separador + fitxers[x].getName() + "  ( D ) , es va modificar : "
							+ data.format(fitxers[x].lastModified()));

					getLlistaFitxers(fitxers[x], "\t");

				} else {

					System.out.println(separador + fitxers[x].getName() + "  ( F ) , es va modificar : "
							+ data.format(fitxers[x].lastModified()));

				}

			}
		}
	}

}
