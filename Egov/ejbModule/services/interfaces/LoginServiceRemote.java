package services.interfaces;

import javax.ejb.Remote;

import persistence.User;

@Remote
public interface LoginServiceRemote {
	public User authenticate(String login, String pwd);
}
