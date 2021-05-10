package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class HibernateUserDao implements UserDao {

	List<User> users = new ArrayList<User>();

	@Override
	public void add(User user) {
		users.add(user);
		System.out.println(user.getName() + user.getLastName() + " added ");

	}

	@Override
	public void delete(User user) {
		System.out.println(user.getName() + user.getLastName() + " deleted ");
		

	}

	@Override
	public void update(User user) {
		System.out.println(user.getEmail() + " updated ");
		
	}

	@Override
	public User getEmail(String email) {
		List<User> users = getAll();
		if (users != null) {
			for (User user : users) {
				if (user.getEmail().equals(email));
				return user;
			}
		}
		return null;
	}

	@Override
	public List<User> getAll() {
		
		return users;
	}

}
