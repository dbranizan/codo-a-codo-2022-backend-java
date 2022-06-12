package codo.a.codo;

public class While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int contador = 10;
		
		while (contador >= 0) {
			System.out.println("Contador: "+contador);
			
			if (contador == 3) {
				break; //corta la ejecucion, sale del loop
				//otra opcion es
				//continue; //no ejecuta las lineas que siguen, no hace el decremento
				//se mete en un loop infinito porque a partir de que valga 3
				//ya no decrementa
			}
			contador--;
		}
		
		while (contador >= 0) {
			System.out.println("Contador: "+contador);
			
			if (contador % 2 == 0) { //par o impar
				System.out.println("Contador par");
			} else {
				System.out.println("Contador impar");
			}
			contador--;
		}
	}

}
