package it.polito.tdp.ufo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SightingDAO {
	
	//metto i metodi statici nel DAO

//	String jdbcURL = "jdbc:mysql://localhost/ufo_sightings?user=root&password=root";
	
	
	public List <String> readShape (){
		try {
		Connection conn = DBConnect.getConnection();
		
		String sql= "SELECT DISTINCT shape "
				+ "FROM sighting "
				+ "WHERE shape <> '' "
				+ "ORDER BY shape ASC"; 
		
		PreparedStatement st = conn.prepareStatement(sql);

		
		ResultSet res = st.executeQuery(sql);
		
		List <String> f = new ArrayList<>();
		while(res.next()) {
			String ft = res.getString("shape");
			f.add(ft);
		}
		st.close();
		conn.close();
		
		return f;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException ("Database error in readShae", e);
		}
		
	}
	
	public int countByShape (String shape) {
		
		try {

			Connection conn = DBConnect.getConnection();
			String sql2 = "SELECT COUNT (*) AS cnt FROM sighting WHERE shape =?";
			
			PreparedStatement st2 = conn.prepareStatement (sql2);
			
			st2.setString(1, shape);
			ResultSet res2 = st2.executeQuery();
			res2.first();
			int count = res2.getInt("cnt");
			st2.close();
			conn.close();
			
			return count;
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException ("Database error in countByShape", e);
		}
		
		
	}

}
