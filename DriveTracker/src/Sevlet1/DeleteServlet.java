package Sevlet1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DBcon;
import PojoPac.Drive;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
static int did;
	private static final long serialVersionUID = 1L;

	

		

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
			String str = request.getReader().readLine();
			  did=Integer.parseInt(str);
			System.out.println(did);
		try {
				deleteInDB();
				//System.out.println("data deleted");
			} catch (ClassNotFoundException e) {
			
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
	}
		
		protected void deleteInDB() throws ClassNotFoundException, SQLException
		{
			Connection con = DBcon.getDBConnection()	;

		PreparedStatement ps = con.prepareStatement("delete from drive where did=?");

		System.out.println("In deletedata post");
			ps.setObject(1, did);

			int status = ps.executeUpdate();
		System.out.println(status);
			
	}
			
		
}
