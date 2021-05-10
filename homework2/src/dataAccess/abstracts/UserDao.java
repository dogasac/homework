package dataAccess.abstracts;

import java.util.List;

import entities.concretes.User;

public interface UserDao {
	void add(User user);
	void delete(User usesr);
	void update(User user);
	User getEmail(String email);

	List<User> getAll();

}
