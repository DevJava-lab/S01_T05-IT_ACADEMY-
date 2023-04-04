package Exercici5;

import java.io.*;

public class ObjecteSerial {

	public static void main(String[] args) {

		escriureBinari();
		llegirBinari();

	}

	public static void escriureBinari() {

		Persona p1 = new Persona("Josep", 44);
		Persona p2 = new Persona("Maria", 21);
		Persona p3 = new Persona("Ruth", 36);

		try {

			FileOutputStream arxiu = new FileOutputStream("binaris.ser");
			ObjectOutputStream sortida = new ObjectOutputStream(arxiu);


			sortida.writeObject(p1);
			sortida.writeObject(p2);
			sortida.writeObject(p3);

			sortida.close();
			arxiu.close();

		} catch (FileNotFoundException e) {
			System.out.println("Error : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error : " + e.getMessage());
		}
	}

	public static void llegirBinari() {
		Persona p;
		try {

			FileInputStream arxiu = new FileInputStream("binaris.ser");
			ObjectInputStream sortida= new ObjectInputStream(arxiu);
			
			while (sortida != null) {
				p = (Persona) sortida.readObject();
				System.out.println(p.toString());
			}
			
			sortida.close();
			arxiu.close();
			
		} catch (EOFException ex) {
			return;  // Per quan acaba de llegir l'arxiu binari
		} catch (FileNotFoundException e) {
			System.out.println("Error : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error : " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Error : " + e.getMessage());
		}

	}
}
