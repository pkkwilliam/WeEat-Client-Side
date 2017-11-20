package databases;

import java.util.ArrayList;
import static Values.Controls.AreaCoverControl;
import static Values.Strings.geolocation_latitude;
import static Values.Strings.geolocation_longtitude;
import static Values.Strings.user_Email;
import static Values.Strings.user_Firstname;
import static Values.Strings.user_Lastname;
import static Values.Strings.user_Password;
import static Values.Strings.user_Tel;
import static Values.Strings.user_Username;

public class ComplicatedQuery {
public static String listingQuery(ArrayList<Integer> list,String selectField, String table, String whereAttribue) {
	
	StringBuilder query = new StringBuilder(
			"SELECT " + selectField + " FROM " + table +
			" WHERE " + whereAttribue + " IN (");
	
	for(int i = 0; i < list.size(); i++) {
		query.append(list.get(i)+",");
	}
	// Remove the ',' from the last of the index
	query.delete(query.length() - 1, query.length());
	// add ')' into query
	query.insert(query.length(), ')');
	String result = query.toString();
	return result;
}
public static String geolocationWithinQuery(String selectField, String table, String latitude, String longtitude) {

	float withinLatitudeMinus = (float) (Float.valueOf(latitude) - AreaCoverControl);
	float withinLatitudePlus = (float) (Float.valueOf(latitude) + AreaCoverControl);
	float withinlongtitudeMinus = (float)(Float.valueOf(longtitude) - AreaCoverControl);
	float withinlongtitudePlus = (float) (Float.valueOf(longtitude) + AreaCoverControl);

	String query = "SELECT " +selectField+ " FROM " +table+ 
			" WHERE "+geolocation_latitude+" > "+withinLatitudeMinus+
			" AND "+geolocation_latitude+" < "+ withinLatitudePlus+
			" AND "+geolocation_longtitude+" > "+withinlongtitudeMinus+
			" AND "+geolocation_longtitude+" < "+ withinlongtitudePlus;
	return query;
}
public static String variableNumberInsertQuery(String [] attribute, String [] values, String table) {
	StringBuilder query = new StringBuilder();
	query.append("INSERT INTO "+table+" (");
	// add attribues
	for(int i = 0; i < attribute.length; i++)
		query.append(attribute[i]+",");
	
	// remove ',' from last index
	query.delete(query.length() - 1, query.length());
	query.append(") VALUES (");
	
	// add values
	for(int i = 0; i < attribute.length; i++)
		query.append("'"+values[i]+"',");
	query.delete(query.length() - 1, query.length());
	query.append(")");

	return query.toString();
}
public static String updateQuery(String[] attribute, String[] values, String table, String whereAttribute, String whereValue) {
	StringBuilder query = new StringBuilder();
	query.append("UPDATE "+table+" SET ");
	for(int i = 0; i < attribute.length; i++) {
		query.append(attribute[i]+" = '"+values[i]+"',");
	}
	query.delete(query.length() - 1, query.length());
	query.append(" where "+whereAttribute+" = "+whereValue);
	
	return query.toString();
}
public static String updateQuery(String table, String UpdateAttribute, String updateValue, String whereAttribute, String whereValue) {
	String query = "UPDATE "+table+" SET "+UpdateAttribute+" = '"+updateValue+"' where "+whereAttribute+" = '"+whereValue+"'";
	System.out.println(query);
	return query;
}
}
