package codo.a.codo;

import java.util.Scanner;

public class Operadores {

	public static void main(String[] args) {
		// Aritmeticos
		//+ - * /  ++ --
		
		//Relacionales
		//> < != >= <=
		
		//Lógicos
		//and or not
		//&&  || !
		
		//String usuario = "root";
		//String contrasenia = "root";

		Scanner teclado = new Scanner(System.in);
		String usuario = teclado.next();
		String contrasenia = teclado.next();
		
		if ("root".equals(usuario) && "root".equals(contrasenia) ) {
			System.out.println("ok");
		}else {
			System.out.println("fail");
		}
		
		
	}

}
