package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import persistence.User;

@Remote
public interface UserServiceRemote {
	public List<User> getAll();

	public void addUSer(User user);

	public void delete(String usernameSelected);

	public void delete(Integer id);

	public User getUserById(Integer id);

	public void updateUser(User userSelected);
}
