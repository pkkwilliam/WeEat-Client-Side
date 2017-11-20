package functions;

import javax.servlet.http.HttpServletRequest;

public class GetParameter {
public static String[] getParameter(HttpServletRequest request, String[] attributes) {
	// Username = 0 , Password = 1, FirstName = 2, Lastname = 3, Email = 4, Tel = 5
	String username = request.getParameter(attributes[0]);
    String password = request.getParameter(attributes[1]);
    String firstname = request.getParameter(attributes[2]);
    String lastname = request.getParameter(attributes[3]);
    String email = request.getParameter(attributes[4]);
    String email2 = request.getParameter("email2");
    String tel = request.getParameter(attributes[5]);
    
    String values [] = {username,password,firstname,lastname,email,tel,email2};
	return values;
}
public static String[] getRegularParameter(HttpServletRequest request, String[] attributes) {
	String values[] = new String[attributes.length];
	for(int i = 0 ; i < attributes.length; i++)
		values[i] = request.getParameter(attributes[i]);
	return values;
}
}
