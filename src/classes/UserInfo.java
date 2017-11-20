package classes;

public class UserInfo {

private final int user_id;
private final String username;
private final String lastname;
private final String firstname;
private final String email;
private final String tel;

public UserInfo(int user_id, String username, String lastname, String firstname, String email, String tel) {
	this.user_id = user_id;
	this.username = username;
	this.lastname = lastname;
	this.firstname = firstname;
	this.email = email;
	this.tel = tel;
}
}
