package ar.com.codoacodo.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.codoacodo.daos.ProductoDAO;
import ar.com.codoacodo.dto.Producto;

@WebServlet("/api/ListadoController")
public class ListadoController extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//crear la instancia de productoDAO
		ProductoDAO dao = new ProductoDAO();
		
		//invocar al metodo
		List<Producto> listado = dao.listarProducto();
		
		//grabar el listado en el request				
		req.setAttribute("listado", listado);
		
		//ir a la sig pagina
		getServletContext().getRequestDispatcher("/listado.jsp").forward(req, resp);
	}
}
