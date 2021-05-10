package Main;
import GoogleLog.GoogleLoginManager;
import business.concretes.UserCheckManager;
import business.concretes.UserManager;
import core.concretes.GoogleLoginManagerAdapter;
import dataAccess.concretes.HibernateUserDao;
import entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User user = new User(1, "Doğa", "Saçıkara","dogasacikara@hotmail.com","12345678");
		
		UserManager userManager = new UserManager (new HibernateUserDao(), new GoogleLoginManager(), new UserCheckManager(), new GoogleLoginManagerAdapter());
		userManager.signup(user);
		userManager.loginwithGoogle("", "12345678");

	}

}
