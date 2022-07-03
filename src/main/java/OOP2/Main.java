package OOP2;

import OOP.Auto;
import OOP.Estereo;
import OOP.Motor;

public class Main {

	public static void main(String[] args) {
		
		//composicion
		Motor motorDesdeAfuera = new Motor("MCLAREN",150f); 
		
		// la puedo usar porque la clase tiene constructor public
		Auto auto = new Auto(220f, "REANULT", motorDesdeAfuera); //220f es un float
		//tb podria haber sido asi, sin motor (el setMotor les asigna uno x default)
		//Auto auto = new Auto(220f, "REANULT", null);
		
		//agregacion
		Estereo e = new Estereo();  
		auto.setEstereo(e);
		
	}

}
