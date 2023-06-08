

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login_info_Check
 */
@WebServlet("/Login_info_Check")
public class Login_info_Check extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login_info_Check() {
        super();
        // TODO Auto-generated constructor stub
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
		// doGet(request, response);		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cwulogin", "root", "CS380");
			String sql = "SELECT * FROM users";
			PreparedStatement p = connection.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String page = "";
			Boolean loginFound = false;
			
			while(rs.next()) {
				String name = rs.getString("username");
				String pass = rs.getString("password");
				if(username.equals(name) && password.equals(pass)) {
					loginFound = true;
				}
			}
			
			if(loginFound) {
				page = "loginsuccess.jsp";
			} else {
				page = "loginerror.jsp";
			}
			response.sendRedirect(page);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
