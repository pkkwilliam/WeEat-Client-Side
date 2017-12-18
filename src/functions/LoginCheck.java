package functions;

import classes.UserInfo;
import databases.DatabaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.google.gson.Gson;
import static Values.Strings.users_SQLTable;
import static Values.Strings.user_Username;
import static Values.Strings.user_Password;
import static Values.Strings.user_Firstname;
import static Values.Strings.user_Lastname;
import static Values.Strings.user_Email;
import static Values.Strings.user_Tel;


public class LoginCheck {
public static boolean login(String username, String password){
	Gson gson = new Gson();
	String json = "";
	String userLoginCheckQuery = 
			"SELECT * FROM users WHERE "+ user_Username +" = "+ "'" +username+ "'";
	
	ResultSet result = DatabaseConnection.query(userLoginCheckQuery);
	try {
		if(result.next()) {
			if(result.getString(user_Password).equals(password)) {
				return true;
			}
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return false;
}
}
