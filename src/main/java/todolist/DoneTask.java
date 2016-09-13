package todolist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DoneTask
 */
@WebServlet("/DoneTask")
public class DoneTask extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoneTask() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));

		String Cstatus = "Done";

		request.setAttribute("selectedValue", Cstatus);
		Connection c = null;
		try {
			String url = "jdbc:mysql://localhost:3306/todolist";
			String username = "root";
			String password = "abcd";
			String sql = "update tasks  set task_status=? where id=?";
			c = DriverManager.getConnection(url, username, password);

			PreparedStatement pstmt = c.prepareStatement(sql);

			pstmt.setString(1, Cstatus);

			pstmt.setInt(2, id);
			pstmt.executeUpdate();
			pstmt.close();

		} catch (SQLException e) {
			throw new ServletException(e);
		} finally {
			try {
				if (c != null) {
					c.close();
				}
			} catch (SQLException e) {
				throw new ServletException(e);
			}
		}

		response.sendRedirect("ToDoList");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

}
