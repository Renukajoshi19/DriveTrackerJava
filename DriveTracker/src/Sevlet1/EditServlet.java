package Sevlet1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import Dao.DBcon;
import PojoPac.Drive;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("hi i am post");
		BufferedReader br = request.getReader();
		String s = br.readLine();

		ObjectMapper obj = new ObjectMapper();
		Drive r = obj.readValue(s, Drive.class);
/*		System.out.println("javaobject" + r);
*/
		try {
			Connection con = Dao.DBcon.getDBConnection();

			PreparedStatement ps = con.prepareStatement("update drive set c_nm=?,no_of_rsrcs=?,exp_req=?,ctc=?,join_crt=?,bond=?,position=?,followup=?,edu_crt=? where did=?");

			
		

			

			ps.setObject(1, r.getCnm());

			ps.setObject(2, r.getNo_of_rsrcs());
			ps.setObject(3, r.getExp_req());
			ps.setObject(4, r.getCtc());
			ps.setObject(5, r.getJoin_crt());
			ps.setObject(6, r.getBond());
			ps.setObject(7, r.getPosition());
			ps.setObject(8, r.getFollowup());
			ps.setObject(9, r.getEdu_crt());
			ps.setObject(10, r.getDid());

			int status = ps.executeUpdate();

			Map<String, String> m = new HashMap<>();

			if (status == 1) {
				m.put("Data", "succesfully updated");
			} else {
				m.put("Data", "error");
			}
			System.out.println("map object=" + m);

			String jsonstr = obj.writeValueAsString(m);

			System.out.println("json string=" + jsonstr);

			PrintWriter pw = response.getWriter();

			pw.write(jsonstr);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
