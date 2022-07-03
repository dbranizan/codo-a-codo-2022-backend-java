package OOP;

public class FabricaDeAutos {

	public static void main(String[] args) {
		//creamos el primer objeto de la clase auto
		//constructor
		Auto fiatUno = new Auto(300f,"AUTO",new Motor("motor",300f));
		System.out.println("");
		fiatUno.encender(); // f3 para ver el cod del metodo
		
		System.out.println("Acelerando");
		fiatUno.acelerar();
		fiatUno.verVelocidad();
		fiatUno.acelerar();
		fiatUno.verVelocidad();
		fiatUno.acelerar();
		fiatUno.verVelocidad();
		System.out.println("Frenando");
		fiatUno.frenar();
		System.out.println("Apagando");
		fiatUno.apagar();
		
		
		System.out.println("fin");

	}

}
