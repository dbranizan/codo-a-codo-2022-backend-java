package codo.a.codo;

import java.util.Scanner;

public class Switch {

	public static void main(String[] args) {
		//lee la nota desde teclado
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingrese nota ");
		
		int nota = teclado.nextInt();
		
		switch (nota) {
		case 7:
			System.out.println("aprobado");
			break;
		case 4:
			System.out.println("desaprobado");
			break;	
		default:
			System.out.println("no se");
			break;
		}
		//cierro teclado
		teclado.close();
	}

}
