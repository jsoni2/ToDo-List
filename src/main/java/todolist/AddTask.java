package todolist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddTask
 */
@WebServlet("/AddTask")
public class AddTask extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddTask() {
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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String choice = request.getParameter("test");
		if (choice.equals("Add")) {

			String Mtask = request.getParameter("task");
			Date date = new Date();
			String Mdate = new SimpleDateFormat("yyyy-MM-dd").format(date);
			String Mstatus = null;
			;
			Connection c = null;
			/*
			 * CREATE SCHEMA `todolist` ;
			 * 
			 * CREATE TABLE `todolist`.`tasks` ( `id` INT NOT NULL
			 * AUTO_INCREMENT, `tasks_desc` VARCHAR(45) NULL, `date_added`
			 * VARCHAR(45) NULL, `task_status` VARCHAR(45) NULL, PRIMARY KEY
			 * (`id`));
			 */

			try {
				String url = "jdbc:mysql://localhost:3306/todolist";
				String username = "root";
				String password = "abcd";
				String sql = "insert into tasks (tasks_desc,date_added,task_status) values(?,?,?)";
				c = DriverManager.getConnection(url, username, password);

				PreparedStatement pstmt = c.prepareStatement(sql);
				pstmt.setString(1, Mtask);
				pstmt.setString(2, Mdate);
				pstmt.setString(3, Mstatus);
				pstmt.executeUpdate();

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

		}
		response.sendRedirect("ToDoList");
	}
}