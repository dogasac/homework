package core.concretes;

import core.abstracts.GoogleService;

public class GoogleLoginManagerAdapter implements GoogleService{

	

	public void googleLoginToSystem(String email, String password) {
		
		GoogleLoginManagerAdapter manager = new GoogleLoginManagerAdapter();
		manager.googleLoginToSystem(email, password);
	}

}