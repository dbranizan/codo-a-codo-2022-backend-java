package OOP;

public class Auto {

	// atributos de clase, deben ser privados
	private String color;
	private int anio;
	private long serie;
	private String marca;
	private String modelo;
	private float velocidad;
	private float velocidadMaxima;
	private boolean encendido;
	
	private Motor motor;
	private Estereo estereo;
	
	//Constructor: para definir los vs x defecto
	public Auto(float velocidadMaxima, String marca, Motor motor){
		//en lugar de asignar los valores a atributos, usamos los setters
		this.setVelocidad(0);  //velocidad = 0;
		this.setAnio(2022);  //anio = 2022;
		this.setMarca(marca); //marca = "SIN MARCA";
		this.setModelo("SIN MODELO");//modelo = "SIN MODELO";
		this.setEncendido(false); //encendido = false;
		this.setVelocidadMaxima(velocidadMaxima); //velocidadMaxima = 3;
		this.setMotor(motor);
	}
	
	public void setMotor(Motor motor) {
		if (motor == null) {
			Motor motorInterno = new Motor("default", 100f);
			this.motor = motorInterno;
		} else {
			this.motor = motor;
		}
	}
	
	public Motor getMotor() {
		return this.motor;
	}
	
	public void setEstereo(Estereo nuevoEstereo) {
		if (nuevoEstereo != null)
			this.estereo = nuevoEstereo;
	}
	

	// metodos
	public void encender() {
		if (!this.isEncendido()) {
		   this.setEncendido(true);
		   System.out.println("Se ha encendido el auto");
		} else {
			System.out.println("No se puede encender dos veces");
		}
	}	
	
	public void apagar() {
		//if (!encendido) {
		if (this.isEncendido()) {
			while(this.getVelocidad() > 0) {
				frenar();
			}
			//encendido = false;
			this.setEncendido(false);
			System.out.println("Auto apagado");
		} else {
			System.out.println("No se puede apagar dos veces");
		}
	}

	public void acelerar() {
		if (this.isEncendido()) {
			if (this.getVelocidad() < this.getVelocidadMaxima()) {
				this.setVelocidad(this.getVelocidad() + 1);  //velocidad++;
			} else {
				System.out.println("Error: no puede superar la velocidad máxima");
			}
		} else {
			System.out.println("Error: encender el auto");
		}
	}

	public void frenar() {
		if (this.isEncendido()) {
			if (this.getVelocidad() > 0 ) {
				this.setVelocidad(this.getVelocidad() - 1);  //velocidad--;
			}	
		} else {
			System.out.println("Error: el auto no enstá encendido");
		}
	}
	
	public void verVelocidad() {
		System.out.println("Velocidad actual: "+this.getVelocidad());
	}
	
	public String getMarca () {
		/*String aux ="";
		if (marca == null) {
			aux = "SIN MARCA";
		}
		return aux;*/
		//para hacerlo en 1 linea es asi
		return marca == null ? "" : marca; //devuelve vacio o marca
		//wrapper  tipo de dato envoltorio		
	}
	
	private void setMarca (String marca) {
		if (marca != null) {
			this.marca = marca;
		} else {
			this.marca = "";
		}		
	}

	public String getColor() {
		return this.color;
	}

	private void setColor(String color) {
		this.color = color;
	}

	public int getAnio() {
		return this.anio;
	}

	private void setAnio(int anio) {
		this.anio = anio;
	}

	public long getSerie() {
		return this.serie;
	}

	private void setSerie(long serie) {
		this.serie = serie;
	}

	public String getModelo() {
		return this.modelo;
	}

	private void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public float getVelocidad() {
		return this.velocidad;
	}

	private void setVelocidad(float velocidad) {
		if (velocidad < 0) {
			this.velocidad = 0;
		} else {
			this.velocidad = velocidad;
		}
	}

	public float getVelocidadMaxima() {
		return velocidadMaxima;
	}

	private void setVelocidadMaxima(float velocidadMaxima) {
		if (velocidadMaxima < 0 || velocidadMaxima > 220) {
			if (velocidadMaxima < 0) 
				this.velocidadMaxima = 0;
			if (velocidadMaxima > 220)
				this.velocidadMaxima = 220;
		}else {
			this.velocidadMaxima = velocidadMaxima;
		}
		/*if (velocidadMaxima < 0) {
			this.setVelocidadMaxima(0);
		} else if (velocidadMaxima > 220) {
			this.setVelocidadMaxima(220);
		} else {
			this.velocidadMaxima = velocidadMaxima;
		}*/
	}

	private  boolean isEncendido() {
		return encendido;
	}

	private void setEncendido(boolean encendido) {
		this.encendido = encendido;
	}
	
	//alt+shift+s  Generate getters and setters
	
}
