

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.sql.DataSource;

/**
 * Servlet implementation class RegisterServlet
 */

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDbUtil registerDao;
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
			registerDao = new UserDbUtil(datasource);
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
		String firstname=request.getParameter("fname");
		String lastname=request.getParameter("lname");
		String loginid=request.getParameter("login");
		String password=request.getParameter("password");
		Date dateofbirth=Date.valueOf(request.getParameter("dob"));
		String mobileno=request.getParameter("mobile");
		User u = new User(firstname,lastname,loginid,password,dateofbirth,mobileno);
		try {
			registerDao.register(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
		System.out.println("Registered successfully");
		response.sendRedirect("login.jsp");
		
	}

}
