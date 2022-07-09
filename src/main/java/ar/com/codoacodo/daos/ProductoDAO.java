package ar.com.codoacodo.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.com.codoacodo.connection.AdministradorDeConexiones;
import ar.com.codoacodo.dto.Producto;

public class ProductoDAO {
	
	public Producto obtenerPorId(Long id) {
		
		//Consulta
		String sql = "SELECT * FROM PRODUCTO WHERE ID="+id;
		
		//Conexion
		Connection con = AdministradorDeConexiones.getConnection();
		
		Producto prodFromDb = null;
		
		try {
			//Statement
			Statement st = con.createStatement();
			
			//resultset
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				//tomamos los datos del rs
				String nombre = rs.getString(2);
				Float precio = rs.getFloat(3);
				Date fecha = rs.getDate(4);
				String imagen = rs.getString(5);
				String codigo = rs.getString(6);
				
				//creamos el objeto
				prodFromDb = new Producto(id,nombre,precio,fecha,imagen,codigo);
			}
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return prodFromDb;
	}

	public List<Producto> listarProducto () {

		String sql = "SELECT * FROM PRODUCTO ORDER BY NOMBRE";
		
		//conexion
		Connection con = AdministradorDeConexiones.getConnection();
		
		List<Producto> listado = new ArrayList<>(); 
				
		try {
			//statement 
			Statement st = con.createStatement();
			
			//resultset
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				// rs > sacando los datos
				Long idProducto = rs.getLong(1);
				String nombre = rs.getString(2);
				Float precio = rs.getFloat(3);
				Date fecha = rs.getDate(4);
				String imagen = rs.getString(5);
				String codigo = rs.getString(6);
				
				//creamos el objeto
				Producto prodFromDb = new Producto(idProducto,nombre,precio,fecha,imagen,codigo);
				
				//cargo el producto en listado
				listado.add(prodFromDb);
			}
			
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return listado;
	}

	public void crearProducto(String nombre, Float precio, String imagen, String codigo) {
		
		//conexion
		Connection con = AdministradorDeConexiones.getConnection();
		
		if(con != null) { 
			String sql = "INSERT INTO PRODUCTO (nombre, precio,fecha_creacion,imagen,codigo) ";
			sql += "VALUES('"+nombre+"',"+precio+",CURRENT_DATE,'"+imagen+"','"+codigo+"')";
			
			try {
				Statement st = con.createStatement();
				
				st.execute(sql);
				
				con.close();			
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void actualizarProducto(String nombre, Float precio, String codigo) {
		
		Connection con = AdministradorDeConexiones.getConnection();
		
		if(con != null) { 
			String sql = "UPDATE PRODUCTO "
					+ " set nombre='"+nombre+"',"
					+ " precio='"+precio+"'"
					+ " WHERE codigo = '"+codigo+"'"; 			
		
			try {
				Statement st = con.createStatement();			
				
				st.executeUpdate(sql);
				
				con.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}		
 
	}
	
	public void eliminarProducto(Long id) {
		
		Connection con = AdministradorDeConexiones.getConnection();
		
		if(con != null) { 
			// delete 
			String sql = "DELETE FROM PRODUCTO WHERE id="+id;
			
			try {
				Statement st = con.createStatement();			
				
				st.executeUpdate(sql);
				
				con.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Producto> buscar(String clave) {
		
		//Consulta
		String sql = "SELECT * FROM PRODUCTO WHERE NOMBRE LIKE '%"+clave+"%' ";
		
		//Conexion
		Connection con = AdministradorDeConexiones.getConnection();
		
		List<Producto> listado = new ArrayList<Producto>(); 
		
		try {
			//Statement
			Statement st = con.createStatement();
			
			//resultset
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				//tomamos los datos del rs
				Long idProducto = rs.getLong(1);
				String nombre = rs.getString(2);
				Float precio = rs.getFloat(3);
				Date fecha = rs.getDate(4);
				String imagen = rs.getString(5);
				String codigo = rs.getString(6);
				
				//creamos el objeto
				Producto prodFromDb = new Producto(idProducto,nombre,precio,fecha,imagen,codigo);
				
				//cargo el producto en listado
				listado.add(prodFromDb);
			}
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return listado;
	}

}
