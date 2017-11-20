package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

private static final String databaseName= "food_delivery_system";
private static final String driver = "com.mysql.jdbc.Driver";
private static final String url = "jdbc:mysql://localhost:3306/"+databaseName;
private static final String databaseUsername = "root";
private static final String databasePassword ="";
	
public static Connection getConnection() {
	try {
		Class.forName(driver);
		// System.out.println("Driver Found");
	}catch(ClassNotFoundException e) {
		System.out.println(e);
	}
	try {
		Connection con = DriverManager.getConnection(url,databaseUsername,databasePassword);
		// System.out.println("Connected");
		return con;
	}catch(SQLException e) {
		System.out.println(e);
		return null;
	}
}
public static boolean insert(String query) {
	Connection con = getConnection();
	try {
		PreparedStatement statement = con.prepareStatement(query);	
		int result = statement.executeUpdate();
		
		if(result == 1)
			return true;
		else
			return false;
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return false;
}
public static ResultSet query(String query) {
	Connection con = getConnection();
	try {
		Statement statement = con.createStatement();
		ResultSet result = statement.executeQuery(query);
		return result;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
}
public static boolean deleteAndUpdateQuery(String query) {
	Connection con = getConnection();
	try {
		PreparedStatement statement = con.prepareStatement(query);	
		int result = statement.executeUpdate();
		
		if(result == 1)
			return true;
		else
			return false;
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return false;
}
public static String register(String[] attribute, String values[], String table) {
	// Username = 0 , Password = 1, FirstName = 2, Lastname = 3, Email = 4, Tel = 5, Email2 = 6
	if(!values[4].equals(values[6])) {
		return "Your Email Does Not Match.";
	}else {
		String checkEmailQuery = "SELECT "+attribute[4]+" FROM "+table+" WHERE "+attribute[4]+" = " + "'" +values[4]+ "'";
		String checkUsernameQuery = "SELECT "+attribute[0]+" FROM "+table+" WHERE "+attribute[0]+" = " + "'" +values[0]+ "'";
		String registerQuery = ComplicatedQuery.variableNumberInsertQuery(attribute,values,table);
		if(checkExist(checkEmailQuery)) {
			if(checkExist(checkUsernameQuery)) {
				if(insert(registerQuery)){
					return "Success. Please Click Login";
				}
			}else {
				return "This Username Has Been Taken.";
			}
		}else {
			return "This Email Has Been Taken.";
		}
	}
	return "Error Occur";
}
public static boolean checkExist(String query) {
	ResultSet result = query(query);
	boolean check = false;
	try {
		check = !result.next();
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return check;
}
}
