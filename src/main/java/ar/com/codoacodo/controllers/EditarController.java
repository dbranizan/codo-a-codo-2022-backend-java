package ar.com.codoacodo.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.codoacodo.daos.ProductoDAO;
import ar.com.codoacodo.dto.Producto;

@WebServlet("/api/EditarController")
public class EditarController extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
			
		ProductoDAO dao = new ProductoDAO();
		
		//invocamos al metodo para obtener el prod
		Producto prodFromDb = dao.obtenerPorId(Long.parseLong(id));
		
		//guardar en el request el producto 
		req.setAttribute("producto", prodFromDb);
		
		getServletContext().getRequestDispatcher("/editar.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nombre = req.getParameter("nombre");
		String precio = req.getParameter("precio");
		String imagen = req.getParameter("imagen");
		String codigo = req.getParameter("codigo");
		
		ProductoDAO dao = new ProductoDAO();
		
		dao.actualizarProducto(nombre, Float.parseFloat(precio), codigo);
		
		resp.sendRedirect(req.getContextPath()+"/api/ListadoController");
	}
}
