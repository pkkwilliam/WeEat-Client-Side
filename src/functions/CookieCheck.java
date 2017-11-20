package functions;

import java.sql.ResultSet;
import java.sql.SQLException;

import static Values.Strings.users_SQLTable;
import static Values.Strings.user_Username;
import static databases.DatabaseConnection.query;

public class CookieCheck {
public static String cookieCheck(String username) {
	String query = "SELECT * FROM "+users_SQLTable+" WHERE username = '"+username+"'";
	ResultSet result = query(query);
	try {
		if(result.next()) {
			return result.getString(user_Username);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
}
}
