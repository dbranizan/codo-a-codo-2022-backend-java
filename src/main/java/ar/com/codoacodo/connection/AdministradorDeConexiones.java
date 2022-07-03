package ar.com.codoacodo.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class AdministradorDeConexiones {

	public static Connection getConnection() {
		/* Conexion a la base local
		String url = "jdbc:mysql://127.0.0.1:3306/codo-a-codo?serverTimeZone=UTC&userSSL=false";
		String username = "root";
		String password = "root";
		String driverName = "com.mysql.cj.jdbc.Driver";//mysql|postrges
		*/
		//conexion a la BD Heroku
		String url = System.getenv("DATASOURCE_URL");
		String user = System.getenv("DATASOURCE_USERNAME");
		String password = System.getenv("DATASOURCE_PASSWORD");
		String driverName = System.getenv("DATASOURCE_DRIVER");
		
		//control de errores
		Connection con = null;
		try {
			Class.forName(driverName); //carga en memoria el driver
			con = DriverManager.getConnection(url,user,password); //este getConnection es de la clase DriverManager, no es el que estoy creando
			
		}catch(Exception e){
			e.printStackTrace();//se que paso lo o porque fallo.
		}
		return con;
	}

	public static void main(String[] args) {
		Connection con = AdministradorDeConexiones.getConnection();//f5 para entrar al metodo, f6 para ir lina a linea
		if(con != null) {
			System.out.println("Conexion ok");
		}else {
			System.err.println("Conexion fail");
		}
	}
}
