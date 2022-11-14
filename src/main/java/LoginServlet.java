

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDbUtil loginDao;
	@Resource(name="jdbc/tp1")
	private DataSource datasource;       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@Override
	public void init() throws ServletException {
		super.init();
		
		// create our student db util ... and pass in the conn pool / datasource
		try {
			loginDao = new UserDbUtil(datasource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String loginid=request.getParameter("lid");
		String password=request.getParameter("password");
		User u= new User();
		u.setLogin(loginid);
		u.setPassword(password);
		try {
			if(loginDao.login(u)) {
				session.setAttribute("login", loginid);
				response.sendRedirect("welcome.jsp");
			}
			else {
				response.sendRedirect("errorpage.jsp");    
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
