package business.concretes;

import java.util.ArrayList;
import java.util.List;

import GoogleLog.GoogleLoginManager;
import business.abstracts.UserCheckService;
import business.abstracts.UserService;
import core.abstracts.GoogleService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserService{
	private UserDao userDao;
	private UserCheckService userCheckService;
	private GoogleService googleService;
	List<User> users = new ArrayList<User>();
	

	public UserManager(UserDao userDao, GoogleLoginManager googleLoginManager, UserCheckService userCheckService,GoogleService googleService) {
		super();
		this.userDao = userDao;
		this.userCheckService = userCheckService;
		this.googleService = googleService;
	
	}


	@Override
	public void loginwithGoogle(String email, String password) {
		Object googleService;
		GoogleService.googleLoginToSystem(email, password);
		
	}

	@Override
	public void sendVerificationEmail(String email) {
		int verifyingCode = 10000;
		System.out.println("Doğrulama kodu gönderildi.");
		System.out.println("Doğrulama kodu : " + verifyingCode);
		verifyEmail(verifyingCode);
	}

	@Override
	public void verifyEmail(int verfyingCode) {
		System.out.println("Doğrulama kodunu giriniz : ");
		
		
	}


	@Override
	public void signup(User user) {
	if(!userCheckService.checkEmail(user.getEmail(), userDao) || user.getEmail() == null) {
		System.out.println("Geçerli bir email giriniz.");
		return;
	}else if(!userCheckService.checklastName(user.getLastName()) || user.getLastName() == null){
		System.out.println("Soyisim en az 2 karakter olmalıdır.");
		
	}else if(!userCheckService.checkpassword(user.getPassword()) || user.getPassword() == null) {
		System.out.println("Şifreniz en az 6 karakterli olmalıdır.");
		
	}else if(!userCheckService.isEmailInUse(user.getEmail())) {
		System.out.println("Bu mail kullanılmamaktadır.");
	}else {
		userDao.add(user);
		System.out.println("Kayıt başarılı");
		sendVerificationEmail(user.getEmail());
	}
	}

	
		


	
		
	}


