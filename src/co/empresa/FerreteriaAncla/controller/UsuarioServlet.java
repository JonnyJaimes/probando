package co.empresa.FerreteriaAncla.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.empresa.FerreteriaAncla.dao.UsuarioDao;
import co.empresa.FerreteriaAncla.modelo.Usuario;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private  UsuarioDao usuarioDao;
	private  Usuario usuario;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		this.usuarioDao= new UsuarioDao();
		this.usuario= new Usuario();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		try {
		switch(action) {
		case "/new":
			showNewForm(request,response);
			break;
		case"/insert":
			insertarUsuario(request,response);
		break;
		case"/delete":
			eliminarUsuario(request,response);
		break;
		case"/edit":
			editarUsuario(request,response);
			break;
		case"/update":
			actualizarUsuario(request,response);
			break;
		default:
			listUsuarios (request,response);
		break;
		
		
		}
		}catch(SQLException e) {
			throw new ServletException (e);
			
		}
		
	}

	


	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	private void login(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String accion=request.getParameter("accion");
		if(accion.equalsIgnoreCase("Ingresar")){
			String user=request.getParameter("txtuser");
			String pass=request.getParameter("txtpass");
			
			usuario=usuarioDao.validar(user,pass);
			if(usuario.getNombre()!=null) {
				request.getRequestDispatcher("Controlador?accion=principal").forward(request,response);
				
			}else {
				request.getRequestDispatcher("usuariolist.jsp").forward(request, response);
				
			}
		}else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		RequestDispatcher dispacher = request.getRequestDispatcher("usuario.jsp");
		dispacher.forward(request, response);
	}
	
	private void  showNewForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispacher = request.getRequestDispatcher("usuario.jsp");
		dispacher.forward(request, response);
	}
	private void  insertarUsuario(HttpServletRequest request,HttpServletResponse response) throws  ServletException, IOException, SQLException {
		String nombre= request.getParameter("nombre");
		String email= request.getParameter("email");
		String pais= request.getParameter("pais");
		
		Usuario usuario = new Usuario(nombre,email,pais);
		usuarioDao.insert(usuario);
		
		
		response.sendRedirect("list");
	}
	private void editarUsuario(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
		// TODO Auto-generated method stub
		int id =Integer.parseInt(request.getParameter("id"));
		Usuario usuarioActual = usuarioDao.select(id);
		request.setAttribute("nombre", usuarioActual);
		
		RequestDispatcher dispacher = request.getRequestDispatcher("usuario.jsp");
		dispacher.forward(request, response);
		
		
	}

	private void actualizarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		int id =Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String pais = request.getParameter("pais");
		
		Usuario usuario= new Usuario(nombre,email,pais);
		usuarioDao.update(usuario);
		
		response.sendRedirect("list");
		
		
		
	}
	private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, SQLException  {
		// TODO Auto-generated method stub
		int id =Integer.parseInt(request.getParameter("id"));
		
		usuarioDao.delete(id);
		response.sendRedirect("list");
		
		
	}
	private void listUsuarios(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, SQLException  {
		// TODO Auto-generated method stub
		List<Usuario>listUsuarios= usuarioDao.selectAll();
		request.setAttribute("listUsuarios", listUsuarios);
		RequestDispatcher dispacher = request.getRequestDispatcher("usuariolist.jsp");
		dispacher.forward(request, response);
	}
	
}
