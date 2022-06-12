package codo.a.codo;

public class Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[3]; //0 a 2
		array[0] = 10;
		array[1] = 11;
		array[2] = 12;
		
		String[] nombres = new String[] {"nombre1","nombre2"};
		
		for (int i=0;i<array.length;i++) {
			System.out.println("Valor"+array[i]);
		}
		System.out.println("valor en 1: "+array[1]);
		
		//recorrer el array con for each
		for (int aux:array) {
			System.out.println(aux);
		}
	}

}
