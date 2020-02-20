package Com.tq.Servlet;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Com.tq.Daoutil.Dao_Opration;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	static int did;
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String str = request.getReader().readLine();
		did = Integer.parseInt(str);

		try {
			Dao_Opration.deleteInDB(did);

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}
}