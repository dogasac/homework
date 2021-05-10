package business.abstracts;

import entities.concretes.User;

public interface UserService {
	void signup(User user);
	void loginwithGoogle(String email, String password);
	void sendVerificationEmail(String email);
	void verifyEmail(int verfyingCode);

}
