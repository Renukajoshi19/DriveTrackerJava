package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;

import PojoPac.Drive;

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
				"insert into drive(c_nm,no_of_rsrcs,exp_req,ctc,join_crt,bond,position,followup,edu_crt) values(?,?,?,?,?,?,?,?,?)");

		 String cnm=cd.getCnm();
		 int no_of_rsrc=cd.getNo_of_rsrcs();
		 int exp_req=cd.getExp_req();
		 int ctc=cd.getCtc();
		 int join_crt=cd.getJoin_crt();
		 String bond=cd.getBond();
		 int position=cd.getPosition();
		 Date followup=cd.getFollowup();
		 int edu_crt=cd.getEdu_crt();
		
		Object[] parameter = {cnm,no_of_rsrc, exp_req, ctc, join_crt, bond, position, followup,
				edu_crt };
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
	
	
	
}

