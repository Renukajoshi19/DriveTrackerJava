package Com.tq.Servlet;

import java.io.IOException;

import java.sql.SQLException;

import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Com.tq.JavaBean.Login;

@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String jsonobject = request.getReader().readLine();
		System.out.println(jsonobject);

		Login drive = (Login) Com.tq.Jsonutil.convert_j_to_java_and_java_to_j.getObjectFromJSON(jsonobject,
				Login.class);
		System.out.println(drive);

		Map<String, String> mp = null;
		try {
			mp = Com.tq.Daoutil.Dao_Opration.chklogin(drive);
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

		String jsonString = (String) Com.tq.Jsonutil.convert_j_to_java_and_java_to_j.getJSONFromObject(mp);

		response.getWriter().write(jsonString);

		response.flushBuffer();

	}

}
