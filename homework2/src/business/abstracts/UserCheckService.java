package business.abstracts;

import dataAccess.abstracts.UserDao;

public interface UserCheckService {
	

	boolean checkEmail(String email, UserDao userDao);
	boolean checkName(String name);
	boolean checklastName(String lastName);
	boolean checkpassword(String password);
	boolean isEmailInUse(String email);
	

}
