package resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class jdbcconnection {

	List<String> col1 = new ArrayList<>();
	List<String> col12 = new ArrayList<>();
	List<String> col123 = new ArrayList<>();
	public  List<String> getResult(String database, String column1, String column2, String column3, String table, String whereCondition ) throws SQLException {

		String host= "localhost";
		String port= "3306";

		Connection  con= DriverManager.getConnection("jdbc:mysql://" + host + ":"+ port + "/" + database,"root","root" );
		Statement s = con.createStatement();
		ResultSet rs= s.executeQuery("select * from " + table +" where " + whereCondition );
		if (column1 != null && column2 !=null && column3!=null) {

			while(rs.next()) {

				col123.add((rs.getString(column1)+ "-" + rs.getString(column2)+ "-" + rs.getString(column3)));

			}

		}else if(column1 != null && column2 !=null && column3 ==null){

			while(rs.next()) {
				col12.add( (rs.getString(column1)+ "-" + rs.getString(column2)));

			}

		}else if(column1 != null && column2 ==null && column3 ==null) {


			while(rs.next()) {
				col1.add((rs.getString(column1)));

			}

		}

		int size1=col1.size();
		int size12=col12.size();
		int size123=col123.size();
		if (size1> size12 & size1> size123){
			return col1;
		}else if(size12> size1 & size12> size123){
			return col12;

		}else {
			return col123;
		}
	}

}
