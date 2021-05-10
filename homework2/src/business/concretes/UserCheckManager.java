package business.concretes;



import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import business.abstracts.UserCheckService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserCheckManager implements UserCheckService{
private UserDao userDao;

	
	@Override
	public boolean checkEmail(String email, UserDao userDao) {
		String regrex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regrex);
		Matcher matcher = pattern.matcher(email);
		
		return matcher.matches();
	}

	@Override
	public boolean checkName(String firstName) {
		
		if(firstName.length()>=2) {
			return true;
		}
		return false;
	}

	@Override
	public boolean checklastName(String lastName) {
		if(lastName.length()>=2) {
			return true;
		}
		return false;
	}

	@Override
	public boolean checkpassword(String password) {
		if(password.length()>=6) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isEmailInUse(String email) {
	
		List<User> users =userDao.getAll();
		for(User user : users) {
			if (user.getEmail().equals(email)){
				return true;
			}
		
		}
		return false;
	}
}


	