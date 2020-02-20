package Com.tq.Daoutil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;

import Com.tq.JavaBean.Drive;
import Com.tq.JavaBean.Login;



public class Dao_Opration {
public static void setValues(PreparedStatement statement,Object... values) 
		throws SQLException{
	for(int i=0;i<values.length;i++)
	{
		statement.setObject(i+1, values[i]);
	}
}
public static Map<String,String>insertUser(Drive cd) throws JSONException
{Connection con=null;
	int affectedRows = 0;
	HashMap<String, String> mapResponse = new HashMap<>();
	try {
		 con = DBcon.getDBConnection();
		PreparedStatement pst = con.prepareStatement(
				"insert into drive(c_nm,no_of_rsrcs,exp_req,ctc,join_crt,bond,position,followup,edu_crt,gst) values(?,?,?,?,?,?,?,?,?,?)");

		 String cnm=cd.getCnm();
		 int no_of_rsrc=cd.getNo_of_rsrcs();
		 int exp_req=cd.getExp_req();
		 int ctc=cd.getCtc();
		 int join_crt=cd.getJoin_crt();
		 String bond=cd.getBond();
		 int position=cd.getPosition();
		 Date followup=cd.getFollowup();
		 int edu_crt=cd.getEdu_crt();
		String gst=cd.getGst();
		Object[] parameter = {cnm,no_of_rsrc, exp_req, ctc, join_crt, bond, position, followup,
				edu_crt,gst};
		setValues(pst, parameter);
		
		
		
		affectedRows = pst.executeUpdate();
		if (affectedRows == 1)
			mapResponse.put("Msg", "SuccessFul SignUp");
		else
			mapResponse.put("Msg", "Error_In_SignUp");
		return mapResponse;

	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	return mapResponse;

}
	
public static Map<String, String> chklogin(Login drive) throws SQLException, ClassNotFoundException {

	Map<String, String> mapobject = new HashMap<String, String>();

	ResultSet status = null;

	Connection con = Com.tq.Daoutil.DBcon.getDBConnection();
	PreparedStatement ps = con.prepareStatement("select * from tpo");

	status = ps.executeQuery();

	while (status.next()) 
	{
		if (status.getString(3).equals(drive.getEmail()) && status.getString(5).equals(drive.getPassword())) 
		{
			mapobject.put("status", "user");
			break;
		}
		else
		{
			mapobject.put("status", "Error");
		}
	}
	
	System.out.println(mapobject);
	return mapobject;

}


   
 public static void deleteInDB(int did) throws ClassNotFoundException, SQLException
{
	Connection con = DBcon.getDBConnection()	;

PreparedStatement ps = con.prepareStatement("delete from drive where did=?");

System.out.println("In deletedata post");
	ps.setObject(1, did);

	int status = ps.executeUpdate();
System.out.println(status);
	
}
 

 
}

