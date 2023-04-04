package Exercici1;

import java.io.File;
import java.util.Arrays;

public class LlistaArxiusAlfabeticament {

	public static void main(String[] args) {

		
		File directori = new File("/");

		File[] contingut = directori.listFiles();

		Arrays.sort(contingut); 

		for (File fitxer : contingut) {
			System.out.println(fitxer);
		}
	}
}
